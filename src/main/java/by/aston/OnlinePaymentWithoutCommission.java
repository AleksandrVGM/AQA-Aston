package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OnlinePaymentWithoutCommission {

    public static final String NAME_BUTTON_CANCEL = "Отклонить";
    public static final String PHONE_NUMBER = "Номер телефона";
    public static final String PLACEHOLDER_SUM = "Сумма";
    public static final String PLACEHOLDER_EMAIL = "E-mail для отправки чека";
    public static final String LOGO_VISA = "Visa";
    public static final String LOGO_VERIFIED_BY_VISA = "Verified By Visa";
    public static final String LOGO_MASTERCARD = "MasterCard";
    public static final String LOGO_MASTERCARD_SECURE_CODE = "MasterCard Secure Code";
    public static final String LOGO_BELKART = "Белкарт";

    private WebDriver driver;

    public OnlinePaymentWithoutCommission(WebDriver driver) {
        this.driver = driver;
        driver.get("https://mts.by");
        onCanceledCookies();
    }

    public String getPlaceHolderPhoneNumber(){
        return getPlaceHolder("//*[@id=\"connection-phone\"]", "placeholder");
    }

    public String getPlaceHolderSum(){
        return getPlaceHolder("//*[@id=\"connection-sum\"]", "placeholder");
    }

    public String getPlaceHolderEMail(){
        return getPlaceHolder("//*[@id=\"connection-email\"]", "placeholder");
    }

    private String getPlaceHolder(String xpath, String placeholder){
        return driver.findElement(By.xpath(xpath)).getDomAttribute(placeholder);
    }

    public String getName(){
        WebElement webElement = driver.findElement(By.className("pay__wrapper")).findElement(By.xpath("h2"));
        return webElement.getText();
    }

    public List<WebElement> getLogos() {
        return driver.findElement(By.className("pay__partners")).findElements(By.cssSelector("img"));
    }

    public List<String> getLogoNames() {
        return driver.findElement(By.className("pay__partners")).findElements(By.cssSelector("img"))
                .stream().map(webElement -> webElement.getDomAttribute("alt"))
                .collect(Collectors.toList());
    }

    public boolean isVisible(String nameLogo){
        return getLogos().stream().
                filter(webElement -> webElement.getDomAttribute("alt").equals(nameLogo)).findFirst().get().isDisplayed();
    }

    public PaymentRules clickLinkServiceDetails(){
        WebElement link = driver.findElement(By.className("pay__wrapper")).findElement(By.cssSelector("a"));
        link.click();
        return new PaymentRules(driver);
    }

    public OnlinePaymentWithoutCommission typePhoneNumber(String phoneNumber){
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.sendKeys(phoneNumber);
        return this;
    }

    public OnlinePaymentWithoutCommission typeSum(String sum){
        WebElement money = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        money.sendKeys(sum);
        return this;
    }

    public BePaidIFrame submitPayButton(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]")).findElement(By.className("button"));
        button.click();
        return new BePaidIFrame(driver);
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



}
