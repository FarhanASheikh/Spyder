package Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class ScraperPageObjects {

    @FindBy(xpath ="//*[@id='slectVenture' and @name='lang' and @class='my-0 w-80 form-control']")
            public WebElement venture_dropdown;
    @FindBy(xpath ="//*[contains(text(),'BD')]")
            public WebElement select_venture;
    @FindBy(css = ".btnBlue.btn-danger")
            public WebElement button_Initiate_Job;
    @FindBy(xpath = "//*[@for='17']")
            public WebElement select_Shajgoj;
    @FindBy(xpath = "//*[@for='10']")
            public WebElement select_Pickaboo_bd;
    @FindBy(xpath = "//*[@for='7']")
            public WebElement select_PandaMart;
    @FindBy(xpath = "//*[@for='6']")
            public WebElement select_Chaldal_bd;
    @FindBy(css = ".btn-lg.btn-block.btn-primary")
            public WebElement button_Done;
    @FindBy(xpath = "//*[@id='scrapyDetailtable']/tbody/tr")
            public List<WebElement> rowelement;
    @FindBy(xpath ="//*[@id='scrapyDetailtable']/tbody/tr[1]/td")
            public List<WebElement> colelement;


    @FindBy(css = "div.alert.alert-success.fade.show")
        public WebElement Success_msg;
}
