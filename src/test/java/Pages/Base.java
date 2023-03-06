package Pages;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class Base extends Wait {




    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver","//Users/farhanahmedsheikh/Downloads/chromedriver");
        driver = new ChromeDriver();
            driver.get("https://stage-spyder.daraz.com/scrapy-ui/login");//Open Price Scraper Staging Env
        driver.manage().window().maximize();
        String title = driver.getTitle();
        if (title.contains("Daraz App"))
            System.out.println("Web Page Displayed");
        else{
            System.out.println("Web Page Not Displayed");
        }
//        String Url = driver.getCurrentUrl();
//        String source = driver.getPageSource();
//        System.out.println(title);
//        System.out.println(Url);
//        System.out.println(source);
        return driver;
    }

    public void teardown() {
        driver.quit();
    }

}
