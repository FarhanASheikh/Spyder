package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait{
    public static WebDriver driver;
    public static WebDriver wait =null;
    public static WebDriverWait waitforelement() {
        int seconds = 60; // Replace this with your desired number of seconds
        Duration duration = Duration.ofSeconds(seconds);
         return new WebDriverWait(driver, duration);
    }






}
