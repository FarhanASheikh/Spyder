//package Tests;
//
//import Pages.*;
//import Utilities.Wait;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//public class  tests {
//
//    Base base = new Base();
//    LoginPage lpg = new LoginPage();
//
//    ScraperPage sp = new ScraperPage();
//    SKUMatchingPage SKUmp = new SKUMatchingPage();
//    // VerificationQueuePage vqp= new VerificationQueuePage();
//    DarazPricingDatabasePage dpdp = new DarazPricingDatabasePage();
//    Userspage up=new Userspage();
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
//    @Test(priority = 1)
//    public void login() throws InterruptedException {
//        lpg.Login_Case1();
//    }
//    @Test(priority = 2)
//    public void change_venture() throws InterruptedException {
//        sp.Change_venture();
//        up.click_users_module();
//        up.click_add_user_btn();
//
//    }
////    @Test(priority = 3)
////    public void dpdp(){
////     dpdp.click_daraz_pricing_database_module();
////        dpdp.dpd_verify_view_matched_item_data();
////        dpdp.dpd_verify_view_matched_item_data_7th_row();
////
////    }
////    @Test(priority = 4)
////    public void dpdp2() throws InterruptedException {
////        dpdp.verify_search_sku_name_upper_case();
////    }
////    @Test(priority = 5)
////    public void dodod() throws InterruptedException {
////        dpdp.verify_search_sku_name_lower_case();
////        dpdp.verify_search_sku_id();
////    }
////
////   @Test(priority = 6)
////   public void dpdp3() throws InterruptedException {
////    //dpdp.add_online_competitor_sku_match_valid_url();}
////       dpdp.get_sku_name();
////       dpdp.add_online_competitor_sku_invalid_url();
////       dpdp.verify_add_sku_btn_disable_on_popup_display();}
////    @Test(priority = 7)
////    public void dpdp4() throws InterruptedException {
////          // dpdp.verify_online_match_added();
////           dpdp.verify_add_sku_btn_disable_on_competitor_select();
////           dpdp.verify_add_sku_btn_disable_on_add_url();
////       }
////    @Test(priority = 8)
////    public void dpdp5() throws InterruptedException {
////        dpdp.get_sku_id();
////        dpdp.filter_by_defualt_option_all();
////        dpdp.filter_by_higher_than();
////        dpdp.filter_by_lower_than();
////        dpdp.filter_verify_option();
//
////        dpdp.mark_verified();
////        dpdp.verify_offline_selection();
////        dpdp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name();
////        dpdp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name();
////        dpdp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price();
////        dpdp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category();
////        dpdp.add_offline_competitor_sku_match_valid_data_verify_button_enabled();
////        dpdp.add_offline_competitor_sku_match_valid_data_click_add_sku_button();
////        dpdp.verify_offline_competitor_sku_match_added_verify_competitor_sku();
////        dpdp.verify_offline_competitor_sku_match_added_verify_competitor_name();
////        dpdp.verify_offline_competitor_sku_match_added_verify_competitor_price();
////        dpdp.verify_offline_competitor_sku_match_added_verify_competitor_category();
//
//
//    }
////    @Test(priority = 9)
////    public void dpdp6() throws InterruptedException {
////        dpdp.verify_database_tab_selection();
////        dpdp.verify_database_tab_add_btn_disabled();
////        dpdp.verify_search_btn_disabled();
////        dpdp.verify_cancel_icon_database_tab();
////        dpdp.verify_cancel_button_database_tab();
////        dpdp.verify_search_btn_enabled_on_filter_selection();
////        dpdp.verify_filter_competitor_name();
////            dpdp.verify_data_on_filter_by_chaldal_database_tab();
////        dpdp.verify_data_on_filter_by_pandamart_database_tab();
////        dpdp.verify_data_on_filter_by_pickaboo_database_tab();
////        dpdp.verify_data_on_filter_by_shajgoj_database_tab();
////        dpdp.search_sku_name_against_competitor_database_tab();
////        dpdp.add_match_database_tab();
////        dpdp.dpdp_verify_database_match_added();
////
////
////
////    }
//
