package Pages;

import Utilities.Wait;
import Object.ScraperPageObjects;
import Object.SKUMatchingPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SKUMatchingPage extends Wait {
    int table_matched_daraz_skus = 0;
    String table_competitors = null;
    String table_user = null;
    Date table_created_time;
    int popup_displayed = 0;
    static int a = 0;
    static int b = 0;



    public void click_SKUMatching_module() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        if(!(skumpo.Daraz_logo_left_pane.size() >0)){
            skumpo.hamburger_icon.click();
        }
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.SKU_Matching)).click();
        String scraper_module_nav_class = skumpo.SKU_Matching.getAttribute("Class");
        Assert.assertEquals("active", scraper_module_nav_class);

    }
    //Create Task

    public void Create_task_popup() throws InterruptedException {//CHeCK again
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        boolean popup_displayed = waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.Create_task_popup)).get(0).isDisplayed();
        Assert.assertTrue(popup_displayed);
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_btn)));
    }

    public void create_task_popup_cancel_btn() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_btn)));
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);


    }

    public void create_task_popup_cancel_icon() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_icon)));
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }

    public void get_table_data_before_create_task() throws InterruptedException {
        ScraperPageObjects spo = new ScraperPageObjects(driver);
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(9000);
        int Beforejob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(spo.pagination)).size();
        waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(Beforejob_tablesize-2))).click();
        Thread.sleep(10000);
        a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.last_id)).getText());
        System.out.println("Status "+a);
        waitforelement().until(ExpectedConditions.elementToBeClickable(spo.pagination.get(1))).click();
    }




    public void Create_task() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Thread.sleep(20000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.Create_task_popup));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)).sendKeys("^^$$Automation Testing task$$^^");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        skumpo.select_competitor_pickaboo.click();
        skumpo.select_competitor_pandamart.click();
        skumpo.select_competitor_shajgoj.click();
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_1669017946660.csv";
        File file = new File(absoluteFilePath);
        skumpo.Create_task_file_upload.sendKeys(file.getAbsolutePath());
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.done_btn)).click();
        String success_text  = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(success_text, "Task Created Successfully");
        System.out.println("Task Created Successfully");
    }
    public void verify_task_created() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int Afterjob_tablesize = Wait.waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.pagination)).size();
        Thread.sleep(9000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.pagination.get(Afterjob_tablesize-2))).click();
        Thread.sleep(20000);
        b = Integer.parseInt(skumpo.last_id.getText());
        Assert.assertEquals(b, a + 1);
        System.out.println(b);
        skumpo.pagination.get(Afterjob_tablesize-8).click();
        Thread.sleep(10000);

    }


    public void double_click_chaldal_remove_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        skumpo.select_competitor_pickaboo.click();
        Thread.sleep(4000);
        String checked_chaldal = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).getCssValue("background-color");
        Assert.assertEquals(checked_chaldal, "rgba(255, 255, 255, 0.9)");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_icon)));

    }

    public void check_single_competitor_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pandamart)));
        Thread.sleep(2000);
        String checked_pandamart = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pandamart)).getCssValue("background-color");
        Assert.assertEquals(checked_pandamart, "rgba(15, 149, 230, 1)");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_icon)));

    }

    public void check_multiple_competitor_selection() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pickaboo)).click();
        Thread.sleep(2000);
        String checked_chaldal = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).getCssValue("background-color");
        String checked_pickaboo = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_pickaboo)).getCssValue("background-color");
        Assert.assertEquals(checked_chaldal, "rgba(15, 149, 230, 1)");
        Assert.assertEquals(checked_pickaboo, "rgba(15, 149, 230, 1)");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_icon)));
    }

    public void Create_task_replace_file() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)).sendKeys("$$Testing task");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_chaldal)).click();
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_1669017946660.csv";
        String absoluteFilePath2 = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_1669311262155.csv";
        File file = new File(absoluteFilePath);
        File file2 = new File(absoluteFilePath2);
        skumpo.Create_task_file_upload.sendKeys(file2.getAbsolutePath());
        Thread.sleep(2000);
        skumpo.Create_task_file_upload.sendKeys(file.getAbsolutePath());
        Assert.assertEquals(skumpo.uploaded_file_name.getText(),"sku_template_1669017946660.csv   ");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.cancel_icon)));
    }

    public void download_create_task_templete() throws InterruptedException, IOException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_btn)));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_name_field)).isDisplayed();
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.download_match_templete)));
        Thread.sleep(2000);
        Path dir = Paths.get("/home/qaautomation/Downloads");  // specify your directory

        Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
                .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

        if (lastFilePath.isPresent()) // your folder may be empty
        {
            System.out.println(lastFilePath);
        }
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.create_task_cancel_icon)).click();

    }

    public void get_task_data() throws InterruptedException, ParseException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",skumpo.create_task_btn);
        Thread.sleep(4000 );
        jsExecutor.executeScript("arguments[0].scrollIntoView();",skumpo.table_matched_daraz_sku);
        table_matched_daraz_skus = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_matched_daraz_sku)).getText());
        table_competitors = skumpo.table_competitors.getText();
        System.out.println(table_competitors);
        table_user = skumpo.table_user.getText();
        Thread.sleep(10000);
        String get_table_time = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_created_time)).getText();
        SimpleDateFormat formatter5 = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
        table_created_time = formatter5.parse(get_table_time);
    }

    //TASK DETAILS
    public void click_task_details() {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();",skumpo.create_task_btn);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.task_details_btn)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("details"));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_matched_skus));
    }

    //Verify Filters
    public void verify_sku_current_filter() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current)).getText(), "Active\n" +
                "In Active");
    }

    public void verify_matching_status_filter() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_matching_status)).getText(), "ALL\n" +
                "SKUs with only verified matches\n" +
                "SKUs with inaccurate matches\n" +
                "SKUs with unchecked matches\n" +
                "SKUs with OOS matches");
    }

    //Veirfy all active/inactive skus from file

    public void verify_all_active_skus_from_file() throws IOException, InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Pages/uploaded_file_skus.properties";
        File file = new File(absoluteFilePath);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        Properties prop = new Properties();
        prop.load(fis);
        if (prop == null) {
            System.out.println("No Data Found");
            Assert.assertTrue(prop.isEmpty());
        } else {
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id));
                for (int h = 0; h < skumpo.task_details_table_sku_id.size(); h++) {
                    String first_sku = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id)).get(h).getText());
                    for (int i = 1; i <= 8; i++) {
                        String t = prop.getProperty("SKU" + i);
                        if (t.equals(first_sku)) {
                            System.out.println(first_sku);
                            System.out.println(t);
                            Assert.assertEquals(t, first_sku);
                        }
                    }
                }
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();

                System.out.println(skumpo.task_details_no_data_found.getText());
            }
        }
    }

    public void verify_all_inactive_skus_from_file() throws IOException, InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_inactive)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
        Thread.sleep(4000);

        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Pages/uploaded_file_skus.properties";
        File file = new File(absoluteFilePath);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        Properties prop = new Properties();
        prop.load(fis);
        if (prop == null) {
            System.out.println("No Data Found");
            Assert.assertTrue(prop.isEmpty());
        } else {
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id));
                for (int h = 0; h < skumpo.task_details_table_sku_id.size(); h++) {
                    String first_sku = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id)).get(h).getText());
                    for (int i = 1; i <= 8; i++) {
                        String t = prop.getProperty("SKU" + i);
                        if (t.equals(first_sku)) {
                            System.out.println(first_sku);
                            System.out.println(t);
                            Assert.assertEquals(t, first_sku);
                        }
                    }
                }
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();

                System.out.println(skumpo.task_details_no_data_found.getText());
            }
        }
    }


    public void verify_all_active_inactive_skus_with_matched_daraz_skus() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(4000);
        int total_size = 0;
        if (skumpo.task_details_table_sku_id.size() >= 1) {
            total_size = skumpo.task_details_table_sku_id.size();
            skumpo.filter_sku_current_inactive.click();
            skumpo.filter_filter_btn.click();
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                System.out.println("a1");
                total_size = total_size + skumpo.task_details_table_sku_id.size();
                System.out.println(total_size + "and" + skumpo.label_number_of_matched_skus.getText());
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();
                System.out.println(total_size + "and" + skumpo.label_number_of_matched_skus.getText());

                System.out.println("inactive" + skumpo.task_details_no_data_found.getText());
            }
        } else {
            skumpo.filter_sku_current_inactive.click();
                skumpo.filter_filter_btn.click();
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                System.out.println("a2");
                total_size = total_size + skumpo.task_details_table_sku_id.size();
                System.out.println(total_size + "and" + skumpo.label_number_of_matched_skus.getText());
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();
                System.out.println(total_size + "and" + skumpo.label_number_of_matched_skus.getText());

                System.out.println("active" + skumpo.task_details_no_data_found.getText());
            }

        }
        Assert.assertEquals(total_size, Integer.parseInt(skumpo.label_number_of_matched_skus.getText()));
    }

    public void verify_verified_active_inactive_skus_with_number_of_checked_matches() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        int total_size = 0;
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.filter_matching_status_all_options)).size();
        for (int j = 1; j < 3; j++) {
            skumpo.filter_matching_status_all_options.get(j).click();
            Thread.sleep(2000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
            for (int i = 0; i < skumpo.filter_sku_current_all_options.size(); i++) {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_all_options.get(i))).click();
                Thread.sleep(3000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
                Thread.sleep(4000);
                if (skumpo.task_details_table_sku_id.size() >= 1) {
                    for (int k = 0; k < skumpo.task_details_table_no_of_matched_skus.size(); k++) {
                        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_no_of_matched_skus));
                        Thread.sleep(5000);
                        total_size += Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_table_no_of_matched_skus.get(k))).getText());
                    }
                    System.out.println(total_size + "and" + skumpo.label_number_of_verified_matches.getText());
                } else {
                    waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();
                    System.out.println(total_size + "and" + skumpo.label_number_of_verified_matches.getText());

                }
            }
        }
        Assert.assertEquals(total_size, Integer.parseInt(skumpo.label_number_of_verified_matches.getText()));
    }


    //Verify UnVerified Matches
    public void verify_number_of_unchecked_matches() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        int total_size = 0;
        Thread.sleep(2000);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.filter_matching_status_all_options)).size();
        for (int j = 3; j < 4; j += 2) {
            skumpo.filter_matching_status_all_options.get(j).click();
            Thread.sleep(6000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
            for (int i = 0; i < skumpo.filter_sku_current_all_options.size(); i++) {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_all_options.get(i))).click();
                Thread.sleep(6000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
                Thread.sleep(6000);
                if (skumpo.task_details_table_sku_id.size() >= 1) {
                    waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_no_of_unverified_skus)).size();
                    System.out.println(skumpo.pagination.size());
                    int size = Integer.parseInt(skumpo.pagination.get(skumpo.pagination.size()-2).getText());
                    for(int l = 1; l<=size;l++){
                        Thread.sleep(8000);
                        if(l>=2) {
                            waitforelement().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class=\"pagination-item\" and text()='" + l + "']")))).click();
                            Thread.sleep(8000);
                        }
                    for (int k = 0; k < skumpo.task_details_table_no_of_unverified_skus.size(); k++) {
                        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_no_of_unverified_skus));
                        total_size += Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_table_no_of_unverified_skus.get(k))).getText());
                            System.out.println("Page No Is "+l+" & size is "+total_size);
                    }}

                    System.out.println(total_size + "and" + skumpo.label_number_of_unverified_matches.getText());
                } else {
                    waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();
                    System.out.println(total_size + "and" + skumpo.label_number_of_unverified_matches.getText());

                }
            }
        }
        Assert.assertEquals(total_size, Integer.parseInt(skumpo.label_number_of_unverified_matches.getText()));
    }

    //Verify Search

    public void verify_search_by_sku_name() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
        Thread.sleep(2000);
        for (int i = 0; i < skumpo.filter_sku_current_all_options.size(); i++) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_all_options.get(i))).click();
            Thread.sleep(6000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_name.size() >= 1) {
                String search_product_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_table_sku_name.get(0))).getText();
                skumpo.filter_sku_name_search_field.sendKeys(search_product_name);
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_filter_btn)).click();
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
                Thread.sleep(4000);
                if (skumpo.task_details_table_sku_name.size() >= 1) {
                    Assert.assertEquals(skumpo.task_details_table_sku_name.get(0).getText(), search_product_name);
                    System.out.println(search_product_name);
                    skumpo.filter_sku_name_search_field.clear();
                }
            } else {
                Assert.assertTrue(skumpo.task_details_no_data_found.isDisplayed());

            }
        }
    }

    public void verify_search_by_sku_name_and_id() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
        Thread.sleep(2000);
        for (int i = 0; i < skumpo.filter_sku_current_all_options.size(); i++) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_all_options.get(i))).click();
            Thread.sleep(2000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_name.size() >= 1) {
                String search_product_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_table_sku_name.get(0))).getText();
                String search_product_id = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_table_sku_id.get(0))).getText();
                skumpo.filter_sku_id_search_field.sendKeys(search_product_id);
                skumpo.filter_sku_name_search_field.sendKeys(search_product_name);
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_filter_btn)).click();
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
                Thread.sleep(4000);
                if (skumpo.task_details_table_sku_name.size() >= 1) {
                    Assert.assertEquals(skumpo.task_details_table_sku_name.get(0).getText(), search_product_name);
                    Assert.assertEquals(skumpo.task_details_table_sku_id.get(0).getText(), search_product_id);
                    System.out.println(search_product_name + "id=" + search_product_id);
                    skumpo.filter_sku_name_search_field.clear();
                    skumpo.filter_sku_id_search_field.clear();
                }


            } else {
                Assert.assertTrue(skumpo.task_details_no_data_found.isDisplayed());

            }
        }
    }

    public void verify_search_by_sku_id() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
        Thread.sleep(2000);
        for (int i = 0; i < skumpo.filter_sku_current_all_options.size(); i++) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_all_options.get(i))).click();
            Thread.sleep(2000);
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
            waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                String search_product_id = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_table_sku_id.get(0))).getText();

                skumpo.filter_sku_id_search_field.sendKeys(search_product_id);
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_filter_btn)).click();
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.table_show_records_dropdown)).isEnabled();
                Thread.sleep(4000);
                if (skumpo.task_details_table_sku_id.size() >= 1) {
                    Assert.assertEquals(skumpo.task_details_table_sku_id.get(0).getText(), search_product_id);
                    System.out.println(search_product_id);
                    skumpo.filter_sku_id_search_field.clear();
                }
            } else {
                Assert.assertTrue(skumpo.task_details_no_data_found.isDisplayed());

            }
        }
    }

    //click add competitor sku button and verify pop_up
    public void click_add_competitor_sku_verify_popup() {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_btn)).click();
        boolean verify_popup = waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.popup)).isDisplayed();
        Assert.assertTrue(verify_popup);
    }

    //Click add competitor sku button and close popup

    public void click_cancel_popup() throws InterruptedException {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.cancel_icon)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);

    }


    //Add Online Competitor sku match


    public void verify_online_selection() {
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).popup)).isDisplayed();
        String online_tab_class = new SKUMatchingPageObjects(driver).add_competitor_sku_online_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class, "active nav-link");
    }

    String competitor_name;
    int no_of_matches = 0;

    public void add_online_competitor_sku_match_valid_url() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        competitor_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_match_competitor_name)).getText();
        System.out.println(competitor_name);

    //    if (competitor_name.contains("Chaldal_bd")) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
            skumpo.select_pickaboo.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.pickaboo.com/product-detail/hp-m22f-22-inch-1080p-fhd-ips-monitor/");
            skumpo.add_online_sku_btn.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).isDisplayed();
            String toast_msg_text = (skumpo.success_msg).getText();
            Assert.assertEquals(toast_msg_text, "Scraping Process Started");
       // }
    }

    public void verify_online_match_added() {//Work around discussed with zaidan
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_pikaboo_tab)).click();
        Assert.assertEquals(skumpo.online_matched_sku_first_row_competitor_sku.getText(),"HP M22f 22 Inch 1080P FHD IPS Monitor");
    }

    public void add_online_competitor_sku_invalid_url() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        String competitor_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_match_competitor_name)).getText();

        if (competitor_name.contains("Chaldal_bd")) {
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
            skumpo.select_pickaboo.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.abc.com.bd/pandamart-cumilla/product/3435204");
            skumpo.add_online_sku_btn.click();
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.toast_msg)).isDisplayed();
            String toast_msg_text = (skumpo.toast_msg).getText();
            Assert.assertEquals(toast_msg_text, "Error! Url is not valid");
        }
    }

    public void verify_add_sku_btn_disable_on_popup_display() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class, "btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }

    public void verify_add_sku_btn_disable_on_competitor_select() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.select_competitor_dropdown)).click();
        skumpo.select_pickaboo.click();
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class, "btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }

    public void verify_add_sku_btn_disable_on_add_url() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.product_url_input)).sendKeys("https://www.foodpanda.com.bd/darkstore/xs1w/pandamart-cumilla/product/3435204");
        String btn_class = (waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_online_sku_btn_disabled)).getAttribute("class"));
        Assert.assertEquals(btn_class, "btn create-btn blue-shadow float-right btn btn-secondary disabled");

    }


    //Add Offline Competitor sku

    public void verify_offline_selection() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_offline_tab.click();
        String online_tab_class = skumpo.add_competitor_sku_offline_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class, "active nav-link");
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
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_offline_tab)).click();
        ;
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_l1_category_dropdown)));
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertFalse(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_verify_button_enabled() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_sku_price_input)));
        skumpo.offline_match_sku_price_input.sendKeys("20");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_l1_category_dropdown)));
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        boolean button_enabled = skumpo.offline_match_add_sku_btn.isEnabled();
        Assert.assertTrue(button_enabled);
    }

    public void add_offline_competitor_sku_match_valid_data_click_add_sku_button() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_offline_tab)).click();
        skumpo.offline_match_sku_name_input.sendKeys("TD-122211");
        skumpo.offline_match_competitor_name_input.sendKeys("test competitor");
        skumpo.offline_match_sku_price_input.sendKeys("20");
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_l1_category_dropdown)));
        skumpo.offline_match_l1_category_dropdown_select_cameras.click();
        skumpo.offline_match_add_sku_btn.click();
        String toast = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(toast, "Competitor SKU Inserted");
    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_sku() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        Thread.sleep(3000);
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)));
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.online_matched_sku_first_row_competitor_sku));
        Assert.assertEquals(skumpo.offline_matched_sku_first_row_competitor_sku.getText(), "TD-122211");

    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_name() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.matched_skucompetitor_name.getText(), "test competitor");


    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_price() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        Thread.sleep(2000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.matched_sku_first_row_competitor_price.getText(), "20");

    }

    public void verify_offline_competitor_sku_match_added_verify_competitor_category() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.matches_popup_offline_tab)).click();
        Assert.assertEquals(skumpo.matched_sku_first_row_competitor_categrory.getText(), "Cameras");

    }


    //Database Matches
    public void verify_database_tab_selection() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_database_tab)).click();
        String online_tab_class = skumpo.add_competitor_sku_database_tab.getAttribute("class");
        Assert.assertEquals(online_tab_class, "active nav-link");
    }

    public void verify_database_tab_add_btn_disabled() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_sku_database_btn_disabled)).getAttribute("class"), "btn create-btn blue-shadow float-right btn btn-secondary disabled");
    }

    public void verify_search_btn_disabled() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_search_button)).isDisplayed();
        Assert.assertFalse(skumpo.database_tab_search_button.isEnabled());
    }

    public void verify_cancel_icon_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.cancel_icon)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }

    public void verify_cancel_button_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_cancel_button)).click();
        Thread.sleep(2000);
        popup_displayed = skumpo.Create_task_popup.size();
        Assert.assertEquals(popup_displayed, 0);
    }


    public void verify_search_btn_enabled_on_filter_selection() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        skumpo.database_tab_competitor_dropdown_filters.click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.database_tab_competitor_dropdown_filters_select_chaldal)).click();
        Assert.assertTrue(skumpo.database_tab_search_button.isEnabled());
    }

    public void verify_filter_competitor_name() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        Assert.assertEquals(skumpo.database_tab_competitor_dropdown_filters.getText(), "Select competitor\n" +
                "Chaldal_bd\n" +
                "PandaMart\n" +
                "Pickaboo_bd\n" +
                "Shajgoj\n" +
                "Startech_BD");
    }

    public void verify_data_on_filter_by_chaldal_database_tab() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_competitor_dropdown_filters_select_chaldal)).click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.database_tab_search_button)).click();
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
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_competitor_dropdown_filters_select_pandamart)).click();
        Thread.sleep(1000);
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
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
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
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
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
        driver.navigate().refresh();
        Thread.sleep(10000);
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        skumpo.add_competitor_sku_database_tab.click();
        skumpo.database_tab_search_field.sendKeys("Food");
        skumpo.database_tab_competitor_dropdown_filters_select_chaldal.click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.database_tab_search_button)).click();
        System.out.println(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.database_tab_search_row)).size());
        for (int i = 1; i <= skumpo.database_tab_search_row.size(); i++) {
            System.out.println("loop" + i);
            String productname = driver.findElement(By.xpath("//*[@class='scrappy-table']/table[@id= 'taskListTable']/tbody/tr[" + i + "]/td[2]")).getText();
            Assert.assertTrue(productname.contains("Food"));
            String comp_id = driver.findElement(By.xpath("//*[@class='scrappy-table']/table[@id= 'taskListTable']/tbody/tr[" + i + "]/td[3]")).getText();
            Assert.assertTrue(comp_id.contains("CHAL-BD"));

        }

    }

    public void add_match_database_tab() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.add_competitor_sku_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.add_competitor_sku_database_tab)).click();
        skumpo.database_tab_search_field.sendKeys("Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50");
        skumpo.database_tab_search_button.click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.database_tab_select_sku)).click();
        skumpo.add_sku_database_btn.click();
        Assert.assertEquals(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText(), "Match Inserted");
    }

    public void verify_database_match_added() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.database_tab_sku_from_matched_items)).size();
        for (int i =0 ; i<skumpo.database_tab_sku_from_matched_items.size();i++)
            if(skumpo.database_tab_sku_from_matched_items.get(i).getText().contains("Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50 gm) 200 m")){
        Assert.assertEquals(skumpo.database_tab_sku_from_matched_items.get(i).getText(), "Parachute SkinPure Beauty Olive Oil (Free Glow Face Wash 50 gm) 200 ml");
        skumpo.cancel_icon.click();
    }}


