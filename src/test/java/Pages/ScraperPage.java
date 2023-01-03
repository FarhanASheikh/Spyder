package Pages;
import Object.ScraperPageObjects;
import Utilities.Wait;
import org.openqa.selenium.By;
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
        spo.records_20.click();
        Thread.sleep(2000);
        int rec_20 = Integer.parseInt(spo.last_id.getText());
        Assert.assertEquals(20,rec_20);
        spo.records_10.click();


    }

    public void Change_venture() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);

        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.venture_dropdown)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.select_venture)).click();
        Thread.sleep(3000);
    }

    public void Get_Table_Data() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);

        for (int i = 1; i <= spo.rowelement.size(); i++) {
            for (int j = 1; j <= spo.colelement.size(); j++) {
                System.out.println(driver.findElement(By.xpath("//*[@id='scrapyDetailtable']/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");


            }
        }
    }

    public void check_cancel_button() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.button_Initiate_Job)).click();//Click intiate Job button
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.cancel_button)).click();
    }

    public void Start_Scraping_Jobs() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        spo.button_Initiate_Job.click();//Click intiate Job button
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.select_Pickaboo_bd)).click();//Select competitors to scrape
        spo.select_Shajgoj.click();//Select competitors to scrape
        spo.select_Chaldal_bd.click();//Select competitors to scrape
        spo.select_PandaMart.click();///Select competitors to scrape
        spo.button_Done.click();//Click Done button

    }


    public void Success_msg() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        //Check and compare pop up text
        String Jobstart = Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.Success_msg)).getText();
        Assert.assertEquals(Jobstart, "IniateJob SUCCESSFULLY!");
        Assert.assertNotEquals(Jobstart, "Something went wrong, try again later!");
    }

    public void pagination() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        boolean ispresent = Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.check_bd)).isDisplayed();
        Assert.assertTrue(ispresent);
        Thread.sleep(3000);
        int Beforejob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
            spo.pagination.get(Beforejob_tablesize-2).click();
            Thread.sleep(3000);
            a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
        System.out.println(a);
        }
    public void getandcomparedata() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        Thread.sleep(3000);
        int Afterjob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
            Thread.sleep(3000);
            spo.pagination.get(Afterjob_tablesize-2).click();
        Thread.sleep(3000);
             b = Integer.parseInt(spo.last_id.getText());
            Assert.assertEquals(b, a + 4);

        }
    }