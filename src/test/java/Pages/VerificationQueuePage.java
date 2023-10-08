package Pages;
import Object.VerificationQueuePageObjects;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Object.SKUMatchingPageObjects;

public class VerificationQueuePage extends Wait {






    public void click_verfication_queue_module() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.navigate().refresh();
        try{
            waitforelement().until(ExpectedConditions.elementToBeClickable(vqpo.select_VQ_leftpanel)).click();
        }
        catch (Exception e ){
            jsExecutor.executeScript("arguments[0].scrollIntoView();",skumpo.hamburger_icon);
            skumpo.hamburger_icon.click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(vqpo.select_VQ_leftpanel)).click();
        }
        Assert.assertEquals(driver.getCurrentUrl(),"https://spyder.daraz.com/scrapy-ui/verification-queue");
    }

    public void verify_sortby_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        Assert.assertEquals( vqpo.select_SortBy_filter.getText(),"Select Criteria\n" +
                "Exposure\n" +
                "GMV");
        driver.findElement(By.xpath("//footer[@class='mt-5 footerScrapy']")).click();
    }
    public void Select_SortBy_filters() throws InterruptedException {
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        Thread.sleep(6000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.cssSelector("div.toggle-switch-gl")));
       waitforelement().until(ExpectedConditions.elementToBeClickable(vqpo.select_SortBy_filter)).click();
        vqpo.select_SortBy_Exposure.click();

    }
    public void verify_Competitors_filters(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",vqpo.select_Competitor_filter);
        vqpo.select_Competitor_filter.click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.form-row.flex-column.p-3:nth-child(2) div.optionListContainer")).getText(),"All\n" +
                "AliExpress BD\n" +
                "Chaldal_bd\n" +
                "PandaMart\n" +
                "Pickaboo_bd\n" +
                "Shajgoj\n" +
                "Startech_BD");
        driver.findElement(By.xpath("//footer[@class='mt-5 footerScrapy']")).click();
    }
    public void select_competitors(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",vqpo.select_Competitor_filter);
        vqpo.select_Competitor_filter.click();
      vqpo.select_all_competitor_checkbox.click();
        Assert.assertTrue(vqpo.select_all_competitor_checkbox.getAttribute("class").contains("selected"));

    }

    public void verify_l1_cateogry_filter() {
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
       waitforelement().until(ExpectedConditions.elementToBeClickable(vqpo.select_l1_category_filter)).click();

        Assert.assertEquals(waitforelement().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.form-row.flex-column.p-3:nth-child(3) div.optionListContainer")))).getText(),"All\n" +
                        "Bags and Travel\n" +
                        "Bedding & Bath\n" +
                        "Cameras\n" +
                        "Charity and Donation\n" +
                        "Computers & Laptops\n" +
                        "Digital Goods\n" +
                        "Fashion\n" +
                        "Furniture & Decor\n" +
                        "Groceries\n" +
                        "Health & Beauty\n" +
                        "Home and Living\n" +
                        "Home Appliances\n" +
                        "Kitchen & Dining\n" +
                        "Laundry & Cleaning\n" +
                        "Media; Music & Books\n" +
                        "Mobiles & Tablets\n" +
                        "Mother & Baby\n" +
                        "Motors\n" +
                        "Packaging Material\n" +
                        "Pet Supplies\n" +
                        "Special Digital Products\n" +
                        "Sports & Outdoors\n" +
                        "Stationery & Craft\n" +
                        "Tools; DIY & Outdoor\n" +
                        "Toys & Games\n" +
                        "Toys Kids and Babies\n" +
                        "TV; Audio / Video; Gaming & Wearables\n" +
                        "Watches Sunglasses Jewellery");
        driver.findElement(By.xpath("//footer[@class='mt-5 footerScrapy']")).click();
    }
    public void select_l1_cateogry(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",vqpo.select_l1_category_filter);
        waitforelement().until(ExpectedConditions.elementToBeClickable(vqpo.select_l1_category_filter)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(vqpo.select_all_l1_category_checkbox)).click();
        Assert.assertTrue(vqpo.select_all_l1_category_checkbox.getAttribute("class").contains("selected"));

    }
    public void verify_business_type_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(vqpo.select_business_type_filter)).getText(),"" +"Business Type*\n"+
                "Select Business Type\n" +
                "CB\n" +
                "Retail\n" +
                "Marketplace");
    }

    public void select_business_type_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOf(vqpo.select_business_type_filter)).click();
        vqpo.select_marketplace_business_type_filter.click();
    }
    public void verify_match_age_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(vqpo.select_match_age_filter)).getText(),"Match Age*\n" +
                "Select Match Age\n" +
                "less than 7 days\n" +
                "7 to 14 days\n" +
                "more than 14 days");
    }

    public void select_match_age_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOf(vqpo.select_match_age_filter)).click();
        vqpo.select_more_than_7_match_age_filter.click();
    }
    public void verify_industry_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        vqpo.select_industry_filter.click();
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.form-row.flex-column.p-3:nth-child(6) div.optionListContainer")))).getText(),"All\n" +
                "GM\n" +
                "EL\n" +
                "FMCG\n" +
                "Fashion\n" +
                "Others\n" +
                "Digital Goods\n" +
                "Mobiles & Tablets\n" +
                "Kitchen & Dining");
    }
    public void verify_stock_filter(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(vqpo.select_stock_filter)).getText(),"Stock*\n" +
                "Select Stock\n" +
                "All\n" +
                "In Stock\n" +
                "Out of Stock");
    }
    public void click_filter_button(){
        VerificationQueuePageObjects vqpo = new VerificationQueuePageObjects(driver);
        System.out.println(vqpo.filter_button.getText());
        vqpo.filter_button.click();
        Assert.assertTrue(vqpo.spinner.isDisplayed());

    }


}
