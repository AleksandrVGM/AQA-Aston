package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class OnlinePaymentWithoutCommission {

    private WebDriver driver;

    public OnlinePaymentWithoutCommission(WebDriver driver) {
        this.driver = driver;
        driver.get("https://mts.by");
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

    public void paymentTest(){
        WebElement select_now = driver.findElement(By.className("select__header")).findElement(By.className("select__now"));
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.sendKeys("297777777");
        WebElement money = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        money.sendKeys("11");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]")).findElement(By.className("button"));
        button.click();
    }

}
