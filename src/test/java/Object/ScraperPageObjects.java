package Object;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ScraperPageObjects {

    public ScraperPageObjects(WebDriver driver) {
        Wait.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/scrapy-ui/scraper']")
            public WebElement scraper_module_nav;
    @FindBy(css ="div.logo-img")
    public List<WebElement> Daraz_logo_left_pane;
    @FindBy(css = "div.sidebar-header button")
    public WebElement hamburger_icon;
    @FindBy(xpath = "//h2[@class='pageTitle']")
        public WebElement pagetitle;
    @FindBy(xpath ="//*[@id='slectVenture' and @name='lang' and @class='my-0 w-80 form-control']")
            public WebElement venture_dropdown;
    @FindBy(xpath ="//*[contains(text(),'BD')]")
            public WebElement select_BD_venture;
    @FindBy(xpath ="//*[contains(text(),'PK')]")
    public WebElement select_PK_venture;
    @FindBy(xpath ="//*[contains(text(),'LK')]")
    public WebElement select_LK_venture;
    @FindBy(css = "div.col-md-12.d-sm-flex.align-items-center.p-0.pageHead div.ml-sm-auto .btnBlue.btn-danger")
            public WebElement button_Initiate_Job;
    @FindBy(xpath = "//*[@for='204']")
            public WebElement select_Shajgoj;
    @FindBy(xpath = "//*[@for='10']")
            public WebElement select_Pickaboo_bd;
    @FindBy(xpath = "//*[@for='7']")
            public WebElement select_PandaMart;
    @FindBy(xpath = "//*[@for='6']")
            public WebElement select_Chaldal_bd;
    @FindBy(xpath = "//*[@for='233']")
    public WebElement select_Startech_bd;
    @FindBy(xpath = "//*[@for='317']")
    public WebElement select_Aliexpress_bd;
    @FindBy(xpath = "//*[@for='324']")
    public WebElement select_Diamu_bd;
    @FindBy(xpath = "//*[@for='325']")
    public WebElement select_Othoba_bd;
    @FindBy(xpath = "//*[@for='326']")
    public WebElement select_Fixit_bd;
    @FindBy(xpath = "//*[@for='327']")
    public WebElement select_Ryans_bd;

    //PK Scraper
    @FindBy(xpath = "//*[@for='1']")
    public WebElement select_Grocersapp;
    @FindBy(xpath = "//*[@for='2']")
    public WebElement select_shophive;
    @FindBy(xpath = "//*[@for='3']")
    public WebElement select_ishopping;
    @FindBy(xpath = "//*[@for='4']")
    public WebElement select_foodpanda;
    @FindBy(xpath = "//*[@for='5']")
    public WebElement select_telemart;
    @FindBy(xpath = "//*[@for='203']")
    public WebElement select_carrefour;
    @FindBy(xpath = "//*[@for='222']")
    public WebElement select_alfatah;
    @FindBy(xpath = "//*[@for='316']")
    public WebElement select_aliexpress;
    @FindBy(xpath = "//*[@for='322']")
    public WebElement select_metro;
    @FindBy(xpath = "//*[@for='323']")
    public WebElement select_naheed;

    //LK Scraper
    @FindBy(xpath = "//*[@for='11']")
    public WebElement select_Keellssuper_lk;
    @FindBy(xpath = "//*[@for='12']")
    public WebElement select_Glomark_lk;
    @FindBy(xpath = "//*[@for='13']")
    public WebElement select_Wasi_lk;
    @FindBy(xpath = "//*[@for='14']")
    public WebElement select_Ideabeam_lk;
    @FindBy(xpath = "//*[@for='15']")
    public WebElement select_Greasemonkey_lk;
    @FindBy(xpath = "//*[@for='282']")
    public WebElement select_MySoftlogic;
    @FindBy(xpath = "//*[@for='318']")
    public WebElement select_AliExpress;
    @FindBy(xpath = "//*[@for='329']")
    public WebElement select_MyarpicoLK;
    @FindBy(xpath = "//*[@for='329']")
    public WebElement select_BuyAbans;
    @FindBy(xpath = "//*[@for='330']")
    public WebElement select_CarGill;

    @FindBy(css = ".btn-lg.btn-block.btn-primary")
            public WebElement button_Done;
    @FindBy(xpath = "//*[@id='scrapyDetailtable']/tbody/tr")
            public List<WebElement> rowelement;
    @FindBy(xpath ="//*[@id='scrapyDetailtable']/tbody/tr[1]/td")
            public List<WebElement> colelement;
    @FindBy(xpath = "//button[@class ='btn btn-lg btn-block transformbuttonbg btn btn-secondary']")
            public WebElement cancel_button;
    @FindBy(className = "pagination-item")
            public WebElement wait;
    @FindBy(xpath ="//ul[@class = 'pagination-container pagination-bar']/li")
            public List<WebElement> pagination;
    @FindBy(css = "div.alert.alert-success.fade.show")
        public WebElement Success_msg;
    @FindBy(xpath = "//table[@id='scrapyDetailtable']//tbody//tr[last()]//td[1]")
            public WebElement last_id;
    @FindBy(xpath = "//td[contains(text(),'_bd')]")
        public WebElement check_bd;
    @FindBy(xpath ="//select[@class ='custom-select custom-select-sm form-control form-control-sm']/option[contains(text(),'20')]")
        public WebElement records_20;
    @FindBy(xpath ="//select[@class ='custom-select custom-select-sm form-control form-control-sm']/option[contains(text(),'10')]")
    public WebElement records_10;
}
