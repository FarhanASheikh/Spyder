package Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SKUMatchingPageObjects {

    @FindBy(xpath = "//span[contains(text(),'Sku Matching')]")
           public WebElement SKU_Matching;
    @FindBy(xpath = "//*[@type='button' and @class='btn btnBlue inner btn btn-danger']")
    public WebElement Create_task_btn;
    @FindBy(xpath = "//*[@name='taskname' and @placeholder='Task Name']")
            public WebElement task_name_field;
    @FindBy(id ="inputFile")
        public WebElement file_upload;
    @FindBy(css = " .create-btn.blue-shadow.btn-primary")
        public WebElement done_btn;
}
