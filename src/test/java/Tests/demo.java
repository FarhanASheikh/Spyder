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






        }

    @Test(priority = 10)
    public void click_skumatching_module() throws InterruptedException {
      SKUmp.Create_task();

    }
//    @Test(priority = 11)
//    public void verify_task_created() throws InterruptedException {
//        SKUmp.verify_task_created();
//    }

}
