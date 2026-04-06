package demoQa.alertfrimeTest;

import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("SmokeUI")
public class IframeTest extends BaseDemoQaTest {

    @Test
    void iframeTest(){
        driver.get("https://demoqa.com/frames");
        iframeHelper.switchToFrame("frame2");
        String txt = iframePage.getSampleHeadingTex();
        System.out.println(txt);

        iframeHelper.switchToParentFrame();
        iframeHelper.switchToFrame("frame2");
        String txt2 = iframePage.getSampleHeadingTex();
        System.out.println(txt2);

    }
}
