package Pages;

import Object.ScraperPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class ScraperPage extends Base {

    ScraperPageObjects spo = new ScraperPageObjects();

        public ScraperPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver,spo);
    }
    public void Change_venture() {

            wait.until(ExpectedConditions.visibilityOf(spo.venture_dropdown)).click();

        wait.until(ExpectedConditions.visibilityOf(spo.select_venture)).click();
        }
        public void Get_Table_Data(){
            System.out.println(spo.rowelement.size());//
            System.out.println(spo.colelement.size());//
            for (int i =1; i<=spo.rowelement.size(); i++){
                for (int j = 1 ; j<=spo.colelement.size(); j++){
                    System.out.println(driver.findElement(By.xpath("//*[@id='scrapyDetailtable']/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");

                }
            }
        }
       public void Start_Scraping_Jobs() {

           spo.button_Initiate_Job.click();//Click intiate Job button
           wait.until(ExpectedConditions.visibilityOf(spo.select_Pickaboo_bd)).click();//Select competitors to scrape
           spo.select_Shajgoj.click();//Select competitors to scrape
           spo.select_Chaldal_bd.click();//Select competitors to scrape
           spo.select_PandaMart.click();///Select competitors to scrape
           spo.button_Done.click();//Click Done button
       }

       public void Success_msg(){
           //Check and compare pop up text
           String Jobstart = wait.until(ExpectedConditions.visibilityOf(spo.Success_msg)).getText();
           if(Jobstart.contains("IniateJob SUCCESSFULLY!")){
               System.out.println("Jobstarted");}
           else {
               System.out.println("IniateJob Unsuccessfull");
           }
       }

    }
