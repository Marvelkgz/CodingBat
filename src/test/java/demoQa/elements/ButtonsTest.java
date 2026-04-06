package demoQa.elements;

import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Tag("SmokeUI")
public class ButtonsTest extends BaseDemoQaTest {

    @Test
    void buttonPageTest(){
        driver.get("https://demoqa.com/buttons");
        buttonPage.doubleClick();
        buttonPage.rightClick();
        buttonPage.сlickMe();
            assertEquals("You have done a double click", buttonPage.getDoubleClickMessage());
            assertEquals("You have done a right click", buttonPage.getRightClickMessage());
            assertEquals("You have done a dynamic click", buttonPage.getDynamicClickMessage());

        }

    }

