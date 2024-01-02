package Pages;

import Object.LoginPageObjects;
import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utilities.Wait.*;


public class LoginPage extends Wait {

    protected String pwd = ")<6zRZvD!S";
    protected String username = "techadmin";




   public void Check_Login_Displayed() {
       Assert.assertEquals(new LoginPageObjects(driver).Log_in_text.getText(),"Log in");
    }


    public void CheckLogo() {
       Assert.assertTrue(new LoginPageObjects(driver).logo.isDisplayed());
    }

    public void Verifyfootertext() {
        LoginPageObjects lpo = new LoginPageObjects(driver);
               String footer_text_verify=lpo.footer_text.getText();
     Assert.assertEquals(footer_text_verify, "All rights reserved © Daraz2024.");

    }


    public void Login_Case1() throws InterruptedException {//Successful Login
        LoginPageObjects lpo = new LoginPageObjects(driver);
        driver.navigate().refresh();
        lpo.email.sendKeys(username);//input username
        lpo.unhide_password.click();//Check view password icon
        lpo.password.sendKeys(pwd);//input Password
        lpo.rememberme_checkbox.click();//Check remember me
        lpo.login_button.click();//click login button
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://spyder.daraz.com/scrapy-ui/skumatching?page=1&pageSize=10");
        System.out.println("Status"+driver.getCurrentUrl());
    }
    public void  Login_Case2() {//Empty Login and Verify  username validation
        LoginPageObjects lpo = new LoginPageObjects(driver);
        driver.navigate().refresh();
        lpo.login_button.click();
        Assert.assertEquals(lpo.username_validation.getText(), "Email OR username is a required field; you cannot leave it as blank.");
    }
    public void Login_Case3(){//wrong password
        LoginPageObjects lpo = new LoginPageObjects(driver);
        driver.navigate().refresh();
        lpo.email.sendKeys("admin");
        lpo.password.sendKeys(("1234"));
        lpo.login_button.click();
        String validation_text = waitforelement().until(ExpectedConditions.visibilityOf( lpo.validation)).getText();
        Assert.assertEquals(validation_text,"Either provided username or password is incorrect.");
    }

    public void Login_Case4(){ //wrong username
        LoginPageObjects lpo = new LoginPageObjects(driver);
        driver.navigate().refresh();
        lpo.email.sendKeys("admi");
        lpo.password.sendKeys(("12345"));
        lpo.login_button.click();
        String validation_text = waitforelement().until(ExpectedConditions.visibilityOf(lpo.validation)).getText();
        Assert.assertEquals(validation_text,"Either provided username or password is incorrect.");
    }
    public void Login_Case5() { //wrong username and password
        LoginPageObjects lpo = new LoginPageObjects(driver);
        driver.navigate().refresh();
        lpo.email.sendKeys("test");
        lpo.password.sendKeys(("12345"));
        lpo.login_button.click();
        String validation_text = waitforelement().until(ExpectedConditions.visibilityOf(lpo.validation)).getText();
        Assert.assertEquals(validation_text,"Either provided username or password is incorrect.");

}
    public void  Login_Case6() {//Empty Login and Verify Password validation
        LoginPageObjects lpo = new LoginPageObjects(driver);
        driver.navigate().refresh();
        lpo.login_button.click();
        Assert.assertEquals(lpo.password_validation.getText(), "Password is a required field; you cannot leave it as blank.");
    }
}

