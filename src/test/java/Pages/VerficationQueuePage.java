package Pages;
import Object.VerificationQueuePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VerficationQueuePage extends Base{

    VerificationQueuePageObjects VQPO = new VerificationQueuePageObjects();


    public VerficationQueuePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, VQPO);
    }

    public void GOTO_VQ_Module() {
        VQPO.Select_VQ_leftpanel.click();
    }
    public void Select_Read_SortBy_filters(){
        System.out.println(VQPO.Select_SortBy_filter.getText());
        VQPO.Select_SortBy_filter.click();
        VQPO.Select_SortBy_Exposure.click();

    }
    public void Select_Read_Competitors_filters(){
        System.out.println(VQPO.Select_Competitor_filter.getText());

       VQPO.Select_Competitor_filter.click();
        VQPO.Select_Chaldal_bd.click();
    }

}
