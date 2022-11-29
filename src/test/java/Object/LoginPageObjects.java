package Object;x`x`

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

    @FindBy(id ="email")
    public WebElement email;
    @FindBy(css= "i.fa.fa-eye")
    public WebElement view_password;
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
    @FindBy(xpath = "//*[contains(text(),'Log in')]")
    public WebElement Log_in_text;
    @FindBy(xpath = "//*[contains(text(),'Email OR username is a required field; you cannot leave it as blank.')]")
    public WebElement username_validation;
    @FindBy(xpath = "//*[contains(text(),'Password  is a required field; you cannot leave it as blank.')]")
    public  WebElement password_validation;
    @FindBy(xpath = "//*[@class = 'alert alert-danger fade show' and @role='alert']")
    public WebElement validation;

}
