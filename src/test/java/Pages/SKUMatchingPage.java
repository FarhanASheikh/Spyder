package Pages;

import Utilities.Wait;
import Object.SKUMatchingPageObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

public class SKUMatchingPage extends Wait {
    int table_matched_daraz_skus = 0;
    String table_competitors = null;
    String table_user = null;
    String table_created_time = null;
    int popup_displayed = 0;


    public void Click_SKUMatching_Module() {
        new SKUMatchingPageObjects(driver).SKU_Matching.click();

    }
    //Create Task

    public void Create_task_popup() {//CHeCK again
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        skumpo.create_task_btn.click();
        boolean popup_displayed = waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.Create_task_popup)).get(0).isDisplayed();
        Assert.assertTrue(popup_displayed);
    }

    public void create_task_popup_cancel_btn() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        skumpo.create_task_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_btn)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);


    }
    public void create_task_popup_cancel_icon() throws InterruptedException {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        skumpo.create_task_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_icon)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }


    public void Create_task() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        new SKUMatchingPageObjects(driver).create_task_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)).sendKeys("^^$$Automation Testing task$$^^");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        skumpo.Create_task_file_upload.sendKeys("/Users/farhanahmedsheikh/Downloads/sku_template_1669017946660.csv");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.done_btn)).click();
        String success_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
       Assert.assertEquals(success_text,"Task Created Successfully");
       Thread.sleep(2000);
    }

    public void double_click_chaldal_remove_selection() throws InterruptedException{
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        skumpo.create_task_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        skumpo.select_competitor_pickaboo.click();
        Thread.sleep(4000);
        String checked_chaldal = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).getCssValue("background-color");
            Assert.assertEquals(checked_chaldal,"rgba(255, 255, 255, 0.9)");


    }
    public void check_single_competitor_selection() throws InterruptedException{
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        skumpo.create_task_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pandamart)).click();
        Thread.sleep(2000);
        String checked_pandamart = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pandamart)).getCssValue("background-color");
        Assert.assertEquals(checked_pandamart,"rgba(15, 149, 230, 1)");

    }

    public void check_multiple_competitor_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
            driver.navigate().refresh();
        skumpo.create_task_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pickaboo)).click();
        Thread.sleep(2000);
        String checked_chaldal = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).getCssValue("background-color");
        String checked_pickaboo = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pickaboo)).getCssValue("background-color");
        Assert.assertEquals(checked_chaldal,"rgba(15, 149, 230, 1)");
        Assert.assertEquals(checked_pickaboo,"rgba(15, 149, 230, 1)");
    }
    public void Create_task_replace_file(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
            driver.navigate().refresh();
            skumpo.create_task_btn.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)).sendKeys("$$Testing task");
            Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
            skumpo.Create_task_file_upload.sendKeys("/Users/farhanahmedsheikh/Downloads/sku_template_1669311262155.csv");
            skumpo.Create_task_file_upload.sendKeys("/Users/farhanahmedsheikh/Downloads/sku_template_1669017946660.csv");
            Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).done_btn)).click();
        }
