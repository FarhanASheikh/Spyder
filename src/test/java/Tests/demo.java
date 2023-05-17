package Tests;


import Pages.*;
import Utilities.Wait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class demo {
    Base base = new Base();
    LoginPage lpg = new LoginPage();

    ScraperPage sp = new ScraperPage();
    SKUMatchingPage SKUmp = new SKUMatchingPage();
    DarazPricingDatabasePage dpdp = new DarazPricingDatabasePage();

    @BeforeSuite
    public void driverIntialize() throws IOException {
        Wait.driver = base.driver();
    }
//
//    //    @AfterSuite
////    public void tearDown() {
////        base.teardown();
////    }
//

    @Test(priority = 2)
    public void verify_successful_login() throws InterruptedException {
        lpg.Login_Case1();
        sp.Change_venture();
        SKUmp.click_SKUMatching_module();
        SKUmp.get_table_data_before_create_task();
        SKUmp.Create_task();
        SKUmp.verify_task_created();




        }

    @Test(priority = 10)
    public void click_skumatching_module() throws InterruptedException {
       dpdp.click_daraz_pricing_database_module();
       dpdp.get_sku_id();
       dpdp.verify_search_sku_name_lower_case();
       dpdp.verify_search_sku_name_upper_case();
       dpdp.verify_search_sku_id_and_name();
        dpdp.verify_search_sku_id();
                dpdp.filter_verify_option();
        dpdp.filter_by_defualt_option_all();
        dpdp.filter_by_higher_than();
        dpdp.filter_by_lower_than();
        dpdp.dpd_verify_view_matched_item_data();
                dpdp.dpd_verify_view_matched_item_data_7th_row();
                dpdp.mark_inaccurate();
                dpdp.mark_verified();
                dpdp.verify_mark_inaccurate_dropdown();

    }
//    @Test(priority = 11)
//    public void verify_task_created() throws InterruptedException {
//        SKUmp.verify_task_created();
//    }

}
