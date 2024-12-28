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

    private WebDriver driver;

    public OnlinePaymentWithoutCommission(WebDriver driver) {
        this.driver = driver;
        driver.get("https://mts.by");
        onCanceledCookies();
    }

    public String getName(){
        WebElement webElement = driver.findElement(By.className("pay__wrapper")).findElement(By.xpath("h2"));
        return webElement.getText();
    }

    public List<String> getPartners() {
        return driver.findElement(By.className("pay__partners")).findElements(By.cssSelector("img"))
                .stream().map(webElement -> webElement.getDomAttribute("alt"))
                .collect(Collectors.toList());
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
        // should return object page with payment details
    }


    //deleted
    public void paymentTest(){
        WebElement select_now = driver.findElement(By.className("select__header")).findElement(By.className("select__now"));
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.sendKeys("297777777");
        WebElement money = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        money.sendKeys("11");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]")).findElement(By.className("button"));
        button.click();
    }

    public void onCanceledCookies(){
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("cookie")));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("cookie")));
            driver.findElement(By.className("cookie")).findElements(By.tagName("button")).stream()
                    .filter(button -> button.getText().equals(NAME_BUTTON_CANCEL)).findFirst().get().click();

        }
        catch (Exception e){

        }

    }
}
