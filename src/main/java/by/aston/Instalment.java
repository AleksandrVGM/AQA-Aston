package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Instalment extends CommonUtils {
    public static final String SCORE_INSTALMENT = "Номер счета на 44";
    public static final String PLACEHOLDER_SUM = "Сумма";
    public static final String PLACEHOLDER_EMAIL = "E-mail для отправки чека";

    public Instalment(WebDriver driver) {
        super(driver);
    }

    public String getPlaceHolderScoreInstalment() {
        return getPlaceHolder("//*[@id=\"score-instalment\"]", "placeholder");
    }

    public String getPlaceHolderSum() {
        return getPlaceHolder("//*[@id=\"instalment-sum\"]", "placeholder");
    }

    public String getPlaceHolderEMail() {
        return getPlaceHolder("//*[@id=\"instalment-email\"]", "placeholder");
    }
}
