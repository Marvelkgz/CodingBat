package demoQa.elements;

import demoQa.BaseDemoQaTest;
import org.example.digital_nomads.demoQa.models.UserTextBox;
import org.example.digital_nomads.demoQa.utils.RandomUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("SmokeUI")
public class TextBoxTest extends BaseDemoQaTest {

    @Test
    void textBoxTest() {
        UserTextBox userTextBox = RandomUtils.generateTexBoxUser();
        driver.get("https://demoqa.com/text-box");
        textBoxPage.fillUpTextBoxForm(userTextBox);
    }
}
