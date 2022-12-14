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
        public WebElement Select_VQ_leftpanel;
    @FindBy(xpath ="//*[@class ='searchBox ' and @placeholder='Select Competitor']")
        public  WebElement Select_Competitor_filter;
    @FindBy(xpath = "//*[contains(text(),'Chaldal_bd')]")
        public  WebElement Select_Chaldal_bd;
    @FindBy(xpath = "//*[@class ='form-control custom-select' and @name='sort_by']")
        public WebElement Select_SortBy_filter;
    @FindBy(xpath = "//*[@value='Exposure']")
        public WebElement Select_SortBy_Exposure;
}
