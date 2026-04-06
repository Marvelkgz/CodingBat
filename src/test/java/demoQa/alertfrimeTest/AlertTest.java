package demoQa.alertfrimeTest;

import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("SmokeUI")
public class AlertTest extends BaseDemoQaTest {

    @Test
    void alertsTest(){
        driver.get("https://demoqa.com/alerts");
        alertsPage.clickAlertButton();
        alertHelper.acceptAlert();

        alertsPage.clickConfirmButton();
        alertHelper.dismiss();

        alertsPage.clickPromptButton();
        alertHelper.sendKeys("elka").acceptAlert();
    }
}
