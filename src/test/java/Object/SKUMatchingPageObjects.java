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

    @FindBy(xpath = "//span[contains(text(),'Sku Matching')]")
    public WebElement SKU_Matching;
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
    @FindBy(css = " .create-btn.blue-shadow.btn-primary")
        public WebElement done_btn;
    @FindBy(xpath = "//*[@for='6' and contains(text(),'Chaldal_bd')]")
        public WebElement select_competitor_chaldal;
    @FindBy(css ="ul.ks-cboxtags input[type=checkbox]:checked")
        public  WebElement verify_after_check;
    @FindBy(xpath = "//*[@for='7' and contains(text(),'PandaMart')]")
    public WebElement select_competitor_pandamart;
    @FindBy(xpath = "//*[@for='10' and contains(text(),'Pickaboo_bd')]")
    public WebElement select_competitor_pickaboo;
    @FindBy(xpath = "//*[@for='204' and contains(text(),'Shajgoj')]")
    public WebElement select_competitor_shajgoj;

    @FindBy(xpath = "//button[@class = 'dropdown-btn btnBlue inner btn btn-secondary btn btn-secondary']")
        public  WebElement upload_matches_btn;
    @FindBy(xpath ="//button[@class='dropdown-item' and contains(text(),'Online match')]")
        public  WebElement upload_online_match_dropdown_selection;
    @FindBy(css = "#inputFile.form-control-file.text-danger.font-weight-bold.d-none.form-control-file")
       public WebElement add_file;
    @FindBy(xpath = "//button[@class ='btn create-btn blue-shadow btn btn-secondary' and contains(text(),'Upload matches')]")
        public  WebElement upload_matches_button;
    @FindBy(xpath="//button[@class ='btn btn-outline-primary btn-block transformbuttonbg btn btn-secondary' and contains(text(),'Cancel')]")
        public WebElement upload_online_matches_cancel_button;
    @FindBy(xpath = "//span[@aria-hidden='true']")
        public WebElement cancel_icon;
    @FindBy(xpath = "//img[@class ='tick'and @id ='imgCheck']")
        public WebElement file_validation;
    @FindBy(css = "div.alert.alert-success.fade.show")
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
    public WebElement task_details;
    @FindBy(css = "div.task-info:nth-child(1) div.row:nth-child(2) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_matched_skus;
    @FindBy(css = "div.task-info:nth-child(1) div.row:nth-child(3) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_unmatched_skus;
    @FindBy(css = "div.task-info:nth-child(1) div.row:nth-child(4) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_pending_skus;
    @FindBy(css = "div.task-info:nth-child(1)  div.container-fluid div.col-6.wrap-text strong")
    public WebElement label_competitor;
    @FindBy(css = "div.task-info:nth-child(1)  div.row:nth-child(2) div.col-6 strong")
    public  WebElement label_user;
    @FindBy(css = "div.task-info:nth-child(1)  div.row:nth-child(3) div.col-6 strong")
    public WebElement label_created_time;
    @FindBy(css ="div.card.mt-20.p-3.task-info div.container-fluid div.row:nth-child(1) div.col-3:nth-child(1) strong")
    public WebElement label_number_of_daraz_skus;
    @FindBy(css = "div.scrappy-table.card.p-3.task-info tbody tr:nth-child(1) td:nth-child(4)")
    public WebElement match_competitor_name;
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
    @FindBy(css = "div.modal-content ul.nav.nav-tabs.nav-pills li.nav-item:nth-child(2) a")
    public WebElement matches_popup_offline_tab;
    @FindBy(css = "div.modal-content div.tab-pane.active div.table-responsive.competitor-products tbody td a.link.product-name")
    public WebElement offline_tab_competitor_sku;
    @FindBy(css = "div.modal-content div.tab-pane.active div.table-responsive.competitor-products tbody td p span.promo_price")
    public WebElement offline_tab_competitor_price;
    @FindBy(css = "div.modal-content div.tab-pane.active div.table-responsive.competitor-products tbody td:nth-child(5)")
    public WebElement offline_tab_competitor_categrory;
    @FindBy(css = "div.modal-content div.tab-pane.active div.table-responsive.competitor-products tbody td:nth-child(7)")
    public WebElement offline_tab_competitor_name;
    @FindBy(css = "div.scrappy-table  tbody tr:nth-child(1) td:nth-child(1) input")
    public WebElement database_tab_select_sku;
    @FindBy(css= "div.tab-pane.active input.form-control")
    public WebElement database_tab_search_field;
    @FindBy(css = "div.tab-pane.active div.form-group button")
    public WebElement database_tab_search_button;
    @FindBy(css="div.tab-content div.table-responsive.competitor-products:nth-child(1) tbody tr:nth-child(1) td:nth-child(1) a:nth-child(1)")
    public WebElement database_sku_from_matched_items;
}

