package org.example.digital_nomads.demoQa.alertFrameWindow;

import org.example.digital_nomads.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage {

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    public String getSampleHeadingTex(){
        return sampleHeading.getText();
    }

}
