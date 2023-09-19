package Object;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationQueuePageObjects {
    public VerificationQueuePageObjects(WebDriver driver) {
        Wait.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//span[contains(text(),'Verification Queue')]")
        public WebElement select_VQ_leftpanel;
    @FindBy(css ="div.form-row.flex-column.p-3:nth-child(2)")
        public WebElement select_Competitor_filter;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][1]/div/div[@class='multiselect-container multiSelectContainer  form-control custom-select']/div/ul/li[contains(text(),'All')]")
    public  WebElement select_all_competitor_checkbox;
    @FindBy(xpath = "//*[@class ='form-control custom-select' and @name='sort_by']")
        public WebElement select_SortBy_filter;
    @FindBy(xpath = "//*[@value='Exposure']")
        public WebElement select_SortBy_Exposure;
    @FindBy(css ="div.form-row.flex-column.p-3:nth-child(3)")
    public WebElement select_l1_category_filter;
    @FindBy(xpath = "//div[@class='form-row flex-column p-3'][2]/div/div[@class='multiselect-container multiSelectContainer  form-control custom-select']/div/ul/li[contains(text(),'All')]")
    public WebElement select_all_l1_category_checkbox;
    @FindBy(css ="div.form-row.flex-column.p-3:nth-child(4)")
    public WebElement select_business_type_filter;
    @FindBy(xpath = "//*[@value='Marketplace']")
    public WebElement select_marketplace_business_type_filter;
    @FindBy(css ="div.form-row.flex-column.p-3:nth-child(5)")
    public WebElement select_match_age_filter;
    @FindBy(xpath = "// option[@value='1']")
    public WebElement select_more_than_7_match_age_filter;
    @FindBy(css ="div.form-row.flex-column.p-3:nth-child(6)")
    public WebElement select_industry_filter;
    @FindBy(css ="div.form-row.flex-column.p-3:nth-child(7)")
    public WebElement select_stock_filter;
    @FindBy(css="div.row div.form-group button")
    public WebElement filter_button;

}
