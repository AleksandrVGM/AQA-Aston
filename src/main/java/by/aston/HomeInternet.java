package by.aston;

import org.openqa.selenium.WebDriver;

public class HomeInternet extends CommonUtils {
    public static final String PLACEHOLDER_ABONENT_NUMBER = "Номер абонента";
    public static final String PLACEHOLDER_SUM = "Сумма";
    public static final String PLACEHOLDER_EMAIL = "E-mail для отправки чека";

    public HomeInternet(WebDriver driver) {
        super(driver);
    }

    public String getPlaceHolderPhoneNumber() {
        return getPlaceHolder("//*[@id=\"internet-phone\"]", "placeholder");
    }

    public String getPlaceHolderSum() {
        return getPlaceHolder("//*[@id=\"internet-sum\"]", "placeholder");
    }

    public String getPlaceHolderEMail() {
        return getPlaceHolder("//*[@id=\"internet-email\"]", "placeholder");
    }
}
