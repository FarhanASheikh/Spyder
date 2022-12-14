package Object;
import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageObjects {

    public LoginPageObjects(WebDriver driver) {
        Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="email")
    public WebElement email;
    @FindBy(css= "i.fa.fa-eye")
    public WebElement unhide_password;
    @FindBy(id ="password")
    public WebElement password;
    @FindBy(className = "control__indicator")
    public WebElement rememberme_checkbox;
    @FindBy(css = "div.form-row.mt-2.mb-4")
    public WebElement login_button;
    @FindBy(css = ".logo")
    public WebElement logo;
    @FindBy(css = ".col-12.mt-4.footerText")
    public WebElement footer_text;
    @FindBy(xpath = "//h2[contains(text(),'Log in')]")
    public WebElement Log_in_text;
    @FindBy(xpath = "//*[contains(text(),'Email OR username is a required field; you cannot leave it as blank.')]")
    public WebElement username_validation;
    @FindBy(xpath = "//*[contains(text(),'Password  is a required field; you cannot leave it as blank.')]")
    public  WebElement password_validation;
    @FindBy(xpath = "//*[@class = 'alert alert-danger fade show' and @role='alert']")
    public WebElement validation;



    public WebElement getemail(){
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(email));
        }

        public WebElement getunhide_password() {
            return Wait.waitforelement().until(ExpectedConditions.visibilityOf(unhide_password));
        }
            public WebElement getpassword() {
                return Wait.waitforelement().until(ExpectedConditions.visibilityOf(password));
        }
        public WebElement getrememberme_checkbox() {
                    return Wait.waitforelement().until(ExpectedConditions.visibilityOf(rememberme_checkbox));
                }
    public WebElement getlogin_button() {
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(login_button));
    }
    public WebElement getlogo() {
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(logo));
    }
    public WebElement getfooter_text() {
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(footer_text));
    }
    public WebElement getLog_in_text(){
            return Wait.waitforelement().until(ExpectedConditions.visibilityOf(Log_in_text));
        }
    public WebElement getusername_validation(){
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(username_validation));
    }
    public WebElement getpassword_validation() {
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(password_validation));
    }
    public WebElement getvalidation() {
        return Wait.waitforelement().until(ExpectedConditions.visibilityOf(validation));
    }

    }

