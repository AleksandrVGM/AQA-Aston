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
    private static final String NAME_BUTTON_CANCEL = "Отклонить";
    private static final String NAME_BLOCK = "Онлайн пополнение\nбез комиссии";
    private static final String LOGO_VISA = "Visa";
    private static final String LOGO_VERIFIED_BY_VISA = "Verified By Visa";
    private static final String LOGO_MASTERCARD = "MasterCard";
    private static final String LOGO_MASTERCARD_SECURE_CODE = "MasterCard Secure Code";
    private static final String LOGO_BELKART = "Белкарт";


    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void beforeEach(){
        driver.get("https://mts.by");
        onCanceledCookies();
    }

    public void onCanceledCookies(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("cookie")));
            driver.findElement(By.className("cookie")).findElements(By.tagName("button")).stream()
                    .filter(button -> button.getText().equals(NAME_BUTTON_CANCEL)).findFirst().get().click();
        }
        catch (Exception e){
            //
        }
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

    @Test
    @DisplayName("Онлайн пополнение без комиссии")
    public void nameTest() {
        WebElement webElement = driver.findElement(By.className("pay__wrapper")).findElement(By.xpath("h2"));
        Assertions.assertEquals(NAME_BLOCK, webElement.getText());
    }

    @Test
    public void logoVisaTest() {
        String visa = "Visa";
        Assertions.assertEquals(true, getLogoNames().contains(LOGO_VISA));
    }

    @Test
    public void logoVerifiedByVisaTest() {
        String visa = "Verified By Visa";
        Assertions.assertEquals(true, getLogoNames().contains(visa));
    }

    @Test
    public void logoMasterCardTest() {
        String visa = "MasterCard";
        Assertions.assertEquals(true, getLogoNames().contains(visa));
    }

    @Test
    public void logoMasterCardSecureCodeTest() {
        String visa = "MasterCard Secure Code";
        Assertions.assertEquals(true, getLogoNames().contains(visa));
    }

    @Test
    public void logoBelkartTest() {
        String visa = "Белкарт";
        Assertions.assertEquals(true, getLogoNames().contains(visa));
    }
    @Test
    public void logTest(){
        Assertions.assertEquals(true, getLogoNames().contains(LOGO_VISA));
        Assertions.assertEquals(true, getLogoNames().contains(LOGO_VERIFIED_BY_VISA));
        Assertions.assertEquals(true, getLogoNames().contains(LOGO_MASTERCARD));
        Assertions.assertEquals(true, getLogoNames().contains(LOGO_MASTERCARD_SECURE_CODE));
        Assertions.assertEquals(true, getLogoNames().contains(LOGO_BELKART));
        Assertions.assertEquals(5, getLogoNames().size());

        List<String> logoNames = getLogoNames();
        logoNames.removeAll(List.of(LOGO_VISA,LOGO_VERIFIED_BY_VISA,LOGO_MASTERCARD,LOGO_MASTERCARD_SECURE_CODE,LOGO_BELKART));
        Assertions.assertEquals(0, logoNames.size());

        for (WebElement logo: getLogos()) {
            Assertions.assertEquals(true, logo.isDisplayed(), logo.getAccessibleName() + " is not displayed");
        }
    }

    public List<WebElement> getLogos(){
        return driver.findElement(By.className("pay__partners")).findElements(By.cssSelector("img"));
    }


    public List<String> getLogoNames() {
        return getLogos().stream()
                .map(webElement -> webElement.getDomAttribute("alt"))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Ссылка \"Подробнее о сервисе\"")
    public void linkTest() {
  //      driver.findElement(By.className("cookie__buttons")).findElements(By.tagName("button")).stream().filter(e -> e.getText().equals("Отклонить")).findFirst().get().click();
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