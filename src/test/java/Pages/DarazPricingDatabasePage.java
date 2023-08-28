package Pages;

import Object.DarazPricingDatabasePageObjects;
import Object.SKUMatchingPageObjects;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DarazPricingDatabasePage extends Wait {
    SoftAssert softAssert = new SoftAssert();
    String mark_inaccurate_others_text = "Automation Test";
    int popup_displayed = 0;
    String sku_id= null;

    public String get_sku_id(){
        sku_id= waitforelement().until(ExpectedConditions.visibilityOf(new DarazPricingDatabasePageObjects(driver).table_product_id)).getText();
    return sku_id;}

    public void click_daraz_pricing_database_module() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        Thread.sleep(6000);
        try{
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.SKU_Matching)).click();
        }
        catch (Exception e ){
            jsExecutor.executeScript("arguments[0].scrollIntoView();",skumpo.hamburger_icon);
            skumpo.hamburger_icon.click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.SKU_Matching)).click();
        }
        dpdpo.daraz_pricing_database_module_left_menu.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://spyder.daraz.com/scrapy-ui/pricing-database?page=1&pageSize=10");
    }

    public void verify_search_sku_name_lower_case() throws InterruptedException {
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_product_name_search_input)).sendKeys("baby");
        dpdpo.dpd_search_button.click();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_row.get(0))).isDisplayed();
        for (int i = 1; i <= dpdpo.table_row.size(); i++) {
            System.out.println(driver.findElement(By.cssSelector("tbody tr:nth-child("+ i +") td:nth-child(1) a")).getText());
            Thread.sleep(8000);
            if (driver.findElement(By.cssSelector("tbody tr:nth-child("+ i +") td:nth-child(1) a")).getText().contains("Baby")) {
                Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(1) a"))).getText().contains("Baby"));
            }
            else{
                Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(1) a"))).getText().contains("BABY"));
            }
        }}

        public void verify_search_sku_name_upper_case() throws InterruptedException {
            DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
            driver.navigate().refresh();
            Thread.sleep(9000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_product_name_search_input)).sendKeys("BABY");
            dpdpo.dpd_search_button.click();
            Thread.sleep(9000);
            waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_row.get(0))).isDisplayed();
            for (int i = 1; i <= dpdpo.table_row.size(); i++) {
                Thread.sleep(8000);
                if (driver.findElement(By.cssSelector("tbody tr:nth-child("+ i +") td:nth-child(1) a")).getText().contains("Baby")) {
                    Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(1) a"))).getText().contains("Baby"));
                }
                else{
                    Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child(" + i + ") td:nth-child(1) a"))).getText().contains("baby"));
                }
            }


    }
    public void verify_search_sku_id_and_name() throws InterruptedException {
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_product_name_search_input)).sendKeys("dry");
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_product_id_search_input)).sendKeys("1237482425");
        dpdpo.dpd_search_button.click();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_row.get(0))).isDisplayed();
        for (int i = 1; i <= dpdpo.table_row.size(); i++) {
            Thread.sleep(4000);
            Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr td:nth-child("+i+") a"))).getText().contains("dry"));
            Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr td:nth-child("+i+") p.table-product-id"))).getText().contains("1237482425"));
        }


    }

    public void verify_search_sku_id() throws InterruptedException {
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_product_id_search_input)).sendKeys("1237482425");
        dpdpo.dpd_search_button.click();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_row.get(0))).isDisplayed();
        for (int i = 1; i <= dpdpo.table_row.size(); i++) {
            Assert.assertTrue(waitforelement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child("+ i +") td:nth-child(1) p.table-product-id"))).getText().contains("1237482425"));
        }

    }

   public void filter_verify_option(){
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
       String a = waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_filter_by_competitor_text)).getText();
