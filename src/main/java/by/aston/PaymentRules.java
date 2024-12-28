package by.aston;

import org.openqa.selenium.WebDriver;

public class PaymentRules {
    public static final String TITLE = "Порядок оплаты и безопасность интернет платежей";
    public static final String URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private WebDriver driver;

    public PaymentRules(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }




}
