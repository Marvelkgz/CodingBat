package demoQa.alertfrimeTest;

import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class WindowTest extends BaseDemoQaTest {

    @Test
    void windowTest(){
        driver.get("https://demoqa.com/browser-windows");
        windowPage.clickTabButton();
        windowPage.clickTabButton();
        browserHelper.switchToWindow(2);
        browserHelper.switchToParentWindow();
    }
}
