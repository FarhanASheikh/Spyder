package Object;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SKUMatchingPageObjects {

    public SKUMatchingPageObjects(WebDriver driver) {
        Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/scrapy-ui/skumatching?page=1&pageSize=10']")
    public WebElement SKU_Matching;
    @FindBy(css ="div.logo-img")
    public List<WebElement> Daraz_logo_left_pane;
    @FindBy(css = "div.sidebar-header button")
    public WebElement hamburger_icon;

    @FindBy(xpath = "//*[@type='button' and @class='btn btnBlue inner btn btn-danger']")
    public WebElement create_task_btn;
    @FindBy(css ="button.btn.transformbuttonbg.cancel-btn.btn-secondary")
    public WebElement create_task_cancel_btn;
    @FindBy(css ="button.close span")
    public WebElement create_task_cancel_icon;
    @FindBy(css ="div.modal-content")
    public List <WebElement> Create_task_popup;
    @FindBy(xpath = "//*[@name='taskname' and @placeholder='Task Name']")
            public WebElement task_name_field;
    @FindBy(id ="inputFile")
        public WebElement Create_task_file_upload;
    @FindBy(css="div.modal-content p.filename")
    public WebElement uploaded_file_name;
    @FindBy(css = " .create-btn.blue-shadow.btn-primary")
        public WebElement done_btn;
    @FindBy(xpath = "//label[@for='6' and contains(text(),'Chaldal_bd')]")
        public WebElement select_competitor_chaldal;
    @FindBy(xpath = "//label[@for='7' and contains(text(),'PandaMart')]")
    public WebElement select_competitor_pandamart;
    @FindBy(xpath = "//label[@for='10' and contains(text(),'Pickaboo_bd')]")
    public WebElement select_competitor_pickaboo;
    @FindBy(xpath = "//label[@for='204' and contains(text(),'Shajgoj')]")
    public WebElement select_competitor_shajgoj;
    @FindBy(xpath = "//label[@for='233' and contains(text(),'Startech_BD')]")
    public WebElement select_competitor_startech_BD;
    @FindBy(xpath = "//button[@class = 'dropdown-btn btnBlue inner btn btn-secondary btn btn-secondary']")
        public  WebElement upload_matches_btn;
    @FindBy(xpath ="//button[@class='dropdown-item' and contains(text(),'Online match')]")
        public  WebElement upload_online_match_dropdown_selection;
    @FindBy(css = "#inputFile.form-control-file.text-danger.font-weight-bold.d-none.form-control-file")
       public WebElement add_file;
    @FindBy(xpath = "//div[@class='modal-content']/div[@class='modal-footer']/div/button[contains(text(),'Upload matches')]")
        public  WebElement upload_matches_button;
    @FindBy(xpath="//button[@class ='btn btn-outline-primary btn-block transformbuttonbg btn btn-secondary' and contains(text(),'Cancel')]")
        public WebElement upload_online_matches_cancel_button;
    @FindBy(xpath = "//span[@aria-hidden='true']")
        public WebElement cancel_icon;
    @FindBy(xpath = "//img[@class ='tick'and @id ='imgCheck']")
        public WebElement file_validation;
    @FindBy(css = "div.alert.fade.show")
    public WebElement success_msg;
    @FindBy(className = "modal-content")
    public WebElement popup;
    @FindBy(xpath = "//table[@id='taskListTable']//tbody//tr[last()]//td[1]")
    public WebElement last_id;
    @FindBy(xpath ="//ul[@class = 'pagination-container pagination-bar']/li")
    public List<WebElement> pagination;
    @FindBy(xpath ="//button[@class='transformbuttonbgbrder btn btn-secondary']")
        public WebElement download_match_templete;
    @FindBy(xpath ="//button[@class='dropdown-item' and contains(text(),'Offline match')]")
    public  WebElement offline_match_dropdown_selection;
    @FindBy(xpath ="//*[@id='taskListTable']/tbody/tr[1]/td[3]")
    public WebElement table_matched_daraz_sku;
    @FindBy(xpath ="//*[@id='taskListTable']/tbody/tr[1]/td[4]")
    public WebElement table_competitors;
    @FindBy(xpath = "//*[@id='taskListTable']/tbody/tr[1]/td[5]")
    public WebElement table_user;
    @FindBy(xpath = "//*[@id='taskListTable']/tbody/tr[1]/td[6]")
    public WebElement table_created_time;
    @FindBy(xpath ="//*[@id='taskListTable']/tbody/tr[1]/td[7]/button[@class='row-btn']")
    public WebElement task_details_btn;
    //label
    @FindBy(css = "div.task-info:nth-child(1) div.row:nth-child(2) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_matched_skus;
    @FindBy(css = "div.task-info:nth-child(1) div.row:nth-child(3) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_unmatched_skus;
    @FindBy(css = "div.task-info:nth-child(1) div.row:nth-child(4) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_pending_skus;
    @FindBy(css = "div.task-info:nth-child(1)  div.container-fluid div.col-sm-4:nth-child(9) strong span")
    public List <WebElement> label_competitor;
    @FindBy(css = "div.task-info:nth-child(1)  div.container-fluid div.row:nth-child(1) div:nth-child(8) strong")
    public  WebElement label_user;
    @FindBy(css = "div.task-info:nth-child(1)  div.container-fluid div.row:nth-child(1) div:nth-child(9) strong")
    public WebElement label_created_time;
    @FindBy(css ="div.card.mt-20.p-3.task-info div.container-fluid div.row:nth-child(1) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_daraz_skus;
    @FindBy(css= "strong.h6 span.errors")
    public WebElement label_uploaded_file_name;
    @FindBy(xpath = "//div[@class= 'container-fluid p-2']/div[1]/div[2]/strong")
    public WebElement label_number_of_verified_matches;
    @FindBy(xpath = "//div[@class= 'container-fluid p-2']/div[2]/div[2]/strong")
    public WebElement label_number_of_unverified_matches;
    @FindBy(xpath = "//div[@class= 'container-fluid p-2']/div[4]/div[2]/strong")
    public WebElement label_total_error_value;
    @FindBy(xpath = "//div[@class= 'container-fluid p-2']/div[3]/div[2]/strong")
    public WebElement label_invalid_daraz_sku_value;
    @FindBy(xpath = "//div[@class= 'container-fluid p-2']/div[4]/div[1]/strong")
    public  WebElement label_pending_skus_value;




    @FindBy(css = "div.scrappy-table.card.p-3.task-info tbody tr:nth-child(1) td:nth-child(4)")
    public WebElement table_match_competitor_name;
    @FindBy(css =".table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(9) button:nth-child(2)")
    public  WebElement add_competitor_sku_btn;
    @FindBy(xpath ="//ul[@class = 'nav nav-tabs nav-pills']/li/a[contains(text(),'Online')]")
    public WebElement add_competitor_sku_online_tab;
    @FindBy(xpath="//ul[@class = 'nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")
    public WebElement add_competitor_sku_offline_tab;
    @FindBy(xpath = "//ul[@class = 'nav nav-tabs nav-pills']/li/a[contains(text(),'Database')]")
    public WebElement add_competitor_sku_database_tab;
    @FindBy(css ="div.form-group select.form-control.custom-select-sm option:nth-child(2)")
    public WebElement select_competitor_dropdown;
    @FindBy(xpath="//select[@name ='competitor_id']/option [contains(text(),'Pickaboo_bd')]")
    public WebElement select_pickaboo;
    @FindBy(css = "div.tab-pane.active div.form-group input.form-control.form-control")
    public WebElement product_url_input;
    @FindBy(css = "button.btn.create-btn.blue-shadow.float-right.btn.btn-secondary")
    public WebElement add_online_sku_btn;
    @FindBy(css = "button.btn.create-btn.blue-shadow.float-right.btn.btn-secondary.disabled")
    public WebElement add_online_sku_btn_disabled;
    @FindBy(css = "div.tab-pane.active div.scrappy-table button.btn.create-btn.blue-shadow.float-right.btn.btn-secondary")
    public WebElement add_sku_database_btn;
    @FindBy(css = "div.tab-pane.active div.scrappy-table button.btn.create-btn.blue-shadow.float-right.btn.btn-secondary.disabled")
    public WebElement add_sku_database_btn_disabled;
    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement toast_msg;
    @FindBy(css = "div.col-4 input#skuName")
    public WebElement offline_match_sku_name_input;
    @FindBy(css = "div.col-4 input#cometitor")
    public WebElement offline_match_competitor_name_input;
    @FindBy(css = "div.col-4 input#skuPrice")
    public WebElement offline_match_sku_price_input;
    @FindBy(css = "div.col-4 select.form-control.custom-select-sm")
    public WebElement offline_match_l1_category_dropdown;
    @FindBy(xpath = "//select[@class='form-control custom-select-sm']/option[contains(text(),'Cameras')]")
    public WebElement offline_match_l1_category_dropdown_select_cameras;
    @FindBy(css ="div.container.p-4 button")
    public WebElement offline_match_add_sku_btn;
    @FindBy(css = ".table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(9) button:nth-child(1)")
    public WebElement view_matched_item_btn;
    @FindBy(css="table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(4) p:nth-child(1)")
    public WebElement table_competior_name;
    @FindBy(xpath = "//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Offline')]")
    public WebElement matches_popup_offline_tab;
    @FindBy(xpath = "//ul[@class='nav nav-tabs nav-pills']/li/a[contains(text(),'Pickaboo_bd')]")
    public WebElement matches_popup_pikaboo_tab;
    @FindBy(css = "ul.nav.nav-tabs.nav-pills li")
    public List <WebElement> view_matched_item_competitor_select;
    @FindBy(css= ".table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(7)  p")
    public List<WebElement> table_column_no_of_matched_skus;
    @FindBy(css= ".table.table-borderless.reportList tbody tr:nth-child(7) td:nth-child(7)  p")
    public List<WebElement> table_column_no_of_matched_skus_7th;
    @FindBy(css = ".table.table-borderless.reportList tbody tr:nth-child(7) td:nth-child(9) button:nth-child(1)")
    public WebElement view_matched_item_btn_7th;
    @FindBy(css="div.modal-content div.tab-pane.active div.table-responsive.competitor-products tbody tr")
    public List<WebElement> view_matched_item_rows;
    @FindBy(css = "div.modal-content div.tab-pane.active div.table-responsive.competitor-products tbody td a.link.product-name")
    public List<WebElement> online_matched_sku_first_row_competitor_sku;
    @FindBy(xpath = "//div[@class='modal-content']/div/div/div[@class='tab-content']/div[@class='tab-pane active']/div/table/tbody/tr/td/a[contains(text(),'TD-122211')]")
    public WebElement offline_matched_sku_first_row_competitor_sku;
    @FindBy(xpath = "//div[@class='modal-content']/div/div/div[@class='tab-content']/div[@class='tab-pane active']/div/table/tbody/tr/td/p/span[contains(text(),'20')]")
    public WebElement matched_sku_first_row_competitor_price;
    @FindBy(xpath = "//div[@class='modal-content']/div/div/div[@class='tab-content']/div[@class='tab-pane active']/div/table/tbody/tr/td/p[contains(text(),'Cameras')]")
    public WebElement matched_sku_first_row_competitor_categrory;
    @FindBy(xpath = "//div[@class='modal-content']/div/div/div[@class='tab-content']/div[@class='tab-pane active']/div/table/tbody/tr/td/p[contains(text(),'test competitor')]")
    public WebElement matched_skucompetitor_name;
    @FindBy(css = "div.scrappy-table  tbody tr:nth-child(1) td:nth-child(1) input")
    public WebElement database_tab_select_sku;
    @FindBy(css= "div.tab-pane.active input.form-control")
    public WebElement database_tab_search_field;
    @FindBy(css="div.form-row.flex-column.p-3.form-group select.form-control.custom-select")
    public WebElement database_tab_competitor_dropdown_filters;
    @FindBy(xpath = "//div[@class ='form-row flex-column p-3 form-group']/select/option[contains(text(),'Chaldal_bd')]")
    public WebElement database_tab_competitor_dropdown_filters_select_chaldal;
    @FindBy(xpath = "//div[@class ='form-row flex-column p-3 form-group']/select/option[contains(text(),'PandaMart')]")
    public WebElement database_tab_competitor_dropdown_filters_select_pandamart;
    @FindBy(xpath = "//div[@class ='form-row flex-column p-3 form-group']/select/option[contains(text(),'Pickaboo_bd')]")
    public WebElement database_tab_competitor_dropdown_filters_select_pickaboo;
    @FindBy(xpath = "//div[@class ='form-row flex-column p-3 form-group']/select/option[contains(text(),'Shajgoj')]")
    public WebElement database_tab_competitor_dropdown_filters_select_shajgoj;
    @FindBy(css = "div.tab-pane.active div.form-group button")
    public WebElement database_tab_search_button;
    @FindBy(css= "div.modal-content div.paginationtabledata button:nth-child(2)")
    public WebElement database_tab_pagination_next_btn;
    @FindBy(css="div.tab-content div.tab-pane.active div.table-responsive.competitor-products:nth-child(1) tbody tr td:nth-child(1) a")
    public List<WebElement> database_tab_sku_from_matched_items;
    @FindBy(css="div.modal-body table.table.table-borderless.reportList tbody tr:nth-child(3) td:nth-child(3)")
    public WebElement database_tab_table_3rd_row_comp_bank_id;
    @FindBy(css="div.modal-body table.table.table-borderless.reportList tbody tr:nth-child(6) td:nth-child(3)")
    public WebElement database_tab_table_6rd_row_comp_bank_id;
    @FindBy(css="div.modal-body table.table.table-borderless.reportList tbody tr:nth-child(8) td:nth-child(3)")
    public WebElement database_tab_table_8rd_row_comp_bank_id;
    @FindBy(xpath = "//*[@class='scrappy-table']/table[@id= 'taskListTable']/tbody/tr")
    public List<WebElement> database_tab_search_row;
    @FindBy(css = "div.modal-content button.btn.btn-outline-primary.transformbuttonbg.float-right.btn.btn-secondary")
    public WebElement database_tab_cancel_button;
    @FindBy(css = "ul.nav.nav-tabs.nav-pills a.active.nav-link")
    public  WebElement view_matched_item_active_tab;
    @FindBy(css="//ul[@class = 'nav nav-tabs nav-pills']/li/a[contains(text(),'Chaldal_bd')]")
    public WebElement view_matched_item_chaldal_tab;
    @FindBy(css = "div.tab-pane.active tbody tr:nth-child(1) td:nth-child(9) p.reason")
    public WebElement view_matched_item_first_row_of_table;
    //Mark accurate/inaccurate
    @FindBy(css ="div.tab-pane.active tbody tr:nth-child(1) td:nth-child(1)")
    public WebElement view_matched_item_first_row_product_name;
    @FindBy(css= "div.tab-pane.active tbody tr:nth-child(1) td:nth-child(10) button")
    public WebElement mark_verified_or_inaccurate_btn;
    @FindBy(xpath= "//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[1]/button[4]")
    public WebElement mark_inaccurate_dropdown_reasons_quantity_selection;
    @FindBy(xpath= "//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']/button[contains(text(),'Others')]")
    public WebElement mark_inaccurate_dropdown_reasons_others_selection;
    @FindBy(css = "div.modal-dialog.custom-reason.modal-md.modal-dialog-centered div.modal-content")
    public List <WebElement> mark_inaccurate_others_popup;
    @FindBy(css ="div.modal-dialog.custom-reason.modal-md.modal-dialog-centered div.modal-content textarea")
    public WebElement mark_inaccurate_other_input;
    @FindBy(css = "div.modal-dialog.custom-reason.modal-md.modal-dialog-centered div.modal-content button.btn.create-btn.blue-shadow.float-right")
    public WebElement mark_inaccurate_other_popup_submit_button;
    @FindBy(css="div.modal-dialog.custom-reason.modal-md.modal-dialog-centered div.modal-content button.btn.btn-outline-primary.float-right")
    public WebElement mark_inaccurate_other_popup_cancel_button;
    @FindBy(css ="div.modal-dialog.custom-reason.modal-md.modal-dialog-centered div.modal-content span")
    public WebElement mark_inaccurate_other_popup_cancel_icon;
    @FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[1]/td[10]/div//div[@class='dropdown-menu dropdown-menu-right dropdown-menu show']")
    public WebElement mark_inaccurate_dropdown_reasons;
    @FindBy(css= "table.table.table-striped.table-hover tbody tr:nth-child(1) td:nth-child(9) p.reason")
    public WebElement status_column;
    @FindBy(css="table.table.table-striped.table-hover tbody tr:nth-child(1) td:nth-child(9) div.tooltip p")
    public WebElement status_column_reason;
    //Task Details
    @FindBy(xpath ="//select[@class ='custom-select custom-select-sm form-control form-control-sm']")
    public WebElement table_show_records_dropdown;
    @FindBy(css="div.scrappy-table table.table.table-borderless.reportList tbody tr td  p.table-product-id")
    public List <WebElement> task_details_table_sku_id;
    @FindBy(css = "div.scrappy-table table.table.table-borderless.reportList tbody tr td  a.table-product-name")
    public List<WebElement> task_details_table_sku_name;
    @FindBy(css = "tbody td:nth-child(7) p")
    public List <WebElement> task_details_table_no_of_matched_skus;
    @FindBy(css = "tbody td:nth-child(8) p")
    public List <WebElement> task_details_table_no_of_unverified_skus;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][2]/select")
    public WebElement filter_sku_current;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][2]/select/option")
    public List <WebElement> filter_sku_current_all_options;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][5]/select/option")
    public List<WebElement> filter_matching_status_all_options;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][5]/select")
    public WebElement filter_matching_status;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][2]/select/option[contains(text(),'In Active')]")
    public WebElement filter_sku_current_inactive;
    @FindBy(css ="div.card.mt-20.p-3.task-info button.btn.form-control.btn-primary.blue-shadow")
    public WebElement filter_filter_btn;
    @FindBy(css = "div.card.mt-20.p-3.task-info form.form-inline div.form-row.flex-column.p-3:nth-child(5) input.form-control")
    public WebElement filter_sku_name_search_field;
    @FindBy(css = "div.card.mt-20.p-3.task-info form.form-inline div.form-row.flex-column.p-3:nth-child(4) input.form-control")
    public WebElement filter_sku_id_search_field;
    @FindBy(css = "div.notfound")
    public WebElement task_details_no_data_found;
    @FindBy(css="div.tab-pane.active div.notfound")
    public WebElement view_match_item_no_data_found;
    @FindBy(css="div.modal-content div.sku.d-flex")
    public List<WebElement> pendig_skus;
    @FindBy(css="div.modal-content button.nextPrevious.btn-secondary:nth-child(2)")
    public WebElement next_button;
}

