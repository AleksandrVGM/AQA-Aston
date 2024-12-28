package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BePaidIFrame {
    public static final String TITLE_PHONE_NUMBER = "Номер карты";
    public static final String TITLE_VALIDITY_PERIOD = "Срок действия";
    public static final String TITLE_CVC = "CVC";
    public static final String TITLE_OWNER_NAME = "Имя держателя (как на карте)";
    private WebDriver driver;

    public BePaidIFrame(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
    }

    public String getPhoneNumber(){
        String[] array = driver.findElement(By.className("pay-description__text")).getText().split(":");
        return array[array.length - 1];
    }

    public String getSum(){
        return driver.findElement(By.className("pay-description__cost")).getText();
    }
    public String getSumOnButton(){
        return driver.findElement(By.className("colored")).getText();
    }

    private List<WebElement> getAppInput(){
        return driver.findElements(By.className("app-input"));
    }

    public String getLabelCartNumber(){
        return getAppInput().get(0).getText();
    }

    public String getLabelValidityPeriod(){
        return getAppInput().get(1).getText();
    }

    public String getLabelCVC(){
        return getAppInput().get(2).getText();
    }

    public String getLabelOwnerName(){
        return getAppInput().get(3).getText();
    }



}
