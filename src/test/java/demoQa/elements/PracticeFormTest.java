package demoQa.elements;

import demoQa.BaseDemoQaTest;
import org.example.digital_nomads.demoQa.models.UserPracticeForm;
import org.example.digital_nomads.demoQa.utils.RandomUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("SmokeUI")
public class PracticeFormTest extends BaseDemoQaTest {

    @Test
    void pageBoxTest(){
        UserPracticeForm userPracticeForm = RandomUtils.generatePracticeForm();
        driver.get("https://demoqa.com/automation-practice-form");
       // userPracticeForm.fillUpTextBoxForm(userPracticeForm);
    }

    @Test
    void pageBoxTest3(){
        driver.get("https://demoqa.com/automation-practice-form");
        practiceFormPage.fillUserFirstName("Bob").fillUserLastName("Marly").fillUserEmail("bob@gmail.com")
                .choiceUserGender("male").fillUserMobileNumber("0555999900")
                .fillDateOfBirthday("8 September 1999")
                .fillUserSubject("English")
                .choiceUserHobbiesSport().choiceUserHobbiesMusic().choiceUserHobbiesReading()
                .uploadPicture("D:/Project/Apple/src/test/resources/cat.png")
                .fillUserCurrentAddress("lenina 9").selectStateAndCity("NCR")
                .submitButton().assertionsValidate("Bob");

    }
}
