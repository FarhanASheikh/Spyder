package Tests;

import Pages.Base;
import Pages.LoginPage;
import Pages.SKUMatchingPage;
import Pages.ScraperPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static Utilities.Wait.driver;

public class tests{

    Base base = new Base();
    LoginPage lpg = new LoginPage();

    ScraperPage sp = new ScraperPage();
    SKUMatchingPage SKUmp = new SKUMatchingPage();




    @BeforeSuite
    public void BeforeSuite() throws Exception {
        driver = base.driver();
    }
    @Test(priority = 1)
    public void test() throws InterruptedException {
        lpg.Login_Case1();
        sp.Change_venture();
        SKUmp.click_SKUMatching_module();
    }
    @Test(priority = 2)
    public void case2() throws InterruptedException {
        Thread.sleep(2000);
        SKUmp.upload_online_match_valid_file_click_cancel_button();

    }
    @Test(priority = 3)
    public void test2(){
        SKUmp.upload_online_match_valid_file_click_cancel_icon();
    }
    @Test(priority = 4)
    public void test4() throws InterruptedException {

        SKUmp.upload_offline_match_valid_file_click_cancel_button();

    }
    @Test(priority = 5)
    public void test5() throws InterruptedException {

        SKUmp.upload_offline_match_valid_file_click_cancel_icon();

    }

}