//LABELS AND TABLE DATA VERIFICATION

    public void label_number_of_daraz_skus() {
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        Assert.assertEquals(daraz_sku, 8);//Number of records in uploaded file
    }

    public void label_number_of_unmatched_skus() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        String umatched_sku = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_unmatched_skus)).getText();
        int matched_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_matched_skus)).getText());
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_daraz_skus)).getText());
        int invalid_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_invalid_daraz_sku_value)).getText());
        int pending_skus = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_pending_skus_value)).getText());
        int total_error = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_total_error_value)).getText());
        int unmatched = daraz_sku - matched_sku-invalid_sku-pending_skus;
        if(umatched_sku.contains("None")){
        Assert.assertEquals(umatched_sku, "None");
    }
        else{
            int unmatched_sku = Integer.parseInt(umatched_sku);
            Assert.assertEquals(unmatched_sku, unmatched);
        }}

    public void label_number_of_matched_skus() {
        int matched_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        Assert.assertEquals(table_matched_daraz_skus, matched_sku);
    }

    public void label_number_of_pending_skus() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        int pending_sku = Integer.parseInt((waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_pending_skus))).getText());
        String umatched_sku = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_unmatched_skus)).getText();
        int matched_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_matched_skus)).getText());
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_number_of_daraz_skus)).getText());
        int invalid_sku =  Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_invalid_daraz_sku_value)).getText());
        int total_errors =Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_total_error_value)).getText());
        if (pending_sku == 0) {
            if(umatched_sku.contains("None")){
            int total = matched_sku + total_errors + invalid_sku;
            Assert.assertEquals(total, daraz_sku);
        }} else {
            System.out.println("Wait Until Scraping is compeleted");

        }

    }



    public void label_competitor() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Thread.sleep(3000);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements( skumpo.label_competitor));
        String label_competitor_name="";
        for(int i =0 ;i<skumpo.label_competitor.size();i++){
          label_competitor_name +=  skumpo.label_competitor.get(i).getText();}
        Assert.assertEquals(label_competitor_name,table_competitors.replace(",", ""));
    }

    public void label_user() {
        String user = new SKUMatchingPageObjects(driver).label_user.getText();
        Assert.assertEquals(table_user, user);
    }

    public void label_created_time() throws ParseException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        String created_time_txt = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_created_time)).getText();
        SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date created_time = formatter5.parse(created_time_txt);
        Assert.assertEquals(table_created_time, created_time);
    }


    public void get_skumatching_table_data() throws InterruptedException {// Pagination Blocker
        Thread.sleep(3000);
        int Beforejob_tablesize = new SKUMatchingPageObjects(driver).pagination.size();
        new SKUMatchingPageObjects(driver).pagination.get(Beforejob_tablesize - 2).click();
        Thread.sleep(3000);
        int a = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).last_id)).getText());
        System.out.println(a);
    }

    public void download_file_task_details() throws InterruptedException, IOException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.label_uploaded_file_name)).click();
        Thread.sleep(2000);
        Path dir = Paths.get("/home/qaautomation/Downloads");  // specify your directory

        Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
                .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

        if (lastFilePath.isPresent()) // your folder may be empty3
        {
            System.out.println(lastFilePath);
        }

    }

    //Verify View Matched item data

    public void verify_view_matched_item_data(){
        int table_matched_sku=0;
        int view_matched_item_rows=0;
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.table_column_no_of_matched_skus)).size();
        for (int i =0; i<skumpo.table_column_no_of_matched_skus.size();i++){
            table_matched_sku += Integer.parseInt(skumpo.table_column_no_of_matched_skus.get(i).getText());
        }
        skumpo.view_matched_item_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.view_matched_item_competitor_select)).size();
        for(int j=0; j<skumpo.view_matched_item_competitor_select.size();j++){
            if(skumpo.view_matched_item_competitor_select.get(j).getText().equals("Offline")) {
                System.out.println("Offline");
            }
            else{
                waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.view_matched_item_competitor_select.get(j))).click();
            if ( skumpo.view_matched_item_rows.size()>=1){
                view_matched_item_rows +=  skumpo.view_matched_item_rows.size();
                System.out.println(table_matched_sku+"/n"+view_matched_item_rows);
            }
            else{
                Assert.assertTrue(skumpo.view_match_item_no_data_found.isDisplayed());

            }
        }}
        Assert.assertEquals(view_matched_item_rows,table_matched_sku);
        skumpo.cancel_icon.click();



    }

    public void verify_view_matched_item_data_7th_row(){
        int table_matched_sku=0;
        int view_matched_item_rows=0;
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.table_column_no_of_matched_skus_7th)).size();
        for (int i =0; i<skumpo.table_column_no_of_matched_skus_7th.size();i++){
            table_matched_sku += Integer.parseInt(skumpo.table_column_no_of_matched_skus_7th.get(i).getText());
        }
        skumpo.view_matched_item_btn_7th.click();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.view_matched_item_competitor_select)).size();
        for(int j=0; j<skumpo.view_matched_item_competitor_select.size();j++){
            if(skumpo.view_matched_item_competitor_select.get(j).getText().equals("Offline")) {
                System.out.println("Offline");
            }
            else{
            skumpo.view_matched_item_competitor_select.get(j).click();
            if ( skumpo.view_matched_item_rows.size()>=1){
                view_matched_item_rows +=  skumpo.view_matched_item_rows.size();
                System.out.println(table_matched_sku+"/n"+view_matched_item_rows);
            }
            else{
                Assert.assertTrue(skumpo.view_match_item_no_data_found.isDisplayed());

            }
        }}
        Assert.assertEquals(view_matched_item_rows,table_matched_sku);
        skumpo.cancel_icon.click();


    }

    //Mark accurate/inaccurate

    public void mark_inaccurate() throws InterruptedException {
        driver.navigate().refresh();
        Actions reason = new Actions(driver);
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        String competitor_name = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_competior_name)).getText();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        System.out.println(skumpo.view_matched_item_active_tab.getText());
        if (competitor_name.contains("Chaldal_bd") || competitor_name.contains("Pickaboo_bd") || competitor_name.contains("Shajgoj") || competitor_name.contains("PandaMart")) {
            driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'" + competitor_name + "')]")).click();
        } else {
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
        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_competior_name)).getText();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
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
        String competitor_name =waitforelement().until(ExpectedConditions.visibilityOf(skumpo.table_competior_name)).getText();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
        Thread.sleep(2000);
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
    driver.findElement(By.cssSelector("div.modal-content button.close span")).click();}
