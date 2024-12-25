package by.aston;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

class MTSTest {
    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

    @Test
    @DisplayName("Онлайн пополнение без комиссии")
    public void nameTest() {
        WebElement webElement = driver.findElement(By.className("pay__wrapper")).findElement(By.xpath("h2"));
        String text = webElement.getText();
    }

    @Test
    public void logoVisaTest() {
        String visa = "Visa";
        Assertions.assertEquals(true, getPartners().contains(visa));
    }

    @Test
    public void logoVerifiedByVisaTest() {
        String visa = "Verified By Visa";
        Assertions.assertEquals(true, getPartners().contains(visa));
    }

    @Test
    public void logoMasterCardTest() {
        String visa = "MasterCard";
        Assertions.assertEquals(true, getPartners().contains(visa));
    }

    @Test
    public void logoMasterCardSecureCodeTest() {
        String visa = "MasterCard Secure Code";
        Assertions.assertEquals(true, getPartners().contains(visa));
    }

    @Test
    public void logoBelkartTest() {
        String visa = "Белкарт";
        Assertions.assertEquals(true, getPartners().contains(visa));
    }

    public List<String> getPartners() {
        return driver.findElement(By.className("pay__partners")).findElements(By.cssSelector("img"))
                .stream().map(webElement -> webElement.getDomAttribute("alt"))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Ссылка \"Подробнее о сервисе\"")
    public void linkTest() {
        String url = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        WebElement link = driver.findElement(By.className("pay__wrapper")).findElement(By.cssSelector("a"));
        link.click();
        Assertions.assertEquals(url, driver.getCurrentUrl());
    }

    @Test
    public void paymentTest(){
        WebElement select_now = driver.findElement(By.className("select__header")).findElement(By.className("select__now"));
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.sendKeys("297777777");
        WebElement money = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        money.sendKeys("11");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]")).findElement(By.className("button"));
        button.click();
    }
}