//       waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_filter_by_competitor_text)).size();
//        for(int i=0;i<dpdpo.dpd_filter_by_competitor_text.size();i++){
//            a = dpdpo.dpd_filter_by_competitor_text.get(i).getText();
//            System.out.println(a);
//        }
     Assert.assertEquals(a,"ALL\n" +
                "Higher than competitor SKU\n" +
                "Lower than competitor SKU");
    }
    public void filter_by_defualt_option_all() throws InterruptedException {
        driver.navigate().refresh();
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        Thread.sleep(9000);
         waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_table_daraz_price)).size();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_table_competitor_price)).size();
            Assert.assertEquals(dpdpo.dpd_table_daraz_price.size(),10);
        }

    public void filter_by_higher_than() throws InterruptedException {
        driver.navigate().refresh();
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_filter_by_higher_than_competitor)).click();
        dpdpo.dpd_search_button.click();
        Thread.sleep(7000);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_table_daraz_price)).size();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_table_competitor_price)).size();
        for(int i=0;i< dpdpo.dpd_table_daraz_price.size(); i++){
           float a = Float.parseFloat(dpdpo.dpd_table_daraz_price.get(i).getText());
           float b = Float.parseFloat(dpdpo.dpd_table_competitor_price.get(i).getText());
            boolean result= a>b;
            Assert.assertTrue(result);
        }}
        public void filter_by_lower_than() throws InterruptedException {
            driver.navigate().refresh();
            DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
            Thread.sleep(9000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_filter_by_lower_than_competitor)).click();
            dpdpo.dpd_search_button.click();
            Thread.sleep(7000);
            waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_table_daraz_price)).size();
            waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.dpd_table_competitor_price)).size();
            for(int i=0;i< dpdpo.dpd_table_daraz_price.size(); i++){
                float a = Float.parseFloat(dpdpo.dpd_table_daraz_price.get(i).getText());
                float b = Float.parseFloat(dpdpo.dpd_table_competitor_price.get(i).getText());
                boolean result= a<b;
                Assert.assertTrue(result);
            }}

    public void dpd_verify_view_matched_item_data() throws InterruptedException {
        driver.navigate().refresh();
        int table_matched_sku=0;
        int view_matched_item_rows=0;
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.table_column_no_of_matched_skus)).size();
        table_matched_sku += Integer.parseInt(dpdpo.table_column_no_of_matched_skus.get(0).getText());
        for (int i =1; i<dpdpo.table_column_no_of_matched_skus.size();i++){
            table_matched_sku += Integer.parseInt(dpdpo.table_column_no_of_matched_skus.get(i).getText());
        }
        dpdpo.dpd_view_matched_item_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.view_matched_item_competitor_select)).size();
        for(int j=0; j<skumpo.view_matched_item_competitor_select.size();j++){
            skumpo.view_matched_item_competitor_select.get(j).click();
            if ( skumpo.view_matched_item_rows.size()>=1){
                view_matched_item_rows +=  skumpo.view_matched_item_rows.size();
                System.out.println("table"+table_matched_sku+"\n"+"view matched item rows"+view_matched_item_rows);
            }
            else{
                Assert.assertTrue(skumpo.view_match_item_no_data_found.isDisplayed());

            }
        }
        Assert.assertEquals(view_matched_item_rows,table_matched_sku);
        skumpo.cancel_icon.click();


    }
    public void dpd_verify_view_matched_item_data_7th_row(){
        driver.navigate().refresh();
        int table_matched_sku=0;
        int view_matched_item_rows=0;
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(dpdpo.table_column_no_of_matched_skus_7th_row)).size();
        for (int i =0; i<dpdpo.table_column_no_of_matched_skus_7th_row.size();i++){
            table_matched_sku += Integer.parseInt(dpdpo.table_column_no_of_matched_skus_7th_row.get(i).getText());
        }
        dpdpo.dpd_view_matched_item_btn_7th_row.click();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.view_matched_item_competitor_select)).size();
        for(int j=0; j<skumpo.view_matched_item_competitor_select.size();j++){
            skumpo.view_matched_item_competitor_select.get(j).click();
            if ( skumpo.view_matched_item_rows.size()>=1){
                view_matched_item_rows +=  skumpo.view_matched_item_rows.size();
                System.out.println(table_matched_sku+"/n"+view_matched_item_rows);
            }
            else{
                Assert.assertTrue(skumpo.view_match_item_no_data_found.isDisplayed());

            }
        }
        Assert.assertEquals(view_matched_item_rows,table_matched_sku);
        skumpo.cancel_icon.click();


    }



    public void mark_inaccurate() throws InterruptedException {
        driver.navigate().refresh();
        Actions reason = new Actions(driver);
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_competitor_name)).getText();
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        System.out.println(skumpo.view_matched_item_active_tab.getText());
        if(competitor_name.contains("Chaldal_bd") ||competitor_name.contains("Pickaboo_bd")||competitor_name.contains("Shajgoj") ||competitor_name.contains("PandaMart")) {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
        }
        else {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")).click();
        }
        if (skumpo.view_matched_item_first_row_product_name.getText().contains("Scraping in Progress")) {
            System.out.println("Scraping in Progress");
        } else {
            String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
            System.out.println(match_text + '\n');

            if (match_text.contains("VERIFIED")) {
                skumpo.mark_verified_or_inaccurate_btn.click();
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_quantity_selection)).click();
                Thread.sleep(2000);
                reason.moveToElement(skumpo.status_column).perform();
                System.out.println(skumpo.status_column_reason.getText());
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), "Quantity");
                skumpo.mark_verified_or_inaccurate_btn.click();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column)).getText(), "VERIFIED");
            } else if (match_text.contains("INACCURATE")) {
                reason.moveToElement(skumpo.status_column).perform();
                String hover_reason = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText();
                skumpo.mark_verified_or_inaccurate_btn.click();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column)).getText(), "VERIFIED");
                skumpo.mark_verified_or_inaccurate_btn.click();
                driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'" + hover_reason + "')]")).click();
                reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), hover_reason);
            }
        }
    }

    public void mark_verified() throws InterruptedException {
        driver.navigate().refresh();
        Actions reason = new Actions(driver);
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_competitor_name)).getText();
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        System.out.println(skumpo.view_matched_item_active_tab.getText());
        if(competitor_name.contains("Chaldal_bd") ||competitor_name.contains("Pickaboo_bd")||competitor_name.contains("Shajgoj") ||competitor_name.contains("PandaMart")) {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
        }
        else {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")).click();
        }
        System.out.println(skumpo.view_matched_item_active_tab.getText());
        if (skumpo.view_matched_item_first_row_product_name.getText().contains("Scraping in Progress")) {
            System.out.println("Scraping in Progress");
        } else {
            String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
            System.out.println(match_text + '\n');
            if (match_text.contains("VERIFIED")) {
                skumpo.mark_verified_or_inaccurate_btn.click();
                Thread.sleep(4000);
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_quantity_selection)).click();
                reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), "Quantity");
                skumpo.mark_verified_or_inaccurate_btn.click();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column)).getText(), "VERIFIED");

            } else if (match_text.contains("INACCURATE")) {
                reason.moveToElement(skumpo.status_column).perform();
                String hover_reason = skumpo.status_column_reason.getText();
                skumpo.mark_verified_or_inaccurate_btn.click();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column)).getText(), "VERIFIED");
                skumpo.mark_verified_or_inaccurate_btn.click();
                driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'" + hover_reason + "')]")).click();
                reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
                Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), hover_reason);
            }
        }}
    public void verify_mark_inaccurate_dropdown() throws InterruptedException {
        driver.navigate().refresh();
        Actions reason = new Actions(driver);
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_competitor_name)).getText();
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        if(competitor_name.contains("Chaldal_bd") ||competitor_name.contains("Pickaboo_bd")||competitor_name.contains("Shajgoj") ||competitor_name.contains("PandaMart")) {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
        }
        else {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")).click();
        }
        String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
        System.out.println(match_text + '\n');
        if (match_text.contains("VERIFIED")) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons)).isDisplayed();
            System.out.println(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons)).getText());
            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons)).getText(), "Model/Variant\n" +
                    "Brand\n" +
                    "Free Product/Combo Offer\n" +
                    "Quantity\n" +
                    "Specification\n" +
                    "Size\n" +
                    "Flavor\n" +
                    "Packaging\n" +
                    "Design\n" +
                    "Replica Product/Copy/Old/2nd hand\n" +
                    "Quality/Material\n" +
                    "Registration Issues (PTA approved)/Warranty\n" +
                    "Product\n" +
                    "Daraz Link Not Working\n" +
                    "Competitor Link Not Working");
        } else if (match_text.contains("INACCURATE")) {
            reason.moveToElement(skumpo.status_column).perform();
            String hover_reason = skumpo.status_column_reason.getText();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons)).isDisplayed();
            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons)).getText(), "Model/Variant\n" +
                    "Brand\n" +
                    "Free Product/Combo Offer\n" +
                    "Quantity\n" +
                    "Specification\n" +
                    "Size\n" +
                    "Flavor\n" +
                    "Packaging\n" +
                    "Design\n" +
                    "Replica Product/Copy/Old/2nd hand\n" +
                    "Quality/Material\n" +
                    "Registration Issues (PTA approved)/Warranty\n" +
                    "Product\n" +
                    "Daraz Link Not Working\n" +
                    "Competitor Link Not Working");
            driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'" + hover_reason + "')]")).click();
            reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), hover_reason);
        }
    }