public void download_create_task_templete() throws InterruptedException, IOException {
    new SKUMatchingPageObjects(driver).create_task_btn.click();
    waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).task_name_field)).isDisplayed();
    new SKUMatchingPageObjects(driver).download_match_templete.click();
    Thread.sleep(2000);
    Path dir = Paths.get("/Users/farhanahmedsheikh/Downloads/");  // specify your directory

    Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
            .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
            .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

    if ( lastFilePath.isPresent() ) // your folder may be empty
    {
        System.out.println(lastFilePath);
    }

}
public void get_task_data() throws InterruptedException {
        table_matched_daraz_skus = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).table_matched_daraz_sku)).getText());
       table_competitors = new SKUMatchingPageObjects(driver).table_competitors.getText();
       table_user = new SKUMatchingPageObjects(driver).table_user.getText();
       table_created_time = new SKUMatchingPageObjects(driver).table_created_time.getText();

       System.out.println(table_matched_daraz_skus);
       System.out.println(table_competitors);
       Thread.sleep(4000);}

    //TASK DETAILS
    public void click_task_details(){
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).task_details)).click();
    }
    //click add competitor sku button and verify pop_up
    public void click_add_competitor_sku_verify_popup(){
        driver.navigate().refresh();
       SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        boolean verify_popup = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        Assert.assertTrue(verify_popup);
    }

    //Click add competitor sku button and close popup

    public void click_cancel_popup() throws InterruptedException {
            driver.navigate().refresh();
            SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.cancel_icon)).click();
            Thread.sleep(2000);
            popup_displayed = skumpo.Create_task_popup.size();
            Assert.assertEquals(popup_displayed, 0);

    }


    //Add Online Competitor sku match



    public void verify_online_selection(){
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).popup)).isDisplayed();
        String online_tab_class = new SKUMatchingPageObjects(driver).add_competitor_sku_online_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class,"active nav-link");
    }
    String competitor_name;
    public void add_online_competitor_sku_match_valid_url(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
       competitor_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.match_competitor_name)).getText();
        System.out.println(competitor_name);

        if (competitor_name.equals("Chaldal_bd")){
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
            skumpo.select_pickaboo.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys(" https://www.pickaboo.com/product-detail/amazfit-gtr-2-smart-watch-new-edition-global-version/");
            skumpo.add_online_sku_btn.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).isDisplayed();
            String toast_msg_text= (skumpo.success_msg).getText();
            Assert.assertEquals(toast_msg_text,"Scraping Process Started");
        }
    }

    public void verify_online_match_added(){// Blocked as it displayed 2 Pickaboo matches
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        String updated_competitor_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.match_competitor_name)).getText();
        System.out.println(updated_competitor_name);


    }

    public void add_online_competitor_sku_invalid_url(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        String competitor_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.match_competitor_name)).getText();

        if (competitor_name.equals("Chaldal_bd")) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
            skumpo.select_pickaboo.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.abc.com.bd/pandamart-cumilla/product/3435204");
            skumpo.add_online_sku_btn.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.toast_msg)).isDisplayed();
            String toast_msg_text= (skumpo.toast_msg).getText();
            Assert.assertEquals(toast_msg_text,"Error! Url is not valid");
        }
    }

    public void verify_add_sku_btn_disable_on_popup_display(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class,"btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }
    public void verify_add_sku_btn_disable_on_competitor_select(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
        skumpo.select_pickaboo.click();
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class,"btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }
    public void verify_add_sku_btn_disable_on_add_url(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.foodpanda.com.bd/darkstore/xs1w/pandamart-cumilla/product/3435204");
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class,"btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }


    //Add Offline Competitor sku

    public void verify_offline_selection(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_offline_tab.click();
        String online_tab_class = skumpo.add_competitor_sku_offline_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class,"active nav-link");
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }
    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }
    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();;
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_l1_category_dropdown.click();
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }
    public void add_offline_competitor_sku_match_valid_data_verify_button_enabled() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        skumpo.offline_match_l1_category_dropdown.click();
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertTrue(button_enabled);
    }
    public void add_offline_competitor_sku_match_valid_data_click_add_sku_button() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        skumpo.offline_match_l1_category_dropdown.click();
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        skumpo.offline_match_add_sku_btn.click();
        String toast=  waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(toast,"Competitor SKU Inserted");
    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_sku(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.offline_tab_competitor_sku.getText(),"TD-122211");

    }
    public void verify_offline_competitor_sku_match_added_verify_competitor_name(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.offline_tab_competitor_name.getText(),"test competitor");


    }
    public void verify_offline_competitor_sku_match_added_verify_competitor_price(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.offline_tab_competitor_price.getText(),"20");

    }
    public void verify_offline_competitor_sku_match_added_verify_competitor_categrory(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.offline_tab_competitor_categrory.getText(),"Cameras");

    }


    //Database Matches
    public void verify_database_tab_selection(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_database_tab)).click();
        String online_tab_class = skumpo.add_competitor_sku_database_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class,"active nav-link");
    }
    public void verify_database_tab_add_btn_disabled(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_sku_database_btn_disabled)).getAttribute("class"),"btn create-btn blue-shadow float-right btn btn-secondary disabled");
    }
public void add_match_database_tab(){
    SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
    driver.navigate().refresh();
    waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
    waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
    skumpo.add_competitor_sku_database_tab.click();
    skumpo.database_tab_search_field.sendKeys("Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50");
    skumpo.database_tab_search_button.click();
    waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_select_sku)).click();
    skumpo.add_sku_database_btn.click();
    Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText(),"Match Inserted");
}
public void verify_database_match_added(){
    SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
    driver.navigate().refresh();
    waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
    Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_sku_from_matched_items)).getText(),"Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50 gm) 200 ml");

}






//LABELS AND TABLE DATA VERIFICATION

    public void label_number_of_daraz_skus(){
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        Assert.assertEquals(daraz_sku,4269);//Number of records in uploaded file
    }

    public void label_number_of_unmatched_skus(){
        int umatched_sku= Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_unmatched_skus)).getText());
        int matched_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_matched_skus)).getText());
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        int test = daraz_sku - matched_sku;
        Assert.assertEquals(umatched_sku,test);
    }

    public void label_number_of_matched_skus(){
        int matched_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_matched_skus)).getText());
        Assert.assertEquals(table_matched_daraz_skus, matched_sku);
    }
    public void label_number_of_pending_skus(){
        int pending_sku = Integer.parseInt((waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_pending_skus))).getText());
        int umatched_sku= Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_unmatched_skus)).getText());
        int matched_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_matched_skus)).getText());
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        if(pending_sku == 0){
           int total= umatched_sku+matched_sku;
           Assert.assertEquals(total,daraz_sku);
        } else{
            System.out.println("Wait Until Scraping is compeleted");

        }

    }
    public void label_competitor(){
        String competitor= new SKUMatchingPageObjects(driver).label_competitor.getText();
        Assert.assertEquals(table_competitors,competitor);
    }
    public void label_user(){
        String user= new SKUMatchingPageObjects(driver).label_user.getText();
        Assert.assertEquals(table_user,user);
    }
