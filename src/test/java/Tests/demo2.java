//package Tests;
//
//import Pages.*;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.ParseException;
//import java.util.Base64;
//
//import Utilities.MyScreenRecorder;
//import io.qameta.allure.Allure;
//import io.qameta.allure.Attachment;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.annotations.*;
//
//import static Utilities.Wait.driver;
//
//
//public class demo2 {
//    Base base = new Base();
//    LoginPage lpg = new LoginPage();
//
//    ScraperPage sp = new ScraperPage();
//    SKUMatchingPage SKUmp = new SKUMatchingPage();
//
//
//
//
//    @BeforeSuite
//    public void BeforeSuite() throws Exception {
//        driver = base.driver();
//    }
//
//
//
//
//
//
//
//    @Attachment(value = "Failure screenshot", type = "image/png")
//    public byte[] attachScreenshot() {
//        if (driver instanceof TakesScreenshot) {
//            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            try (InputStream in = new ByteArrayInputStream(screenshot)) {
//                Allure.addAttachment("Screenshot", in);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Reporter.log("<br><img src='data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot) + "' width='300px'/><br>");
//        }
//        return new byte[0];
//    }
//
//
//    //    public void attachVideo() throws IOException {
////        byte[] videoBytes = Files.readAllBytes(Paths.get("/Users/farhanahmedsheikh/Documents/untitled folder/myTestProject(Copy for process 2)/recordings/Test004.avi"));
////        attachVideoToAllureReport(videoBytes);
////    }
////
////    @Attachment(value = "Recorded video", type = "video/mp4")
////    public byte[] attachVideoToAllureReport(byte[] videoBytes) {
////        return videoBytes;
////    }
////
////    @BeforeMethod
////    public void beforemethod() throws Exception {
////        MyScreenRecorder.startRecording("Test004");;
////    }
//    @AfterMethod
//    public void afterMethod(ITestResult result) throws Exception {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            attachScreenshot();
//
//        }
//    }
//
//
//
////    @AfterSuite
////    public void aftertest() throws Exception {
////        base.teardown();
////    }
//
//
//
//
//
//    //   Login Test
//
//    @Test(priority = 1)
//    public void CheckLogin_Text() throws Exception {
//        lpg.Check_Login_Displayed();
//    }
//
//    @Test(priority = 2)
//    public void Checklogo() {
//        lpg.CheckLogo();
//    }
//
//    @Test(priority = 3)
//    public void verifyfooter_text() {
//        lpg.Verifyfootertext();
//    }
//
//    @Test(priority = 4)
//    public void verify_case6() {
//        lpg.Login_Case6();
//
//    }
//    @Test(priority = 5)
//    public void verify_Case5() {
//        lpg.Login_Case5();
//
//    }
//    @Test(priority = 6)
//    public void verify_Case4() {
//        lpg.Login_Case4();
//
//    }
//    @Test(priority = 7)
//    public void verify_Case3() {
//        lpg.Login_Case3();
//
//    }
//    @Test(priority = 8)
//    public void Empty_Login_and_Verify_username_validation() {
//        lpg.Login_Case2();
//
//    }
//    @Test(priority = 9)
//    public void verify_sucessful_login() throws InterruptedException {
//        lpg.Login_Case1();
//
//    }
//    @Test(priority = 10)
//    public void change_venture_BD() throws InterruptedException {
//        sp.Change_venture();
//    }
//    @Test(priority = 11)
//    public void left_menu_scraper_selection() throws InterruptedException {
//        sp.left_menu_scraper_selection();
//
//    }
//
//    @Test(priority = 12)
//    public void verify_pagetitle(){
//        sp.pagetitle();
//    }
//    @Test(priority = 13)
//    public void get_table_data_before_job_start() throws InterruptedException {
//        sp.get_table_data_before_job_start();
//    }
//    @Test(priority = 14)
//    public void check_cancel_button() throws InterruptedException {
//        sp.check_cancel_button();
//    }
//
//
//    @Test(priority = 15)
//    public void Start_Scraping_Jobs(){
//        sp.Start_Scraping_Jobs();
//    }
//    @Test(priority = 16)
//    public void Success_msg() throws InterruptedException {
//        sp.Success_msg();
//    }
//    @Test(priority = 17)
//    public void getandcomparedata() throws InterruptedException {
//        sp.getandcomparedata();
//    }
//    @Test(priority = 18)
//    public void verify_select20records() throws Exception {
//        sp.select20records();
//    }
//    @Test(priority = 19)
//    public void verify_click_SKUMatching_module(){
//        SKUmp.click_SKUMatching_module();
//    }
//    //Create task
//    @Test(priority = 20)
//    public void verify_Create_task_popup() throws InterruptedException {
//        SKUmp.Create_task_popup();
//    }
//    @Test(priority = 21)
//    public void verify_create_task_popup_cancel_btn() throws InterruptedException {
//        SKUmp.create_task_popup_cancel_btn();
//    }
//    @Test(priority = 22)
//    public void create_task_popup_cancel_icon() throws InterruptedException {
//        SKUmp.create_task_popup_cancel_icon();
//    }
//    @Test(priority = 23)
//    public void verify_double_click_chaldal_remove_selection() throws InterruptedException {
//        SKUmp.double_click_chaldal_remove_selection();
//    }
//    @Test(priority = 24)
//    public void verify_check_single_competitor_selection() throws InterruptedException {
//        SKUmp.check_single_competitor_selection();
//    }
//    @Test(priority = 25)
//    public void verify_check_multiple_competitor_selection() throws InterruptedException {
//        SKUmp.check_multiple_competitor_selection();
//    }
//    @Test(priority = 26)
//    public void verify_Create_task_replace_file() throws InterruptedException {
//        SKUmp.Create_task_replace_file();
//    }
//    @Test(priority = 27)
//    public void download_create_task_templete() throws IOException, InterruptedException {
//        SKUmp.download_create_task_templete();
//    }
//    @Test(priority = 28)
//    public void verify_create_task() throws InterruptedException {
//        SKUmp.Create_task();
//    }
//    @Test(priority = 29)
//    public void verify_task_created_message() throws InterruptedException {
//        SKUmp.verify_task_created();
//    }
//    @Test(priority = 29)
//    public void verify_get_task_data() throws InterruptedException, ParseException {
//        SKUmp.get_task_data();
//    }
//    @Test(priority = 30)
//    public void verify_click_task_details(){
//        SKUmp.click_task_details();
//    }
//    @Test(priority = 31)
//    public void label_competitor() throws InterruptedException {
//        SKUmp.label_competitor();}
//    @Test(priority = 31)
//    public void verify_sku_current_filter(){
//        SKUmp.verify_sku_current_filter();
//    }
//    @Test(priority = 32)
//    public void verify_matching_status_filter(){
//        SKUmp.verify_matching_status_filter();
//    }
//    @Test(priority = 33)
//    public void verify_all_active_skus_from_file() throws IOException, InterruptedException {
//        SKUmp.verify_all_active_skus_from_file();
//
//    }
//    @Test(priority = 34)
//    public void verify_all_inactive_skus_from_file() throws IOException, InterruptedException {
//        SKUmp.verify_all_inactive_skus_from_file();
//
//    }
//    @Test(priority = 35)
//    public void verify_all_active_inactive_skus_with_matched_daraz_skus() throws InterruptedException {
//        SKUmp.verify_all_active_inactive_skus_with_matched_daraz_skus();
//
//    }
//    @Test(priority = 36)
//    public void verify_verified_active_inactive_skus_with_number_of_checked_matches() throws InterruptedException {
//        SKUmp.verify_verified_active_inactive_skus_with_number_of_checked_matches();
//    }
//    @Test(priority = 37)
//    public void verify_number_of_unchecked_matches() throws InterruptedException {
//        SKUmp.verify_number_of_unchecked_matches();
//    }
//    @Test(priority = 38)
//    public void verify_search_by_sku_name_and_id() throws InterruptedException {
//        SKUmp.verify_search_by_sku_name_and_id();
//    }
//    @Test(priority = 39)
//    public void verify_search_by_sku_id() throws InterruptedException {
//        SKUmp.verify_search_by_sku_id();
//    }
//    @Test(priority = 40)
//    public void verify_search_by_sku_name() throws InterruptedException {
//        SKUmp.verify_search_by_sku_name();
//    }
//    @Test(priority = 41)
//    public void click_add_competitor_sku_verify_popup() throws InterruptedException {
//        SKUmp.click_add_competitor_sku_verify_popup();
//    }
//    @Test(priority = 42)
//    public void click_cancel_popup() throws InterruptedException {
//        SKUmp.click_cancel_popup();
//    }
//
//    @Test(priority = 43)
//    public void verify_online_selection() throws InterruptedException {
//        SKUmp.verify_online_selection();
//    }
//    @Test(priority = 44)
//    public void add_online_competitor_sku_match_valid_url() throws InterruptedException {
//        SKUmp.add_online_competitor_sku_match_valid_url();
//    }
//    @Test(priority = 45)
//    public void verify_online_match_added(){
//        SKUmp.verify_online_match_added();
//    }
//    @Test(priority = 46)
//    public void add_online_competitor_sku_invalid_url(){
//        SKUmp.add_online_competitor_sku_invalid_url();
//    }
//    @Test(priority = 47)
//    public void verify_add_sku_btn_disable_on_popup_display(){
//        SKUmp.verify_add_sku_btn_disable_on_popup_display();
//    }
//    @Test(priority = 48)
//    public void verify_add_sku_btn_disable_on_competitor_select(){
//        SKUmp.verify_add_sku_btn_disable_on_competitor_select();
//    }
//    @Test(priority = 49)
//    public void verify_add_sku_btn_disable_on_add_url(){
//        SKUmp.verify_add_sku_btn_disable_on_add_url();
//    }
//    @Test(priority = 50)
//    public void verify_offline_selection(){
//        SKUmp.verify_offline_selection();
//    }
//    @Test(priority = 51)
//    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name();
//    }
//    @Test(priority = 52)
//    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name();
//    }
//    @Test(priority = 53)
//    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price();
//    }
//    @Test(priority = 54)
//    public void add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category();
//    }
//    @Test(priority = 55)
//    public void add_offline_competitor_sku_match_valid_data_verify_button_enabled(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_enabled();
//    }
//    @Test(priority = 56)
//    public void add_offline_competitor_sku_match_valid_data_click_add_sku_button(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_click_add_sku_button();
//    }
//    @Test(priority = 57)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_sku() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_sku();
//    }
//    @Test(priority = 58)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_name(){
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_name();
//    }
//    @Test(priority = 59)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_price() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_price();
//    }
//    @Test(priority = 60)
//    public void verify_offline_competitor_sku_match_added_verify_competitor_category(){
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_category();
//    }
//    @Test(priority = 61)
//    public void verify_database_tab_selection(){
//        SKUmp.verify_database_tab_selection();
//    }
//    @Test(priority = 62)
//    public void verify_database_tab_add_btn_disabled(){
//        SKUmp.verify_database_tab_add_btn_disabled();
//    }
//    @Test(priority = 63)
//    public void verify_search_btn_disabled(){
//        SKUmp.verify_search_btn_disabled();
//    }
//    @Test(priority = 64)
//    public void verify_cancel_icon_database_tab() throws InterruptedException {
//        SKUmp.verify_cancel_icon_database_tab();
//    }
//    @Test(priority = 65)
//    public void verify_cancel_button_database_tab() throws InterruptedException {
//        SKUmp.verify_cancel_button_database_tab();
//    }
//    @Test(priority = 66)
//    public void verify_search_btn_enabled_on_filter_selection(){
//        SKUmp.verify_search_btn_enabled_on_filter_selection();
//    }
//    @Test(priority = 67)
//    public void verify_filter_competitor_name(){
//        SKUmp.verify_filter_competitor_name();
//    }
//    @Test(priority = 68)
//    public void verify_data_on_filter_by_chaldal_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_chaldal_database_tab();
//    }
//    @Test(priority = 69)
//    public void verify_data_on_filter_by_pandamart_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
//    }
//    @Test(priority = 70)
//    public void verify_data_on_filter_by_pickaboo_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pickaboo_database_tab();
//    }
//    @Test(priority = 71)
//    public void verify_data_on_filter_by_shajgoj_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
//    }
//    @Test(priority = 72)
//    public void search_sku_name_against_competitor_database_tab(){
//        SKUmp.search_sku_name_against_competitor_database_tab();
//    }
//    @Test(priority = 73)
//    public void add_match_database_tab(){
//        SKUmp.add_match_database_tab();
//    }
//    @Test(priority = 74)
//    public void verify_database_match_added(){
//        SKUmp.verify_database_match_added();
//    }
//    @Test(priority = 75)
//    public void label_number_of_daraz_skus(){
//        SKUmp.label_number_of_daraz_skus();
//    }  @Test(priority = 76)
//    public void label_number_of_unmatched_skus(){
//        SKUmp.label_number_of_unmatched_skus();
//    }
//    @Test(priority = 77)
//    public void label_number_of_matched_skus(){
//        SKUmp.label_number_of_matched_skus();
//    }
//    @Test(priority = 78)
//    public void label_number_of_pending_skus(){
//        SKUmp.label_number_of_pending_skus();
//    }
//    @Test(priority = 80)
//    public void label_user(){
//        SKUmp.label_user();
//    }  @Test(priority = 81)
//    public void label_created_time() throws ParseException {
//        SKUmp.label_created_time();
//    }  @Test(priority = 82)
//    public void download_file_task_details() throws IOException, InterruptedException {
//        SKUmp.download_file_task_details();
//    }
//    @Test(priority = 83)
//    public void verify_view_matched_item_data(){
//        SKUmp.verify_view_matched_item_data();
//    }
//    //    @Test(priority = 84)
////    public void verify_view_matched_item_data_7th_row(){
////        SKUmp.verify_view_matched_item_data_7th_row();
////    }
//    @Test(priority = 85)
//    public void mark_inaccurate() throws InterruptedException {
//        SKUmp.mark_inaccurate();
//    }
//    @Test(priority = 86)
//    public void mark_verified() throws InterruptedException {
//        SKUmp.mark_verified();
//    }
//    @Test(priority = 87)
//    public void verify_mark_inaccurate_dropdown() throws InterruptedException {
//        SKUmp.verify_mark_inaccurate_dropdown();
//    }
//    //    @Test(priority = 88)
////    public void verify_other_reason_mark_inaccurate() throws InterruptedException {
////        SKUmp.verify_other_reason_mark_inaccurate();
////    }
////    @Test(priority = 89)
////    public void verify_other_reason_mark_inaccurate_cancel_button() throws InterruptedException {
////        SKUmp.verify_other_reason_mark_inaccurate_cancel_button();
////    }
////    @Test(priority = 90)
////    public void verify_other_reason_mark_inaccurate_cancel_icon() throws  InterruptedException {
////        SKUmp.verify_other_reason_mark_inaccurate_cancel_icon();
////    }
//    //online task
//    @Test(priority = 91)
//    public void upload_online_match_valid_file_click_upload() throws InterruptedException {
//        SKUmp.upload_online_match_valid_file_click_upload();
//    }
//    @Test(priority = 92)
//    public void upload_online_match_valid_file_click_cancel_button() throws InterruptedException {
//        SKUmp.upload_online_match_valid_file_click_cancel_button();
//    }
//    @Test(priority = 93)
//    public void upload_online_match_valid_file_click_cancel_icon(){
//        SKUmp.upload_online_match_valid_file_click_cancel_icon();
//    }
//    @Test(priority = 94)
//    public void upload_online_match_without_file(){
//        SKUmp.upload_online_match_without_file();
//    }
//    @Test(priority = 95)
//    public void upload_online_match_invalid_excel_file() throws InterruptedException {
//        SKUmp.upload_online_match_invalid_excel_file();
//    }
//    @Test(priority = 96)
//    public void upload_online_match_invalid_image_file() throws InterruptedException {
//        SKUmp.upload_online_match_invalid_image_file();
//    }
//    @Test(priority = 97)
//    public void download_templete_online_matches() throws IOException, InterruptedException {
//        SKUmp.download_templete_online_matches();
//    }
//    @Test(priority = 98)
//    public void online_get_task_data() throws ParseException, InterruptedException {
//        SKUmp.get_task_data();
//    }
//    @Test(priority = 99)
//    public void click_task_details(){
//        SKUmp.click_task_details();
//    }
//    @Test(priority = 100)
//    public void online_label_number_of_daraz_skus(){
//        SKUmp.online_label_number_of_daraz_skus();
//    }
//    @Test(priority = 101)
//    public void online_label_competitors(){
//        SKUmp.online_label_competitors();
//    }
//    @Test(priority = 102)
//    public void online_verify_all_active_skus_from_file() throws IOException, InterruptedException {
//        SKUmp.online_verify_all_active_skus_from_file();
//    }
//    @Test(priority = 103)
//    public void  online_verify_all_inactive_skus_from_file() throws IOException, InterruptedException {
//        SKUmp. online_verify_all_inactive_skus_from_file();
//    }
//    @Test(priority = 103)
//    public void  online_label_total_errors() throws IOException, InterruptedException {
//        SKUmp. online_label_total_errors();
//    }
//    @Test(priority = 104)
//    public void online_verify_all_active_inactive_skus_with_matched_daraz_skus() throws InterruptedException {
//        SKUmp.verify_all_active_inactive_skus_with_matched_daraz_skus();
//    }
//    @Test(priority = 105)
//    public void online_verify_verified_active_inactive_skus_with_number_of_verified_matches() throws InterruptedException {
//        SKUmp.verify_verified_active_inactive_skus_with_number_of_checked_matches();
//    }
//    @Test(priority = 106)
//    public void online_verify_number_of_unverified_matches() throws InterruptedException {
//        SKUmp.verify_number_of_unchecked_matches();
//    }
//    @Test(priority = 107)
//    public void online_verify_search_by_sku_name_and_id() throws InterruptedException {
//        SKUmp.verify_search_by_sku_name_and_id();
//    }
//    @Test(priority = 108)
//    public void online_verify_search_by_sku_id() throws InterruptedException {
//        SKUmp.verify_search_by_sku_id();
//    }
//    @Test(priority = 109)
//    public void online_verify_search_by_sku_name() throws InterruptedException {
//        SKUmp.verify_search_by_sku_name();
//    }
//    @Test(priority = 110)
//    public void online_click_add_competitor_sku_verify_popup() throws InterruptedException {
//        SKUmp.click_add_competitor_sku_verify_popup();
//    }
//    @Test(priority = 111)
//    public void online_click_cancel_popup() throws InterruptedException {
//        SKUmp.click_cancel_popup();
//    }
//
//    @Test(priority = 112)
//    public void online_verify_online_selection() throws InterruptedException {
//        SKUmp.verify_online_selection();
//    }
//    @Test(priority = 113)
//    public void online_add_online_competitor_sku_match_valid_url() throws InterruptedException {
//        SKUmp.add_online_competitor_sku_match_valid_url();
//    }
//    @Test(priority = 114)
//    public void online_verify_online_match_added(){
//        SKUmp.verify_online_match_added();
//    }
//    @Test(priority = 115)
//    public void online_add_online_competitor_sku_invalid_url(){
//        SKUmp.add_online_competitor_sku_invalid_url();
//    }
//    @Test(priority = 116)
//    public void online_verify_add_sku_btn_disable_on_popup_display(){
//        SKUmp.verify_add_sku_btn_disable_on_popup_display();
//    }
//    @Test(priority = 117)
//    public void online_verify_add_sku_btn_disable_on_competitor_select(){
//        SKUmp.verify_add_sku_btn_disable_on_competitor_select();
//    }
//    @Test(priority = 118)
//    public void online_verify_add_sku_btn_disable_on_add_url(){
//        SKUmp.verify_add_sku_btn_disable_on_add_url();
//    }
//    @Test(priority = 119)
//    public void online_verify_offline_selection(){
//        SKUmp.verify_offline_selection();
//    }
//    @Test(priority = 120)
//    public void online_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name();
//    }
//    @Test(priority = 121)
//    public void online_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name();
//    }
//    @Test(priority = 122)
//    public void online_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price();
//    }
//    @Test(priority = 123)
//    public void online_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category();
//    }
//    @Test(priority = 124)
//    public void online_add_offline_competitor_sku_match_valid_data_verify_button_enabled(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_enabled();
//    }
//    @Test(priority = 125)
//    public void online_add_offline_competitor_sku_match_valid_data_click_add_sku_button(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_click_add_sku_button();
//    }
//    @Test(priority = 126)
//    public void online_verify_offline_competitor_sku_match_added_verify_competitor_sku() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_sku();
//    }
//    @Test(priority = 127)
//    public void online_verify_offline_competitor_sku_match_added_verify_competitor_name(){
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_name();
//    }
//    @Test(priority = 128)
//    public void online_verify_offline_competitor_sku_match_added_verify_competitor_price() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_price();
//    }
//    @Test(priority = 129)
//    public void online_verify_offline_competitor_sku_match_added_verify_competitor_category(){
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_category();
//    }
//    @Test(priority = 130)
//    public void online_verify_database_tab_selection(){
//        SKUmp.verify_database_tab_selection();
//    }
//    @Test(priority = 131)
//    public void online_verify_database_tab_add_btn_disabled(){
//        SKUmp.verify_database_tab_add_btn_disabled();
//    }
//    @Test(priority = 132)
//    public void online_verify_search_btn_disabled(){
//        SKUmp.verify_search_btn_disabled();
//    }
//    @Test(priority = 133)
//    public void online_verify_cancel_icon_database_tab() throws InterruptedException {
//        SKUmp.verify_cancel_icon_database_tab();
//    }
//    @Test(priority = 134)
//    public void online_verify_cancel_button_database_tab() throws InterruptedException {
//        SKUmp.verify_cancel_button_database_tab();
//    }
//    @Test(priority = 135)
//    public void online_verify_search_btn_enabled_on_filter_selection(){
//        SKUmp.verify_search_btn_enabled_on_filter_selection();
//    }
//    @Test(priority = 136)
//    public void online_verify_filter_competitor_name(){
//        SKUmp.verify_filter_competitor_name();
//    }
//    @Test(priority = 137)
//    public void online_verify_data_on_filter_by_chaldal_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_chaldal_database_tab();
//    }
//    @Test(priority = 138)
//    public void online_verify_data_on_filter_by_pandamart_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
//    }
//    @Test(priority = 139)
//    public void online_verify_data_on_filter_by_pickaboo_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pickaboo_database_tab();
//    }
//    @Test(priority = 140)
//    public void online_verify_data_on_filter_by_shajgoj_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
//    }
//    @Test(priority = 141)
//    public void online_search_sku_name_against_competitor_database_tab(){
//        SKUmp.search_sku_name_against_competitor_database_tab();
//    }
//    @Test(priority = 142)
//    public void online_add_match_database_tab(){
//        SKUmp.add_match_database_tab();
//    }
//    @Test(priority = 143)
//    public void online_verify_database_match_added(){
//        SKUmp.verify_database_match_added();
//    }
//    @Test(priority = 145)
//    public void online_label_number_of_unmatched_skus(){
//        SKUmp.label_number_of_unmatched_skus();
//    }  @Test(priority = 146)
//    public void online_label_number_of_matched_skus(){
//        SKUmp.label_number_of_matched_skus();
//    }  @Test(priority = 147)
//    public void online_label_number_of_pending_skus(){
//        SKUmp.label_number_of_pending_skus();
//    }
//    @Test(priority = 149)
//    public void online_label_user(){
//        SKUmp.label_user();
//    }  @Test(priority = 150)
//    public void online_label_created_time() throws ParseException {
//        SKUmp.label_created_time();
//    }  @Test(priority = 151)
//    public void online_download_file_task_details() throws IOException, InterruptedException {
//        SKUmp.download_file_task_details();
//    }
//    @Test(priority = 152)
//    public void online_verify_view_matched_item_data(){
//        SKUmp.online_verify_view_matched_item_data();
//    }
//    //        @Test(priority = 153)
////    public void verify_view_matched_item_data_7th_row(){
////        SKUmp.verify_view_matched_item_data_7th_row();
////    }
//    @Test(priority = 154)
//    public void online_mark_inaccurate() throws InterruptedException {
//        SKUmp.mark_inaccurate();
//    }
//    @Test(priority = 155)
//    public void online_mark_verified() throws InterruptedException {
//        SKUmp.mark_verified();
//    }
//    @Test(priority = 156)
//    public void online_verify_mark_inaccurate_dropdown() throws InterruptedException {
//        SKUmp.verify_mark_inaccurate_dropdown();
//    }
//    //    @Test(priority = 157)
////    public void online_verify_other_reason_mark_inaccurate() throws InterruptedException {
////        SKUmp.verify_other_reason_mark_inaccurate();
////    }
////    @Test(priority = 158)
////    public void online_verify_other_reason_mark_inaccurate_cancel_button() throws InterruptedException {
////        SKUmp.verify_other_reason_mark_inaccurate_cancel_button();
////    }
////    @Test(priority = 159)
////    public void online_verify_other_reason_mark_inaccurate_cancel_icon() throws  InterruptedException {
////        SKUmp.verify_other_reason_mark_inaccurate_cancel_icon();
////    }
//    //offline task
//    @Test(priority = 160)
//    public void upload_offline_match_valid_file_click_cancel_button() throws InterruptedException {
//        SKUmp.upload_offline_match_valid_file_click_cancel_button();
//    }
//    @Test(priority = 161)
//    public void upload_offline_match_valid_file_click_upload(){
//        SKUmp.upload_offline_match_valid_file_click_upload();
//    }
//    @Test(priority = 162)
//    public void upload_offline_match_valid_file_click_cancel_icon() throws InterruptedException {
//        SKUmp.upload_offline_match_valid_file_click_cancel_icon();
//    }
//    @Test(priority = 163)
//    public void upload_offline_match_without_file() {
//        SKUmp.upload_offline_match_without_file();
//    }
//    @Test(priority = 164)
//    public void upload_offline_match_invalid_excel_file() {
//        SKUmp.upload_offline_match_invalid_excel_file();
//    }
//    @Test(priority = 165)
//    public void upload_offline_match_invalid_image_file() throws InterruptedException {
//        SKUmp.upload_offline_match_invalid_image_file();
//    }
//    @Test(priority = 166)
//    public void download_templete_offline_matches() throws InterruptedException, IOException {
//        SKUmp.download_templete_offline_matches();
//    }
//    @Test(priority = 167)
//    public void offline_get_task_data() throws ParseException, InterruptedException {
//        SKUmp.get_task_data();
//    }
//    @Test(priority = 168)
//    public void offline_click_task_details(){
//        SKUmp.click_task_details();
//    }
//    @Test(priority = 169)
//    public void offline_verify_all_active_skus_from_file() throws InterruptedException, IOException {
//        SKUmp.offline_verify_all_active_skus_from_file();
//    }
//    @Test(priority = 170)
//    public void offline_verify_all_inactive_skus_from_file() throws InterruptedException, IOException {
//        SKUmp.offline_verify_all_inactive_skus_from_file();
//    }
//    @Test(priority = 171)
//    public void offline_label_number_of_daraz_skus() {
//        SKUmp.offline_label_number_of_daraz_skus();
//    }
//    @Test(priority = 172)
//    public void offline_label_competitors() {
//        SKUmp.offline_label_competitors();
//    }
//    @Test(priority = 173)
//    public void offline_verify_all_active_inactive_skus_with_matched_daraz_skus() throws InterruptedException {
//        SKUmp.verify_all_active_inactive_skus_with_matched_daraz_skus();
//    }
//    @Test(priority = 174)
//    public void offline_verify_verified_active_inactive_skus_with_number_of_verified_matches() throws InterruptedException {
//        SKUmp.verify_verified_active_inactive_skus_with_number_of_checked_matches();
//    }
//    @Test(priority = 175)
//    public void offline_verify_number_of_unverified_matches() throws InterruptedException {
//        SKUmp.verify_number_of_unchecked_matches();
//    }
//    @Test(priority = 176)
//    public void offline_verify_search_by_sku_name_and_id() throws InterruptedException {
//        SKUmp.verify_search_by_sku_name_and_id();
//    }
//    @Test(priority = 177)
//    public void offline_verify_search_by_sku_id() throws InterruptedException {
//        SKUmp.verify_search_by_sku_id();
//    }
//    @Test(priority = 178)
//    public void offline_verify_search_by_sku_name() throws InterruptedException {
//        SKUmp.verify_search_by_sku_name();
//    }
//    @Test(priority = 179)
//    public void offline_click_add_competitor_sku_verify_popup() throws InterruptedException {
//        SKUmp.click_add_competitor_sku_verify_popup();
//    }
//    @Test(priority = 180)
//    public void offline_click_cancel_popup() throws InterruptedException {
//        SKUmp.click_cancel_popup();
//    }
//
//    @Test(priority = 181)
//    public void offline_verify_online_selection() throws InterruptedException {
//        SKUmp.verify_online_selection();
//    }
//    @Test(priority = 182)
//    public void offline_add_online_competitor_sku_match_valid_url() throws InterruptedException {
//        SKUmp.add_online_competitor_sku_match_valid_url();
//    }
//    @Test(priority = 183)
//    public void offline_verify_online_match_added(){
//        SKUmp.verify_online_match_added();
//    }
//    @Test(priority = 184)
//    public void offline_add_online_competitor_sku_invalid_url(){
//        SKUmp.add_online_competitor_sku_invalid_url();
//    }
//    @Test(priority = 185)
//    public void offline_verify_add_sku_btn_disable_on_popup_display(){
//        SKUmp.verify_add_sku_btn_disable_on_popup_display();
//    }
//    @Test(priority = 186)
//    public void offline_verify_add_sku_btn_disable_on_competitor_select(){
//        SKUmp.verify_add_sku_btn_disable_on_competitor_select();
//    }
//    @Test(priority = 187)
//    public void offline_verify_add_sku_btn_disable_on_add_url(){
//        SKUmp.verify_add_sku_btn_disable_on_add_url();
//    }
//    @Test(priority = 188)
//    public void offline_verify_offline_selection(){
//        SKUmp.verify_offline_selection();
//    }
//    @Test(priority = 189)
//    public void offline_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name();
//    }
//    @Test(priority = 190)
//    public void offline_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name();
//    }
//    @Test(priority = 191)
//    public void offline_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_price();
//    }
//    @Test(priority = 192)
//    public void offline_add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_disabled_on_sku_name_and_competitor_name_and_l1_category();
//    }
//    @Test(priority = 193)
//    public void offline_add_offline_competitor_sku_match_valid_data_verify_button_enabled(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_verify_button_enabled();
//    }
//    @Test(priority = 194)
//    public void offline_add_offline_competitor_sku_match_valid_data_click_add_sku_button(){
//        SKUmp.add_offline_competitor_sku_match_valid_data_click_add_sku_button();
//    }
//    @Test(priority = 195)
//    public void offline_verify_offline_competitor_sku_match_added_verify_competitor_sku() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_sku();
//    }
//    @Test(priority = 196)
//    public void offline_verify_offline_competitor_sku_match_added_verify_competitor_name(){
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_name();
//    }
//    @Test(priority = 197)
//    public void offline_verify_offline_competitor_sku_match_added_verify_competitor_price() throws InterruptedException {
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_price();
//    }
//    @Test(priority = 198)
//    public void offline_verify_offline_competitor_sku_match_added_verify_competitor_category(){
//        SKUmp.verify_offline_competitor_sku_match_added_verify_competitor_category();
//    }
//    @Test(priority = 199)
//    public void offline_verify_database_tab_selection(){
//        SKUmp.verify_database_tab_selection();
//    }
//    @Test(priority = 200)
//    public void offline_verify_database_tab_add_btn_disabled(){
//        SKUmp.verify_database_tab_add_btn_disabled();
//    }
//    @Test(priority = 201)
//    public void offline_verify_search_btn_disabled(){
//        SKUmp.verify_search_btn_disabled();
//    }
//    @Test(priority = 202)
//    public void offline_verify_cancel_icon_database_tab() throws InterruptedException {
//        SKUmp.verify_cancel_icon_database_tab();
//    }
//    @Test(priority = 203)
//    public void offline_verify_cancel_button_database_tab() throws InterruptedException {
//        SKUmp.verify_cancel_button_database_tab();
//    }
//    @Test(priority = 204)
//    public void offline_verify_search_btn_enabled_on_filter_selection(){
//        SKUmp.verify_search_btn_enabled_on_filter_selection();
//    }
//    @Test(priority = 205)
//    public void offline_verify_filter_competitor_name(){
//        SKUmp.verify_filter_competitor_name();
//    }
//    @Test(priority = 206)
//    public void offline_verify_data_on_filter_by_chaldal_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_chaldal_database_tab();
//    }
//    @Test(priority = 207)
//    public void offline_verify_data_on_filter_by_pandamart_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
//    }
//    @Test(priority = 208)
//    public void offline_verify_data_on_filter_by_pickaboo_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pickaboo_database_tab();
//    }
//    @Test(priority = 209)
//    public void offline_verify_data_on_filter_by_shajgoj_database_tab() throws InterruptedException {
//        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
//    }
//    @Test(priority = 210)
//    public void offline_search_sku_name_against_competitor_database_tab(){
//        SKUmp.search_sku_name_against_competitor_database_tab();
//    }
//    @Test(priority = 211)
//    public void offline_add_match_database_tab(){
//        SKUmp.add_match_database_tab();
//    }
//    @Test(priority = 212)
//    public void offline_verify_database_match_added(){
//        SKUmp.verify_database_match_added();
//    }
//    @Test(priority = 213)
//    public void offline_label_number_of_unmatched_skus(){
//        SKUmp.label_number_of_unmatched_skus();
//    }  @Test(priority = 214)
//    public void offline_label_number_of_matched_skus(){
//        SKUmp.label_number_of_matched_skus();
//    }  @Test(priority = 215)
//    public void offline_label_number_of_pending_skus(){
//        SKUmp.label_number_of_pending_skus();
//    }  @Test(priority = 216)
//    public void offline_label_total_errors()  {
//        SKUmp.offline_label_total_errors();
//    }  @Test(priority = 217)
//    public void offline_label_user(){
//        SKUmp.label_user();
//    }  @Test(priority = 218)
//    public void offline_label_created_time() throws ParseException {
//        SKUmp.label_created_time();
//    }  @Test(priority = 219)
//    public void offline_download_file_task_details() throws IOException, InterruptedException {
//        SKUmp.download_file_task_details();
//    }
//    @Test(priority = 220)
//    public void offline_verify_view_matched_item_data(){
//        SKUmp.offline_verify_view_matched_item_data();
//    }
//    //    @Test(priority = 221)
////    public void offline_verify_view_matched_item_data_7th_row(){
////        SKUmp.verify_view_matched_item_data_7th_row();
////    }
//    @Test(priority = 222)
//    public void offline_mark_inaccurate() throws InterruptedException {
//        SKUmp.mark_inaccurate();
//    }
//    @Test(priority = 223)
//    public void offline_mark_verified() throws InterruptedException {
//        SKUmp.mark_verified();
//    }
//    @Test(priority = 224)
//    public void offline_verify_mark_inaccurate_dropdown() throws InterruptedException {
//        SKUmp.verify_mark_inaccurate_dropdown();
//    }
//
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
////}
////
////
////
////
////    @Test(priority = 19)
////    public void Click_Create_task() throws InterruptedException, ParseException, IOException {
////        SKUmp.Create_task();
////        SKUmp.click_task_details();
////
////    }
////
////    @Test(priority = 20)
////    public void get_task_data() throws ParseException, InterruptedException {
////        SKUmp.get_task_data();
////    }
////    @Test(priority = 18)
////    public void  verify_active_skus() throws IOException, InterruptedException {
////    SKUmp.offline_verify_all_active_skus_from_file();
////    SKUmp.offline_verify_all_inactive_skus_from_file();
////        SKUmp.offline_label_total_errors();
////        SKUmp.label_competitor();
////
////    }
//
//
////        SKUmp.click_add_competitor_sku_verify_popup();
////        SKUmp.verify_offline_selection();
////       SKUmp.verify_database_tab_selection();
////       SKUmp.verify_database_tab_add_btn_disabled();
////        SKUmp.verify_filter_competitor_name();
//
////        SKUmp.verify_data_on_filter_by_chaldal_database_tab();
////        SKUmp.verify_data_on_filter_by_pandamart_database_tab();
////        SKUmp.verify_data_on_filter_by_pickaboo_database_tab();
////        SKUmp.verify_data_on_filter_by_shajgoj_database_tab();
////        SKUmp.verify_search_btn_enabled_on_filter_selection();
////       SKUmp.verify_search_btn_disabled();
////        SKUmp.add_match_database_tab();
////        SKUmp.verify_database_match_added();
//
////        SKUmp.add_online_competitor_sku_invalid_url();
////        SKUmp.add_online_competitor_sku_valid_url();
////        SKUmp.verify_match_added();
//
//
//
//
//
////   @Test(priority = 4)
////   public void GOTO_VQ_Module(){vqp.GOTO_VQ_Module();}}
//
//
////    @Test(priority = 4)
////    public void Create_task() throws InterruptedException {
//////        SKUmp.Create_task_popup();
////          SKUmp.Create_task();
////          SKUmp.create_task_popup_cancel_btn();
////        SKUmp.upload_offline_match_valid_file_click_cancel_button();
////       SKUmp.upload_online_match_valid_file_click_cancel_button();
////        SKUmp.create_task_popup_cancel_btn();
////        SKUmp.create_task_popup_cancel_icon();
////        SKUmp.Create_task_replace_file();
////        SKUmp.check_multiple_competitor_selection();
////        SKUmp.check_single_competitor_selection();
////        SKUmp.double_click_chaldal_remove_selection();
////        SKUmp.get_task_data();
////        SKUmp.click_task_details();
////        SKUmp.add_online_competitor_sku();
////        SKUmp.click_add_cometitor_sku();
////        SKUmp.verify_online_selection();
////        SKUmp.label_number_of_matched_skus();
////        SKUmp.label_number_of_daraz_skus();
////        SKUmp.label_number_of_unmatched_skus();
////        SKUmp.label_number_of_pending_skus();
////        SKUmp.label_competitor();
////        SKUmp.label_user();
//
//
////    @Test(priority = 5)
////    public void download_create_task_templete() throws IOException, InterruptedException {
////        SKUmp.download_create_task_templete();
////    }
////    @Test(priority = 6)
////    public void Verify_Upload_online_match_cancel_button(){
////        SKUmp.upload_online_match_valid_file_click_cancel_button();
////    }
////    @Test(priority = 7)
////    public void verify_upload_online_match_without_file(){
////        SKUmp.upload_online_match_without_file();
////    }
////    @Test(priority = 8)
////    public void verify_upload_online_match_invalid_excel_file (){
////        SKUmp.upload_online_match_invalid_excel_file();
////    }
////    @Test(priority = 9)
////    public void upload_online_match_invalid_image_file(){
////        SKUmp.upload_online_match_invalid_image_file();
////    }
////    @Test(priority = 10)
////    public void Verify_Upload_online_match()  {
////        SKUmp.upload_online_match_valid_file_click_upload();
////    }
////   @Test(priority = 11)
////    public void upload_online_match_valid_file_click_cancel_icon() {
////        SKUmp.upload_online_match_valid_file_click_cancel_icon();
////    }
////
////    @Test(priority = 12)
////    public void download_templete_online_matches() throws IOException, InterruptedException {
////        SKUmp.download_templete_online_matches();
////    }
////    @Test(priority = 13)
////    public  void upload_offline_match_valid_file_click_upload(){
////        SKUmp.upload_offline_match_valid_file_click_upload();
////    }
////    @Test(priority = 14)
////    public void upload_offline_match_valid_file_click_cancel_button(){
////        SKUmp.upload_offline_match_valid_file_click_cancel_button();
////}
////
////@Test(priority = 15)
////public void upload_offline_match_valid_file_click_cancel_icon(){
////        SKUmp.upload_offline_match_valid_file_click_cancel_icon();
////}
////@Test(priority = 16)
////public void upload_offline_match_without_file(){
////        SKUmp.upload_offline_match_without_file();
////}
////
////@Test(priority = 16)
////public void upload_offline_match_invalid_excel_file(){
////        SKUmp.upload_offline_match_invalid_excel_file();
////}
////@Test(priority = 17)
////public void upload_offline_match_invalid_image_file(){
////        SKUmp.upload_offline_match_invalid_image_file();
////}
////@Test(priority = 18)
////public void download_templete_offline_matches() throws IOException, InterruptedException {
////    SKUmp.download_templete_offline_matches();
////}
////
////
//
//
////    @Test(priority = 13) Blocked due to error
////    public void get_table_data() throws InterruptedException {
////     SKUmp.get_table_data();
////    }
////    @Test(priority = 15)
////    public void GOTO_VQ_Module(){
////        vqp.GOTO_VQ_Module();
////
////    }
