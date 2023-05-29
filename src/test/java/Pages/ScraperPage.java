package Pages;
import Object.ScraperPageObjects;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ScraperPage extends Wait {



    static int a = 0;
    static int b = 0;

    public void left_menu_scraper_selection(){
       ScraperPageObjects spo = new ScraperPageObjects(driver);
       String scraper_module_nav_class = spo.scraper_module_nav.getAttribute("Class");
       Assert.assertEquals("active",scraper_module_nav_class);

    }
    public void pagetitle(){
        ScraperPageObjects spo = new ScraperPageObjects(driver);
      String pagetitle_text = spo.pagetitle.getText();
        Assert.assertEquals("Welcome to Pricing portal",pagetitle_text);
    }
    public void select20records() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        waitforelement().until(ExpectedConditions.visibilityOf(spo.records_20)).click();
        Thread.sleep(25000);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.last_id);
        int rec_20 = Integer.parseInt(spo.last_id.getText());
        Assert.assertEquals(20,rec_20);
        spo.records_10.click();


    }

    public void Change_venture() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.venture_dropdown)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.select_venture)).click();
        Thread.sleep(9000);
    }

    public void get_table_data() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);

        for (int i = 1; i <= spo.rowelement.size(); i++) {
            for (int j = 1; j <= spo.colelement.size(); j++) {
                System.out.println(driver.findElement(By.xpath("//*[@id='scrapyDetailtable']/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");


            }
        }
    }

    public void check_cancel_button() throws InterruptedException {
        driver.navigate().refresh();
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", spo.button_Initiate_Job);
        Thread.sleep(2000);
        Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.cancel_button)).click();
    }

        public void Start_Scraping_Jobs() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", spo.button_Initiate_Job);
        Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Pickaboo_bd)).click();//Select competitors to scrape
            Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Shajgoj)).click();//Select competitors to scrape
            Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Chaldal_bd)).click();//Select competitors to scrape
            Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_PandaMart)).click();///Select competitors to scrape
            Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.button_Done)).click();//Click Done button

    }


    public void Success_msg() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        //Check and compare pop up text
        String Jobstart = Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.Success_msg)).getText();
        Assert.assertEquals(Jobstart, "IniateJob SUCCESSFULLY!");
    }

    public void     get_table_data_before_job_start() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        Thread.sleep(30000);
        boolean ispresent = Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.check_bd)).isDisplayed();
        Assert.assertTrue(ispresent);
        int Beforejob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
            waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Beforejob_tablesize-2))).click();
            Thread.sleep(30000);
            a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
        System.out.println(a);
        }
    public void     getandcomparedata() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Thread.sleep(10000);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.pagination.get(1));
        int Afterjob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
            Thread.sleep(19000);
           waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-2))).click();
        Thread.sleep(20000);
             b = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
            Assert.assertEquals(b, a + 4);
        spo.pagination.get(Afterjob_tablesize-8).click();
        Thread.sleep(10000);

        }
    }