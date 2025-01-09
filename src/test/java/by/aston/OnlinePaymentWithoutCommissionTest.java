package by.aston;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class OnlinePaymentWithoutCommissionTest {

    public static final String PHONE_NUMBER = "297777777";
    private static WebDriver driver;
    public String SUM = "11";
    private OnlinePaymentWithoutCommission onlinePaymentWithoutCommission;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    void setUpEach() {
        onlinePaymentWithoutCommission = new OnlinePaymentWithoutCommission(driver);
    }

    @Test
    public void nameOnlinePaymentWithoutCommissionTest() {
        String name = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(name, onlinePaymentWithoutCommission.getName());
    }

    @Test
    public void logoTest() {
        Assertions.assertTrue(onlinePaymentWithoutCommission.getLogoNames().contains(OnlinePaymentWithoutCommission.LOGO_VISA));
        Assertions.assertTrue(onlinePaymentWithoutCommission.getLogoNames().contains(OnlinePaymentWithoutCommission.LOGO_VERIFIED_BY_VISA));
        Assertions.assertTrue(onlinePaymentWithoutCommission.getLogoNames().contains(OnlinePaymentWithoutCommission.LOGO_MASTERCARD));
        Assertions.assertTrue(onlinePaymentWithoutCommission.getLogoNames().contains(OnlinePaymentWithoutCommission.LOGO_MASTERCARD_SECURE_CODE));
        Assertions.assertTrue(onlinePaymentWithoutCommission.getLogoNames().contains(OnlinePaymentWithoutCommission.LOGO_BELKART));
        Assertions.assertEquals(5, onlinePaymentWithoutCommission.getLogoNames().size());

        List<String> logoNames = onlinePaymentWithoutCommission.getLogoNames();
        logoNames.removeAll(List.of(OnlinePaymentWithoutCommission.LOGO_VISA,
                OnlinePaymentWithoutCommission.LOGO_VERIFIED_BY_VISA,
                OnlinePaymentWithoutCommission.LOGO_MASTERCARD,
                OnlinePaymentWithoutCommission.LOGO_MASTERCARD_SECURE_CODE,
                OnlinePaymentWithoutCommission.LOGO_BELKART));
        Assertions.assertEquals(0, logoNames.size());

        Assertions.assertTrue(onlinePaymentWithoutCommission.isVisible(OnlinePaymentWithoutCommission.LOGO_VISA));
        Assertions.assertTrue(onlinePaymentWithoutCommission.isVisible(OnlinePaymentWithoutCommission.LOGO_VERIFIED_BY_VISA));
        Assertions.assertTrue(onlinePaymentWithoutCommission.isVisible(OnlinePaymentWithoutCommission.LOGO_MASTERCARD));
        Assertions.assertTrue(onlinePaymentWithoutCommission.isVisible(OnlinePaymentWithoutCommission.LOGO_MASTERCARD_SECURE_CODE));
        Assertions.assertTrue(onlinePaymentWithoutCommission.isVisible(OnlinePaymentWithoutCommission.LOGO_BELKART));

    }

    @Test
    public void linkPaymentRulesTest() {
        PaymentRules paymentRules = onlinePaymentWithoutCommission.clickLinkServiceDetails();
        Assertions.assertEquals(PaymentRules.TITLE, paymentRules.getTitle());
        Assertions.assertEquals(PaymentRules.URL, paymentRules.getUrl());
    }

    @Test
    public void labelCardTest() {
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        Assertions.assertAll(() -> Assertions.assertEquals(BePaidIFrame.LABEL_CARD_NUMBER, bePaidIFrame.getLabelCartNumber()),
                () -> Assertions.assertEquals(BePaidIFrame.LABEL_VALIDITY_PERIOD, bePaidIFrame.getLabelValidityPeriod()),
                () -> Assertions.assertEquals(BePaidIFrame.LABEL_CVC, bePaidIFrame.getLabelCVC()),
                () -> Assertions.assertEquals(BePaidIFrame.LABEL_OWNER_NAME, bePaidIFrame.getLabelOwnerName()));
    }

    @Test
    public void paymentTest() {
        BePaidIFrame bePaidIFrame = onlinePaymentWithoutCommission.typePhoneNumber(PHONE_NUMBER).typeSum(SUM).submitPayButton();
        Assertions.assertAll(() -> Assertions.assertEquals(PHONE_NUMBER, bePaidIFrame.getPhoneNumber().substring(3)),
                () -> Assertions.assertEquals(String.format(BePaidIFrame.LABEL_BUTTON, SUM), bePaidIFrame.getSumOnButton()),
                () -> Assertions.assertEquals(String.format(BePaidIFrame.LABEL_SUM, SUM), bePaidIFrame.getSum()));
    }

    @Test
    public void homeInternetPlaceHoldersTest() {
        HomeInternet homeInternet = new HomeInternet(driver);
/*
        driver.findElement(By.className("select__header")).click();

//        new Actions(driver).click(driver.findElement(By.xpath("//section/div/div[1]/div[1]/div[2]/ul/li[2]/p"))).build().perform();
        WebElement element = driver.findElement(By.xpath("//section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        element.click();
//        new Actions(driver).click(driver.findElement(By.xpath("//section/div/div[1]/div[1]/div[2]/ul/li[3]/p"))).build().perform();
        homeInternet.getPlaceHolderEMail();
*/
        Assertions.assertEquals(HomeInternet.PLACEHOLDER_ABONENT_NUMBER, homeInternet.getPlaceHolderPhoneNumber());
        Assertions.assertEquals(HomeInternet.PLACEHOLDER_SUM, homeInternet.getPlaceHolderSum());
        Assertions.assertEquals(HomeInternet.PLACEHOLDER_EMAIL, homeInternet.getPlaceHolderEMail());
    }

    @Test
    public void instalmentPlaceHoldersTest() {
        Instalment instalment = new Instalment(driver);
        Assertions.assertEquals(Instalment.SCORE_INSTALMENT, instalment.getPlaceHolderScoreInstalment());
        Assertions.assertEquals(Instalment.PLACEHOLDER_SUM, instalment.getPlaceHolderSum());
        Assertions.assertEquals(Instalment.PLACEHOLDER_EMAIL, instalment.getPlaceHolderEMail());
    }

    @Test
    public void indebtednessPlaceHoldersTest() {
        Indebtedness indebtedness = new Indebtedness(driver);
        Assertions.assertAll(() -> Assertions.assertEquals(Indebtedness.SCORE_ARREARS, indebtedness.getPlaceHolderScoreArrears()),
                () -> Assertions.assertEquals(Indebtedness.PLACEHOLDER_SUM, indebtedness.getPlaceHolderSum()),
                () -> Assertions.assertEquals(Indebtedness.PLACEHOLDER_EMAIL, indebtedness.getPlaceHolderEMail()));
    }

    @Test
    public void onlinePaymentWithoutCommissionPlaceHolderTest() {
        Assertions.assertAll(() -> Assertions.assertEquals(OnlinePaymentWithoutCommission.PHONE_NUMBER, onlinePaymentWithoutCommission.getPlaceHolderPhoneNumber()),
                () -> Assertions.assertEquals(OnlinePaymentWithoutCommission.PLACEHOLDER_SUM, onlinePaymentWithoutCommission.getPlaceHolderSum()),
                () -> Assertions.assertEquals(OnlinePaymentWithoutCommission.PLACEHOLDER_EMAIL, onlinePaymentWithoutCommission.getPlaceHolderEMail()));
    }

}