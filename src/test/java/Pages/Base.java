package Pages;

import Utilities.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Base extends Wait {



    public WebDriver driver() throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        WebDriverManager.chromedriver().setup();
        System.out.println("\n\nCurrent OS is: "+os+"\n\n");
        if(os.equalsIgnoreCase("mac os x")) {
            WebDriverManager.chromedriver().setup();
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080", "--window-position=0,0", "--remote-allow-origins=*");
            driver = new ChromeDriver();
        }
        else {

            Runtime.getRuntime().exec("sudo apt-get install xvfb");
            WebDriverManager.chromedriver().setup();
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            options.setBinary("/usr/bin/google-chrome");
            options.addArguments("disable-dev-shm-usage"); // recommended for running in Docker
            options.addArguments("no-sandbox"); // recommended for running in Docker
            options.addArguments("start-maximized"); // recommended for running in Docker
            options.addArguments("disable-gpu"); // recommended for running in Docker
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-component-update", "disable-default-apps", "disable-popup-blocking"));
            Runtime.getRuntime().exec("xvfb-run -a -s \"-screen 0 1920x1080x24\" google-chrome");
            driver = new ChromeDriver(service, options);

        }
            driver.get("https://spyder.daraz.com/scrapy-ui/login");//Open Price Scraper Staging Env
        String title = driver.getTitle();
        if (title.contains("Daraz App"))
            System.out.println("Web Page Displayed");
        else{
            System.out.println("Web Page Not Displayed");
        }

        return driver;
    }
    public void delete_allure_results() {

            String folderPath = System.getProperty("user.dir")+"/allure-results";

            // Create a Path object for the folder
            Path folder = Paths.get(folderPath);

            // Check if the folder exists
            if (Files.exists(folder) && Files.isDirectory(folder)) {
                try {
                    // Delete the folder
                    Files.delete(folder);
                    System.out.println("Folder deleted: " + folderPath);
                } catch (IOException e) {
                    // Handle exception as needed
                    e.printStackTrace();
                }
            } else {
                System.out.println("Folder does not exist: " + folderPath);
            }
        }
    public  void teardown() {
        driver.quit();
    }

}