//others reason removed
//    public void verify_other_reason_mark_inaccurate() throws InterruptedException {
//        driver.navigate().refresh();
//        Actions reason = new Actions(driver);
//        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//        System.out.println(skumpo.view_matched_item_active_tab.getText());
//        String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
//        System.out.println(match_text + '\n');
//        if (match_text.contains("VERIFIED")) {
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            skumpo.mark_inaccurate_dropdown_reasons_others_selection.click();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_input)).sendKeys(mark_inaccurate_others_text);
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_inaccurate_other_popup_submit_button)).click();
//            Thread.sleep(2000);
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
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//        System.out.println(skumpo.view_matched_item_active_tab.getText());
//        String match_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_first_row_of_table)).getText();
//        System.out.println(match_text + '\n');
//        if (match_text.contains("VERIFIED")) {
//            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.mark_verified_or_inaccurate_btn)).click();
//            Thread.sleep(3000);
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
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_btn)).click();
//        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.popup)).isDisplayed();
//        System.out.println(skumpo.view_matched_item_active_tab.getText());
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
    //Online Upload

    public void upload_online_match_valid_file_click_upload() throws InterruptedException {

        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Thread.sleep(10000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_online_1671527738208.csv";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)));
        String success_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(success_text, "Successfully Task Created");

    }

    public void upload_online_match_valid_file_click_cancel_button() throws InterruptedException {
       SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
       driver.navigate().refresh();
       Thread.sleep(10000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_online_1671527738208.csv";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        skumpo.upload_online_matches_cancel_button.click();
        boolean popup = skumpo.popup.isDisplayed();
        Assert.assertFalse(popup);
    }

    public void upload_online_match_valid_file_click_cancel_icon() {
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_online_1671527738208.csv";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
       skumpo.cancel_icon.click();
        boolean popup = skumpo.popup.isDisplayed();
        Assert.assertFalse(popup);

    }

    public void upload_online_match_without_file() {

        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.upload_matches_button)).click();
        boolean popup = skumpo.popup.isDisplayed();
        Assert.assertTrue(popup);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.upload_online_matches_cancel_button)).click();

    }

    public void upload_online_match_invalid_excel_file() throws InterruptedException {
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(10000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_online_1671527738208.xlsx";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        Thread.sleep(8000);
        String popup = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).getAttribute("class"));
        System.out.println(popup);
        Assert.assertTrue(popup.contains("disabled"));
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.upload_online_matches_cancel_button)).click();
    }

    public void upload_online_match_invalid_image_file() throws InterruptedException {
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(5000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/camera_test_apple_563728.jpeg";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        String popup = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).getAttribute("class"));
        System.out.println(popup);
        Assert.assertTrue(popup.contains("disabled"));
        skumpo.upload_online_matches_cancel_button.click();
    }

    public void download_templete_online_matches() throws InterruptedException, IOException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_online_match_dropdown_selection)));
        skumpo.download_match_templete.click();
        Thread.sleep(2000);
        Path dir = Paths.get("/home/qaautomation/Downloads/");  // specify your directory

        Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
                .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

        if (lastFilePath.isPresent()) // your folder may be empty
        {
            System.out.println(lastFilePath);
        }
        Assert.assertTrue(lastFilePath.isPresent());
        skumpo.upload_online_matches_cancel_button.click();

    }

    public void online_label_number_of_daraz_skus() {
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        Assert.assertEquals(daraz_sku, 8);//Number of records in uploaded file
    }
    public void online_label_competitors(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Assert.assertEquals(skumpo.label_competitor.get(0).getText(),"MANUAL");
    }

    //online_Veirfy all active/inactive skus from file

    public void online_verify_all_active_skus_from_file() throws IOException, InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Pages/online_upload_sku.properties";
        File file = new File(absoluteFilePath);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        Properties prop = new Properties();
        prop.load(fis);
        if (prop == null) {
            System.out.println("No Data Found");
            Assert.assertTrue(prop.isEmpty());
        } else {
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id));
                for (int h = 0; h < skumpo.task_details_table_sku_id.size(); h++) {
                    String first_sku = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id)).get(h).getText());
                    for (int i = 1; i <= 8; i++) {
                        String t = prop.getProperty("SKU" + i);
                        if (t.equals(first_sku)) {
                            System.out.println(first_sku);
                            System.out.println(t);
                            Assert.assertEquals(t, first_sku);
                        }
                    }
                }
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();

                System.out.println(skumpo.task_details_no_data_found.getText());
            }
        }
    }

    public void online_verify_all_inactive_skus_from_file() throws IOException, InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_inactive)).click();
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
        Thread.sleep(4000);
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Pages/online_upload_sku.properties";
        File file = new File(absoluteFilePath);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        Properties prop = new Properties();
        prop.load(fis);
        if (prop == null) {
            System.out.println("No Data Found");
            Assert.assertTrue(prop.isEmpty());
        } else {
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id));
                for (int h = 0; h < skumpo.task_details_table_sku_id.size(); h++) {
                    String first_sku = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id)).get(h).getText());
                    for (int i = 1; i <= 8; i++) {
                        String t = prop.getProperty("SKU" + i);
                        if (t.equals(first_sku)) {
                            System.out.println(first_sku);
                            System.out.println(t);
                            Assert.assertEquals(t, first_sku);
                        }
                    }
                }
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();

                System.out.println(skumpo.task_details_no_data_found.getText());
            }
        }
    }
    public void online_verify_view_matched_item_data(){
        int table_matched_sku=0;
        int view_matched_item_rows=0;
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.table_column_no_of_matched_skus)).size();
        for (int i =0; i<skumpo.table_column_no_of_matched_skus.size();i++){
            table_matched_sku += Integer.parseInt(skumpo.table_column_no_of_matched_skus.get(i).getText());
        }
        skumpo.view_matched_item_btn.click();
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.view_matched_item_competitor_select)).size();
        for(int j=0; j<skumpo.view_matched_item_competitor_select.size();j++){
            waitforelement().until(ExpectedConditions.visibilityOf(skumpo.view_matched_item_competitor_select.get(j))).click();
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

    public void online_label_total_errors(){
        Assert.assertEquals(Integer.parseInt(new SKUMatchingPageObjects(driver).label_total_error_value.getText()),0);

    }

    //OFFLINE MATCH

    public void upload_offline_match_valid_file_click_upload() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)).click();
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)).click();
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/uploaded_file_794_1674827353544.csv";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).click();
        String success_text = waitforelement().until(ExpectedConditions.visibilityOf(skumpo.success_msg)).getText();
        Assert.assertEquals(success_text, "Task Created Successfully");
    }

    public void upload_offline_match_valid_file_click_cancel_button() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(10000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/uploaded_file_794_1674827353544.csv";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        new SKUMatchingPageObjects(driver).upload_online_matches_cancel_button.click();
        boolean popup = new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertFalse(popup);
    }

    public void upload_offline_match_valid_file_click_cancel_icon() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(5000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/uploaded_file_794_1674827353544.csv";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        skumpo.cancel_icon.click();
        boolean popup = new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertFalse(popup);
    }

    public void upload_offline_match_without_file() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)));
        waitforelement().until(ExpectedConditions.elementToBeClickable(new SKUMatchingPageObjects(driver).upload_matches_button)).click();
        boolean popup = new SKUMatchingPageObjects(driver).popup.isDisplayed();
        Assert.assertTrue(popup);
        skumpo.cancel_icon.click();

    }

    public void upload_offline_match_invalid_excel_file() {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/sku_template_online_1671527738208.xlsx";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        String popup = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).getAttribute("class"));
        System.out.println(popup);
        Assert.assertTrue(popup.contains("disabled"));
        skumpo.cancel_icon.click();

    }

    public void upload_offline_match_invalid_image_file() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        Thread.sleep(5000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)));
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Support_Files/camera_test_apple_563728.jpeg";
        File file = new File(absoluteFilePath);
        skumpo.add_file.sendKeys(file.getAbsolutePath());
        String popup = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_button)).getAttribute("class"));
        System.out.println(popup);
        Assert.assertTrue(popup.contains("disabled"));
        skumpo.cancel_icon.click();
    }

    public void download_templete_offline_matches() throws InterruptedException, IOException {
        driver.navigate().refresh();
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.upload_matches_btn)));
        jsExecutor.executeScript("arguments[0].click();", waitforelement().until(ExpectedConditions.visibilityOf(skumpo.offline_match_dropdown_selection)));
        skumpo.download_match_templete.click();
        Thread.sleep(2000);
        Path dir = Paths.get("/home/qaautomation/Downloads/");  // specify your directory
        Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
                .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

        if (lastFilePath.isPresent()) // your folder may be empty
        {
            System.out.println(lastFilePath);
        }
        skumpo.upload_online_matches_cancel_button.click();
    }
    //offline_Veirfy all active/inactive skus from file

    public void offline_verify_all_active_skus_from_file() throws IOException, InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Pages/online_upload_sku.properties";
        File file = new File(absoluteFilePath);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        Properties prop = new Properties();
        prop.load(fis);
        if (prop == null) {
            System.out.println("No Data Found");
            Assert.assertTrue(prop.isEmpty());
        } else {
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id));
                for (int h = 0; h < skumpo.task_details_table_sku_id.size(); h++) {
                    String first_sku = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id)).get(h).getText());
                    for (int i = 1; i <= 8; i++) {
                        String t = prop.getProperty("SKU" + i);
                        if (t.equals(first_sku)) {
                            System.out.println(first_sku);
                            System.out.println(t);
                            Assert.assertEquals(t, first_sku);
                        }
                    }
                }
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();

                System.out.println(skumpo.task_details_no_data_found.getText());
            }
        }
    }

    public void offline_verify_all_inactive_skus_from_file() throws IOException, InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        driver.navigate().refresh();
        waitforelement().until(ExpectedConditions.visibilityOf(skumpo.filter_sku_current_inactive)).click();
        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.filter_filter_btn)).click();
        Thread.sleep(4000);
        String absoluteFilePath = System.getProperty("user.dir")+"/src/test/java/Pages/online_upload_sku.properties";
        File file = new File(absoluteFilePath);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        Properties prop = new Properties();
        prop.load(fis);
        if (prop == null) {
            System.out.println("No Data Found");
            Assert.assertTrue(prop.isEmpty());
        } else {
            Thread.sleep(4000);
            if (skumpo.task_details_table_sku_id.size() >= 1) {
                waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id));
                for (int h = 0; h < skumpo.task_details_table_sku_id.size(); h++) {
                    String first_sku = String.valueOf(waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.task_details_table_sku_id)).get(h).getText());
                    for (int i = 1; i <= 8; i++) {
                        String t = prop.getProperty("SKU" + i);
                        if (t.equals(first_sku)) {
                            System.out.println(first_sku);
                            System.out.println(t);
                            Assert.assertEquals(t, first_sku);
                        }
                    }
                }
            } else {
                waitforelement().until(ExpectedConditions.visibilityOf(skumpo.task_details_no_data_found)).isDisplayed();

                System.out.println(skumpo.task_details_no_data_found.getText());
            }
        }
    }

    public void offline_verify_view_matched_item_data(){
        int table_matched_sku=0;
        int view_matched_item_rows=0;
        SKUMatchingPageObjects skumpo= new SKUMatchingPageObjects(driver);
        waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.table_column_no_of_matched_skus)).size();
        for (int i =0; i<skumpo.table_column_no_of_matched_skus.size();i++){
            table_matched_sku += Integer.parseInt(skumpo.table_column_no_of_matched_skus.get(i).getText());
        }
        skumpo.view_matched_item_btn.click();
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



    public void offline_label_total_errors(){
        Assert.assertEquals(Integer.parseInt(new SKUMatchingPageObjects(driver).label_total_error_value.getText()),0);

    }
    public void offline_label_number_of_daraz_skus() {
        int daraz_sku = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).label_number_of_daraz_skus)).getText());
        Assert.assertEquals(daraz_sku, 7);//Number of records in uploaded file
    }
    public void offline_label_competitors(){
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        String label_competitor_name="";
        for(int i =0 ;i<skumpo.label_competitor.size();i++){
        label_competitor_name +=  skumpo.label_competitor.get(i).getText();}
        Assert.assertEquals(label_competitor_name,"MANUAL");
    }
//
    public void verify_unmatched_popup_data() throws InterruptedException {
        SKUMatchingPageObjects skumpo = new SKUMatchingPageObjects(driver);
        skumpo.SKU_Matching.click();
        waitforelement().until(ExpectedConditions.elementToBeClickable(skumpo.task_details_btn)).click();
        Thread.sleep(8000);
        int t = Integer.parseInt(waitforelement().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.card mt-20.p-3,.task-info div.row:nth-child(3)  div.col-3:nth-child(1) strong")))).getText());
        if(t == 0){
            System.out.println("No unmatched Sku");
        }
        else {
            float b = t / 10;
            System.out.println(b);
            waitforelement().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.card mt-20.p-3,.task-info div.row:nth-child(3)  div.col-3:nth-child(1) span")))).click();
            int test = waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.pendig_skus)).size();
            for (int i = 1; i < 36; i++) {
                if (skumpo.next_button.isEnabled()) {
                    skumpo.next_button.click();
                    Thread.sleep(3000);
                    test += waitforelement().until(ExpectedConditions.visibilityOfAllElements(skumpo.pendig_skus)).size();
                    System.out.println(test);

                } else System.out.println(test);
            }

        }
    }
}




