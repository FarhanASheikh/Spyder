package Pages;

import Object.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends Base {

    LoginPageObjects lpo = new LoginPageObjects();

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, lpo);
    }

    public void Check_Login_Displayed() {
        if (lpo.Log_in_text.isDisplayed()) {
            System.out.println("Login Page Displayed");
        } else {
            System.out.println("Login Page not displayed");
        }
    }


    public void CheckLogo() {
        if (lpo.logo.isDisplayed()) {//verify logo
            System.out.println("Logo Displayed");
        } else {
            System.out.println("Logo Not Displayed");
        }
    }

    public void Verifyfootertext() {
        String text = lpo.footer_text.getText();
        System.out.println(text);
        if (text.equalsIgnoreCase("All rights reserved © Daraz2022.")) {
            System.out.println("Footer Text Displayed");
        } else {
            System.out.println("Footer Text Not Displaxyed");
        }

    }

    public void Login_Case1() {//Successful Login

        driver.navigate().refresh();
        lpo.email.sendKeys("admin");//input username
        lpo.view_password.click();//Check view password icon
        lpo.password.sendKeys("12345");//input Password
        lpo.rememberme_checkbox.click();//Check remember me
        lpo.login_button.click();//click login button
    }
    public void  Login_Case2(){//Empty Login and Verify validation
        driver.navigate().refresh();
        lpo.login_button.click();
        if(lpo.username_validation.isDisplayed() && lpo.password_validation.isDisplayed()){
            System.out.println("Case 2 Passed");
        }
        else {
            System.out.println("Case2 failed");
        }

    }

    public void Login_Case3(){//wrong password
        driver.navigate().refresh();
        lpo.email.sendKeys("admin");
        lpo.password.sendKeys(("1234"));
        lpo.login_button.click();
        String validation_text = wait.until(ExpectedConditions.visibilityOf(lpo.validation)).getText();
        if(validation_text.equalsIgnoreCase("Either provided username or password is incorrect.")){
            System.out.println("Case 3 Passed");
        }
        else{ System.out.println("Case 3 Failed");}
    }

    public void Login_Case4(){ //wrong username
        driver.navigate().refresh();
        lpo.email.sendKeys("admi");
        lpo.password.sendKeys(("12345"));
        lpo.login_button.click();
        String validation_text = wait.until(ExpectedConditions.visibilityOf(lpo.validation)).getText();
        if(validation_text.equalsIgnoreCase("Either provided username or password is incorrect.")){
            System.out.println("Case 4 Passed");
        }
        else{ System.out.println("Case 4 Failed");}
    }
    public void Login_Case5() { //wrong username
        driver.navigate().refresh();
        lpo.email.sendKeys("test");
        lpo.password.sendKeys(("12345"));
        lpo.login_button.click();
        String validation_text = wait.until(ExpectedConditions.visibilityOf(lpo.validation)).getText();
        if(validation_text.equalsIgnoreCase("Either provided username or password is incorrect.")){
            System.out.println("Case 5 Passed");
        }
        else{ System.out.println("Case 5 Failed");}
    }

}

