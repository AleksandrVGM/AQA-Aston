package by.aston;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

    protected WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public  String getPlaceHolder(String xpath, String placeholder){
        return driver.findElement(By.xpath(xpath)).getDomAttribute(placeholder);
    }
}
