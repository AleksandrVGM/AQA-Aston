package by.aston;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class OnlinePaymentWithoutCommissionTest {

    public static final String PHONE_NUMBER = "297777777";
    public String SUM = "11";

    private OnlinePaymentWithoutCommission onlinePaymentWithoutCommission;
    private static WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setUpEach() {
        onlinePaymentWithoutCommission = new OnlinePaymentWithoutCommission(driver);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void nameOnlinePaymentWithoutCommissionTest() {
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
    public void linkPaymentRulesTest() {
        PaymentRules paymentRules = onlinePaymentWithoutCommission.clickLinkServiceDetails();
        Assertions.assertEquals(PaymentRules.TITLE, paymentRules.getTitle());
        Assertions.assertEquals(PaymentRules.URL, paymentRules.getUrl());
    }

    @Test
    public void labelCartNumberTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        Assertions.assertEquals(BePaidIFrame.LABEL_CART_NUMBER, bePaidIFrame.getLabelCartNumber());
    }
    @Test
    public void labelValidityPeriodTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        Assertions.assertEquals(BePaidIFrame.LABEL_VALIDITY_PERIOD, bePaidIFrame.getLabelValidityPeriod());
    }

    @Test
    public void labelCVCTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        Assertions.assertEquals(BePaidIFrame.LABEL_CVC, bePaidIFrame.getLabelCVC());
    }
    @Test
    public void labelOwnerNameTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        Assertions.assertEquals(BePaidIFrame.LABEL_OWNER_NAME, bePaidIFrame.getLabelOwnerName());
    }

    @Test
    public void phoneNumberTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        String phoneNumber = bePaidIFrame.getPhoneNumber().substring(3);
        Assertions.assertEquals(PHONE_NUMBER, phoneNumber);
    }
    @Test
    public void sumButtonTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        String sum = String.format(BePaidIFrame.LABEL_BUTTON, SUM);
        Assertions.assertEquals(sum, bePaidIFrame.getSumOnButton());
    }
    @Test
    public void sumTest(){
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        String sum = String.format(BePaidIFrame.LABEL_SUM, SUM);
        Assertions.assertEquals(sum, bePaidIFrame.getSum());
    }

    @Test
    public void homeInternet(){
        HomeInternet homeInternet = new HomeInternet(driver);
        homeInternet.getPlaceHolderEMail();
    }

}