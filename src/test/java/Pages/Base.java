package Pages;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;


public class Base extends Wait {



    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver","//Users/farhanahmedsheikh/Downloads/chromedriver");
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080", "--window-position=0,0");
            driver = new ChromeDriver(options);
            driver.get("https://stage-spyder.daraz.com/scrapy-ui/login");//Open Price Scraper Staging Env
        driver.manage().window().maximize();
        String title = driver.getTitle();
        if (title.contains("Daraz App"))
            System.out.println("Web Page Displayed");
        else{
            System.out.println("Web Page Not Displayed");
        }

        return driver;
    }

    public  void teardown() {
        driver.quit();
    }

}
