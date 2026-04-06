package demoQa.elements;

import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("SmokeUI")
public class TaskTest extends BaseDemoQaTest {

    @Test
    void checkMethod(){
        browserHelper.open("https://demoqa.com/text-box");
        task.clickTexBox();
        browserHelper.open("https://demoqa.com/checkbox");
        browserHelper.goBack();
        browserHelper.refreshPage();
        task.clickRadioButton();
        browserHelper.goForward();
        task.clickWebTables();
        browserHelper.goBack();
        browserHelper.refreshPage();

    }
}
