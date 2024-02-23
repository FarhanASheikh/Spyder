package Pages;
import Object.ScraperPageObjects;
import Utilities.ThreadStorage;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ScraperPage extends Wait {



    static int a = 0;
    static int b = 0;

    public void click_scraper_module() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        try{
        waitforelement().until(ExpectedConditions.elementToBeClickable(spo.scraper_module_nav)).click();
        }
        catch (Exception e ){
            jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.hamburger_icon);
            spo.hamburger_icon.click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(spo.scraper_module_nav)).click();
        }
        String scraper_module_nav_class = spo.scraper_module_nav.getAttribute("Class");
        Assert.assertEquals("active", scraper_module_nav_class);

    }

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
        jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.records_20);
        spo.records_20.click();
        Thread.sleep(25000);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.last_id);
        int rec_20 = Integer.parseInt(spo.last_id.getText());
        Assert.assertEquals(20,rec_20);
        jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.records_10);
        spo.records_10.click();
        System.out.println(rec_20);


    }

    public void Change_venture() throws InterruptedException {
        switch (ThreadStorage.get("venture")){
            case "BD": {
                ScraperPageObjects spo = new ScraperPageObjects(driver);
                Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.venture_dropdown)).click();
                Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.select_BD_venture)).click();
                Thread.sleep(2000);
            }
            break;
            case "PK":{
                ScraperPageObjects spo = new ScraperPageObjects(driver);
                Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.venture_dropdown)).click();
                Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.select_PK_venture)).click();
                Thread.sleep(2000);

            }
            break;
            case "LK":{
                ScraperPageObjects spo = new ScraperPageObjects(driver);
                Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.venture_dropdown)).click();
                Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.select_LK_venture)).click();
                Thread.sleep(2000);

            }
    }
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
        Thread.sleep(4000);
        Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.cancel_button)).click();
        Thread.sleep(1000);
    }

        public void Start_Scraping_Jobs() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", spo.button_Initiate_Job);
            Thread.sleep(2000);
            switch (ThreadStorage.get("venture")){
                case "BD": {
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Pickaboo_bd)).click();//Select competitors to scrape
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Shajgoj)).click();//Select competitors to scrape
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Chaldal_bd)).click();//Select competitors to scrape
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_PandaMart)).click();///Select competitors to scrape
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Startech_bd)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Aliexpress_bd)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Diamu_bd)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Othoba_bd)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Ryans_bd)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Fixit_bd)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.button_Done)).click();//Click Done button
                }break;
                case "PK":{
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Grocersapp)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_shophive)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_ishopping)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_foodpanda)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_telemart)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_carrefour)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_alfatah)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_aliexpress)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_metro)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_naheed)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.button_Done)).click();


                }
                break;
                case "LK":{
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Keellssuper_lk)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Glomark_lk)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Wasi_lk)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Ideabeam_lk)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_Greasemonkey_lk)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_MySoftlogic)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_AliExpress)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_MyarpicoLK)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.select_CarGill)).click();
                    Wait.waitforelement().until(ExpectedConditions.elementToBeClickable(spo.button_Done)).click();
                }

            }

    }


    public void Success_msg() {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        //Check and compare pop up text
        String Jobstart = Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.Success_msg)).getText();
        Assert.assertEquals(Jobstart, "IniateJob SUCCESSFULLY!");
        System.out.println("Status -IniateJob SUCCESSFULLY ");
    }

    public void     get_table_data_before_job_start() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        Thread.sleep(4000);
        switch (ThreadStorage.get("venture")){
            case "BD": {
        boolean ispresent = Wait.waitforelement().until(ExpectedConditions.visibilityOf(spo.check_bd)).isDisplayed();
        Assert.assertTrue(ispresent);
        int Beforejob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
        Thread.sleep(20000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Beforejob_tablesize-2))).click();
            Thread.sleep(30000);
            a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
        System.out.println(a);
        }
        break;
            case "PK":{
                int Beforejob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
                Thread.sleep(2000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Beforejob_tablesize-2))).click();
                Thread.sleep(3000);
                a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
                System.out.println(a);
            }
            break;
            case "LK":{
                int Beforejob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
                Thread.sleep(2000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Beforejob_tablesize-2))).click();
                Thread.sleep(3000);
                a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
                System.out.println(a);
            }

            }}

    public void     getandcomparedata() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Thread.sleep(10000);
        switch (ThreadStorage.get("venture")){
            case "BD": {
        jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.pagination.get(1));
        int Afterjob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
            Thread.sleep(29000);
           waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-2))).click();
        Thread.sleep(20000);
             b = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
        System.out.println(b);
            Assert.assertEquals(b, a + 10);
        Thread.sleep(29000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-8))).click();
        Thread.sleep(10000);
        System.out.println("Status-- "+b);

        }
        break;
            case "PK":{
                jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.pagination.get(1));
                int Afterjob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
                Thread.sleep(2900);
                waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-2))).click();
                Thread.sleep(2000);
                b = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
                System.out.println(b);
                Assert.assertEquals(b, a + 10);
                Thread.sleep(2900);
                waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-8))).click();
                Thread.sleep(1000);
                System.out.println("Status-- "+b);
            }
            break;
            case "LK":{
                jsExecutor.executeScript("arguments[0].scrollIntoView();",spo.pagination.get(1));
                int Afterjob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
                Thread.sleep(2900);
                waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-2))).click();
                Thread.sleep(2000);
                b = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(spo.last_id)).getText());
                System.out.println(b);
                Assert.assertEquals(b, a + 10);
                Thread.sleep(2900);
                waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Afterjob_tablesize-4))).click();
                Thread.sleep(1000);
                System.out.println("Status-- "+b);
            }

            }}}