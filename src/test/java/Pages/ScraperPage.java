package Pages;
import Object.ScraperPageObjects;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ScraperPage extends Wait {

    int a =0;
    public void Change_venture() {

        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).venture_dropdown)).click();

        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).select_venture)).click();
    }

    public void Get_Table_Data() {

        for (int i = 1; i <= new ScraperPageObjects(driver).rowelement.size(); i++) {
            for (int j = 1; j <= new ScraperPageObjects(driver).colelement.size(); j++) {
                System.out.println(driver.findElement(By.xpath("//*[@id='scrapyDetailtable']/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");


            }
        }
    }

    public void check_cancel_button() {
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).button_Initiate_Job)).click();//Click intiate Job button
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).cancel_button)).click();
    }

    public void Start_Scraping_Jobs() {
        new ScraperPageObjects(driver).button_Initiate_Job.click();//Click intiate Job button
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).select_Pickaboo_bd)).click();//Select competitors to scrape
        new ScraperPageObjects(driver).select_Shajgoj.click();//Select competitors to scrape
        new ScraperPageObjects(driver).select_Chaldal_bd.click();//Select competitors to scrape
        new ScraperPageObjects(driver).select_PandaMart.click();///Select competitors to scrape
        new ScraperPageObjects(driver).button_Done.click();//Click Done button
    }


    public void Success_msg() {
        //Check and compare pop up text
        String Jobstart = Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).Success_msg)).getText();
        Assert.assertEquals(Jobstart, "IniateJob SUCCESSFULLY!");
        Assert.assertNotEquals(Jobstart, "Something went wrong, try again later!");
    }

    public void pagination(){
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).wait));
        int Test = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(new ScraperPageObjects(driver).pagination)).size();
        new ScraperPageObjects(driver).pagination.get(Test-2).click();
         a = Integer.parseInt(new ScraperPageObjects(driver).last_id.getText());
            }
    public void getandcomparedata(){
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new ScraperPageObjects(driver).wait));
        int Test = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(new ScraperPageObjects(driver).pagination)).size();
        new ScraperPageObjects(driver).pagination.get(Test-2).click();
        int b = Integer.parseInt(new ScraperPageObjects(driver).last_id.getText());
        Assert.assertEquals(b,a+4);

    }
}