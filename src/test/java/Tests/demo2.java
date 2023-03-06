//package Tests;
//
//import Pages.Base;
//import Pages.LoginPage;
//import Pages.SKUMatchingPage;
//import Pages.ScraperPage;
//import Utilities.Wait;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import java.text.ParseException;
//
//public class demo2 {
//
//    Base base = new Base();
//    LoginPage lpg = new LoginPage();
//
//    ScraperPage sp = new ScraperPage();
//    SKUMatchingPage SKUmp = new SKUMatchingPage();
//
//    @BeforeSuite
//    public void driverIntialize() {
//        Wait.driver = base.driver();
//    }
//
//    @Test(priority = 1)
//    public void verify_successful_login() throws InterruptedException {
//        lpg.Login_Case1();
//    }
//
//    @Test(priority = 2)
//    public void Change_venture_to_BD() throws InterruptedException {
//        sp.Change_venture();
//    }
//
//    @Test(priority = 3)
//    public void click_skumatching_module(){
//        SKUmp.click_SKUMatching_module();
//    }
//
//
//@Test(priority = 4)
//public void create_task() throws InterruptedException {
//       SKUmp.Create_task();
//}
//
//
//@Test(priority =5)
//    public void get_task_data() throws ParseException, InterruptedException {
//        SKUmp.get_task_data();
//}
//@Test(priority = 6)
//public void click_task_details(){
//        SKUmp.click_task_details();
//
//}
//    @Test(priority = 7)
//    public void label_number_of_daraz_skus() {
//        SKUmp.label_number_of_daraz_skus();
//    }
//    @Test(priority = 8)
//    public void label_number_of_unmatched_skus() {
//        SKUmp.label_number_of_unmatched_skus();
//    }
//    @Test(priority = 9)
//    public void label_number_of_matched_skus(){
//        SKUmp.label_number_of_matched_skus();
//    }
//    @Test(priority = 10)
//    public void label_number_of_pending_skus() {
//        SKUmp.label_number_of_pending_skus();
//    }
//    @Test(priority = 11)
//    public void label_competitor() throws InterruptedException {
//        SKUmp.label_competitor();
//    }
//    @Test(priority = 12)
//    public void label_user() {
//        SKUmp.label_user();
//    }
//    @Test(priority = 13)
//    public void label_created_time() throws ParseException {
//        SKUmp.label_created_time();
//    }
//    @Test(priority = 14)
//    public void mark_inaccurate() throws InterruptedException {
//        SKUmp.mark_inaccurate();
//    }
//
//    @Test(priority = 15)
//    public void mark_verified() throws InterruptedException {
//        SKUmp.mark_verified();
//    }
//    @Test(priority = 16)
//    public void add_online_competitor_sku_match_valid_url() {
//        SKUmp.add_online_competitor_sku_match_valid_url();
//    }
//    @Test(priority = 17)
//    public void verify_online_match_added() {
//        SKUmp.verify_online_match_added();
//    }
//    @Test(priority = 18)
//    public void add_offline_competitor_sku_match_valid_url() {
//        SKUmp.add_offline_competitor_sku_match_valid_data_click_add_sku_button();
//    }
//    @Test(priority = 19)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_name() {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_name();
//    }
//    @Test(priority = 20)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_price() {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_price();
//
//    }@Test(priority = 21)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_category() {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_category();
//    }
//    @Test(priority = 22)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_sku() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_sku();
//    }
//    @Test(priority = 23)
//    public void add_match_database_tab() {
//        SKUmp.add_match_database_tab();
//    }
//    @Test(priority = 24)
//    public void verify_database_match_added() {
//        SKUmp.verify_database_match_added();
//    }
//
//
//
//
//
//
//
//}
