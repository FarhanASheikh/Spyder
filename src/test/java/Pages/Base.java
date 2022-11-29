package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver driver() {
        System.setProperty("webdriver.chrome.driver","/Users/farhanahmedsheikh/Downloads/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    WebDriverWait wait= new WebDriverWait(driver,5);



}
