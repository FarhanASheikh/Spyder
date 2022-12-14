package Pages;

import Utilities.Wait;
import Object.SKUMatchingPageObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SKUMatchingPage extends Wait {
    public void Click_SKUMatching_Module() {
        new SKUMatchingPageObjects(driver).SKU_Matching.click();
    }

    public void Create_task()  {

        new SKUMatchingPageObjects(driver).Create_task_btn.click();
        new SKUMatchingPageObjects(driver).task_name_field.sendKeys("AAA AAA AAA");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).select_competitor)).click();
        new SKUMatchingPageObjects(driver).file_upload.sendKeys("/Users/farhanahmedsheikh/Downloads/sku_template_1669017946660.csv");
        Wait.waitforelement().until(ExpectedConditions.visibilityOf(new SKUMatchingPageObjects(driver).done_btn)).click();
    }
}

