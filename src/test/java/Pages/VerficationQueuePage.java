package Pages;
import Object.VerificationQueuePageObjects;
import Utilities.Wait;

public class VerficationQueuePage extends Wait {

    public void GOTO_VQ_Module() {
        new VerificationQueuePageObjects(driver).Select_VQ_leftpanel.click();
    }
    public void Select_Read_SortBy_filters(){
        System.out.println(new VerificationQueuePageObjects(driver).Select_SortBy_filter.getText());
        new VerificationQueuePageObjects(driver).Select_SortBy_filter.click();
        new VerificationQueuePageObjects(driver).Select_SortBy_Exposure.click();

    }
    public void Select_Read_Competitors_filters(){
        System.out.println(new VerificationQueuePageObjects(driver).Select_Competitor_filter.getText());

        new VerificationQueuePageObjects(driver).Select_Competitor_filter.click();
        new VerificationQueuePageObjects(driver).Select_Chaldal_bd.click();
    }

}
