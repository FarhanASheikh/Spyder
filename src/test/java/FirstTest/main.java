package FirstTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class main {

    public static void main(String[] args)  {

        WebDriver driver = Base.driver();

        driver.get("https://stage-spyder.daraz.com/");//Open Price Scraper Staging Env
        driver.manage().window().maximize();
        String title = driver.getTitle();
         if (title.contains("Daraz App"))
             System.out.println("Web Page Displayed");
         String Url = driver.getCurrentUrl();
         String source = driver.getPageSource();
        System.out.println(title);
        System.out.println(Url);
        System.out.println(source);
        LoginPage loginpg=PageFactory.initElements(driver,LoginPage.class);
        loginpg.Check_Login_Displayed();
        loginpg.Verifyfootertext();
        loginpg.CheckLogo();
        loginpg.Login_Case2();
        loginpg.Login_Case4();
        loginpg.Login_Case3();
        loginpg.Login_Case5();
        loginpg.Login_Case1();
        ScraperPage scraperpg = PageFactory.initElements(driver,ScraperPage.class);
        scraperpg.Change_venture();

        scraperpg.Get_Table_Data();
         scraperpg.Start_Scraping_Jobs();
         scraperpg.Success_msg();
        SKUMatchingPage SKUMatchingpg = PageFactory.initElements(driver, SKUMatchingPage.class);
        SKUMatchingpg.Click_SKUMatching_Module();
        SKUMatchingpg.Create_task();
        VerficationQueuePage VQpg = PageFactory.initElements(driver, VerficationQueuePage.class);
        VQpg.GOTO_VQ_Module();
        VQpg.Select_Read_SortBy_filters();
        VQpg.Select_Read_Competitors_filters();
    }
}
