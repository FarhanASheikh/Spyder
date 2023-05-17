package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait{
    public static WebDriver driver;
    public static WebDriver wait =null;
    public static WebDriverWait waitforelement() {
         return new WebDriverWait(driver, 120);
    }






}