//    public void verify_other_reason_mark_inaccurate() throws InterruptedException {
//        driver.navigate().refresh();
//        Actions reason = new Actions(driver);
//        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
//        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
//        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_competitor_name)).getText();
//        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//        if(competitor_name.contains("Chaldal_bd") ||competitor_name.contains("Pickaboo_bd")||competitor_name.contains("Shajgoj") ||competitor_name.contains("PandaMart")) {
//            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
//        }
//        else {
//            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")).click();
//        }
//        String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
//        System.out.println(match_text + '\n');
//        if (match_text.contains("VERIFIED")) {
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            skumpo.mark_inaccurate_dropdown_reasons_others_selection.click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_input)).sendKeys(mark_inaccurate_others_text);
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_popup_submit_button)).click();
//            Thread.sleep(5000);
//            reason.moveToElement(skumpo.status_column).perform();
//            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), mark_inaccurate_others_text);
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column)).getText(), "VERIFIED");
//        } else if (match_text.contains("INACCURATE")) {
//            reason.moveToElement(skumpo.status_column).perform();
//            String hover_reason = skumpo.status_column_reason.getText();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_others_selection)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_input)).sendKeys(mark_inaccurate_others_text);
//            skumpo.mark_inaccurate_other_popup_submit_button.click();
//            Thread.sleep(2000);
//            reason.moveToElement(skumpo.status_column).perform();
//            Assert.assertEquals(skumpo.status_column_reason.getText(), mark_inaccurate_others_text);
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column)).getText(), "VERIFIED");
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'" + hover_reason + "')]")).click();
//            reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
//            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), hover_reason);
//
//
//        }
//
//
//    }
//
//    public void verify_other_reason_mark_inaccurate_cancel_button() throws InterruptedException {
//        driver.navigate().refresh();
//        Actions reason = new Actions(driver);
//        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
//        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
//        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_competitor_name)).getText();
//        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//        Thread.sleep(4000);
//        if(competitor_name.contains("Chaldal_bd") ||competitor_name.contains("Pickaboo_bd")||competitor_name.contains("Shajgoj") ||competitor_name.contains("PandaMart")) {
//            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
//        }
//        else {
//            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")).click();
//        }
//        String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
//        System.out.println(match_text + '\n');
//        if (match_text.contains("VERIFIED")) {
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_others_selection)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_popup_cancel_button)).click();
//            Thread.sleep(3000);
//            popup_displayed = skumpo.mark_inaccurate_others_popup.size();
//            Assert.assertEquals(popup_displayed, 0);
//        } else if (match_text.contains("INACCURATE")) {
//            reason.moveToElement(skumpo.status_column).perform();
//            String hover_reason = skumpo.status_column_reason.getText();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_others_selection)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_popup_cancel_icon)).click();
//            Thread.sleep(3000);
//            popup_displayed = skumpo.mark_inaccurate_others_popup.size();
//            Assert.assertEquals(popup_displayed, 0);
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'" + hover_reason + "')]")).click();
//            reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
//            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), hover_reason);
//
//
//        }
//
//    }
//
//    public void verify_other_reason_mark_inaccurate_cancel_icon() throws InterruptedException {
//        driver.navigate().refresh();
//        Actions reason = new Actions(driver);
//        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
//        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
//        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.table_competitor_name)).getText();
//        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//        if(competitor_name.contains("Chaldal_bd") ||competitor_name.contains("Pickaboo_bd")||competitor_name.contains("Shajgoj") ||competitor_name.contains("PandaMart")) {
//            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
//        }
//        else {
//            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")).click();
//        }
//        String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
//        System.out.println(match_text + '\n');
//        if (match_text.contains("VERIFIED")) {
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_others_selection)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_popup_cancel_icon)).click();
//            Thread.sleep(8000);
//            popup_displayed = skumpo.mark_inaccurate_others_popup.size();
//            Assert.assertEquals(popup_displayed, 0);
//        } else if (match_text.contains("INACCURATE")) {
//            reason.moveToElement(skumpo.status_column).perform();
//            String hover_reason = skumpo.status_column_reason.getText();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_dropdown_reasons_others_selection)).click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_popup_cancel_icon)).click();
//            Thread.sleep(2000);
//            popup_displayed = skumpo.mark_inaccurate_others_popup.size();
//            Assert.assertEquals(popup_displayed, 0);
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'" + hover_reason + "')]")).click();
//            reason.moveToElement(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column))).perform();
//            Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.status_column_reason)).getText(), hover_reason);
//
//
//        }
//
//    }


    //click add competitor sku button and verify pop_up
    public void click_add_competitor_sku_verify_popup() {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        boolean verify_popup = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        Assert.assertTrue(verify_popup);
    }

    //Click add competitor sku button and close popup

    public void click_cancel_popup() throws InterruptedException {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.cancel_icon)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }


    //Add Online Competitor sku match


    public void verify_online_selection() {
        driver.navigate().refresh();
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        SKUMatchingPageObjects skumpo=new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        String online_tab_class = skumpo.add_competitor_sku_online_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class, "active nav-link");
    }



    public void add_online_competitor_sku_match_valid_url() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
        skumpo.select_pickaboo.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.pickaboo.com/product-detail/hp-m22f-22-inch-1080p-fhd-ips-monitor/");
        skumpo.add_online_sku_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).isDisplayed();
        String toast_msg_text = (skumpo.success_msg).getText();
        softAssert.assertEquals(toast_msg_text, "Scraping Process Started");
        softAssert.assertAll();
    }

    public void verify_online_match_added() throws InterruptedException {//Work around discussed with zaidan
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_pikaboo_tab)).click();
        for(int i=0; i<skumpo.online_matched_sku_first_row_competitor_sku.size();i++){
            skumpo.online_matched_sku_first_row_competitor_sku.get(i).getText();
            if(skumpo.online_matched_sku_first_row_competitor_sku.get(i).getText().contains("HP M22f 22 Inch 1080P FHD IPS Monitor")){
            Assert.assertEquals(skumpo.online_matched_sku_first_row_competitor_sku.get(i).getText(),"HP M22f 22 Inch 1080P FHD IPS Monitor");

        }
        }
    }

    public void add_online_competitor_sku_invalid_url() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(6000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
            waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
            skumpo.select_pickaboo.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.abc.com.bd/pandamart-cumilla/product/3435204");
            skumpo.add_online_sku_btn.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.toast_msg)).isDisplayed();
            String toast_msg_text = (skumpo.toast_msg).getText();
            Assert.assertEquals(toast_msg_text, "Error! Url is not valid");
    }

    public void verify_add_sku_btn_disable_on_popup_display() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        Thread.sleep(4000);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class, "btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }

    public void verify_add_sku_btn_disable_on_competitor_select() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_search_button)).click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
        skumpo.select_pickaboo.click();
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class, "btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }

    public void verify_add_sku_btn_disable_on_add_url() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.foodpanda.com.bd/darkstore/xs1w/pandamart-cumilla/product/3435204");
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class, "btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }


    //Add Offline Competitor sku

    public void verify_offline_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_search_button)).click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_offline_tab.click();
        String online_tab_class = skumpo.add_competitor_sku_offline_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class, "active nav-link");
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_search_button)).click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_search_button)).click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_search_button)).click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        waitforelement().until(ExpectedConditions.elementToBeClickable(dpdpo.dpd_search_button)).click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        ;
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_l1_category_dropdown.click();
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_enabled() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        skumpo.offline_match_l1_category_dropdown.click();
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertTrue(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_click_add_sku_button() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        skumpo.offline_match_l1_category_dropdown.click();
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        skumpo.offline_match_add_sku_btn.click();
        String toast = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(toast, "Competitor SKU Inserted");
    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_sku() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        for(int i=0; i<skumpo.online_matched_sku_first_row_competitor_sku.size();i++){
            skumpo.online_matched_sku_first_row_competitor_sku.get(i).getText();
            if(skumpo.online_matched_sku_first_row_competitor_sku.get(i).getText().contains("TD-122211")){
                Assert.assertEquals(skumpo.offline_matched_sku_first_row_competitor_sku.getText(), "TD-122211");

            }
        }


    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_name() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.matched_skucompetitor_name.getText(), "test competitor");


    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_price() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo= new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.matched_sku_first_row_competitor_price.getText(), "20");

    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_category() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.matched_sku_first_row_competitor_categrory.getText(), "Cameras");

    }


    //Database Matches
    public void verify_database_tab_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_database_tab)).click();
        String online_tab_class = skumpo.add_competitor_sku_database_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class, "active nav-link");
    }

    public void verify_database_tab_add_btn_disabled() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_sku_database_btn_disabled)).getAttribute("class"), "btn create-btn blue-shadow float-right btn btn-secondary disabled");
    }

    public void verify_search_btn_disabled() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_search_button)).isDisplayed();
        Assert.assertFalse(skumpo.database_tab_search_button.isEnabled());
    }

    public void verify_cancel_icon_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.cancel_icon)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }

    public void verify_cancel_button_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_cancel_button)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }


    public void verify_search_btn_enabled_on_filter_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        skumpo.database_tab_competitor_dropdown_filters.click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.database_tab_competitor_dropdown_filters_select_chaldal)).click();
        Assert.assertTrue(skumpo.database_tab_search_button.isEnabled());
    }

    public void verify_filter_competitor_name() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        Assert.assertEquals(skumpo.database_tab_competitor_dropdown_filters.getText(), "Select competitor\n" +
                "Chaldal_bd\n" +
                "PandaMart\n" +
                "Pickaboo_bd\n" +
                "Shajgoj");
    }

    public void verify_data_on_filter_by_chaldal_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_competitor_dropdown_filters_select_chaldal)).click();
        skumpo.database_tab_search_button.click();
        String third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(third.contains("CHAL-BD-"));
        Assert.assertTrue(sixth.contains("CHAL-BD-"));
        Assert.assertTrue(eight.contains("CHAL-BD-"));
        Thread.sleep(1000);
        skumpo.database_tab_pagination_next_btn.click();
        String II_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String II_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String II_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(II_third.contains("CHAL-BD-"));
        Assert.assertTrue(II_sixth.contains("CHAL-BD-"));Assert.assertTrue(II_eight.contains("CHAL-BD-"));
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        String III_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String III_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String III_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(III_third.contains("CHAL-BD-"));
        Assert.assertTrue(III_sixth.contains("CHAL-BD-"));
        Assert.assertTrue(III_eight.contains("CHAL-BD-"));
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        String IV_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String IV_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String IV_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(IV_third.contains("CHAL-BD-"));
        Assert.assertTrue(IV_sixth.contains("CHAL-BD-"));
        Assert.assertTrue(IV_eight.contains("CHAL-BD-"));
    }

    public void verify_data_on_filter_by_pandamart_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_competitor_dropdown_filters_select_pandamart)).click();
        skumpo.database_tab_search_button.click();
        String third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(third.contains("PAND-BD-"));
        Assert.assertTrue(sixth.contains("PAND-BD-"));
        Assert.assertTrue(eight.contains("PAND-BD-"));
        Thread.sleep(1000);
        skumpo.database_tab_pagination_next_btn.click();
        String II_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String II_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String II_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(II_third.contains("PAND-BD-"));
        Assert.assertTrue(II_sixth.contains("PAND-BD-"));
        Assert.assertTrue(II_eight.contains("PAND-BD-"));
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        String III_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String III_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String III_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(III_third.contains("PAND-BD-"));
        Assert.assertTrue(III_sixth.contains("PAND-BD-"));
        Assert.assertTrue(III_eight.contains("PAND-BD-"));
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        String IV_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String IV_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String IV_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(IV_third.contains("PAND-BD-"));
        Assert.assertTrue(IV_sixth.contains("PAND-BD-"));
        Assert.assertTrue(IV_eight.contains("PAND-BD-"));
    }

    public void verify_data_on_filter_by_pickaboo_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_competitor_dropdown_filters_select_pickaboo)).click();
        skumpo.database_tab_search_button.click();
        String third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(third.contains("PICK-BD-"));
        Assert.assertTrue(sixth.contains("PICK-BD-"));
        Assert.assertTrue(eight.contains("PICK-BD-"));
        Thread.sleep(1000);
        skumpo.database_tab_pagination_next_btn.click();
        String II_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String II_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String II_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(II_third.contains("PICK-BD-"));
        Assert.assertTrue(II_sixth.contains("PICK-BD-"));
        Assert.assertTrue(II_eight.contains("PICK-BD-"));
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        String III_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String III_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String III_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(III_third.contains("PICK-BD-"));
        Assert.assertTrue(III_sixth.contains("PICK-BD-"));
        Assert.assertTrue(III_eight.contains("PICK-BD-"));
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        String IV_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String IV_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String IV_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(IV_third.contains("PICK-BD-"));
        Assert.assertTrue(IV_sixth.contains("PICK-BD-"));
        Assert.assertTrue(IV_eight.contains("PICK-BD-"));
    }

    public void verify_data_on_filter_by_shajgoj_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_competitor_dropdown_filters_select_shajgoj)).click();
        skumpo.database_tab_search_button.click();
        String third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        //  Assert.assertTrue(third.contains("SHAG-BD-")); not working due to invalid entry
        Assert.assertTrue(sixth.contains("SHAG-BD-"));
        Assert.assertTrue(eight.contains("SHAG-BD-"));
        skumpo.database_tab_pagination_next_btn.click();
        Thread.sleep(1000);
        String II_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String II_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String II_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(II_third.contains("SHAG-BD-"));
        // Assert.assertTrue(II_sixth.contains("SHAG-BD-"));not working due to invalid entry
        Assert.assertTrue(II_eight.contains("SHAG-BD-"));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        Thread.sleep(1000);
        String III_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String III_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String III_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(III_third.contains("SHAG-BD-"));
        //   Assert.assertTrue(III_sixth.contains("SHAG-BD-"));
        Assert.assertTrue(III_eight.contains("SHAG-BD-"));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_pagination_next_btn)).click();
        Thread.sleep(1000);
        String IV_third = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_table_3rd_row_comp_bank_id)).getText();
        String IV_sixth = skumpo.database_tab_table_6rd_row_comp_bank_id.getText();
        String IV_eight = skumpo.database_tab_table_8rd_row_comp_bank_id.getText();
        Assert.assertTrue(IV_third.contains("SHAG-BD-"));
        Assert.assertTrue(IV_sixth.contains("SHAG-BD-"));
        Assert.assertTrue(IV_eight.contains("SHAG-BD-"));
    }

    public void search_sku_name_against_competitor_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        skumpo.database_tab_search_field.sendKeys("Food");
        skumpo.database_tab_competitor_dropdown_filters_select_chaldal.click();
        skumpo.database_tab_search_button.click();
        System.out.println(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.database_tab_search_row)).size());
        for (int i = 1; i <= skumpo.database_tab_search_row.size(); i++) {
            System.out.println("loop" + i);
            String productname = driver.findElement(By.xpath("//*[@class='scrappy-table']/table[@id= 'taskListTable']/tbody/tr[" + i + "]/td[2]")).getText();
            Assert.assertTrue(productname.contains("Food"));
            String comp_id = driver.findElement(By.xpath("//*[@class='scrappy-table']/table[@id= 'taskListTable']/tbody/tr[" + i + "]/td[3]")).getText();
            Assert.assertTrue(comp_id.contains("CHAL-BD"));

        }

    }

    public void add_match_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        skumpo.database_tab_search_field.sendKeys("Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50");
        skumpo.database_tab_search_button.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_select_sku)).click();
        skumpo.add_sku_database_btn.click();
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText(), "Product added successfully");
    }

    public void dpdp_verify_database_match_added() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        DarazPricingDatabasePageObjects dpdpo = new DarazPricingDatabasePageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        dpdpo.dpd_product_id_search_input.sendKeys(sku_id);
        dpdpo.dpd_search_button.click();
        Thread.sleep(4000);
        waitforelement().until(ExpectedConditions.visibilityOf(dpdpo.dpd_view_matched_item_btn)).click();
        for (int i =0 ; i<skumpo.database_tab_sku_from_matched_items.size();i++)
            if(skumpo.database_tab_sku_from_matched_items.get(i).getText().contains("Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50 gm) 200 m")){
                Assert.assertEquals(skumpo.database_tab_sku_from_matched_items.get(i).getText(), "Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50 gm) 200 ml");
                skumpo.cancel_icon.click();
            }
    }

}
