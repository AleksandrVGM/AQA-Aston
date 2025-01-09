package by.aston;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;

class PostmanEchoTest {
    public static final String DATA = "This is expected to be sent back as part of response body.";
    public static final String BASE_URI = "https://postman-echo.com";
    private final Map<String, String> params = Map.of("foo1", "bar1", "foo2", "bar2");
    private final Map<String, String> responseBodyHeaders = Map.of("headers.host", "postman-echo.com",
            "headers.connection", "close",
            "headers.x-forwarded-proto", "https",
            "headers.x-forwarded-port", "443",
            "headers.accept", "*/*",
            "headers.user-agent", "PostmanRuntime/7.43.0",
            "headers.cache-control", "no-cache",
            "headers.accept-encoding", "gzip,deflate,br");
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeEach
    void setUp() {
        requestSpecification = given().baseUri(BASE_URI)
                .contentType(ContentType.TEXT)
                .header(new Header("User-Agent", "PostmanRuntime/7.43.0"))
                .header(new Header("Accept", "*/*"))
                .header(new Header("Accept-Encoding", "gzip,deflate,br"))
                .header(new Header("Cache-Control", "no-cache"));
        responseSpecification = expect().statusCode(200);
        for (Map.Entry<String, String> entry : responseBodyHeaders.entrySet()) {
            responseSpecification
                    .body(entry.getKey(), equalTo(entry.getValue()));
        }
    }

    @Test
    public void testGet() {
        requestSpecification
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then().spec(responseSpecification)
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"));
    }

    @Test
    public void testPost() {
        requestSpecification.body(DATA)
                .when().post("/post")
                .then().spec(responseSpecification)
                .assertThat()
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"));
    }

    @Test
    public void testPostWithBody() {
        requestSpecification.config(RestAssured.config()
                        .encoderConfig(encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.TEXT)))
                .contentType("x-www-form-urlencoded")
                .formParams(params)
                .when().post("/post")
                .then().spec(responseSpecification)
                .assertThat()
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.content-type", equalTo("x-www-form-urlencoded; charset=ISO-8859-1"));
    }

    @Test
    public void testPut() {
        requestSpecification.body(DATA)
                .when().put("/put")
                .then().spec(responseSpecification)
                .assertThat()
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.content-length", equalTo("58"));
    }

    @Test
    public void testPatch() {
        requestSpecification.body(DATA)
                .when().patch("/patch")
                .then().spec(responseSpecification)
                .assertThat()
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.content-length", equalTo("58"));
    }

    @Test
    public void testDelete() {
        requestSpecification.body(DATA)
                .when().delete("/delete")
                .then().spec(responseSpecification)
                .assertThat()
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.content-length", equalTo("58"));
    }
}