//    public void label_created_time() {
//        String created_time = new SKUMatchingPageObjects(driver).label_created_time.getText();
//        Assert.assertEquals(table_created_time,created_time);
//    }


    public void get_table_data() throws InterruptedException {
        Thread.sleep(3000);
        int Beforejob_tablesize = new SKUMatchingPageObjects(driver).pagination.size();
        new SKUMatchingPageObjects(driver).pagination.get(Beforejob_tablesize-2).click();
        Thread.sleep(3000);
        int a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).last_id)).getText());
        System.out.println(a);
    }


    //Online Upload

public  void upload_online_match_valid_file_click_upload()  {
    driver.navigate().refresh();
    SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
    Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)).click();
    Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)).click();
    skumpo.add_file.sendKeys("/Users/farhanahmedsheikh/Desktop/untitled folder/sku_template_online_1671527738208.csv");
    Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).click();
    String success_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
    Assert.assertEquals(success_text,"Successfully Task Created");

    }
    public  void upload_online_match_valid_file_click_cancel_button(){
        driver.navigate().refresh();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Documents/Automation/sku_template_online_1671527738208.csv");
        new SKUMatchingPageObjects(driver).upload_online_matches_cancel_button.click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertFalse(popup);
    }
    public  void upload_online_match_valid_file_click_cancel_icon() {
        driver.navigate().refresh();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Documents/Automation/sku_template_online_1671527738208.csv");
        new SKUMatchingPageObjects(driver).cancel_icon.click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertFalse(popup);

    }
    public  void upload_online_match_without_file(){
        driver.navigate().refresh();
        new SKUMatchingPageObjects(driver).upload_matches_btn.click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);

    }

    public void upload_online_match_invalid_excel_file(){
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Desktop/untitled folder/sku_template_online_1671527738208.xlsx");
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);
    }
    public void upload_online_match_invalid_image_file(){
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Documents/Automation/camera_test_apple_563728.jpeg");
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);
    }
    public void download_templete_online_matches() throws InterruptedException, IOException {
        driver.navigate().refresh();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).download_match_templete.click();
        Thread.sleep(2000);
        Path dir = Paths.get("/Users/farhanahmedsheikh/Downloads/");  // specify your directory

        Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
                .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

        if ( lastFilePath.isPresent() ) // your folder may be empty
        {
            System.out.println(lastFilePath);
        }
        Assert.assertTrue(lastFilePath.isPresent());

    }

    //OFFLINE MATCH

    public  void upload_offline_match_valid_file_click_upload(){
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)).click();
        skumpo.add_file.sendKeys("/Users/farhanahmedsheikh/Desktop/untitled folder/sku_template_1671527738208.csv");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).click();
        String success_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(success_text,"Task Created Successfully");
    }
    public  void upload_offline_match_valid_file_click_cancel_button(){
        driver.navigate().refresh();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).offline_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Desktop/untitled folder/sku_template_1671527738208.csv");
        new SKUMatchingPageObjects(driver).upload_online_matches_cancel_button.click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertFalse(popup);
    }
    public  void upload_offline_match_valid_file_click_cancel_icon() {
        driver.navigate().refresh();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).offline_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Desktop/untitled folder/sku_template_1671527738208.csv");
        new SKUMatchingPageObjects(driver).cancel_icon.click();
        boolean popup = new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertFalse(popup);
    }
    public  void upload_offline_match_without_file(){
        driver.navigate().refresh();
        new SKUMatchingPageObjects(driver).upload_matches_btn.click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).offline_match_dropdown_selection)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);

    }
    public void upload_offline_match_invalid_excel_file(){
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_online_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("/Users/farhanahmedsheikh/Desktop/untitled folder/sku_template_online_1671527738208.xlsx");
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);
    }
    public void upload_offline_match_invalid_image_file(){
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).offline_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).add_file.sendKeys("//Users/farhanahmedsheikh/Desktop/untitled folder/camera_test_apple_563728.jpeg");
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup =new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);
    }
    public void download_templete_offline_matches() throws InterruptedException, IOException {
        driver.navigate().refresh();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).offline_match_dropdown_selection)).click();
        new SKUMatchingPageObjects(driver).download_match_templete.click();
        Thread.sleep(2000);
        Path dir = Paths.get("/Users/farhanahmedsheikh/Downloads/");  // specify your directory

        Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
                .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

        if ( lastFilePath.isPresent() ) // your folder may be empty
        {
            System.out.println(lastFilePath);
        }

    }}