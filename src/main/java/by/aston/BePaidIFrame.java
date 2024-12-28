package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BePaidIFrame {
    public static final String LABEL_CART_NUMBER = "Номер карты";
    public static final String LABEL_VALIDITY_PERIOD = "Срок действия";
    public static final String LABEL_CVC = "CVC";
    public static final String LABEL_OWNER_NAME = "Имя держателя (как на карте)";
    public static final String LABEL_BUTTON = "Оплатить %s.00 BYN";
    public static final String LABEL_SUM = "%s.00 BYN";
    private WebDriver driver;

    public BePaidIFrame(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));

    }

    public String getPhoneNumber() {
        setWebDriverWaiter("pay-description__text");
        String[] array = driver.findElement(By.className("pay-description__text")).getText().split(":");
        return array[array.length - 1];
    }

    public String getSum() {
        setWebDriverWaiter("pay-description__cost");
        return driver.findElement(By.className("pay-description__cost")).getText();
    }

    public String getSumOnButton() {
        setWebDriverWaiter("colored");
        return driver.findElement(By.className("colored")).getText();
    }

    private List<WebElement> getAppInput() {
        setWebDriverWaiter("app-input");
        return driver.findElements(By.className("app-input"));
    }

    public String getLabelCartNumber() {
        return getAppInput().get(0).getText();
    }

    public String getLabelValidityPeriod() {
        return getAppInput().get(1).getText();
    }

    public String getLabelCVC() {
        return getAppInput().get(2).getText();
    }

    public String getLabelOwnerName() {
        return getAppInput().get(3).getText();
    }

    private void setWebDriverWaiter(String locatorClassName){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorClassName)));
    }
}
