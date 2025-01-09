package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Indebtedness extends CommonUtils{
    public static final String SCORE_ARREARS = "Номер счета на 2073";
    public static final String PLACEHOLDER_SUM = "Сумма";
    public static final String PLACEHOLDER_EMAIL = "E-mail для отправки чека";
    public Indebtedness(WebDriver driver) {
        super(driver);
    }
    public String getPlaceHolderScoreArrears(){
        return getPlaceHolder("//*[@id=\"score-arrears\"]", "placeholder");
    }

    public String getPlaceHolderSum(){
        return getPlaceHolder("//*[@id=\"arrears-sum\"]", "placeholder");
    }

    public String getPlaceHolderEMail(){
        return getPlaceHolder("//*[@id=\"arrears-email\"]", "placeholder");
    }
}
