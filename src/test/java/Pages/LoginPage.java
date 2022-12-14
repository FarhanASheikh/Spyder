package Pages;

import Object.LoginPageObjects;
import Utilities.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LoginPage extends Wait {

    public void Check_Login_Displayed() {
       Assert.assertEquals(new LoginPageObjects(driver).getLog_in_text().getText(),"Log in");
    }


    public void CheckLogo() {
       Assert.assertTrue(new LoginPageObjects(driver).getlogo().isDisplayed());
    }

    public void Verifyfootertext() {
     Assert.assertEquals(new LoginPageObjects(driver).getfooter_text().getText(), "All rights reserved © Daraz2022.");

    }


    public void Login_Case1() {//Successful Login

        driver.navigate().refresh();
        new LoginPageObjects(driver).getemail().sendKeys("techadmin");//input username
        new LoginPageObjects(driver).getunhide_password().click();//Check view password icon
        new LoginPageObjects(driver).getpassword().sendKeys(")<6zRZvD!S");//input Password
        new LoginPageObjects(driver).getrememberme_checkbox().click();//Check remember me
        new LoginPageObjects(driver).getlogin_button().click();//click login button
    }
    public void  Login_Case2() {//Empty Login and Verify validation
        driver.navigate().refresh();
        new LoginPageObjects(driver).getlogin_button().click();
        Assert.assertEquals(new LoginPageObjects(driver).getusername_validation().getText(), "Email OR username is a required field; you cannot leave it as blank.");
        Assert.assertEquals(new LoginPageObjects(driver).getpassword_validation().getText(), "Password is a required field; you cannot leave it as blank.");
    }
    public void Login_Case3(){//wrong password
        driver.navigate().refresh();
        new LoginPageObjects(driver).getemail().sendKeys("admin");
        new LoginPageObjects(driver).getpassword().sendKeys(("1234"));
        new LoginPageObjects(driver).getlogin_button().click();
        String validation_text = Wait.waitforelement().until(ExpectedConditions.visibilityOf( new LoginPageObjects(driver).getvalidation())).getText();
        Assert.assertEquals(validation_text,"Either provided username or password is incorrect.");
    }

    public void Login_Case4(){ //wrong username
        driver.navigate().refresh();
        new LoginPageObjects(driver).getemail().sendKeys("admi");
        new LoginPageObjects(driver).getpassword().sendKeys(("12345"));
        new LoginPageObjects(driver).getlogin_button().click();
        String validation_text = Wait.waitforelement().until(ExpectedConditions.visibilityOf( new LoginPageObjects(driver).getvalidation())).getText();
        Assert.assertEquals(validation_text,"Either provided username or password is incorrect.");
    }
    public void Login_Case5() { //wrong username
        driver.navigate().refresh();
        new LoginPageObjects(driver).getemail().sendKeys("test");
        new LoginPageObjects(driver).getpassword().sendKeys(("12345"));
        new LoginPageObjects(driver).getlogin_button().click();
        String validation_text = Wait.waitforelement().until(ExpectedConditions.visibilityOf( new LoginPageObjects(driver).getvalidation())).getText();
        Assert.assertEquals(validation_text,"Either provided username or password is incorrect.");

}
}

