package by.aston;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;

class PostmanEchoTest {
    public static final String DATA = "This is expected to be sent back as part of response body.";
    public static final String BASE_URI = "https://postman-echo.com";
    private final Map<String, String> params = Map.of("foo1", "bar1", "foo2", "bar2");

    private String[][] headersArray = {{"headers.host", "postman-echo.com"},
            {"headers.connection", "close"},
            {"headers.x-forwarded-proto", "https"},
            {"headers.x-forwarded-port", "443"},
            /*{"headers.content-type", "text/plain"},*/
            {"headers.accept", "*/*"},
            {"headers.user-agent", "PostmanRuntime/7.43.0"},
            {"headers.cache-control", "no-cache"},
            {"headers.accept-encoding", "gzip,deflate,br"}};
    private Map<String, String> responseHeaders = Arrays.stream(headersArray)
            .collect(Collectors.toMap(h -> h[0], h -> h[1]));

    private RequestSpecification requestSpecification;

    @BeforeEach
    void setUp() {
        requestSpecification = given().baseUri(BASE_URI)
                .contentType(ContentType.TEXT)
                .header(new Header("User-Agent", "PostmanRuntime/7.43.0"))
                .header(new Header("Accept", "*/*"))
                .header(new Header("Accept-Encoding", "gzip,deflate,br"))
                .header(new Header("Cache-Control", "no-cache"));
    }

    @Test
    public void testGet() {
        ValidatableResponse response = requestSpecification.log().all()//.queryParams(params)
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200).and()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2")).log().all();
        checkBody(responseHeaders, response).log().all();
    }

    private ValidatableResponse checkBody(Map<String, String> map, ValidatableResponse response) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            response.body(entry.getKey(), equalTo(entry.getValue()));
        }
        return response;
    }

    @Test
    public void testPost() {
        ValidatableResponse response = requestSpecification.body(DATA).log().all()
                .when().post("/post")
                .then()
//                .assertThat().statusCode(200).and()
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/post"));
        checkBody(responseHeaders, response)
//                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")).log().all();
    }

    @Test
    public void testPostWithBody() {
        ValidatableResponse response = requestSpecification.config(RestAssured.config()
                        .encoderConfig(encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.TEXT)))
                .contentType("x-www-form-urlencoded")
                .formParams(params)
                .log().all()
                .when().post("/post")
                .then().assertThat().statusCode(200).and()
                .body("url", equalTo("https://postman-echo.com/post"));
        checkBody(responseHeaders, response)
                .body("headers.content-length", equalTo("19"))
                .body("headers.content-type", equalTo("x-www-form-urlencoded; charset=ISO-8859-1")).log().all();
    }

    @Test
    public void testPut() {
        ValidatableResponse response = requestSpecification.body(DATA)
                .log().all()
                .when().put("/put")
                .then()
//                .assertThat().statusCode(200)
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/put"));
        checkBody(responseHeaders, response)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .log().all();
    }

    @Test
    public void testPatch() {
        ValidatableResponse response = requestSpecification.body(DATA)
                .log().all()
                .when().patch("/patch")
                .then().assertThat().statusCode(200)
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/patch"));
        checkBody(responseHeaders, response)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .log().all();
    }

    @Test
    public void testDelete() {
        ValidatableResponse response = requestSpecification.body(DATA)
                .log().all()
                .when().delete("/delete")
                .then().assertThat().statusCode(200)
                .body("data", equalTo(DATA))
                .body("url", equalTo("https://postman-echo.com/delete"));
        checkBody(responseHeaders, response)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .log().all();
    }
}