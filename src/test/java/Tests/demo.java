//package Tests;
//
//
//import Pages.*;
//import Utilities.Wait;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//public class demo {
//    Base base = new Base();
//    LoginPage lpg = new LoginPage();
//
//    ScraperPage sp = new ScraperPage();
//    SKUMatchingPage SKUmp = new SKUMatchingPage();
//    // VerificationQueuePage vqp= new VerificationQueuePage();
//   // DarazPricingDatabasePage dpdp = new DarazPricingDatabasePage();
//
//    @BeforeSuite
//    public void driverIntialize() {
//        Wait.driver = base.driver();
//    }
////
////    //    @AfterSuite
//////    public void tearDown() {
//////        base.teardown();
//////    }
////
//
//    @Test(priority = 1)
//    public void Empty_Login_Verify_username_validation() throws InterruptedException {
//        lpg.Login_Case2();
//    }
//    @Test(priority = 2)
//    public void verify_successful_login() throws InterruptedException {
//        lpg.Login_Case1();
//    }
//
//
//    @Test(priority = 3)
//    public void Change_venture_to_BD() throws InterruptedException {
//        sp.Change_venture();
//    }
//
//    @Test(priority = 4)
//    public void Verify_scraper_selection()  {
//        sp.left_menu_scraper_selection();
//    }
//    // Scraper Page Test
//    @Test(priority = 5)
//    public void Get_Table_Data_before_job_start() throws InterruptedException {
//        sp.pagination();
//    }
//
//    @Test(priority = 6)
//    public void check_cancel_button() {
//
//        sp.check_cancel_button();
//    }
//
//    @Test(priority = 7)
//    public void Start_Scraping_Jobs() {
//
//        sp.Start_Scraping_Jobs();
//    }
//    @Test(priority = 8)
//    public void verify_job_started() {
//        sp.Success_msg();
//    }
//    @Test(priority = 9)
//    public void getandcomparedata() throws InterruptedException {
//        sp.getandcomparedata();
//    }
//
//    @Test(priority = 10)
//    public void click_skumatching_module(){
//        SKUmp.click_SKUMatching_module();
//    }
//
//}
