package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomeInternet {
    public static final String PLACEHOLDER_ABONENT_NUMBER = "Номер абонента";
    public static final String PLACEHOLDER_SUM = "Сумма";
    public static final String PLACEHOLDER_EMAIL = "E-mail для отправки чека";
    private WebDriver driver;
    public HomeInternet(WebDriver driver) {
        this.driver = driver;
    }

    //driver.findElement(By.className("select__now")).getText() //Домашний интернет

    public String getPlaceHolderPhoneNumber(){
        return getPlaceHolder("//*[@id=\"internet-phone\"]", "placeholder");
    }

    public String getPlaceHolderSum(){
        return getPlaceHolder("//*[@id=\"internet-sum\"]", "placeholder");
    }

    public String getPlaceHolderEMail(){

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.className("select__now"))).click(driver.findElements(By.className("select__item")).get(1)).build().perform();


        WebElement element = driver.findElement(By.xpath("//ul[@class='select__list']//select__option[text()='Рассрочка']"));
        element.click();

        Select select = new Select(driver.findElements(By.className("select__option")).get(1));
        select.selectByIndex(2);

        //TODO
        //!!!!!!!!!!!!!!!!!!!!!!!!1 Xpath for Выподающий список
        new Actions(driver).click(driver.findElement(By.xpath("//section/div/div[1]/div[1]/div[2]/ul/li[3]/p"))).build().perform();

//        driver.findElement(By.xpath("//ul[@class='select__list']//p[@class='select__option'][text()='Рассрочка']"))

        return getPlaceHolder("//*[@id=\"internet-email\"]", "placeholder");
    }

    private String getPlaceHolder(String xpath, String placeholder){
        return driver.findElement(By.xpath(xpath)).getDomAttribute(placeholder);
    }



}
