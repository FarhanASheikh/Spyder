package Object;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DarazPricingDatabasePageObjects {

    public DarazPricingDatabasePageObjects(WebDriver driver){
        Wait.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/scrapy-ui/pricing-database?page=1&pageSize=10']")
    public WebElement daraz_pricing_database_module_left_menu;
    @FindBy(css= "form.form-inline div.form-row.flex-column.p-3:nth-child(2) input")
    public WebElement dpd_product_name_search_input;
    @FindBy(css= "form.form-inline div.form-row.flex-column.p-3:nth-child(1) input")
    public WebElement dpd_product_id_search_input;
    @FindBy(xpath = "//div[@class='card mt-20 p-3 task-info']//div[@class='form-row flex-column p-3'][2]/select")
    public WebElement dpd_filter_by_competitor_text;
    @FindBy(xpath = "//div[@class='card mt-20 p-3 task-info']//div[@class='form-row flex-column p-3'][2]/select/option[@value='HIGHER']")
    public WebElement dpd_filter_by_higher_than_competitor;
    @FindBy(xpath = "//div[@class='card mt-20 p-3 task-info']//div[@class='form-row flex-column p-3'][2]/select/option[@value='LOWER']")
    public WebElement dpd_filter_by_lower_than_competitor;
    @FindBy(css="tbody td:nth-child(2)")
    public List<WebElement> dpd_table_daraz_price;
    @FindBy(css="tbody td:nth-child(4)")
    public List<WebElement> dpd_table_competitor_price;
    @FindBy(css ="form.form-inline button")
    public WebElement dpd_search_button;
    @FindBy(css ="table.table tbody tr")
    public List<WebElement> table_row;
    @FindBy(css = ".table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(8) button:nth-child(1)")
    public WebElement dpd_view_matched_item_btn;
    @FindBy(css = ".table.table-borderless.reportList tbody tr:nth-child(7) td:nth-child(8) button:nth-child(1)")
    public WebElement dpd_view_matched_item_btn_7th_row;
    @FindBy(css= ".table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(8) button:nth-child(2)")
    public WebElement dpd_add_competitor_sku_btn;
    @FindBy(css ="tr:nth-child(1) td:nth-child(3) ")
    public WebElement table_competitor_name;
    @FindBy(css="tbody tr:nth-child(2) td:nth-child(1) p.table-product-id")
    public WebElement table_product_id;
    @FindBy(css= ".table.table-borderless.reportList tbody tr:nth-child(1) td:nth-child(6)")
    public List<WebElement> table_column_no_of_matched_skus;
    @FindBy(css= ".table.table-borderless.reportList tbody tr:nth-child(7) td:nth-child(6)")
    public List<WebElement> table_column_no_of_matched_skus_7th_row;



}
