package by.aston;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class OnlinePaymentWithoutCommissionTest {

    private OnlinePaymentWithoutCommission onlinePaymentWithoutCommission;
    private static WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setUpEach() {
        driver.get("https://mts.by");
        onlinePaymentWithoutCommission = new OnlinePaymentWithoutCommission(driver);
    }


    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void nameTest() {
        String name = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(name, onlinePaymentWithoutCommission.getName());
    }

    @Test
    public void logoVisaTest() {
        String visa = "Visa";
        Assertions.assertEquals(true, onlinePaymentWithoutCommission.getPartners().contains(visa));
    }

    @Test
    public void logoVerifiedByVisaTest() {
        String verifiedByVisa = "Verified By Visa";
        Assertions.assertEquals(true, onlinePaymentWithoutCommission.getPartners().contains(verifiedByVisa));
    }

    @Test
    public void logoMasterCardTest() {
        String masterCard = "MasterCard";
        Assertions.assertEquals(true, onlinePaymentWithoutCommission.getPartners().contains(masterCard));
    }

    @Test
    public void logoMasterCardSecureCodeTest() {
        String MasterCardSecureCode = "MasterCard Secure Code";
        Assertions.assertEquals(true, onlinePaymentWithoutCommission.getPartners().contains(MasterCardSecureCode));
    }

    @Test
    public void logoBelkartTest() {
        String belkart = "Белкарт";
        Assertions.assertEquals(true, onlinePaymentWithoutCommission.getPartners().contains(belkart));
    }

    @Test
    public void linkTest() {
        PaymentRules paymentRules = onlinePaymentWithoutCommission.clickLinkServiceDetails();
        Assertions.assertEquals(PaymentRules.TITLE, paymentRules.getTitle());
        Assertions.assertEquals(PaymentRules.URL, paymentRules.getUrl());
    }

    @Test
    public void paymentTest(){
        String phoneNumber = "297777777";
        String sum = "11";
        /*should return new object page*/
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(phoneNumber).typeSum(sum).submitPayButton();
//        driver.findElement(By.className("cookie")).findElements(By.tagName("button")).stream().filter(webElement -> webElement.getText().equals("Отклонить")).findFirst().get();


//        bePaidIFrame.getPhoneNumber()

//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));

        driver.findElement(By.className("pay-description__text")).getText();//Оплата: Услуги связи Номер:375297777777
        driver.findElement(By.className("pay-description__cost")).getText();//11.00 BYN
        driver.findElement(By.id("cc-number")).getTagName(); // number card




        driver.findElement(By.className("colored")).getText();//button 11 BYN

        driver.findElement(By.className("app-input")).findElement(By.tagName("label")).getText();
        driver.findElement(By.className("ng-tns-c46-3")).getText(); //Имя держателя (как на карте)



//        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));
        System.out.println("end");

    }


}