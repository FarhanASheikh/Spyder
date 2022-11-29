package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Object.SKUMatchingPageObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SKUMatchingPage extends Base {
    SKUMatchingPageObjects SKUMPO = new SKUMatchingPageObjects();

    public SKUMatchingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, SKUMPO);
    }

    public void Click_SKUMatching_Module() {
        SKUMPO.SKU_Matching.click();
    }

    public void Create_task()  {

        SKUMPO.Create_task_btn.click();
        SKUMPO.task_name_field.sendKeys("AAA AAA AAA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='6' and contains(text(),'Chaldal_bd')]"))).click();
        SKUMPO.file_upload.sendKeys("/Users/farhanahmedsheikh/Downloads/sku_template_1669017946660.csv");
        wait.until(ExpectedConditions.visibilityOf(SKUMPO.done_btn)).click();
    }
}

