package demoQa;

import org.example.digital_nomads.demoQa.alertFrameWindow.AlertsPage;
import org.example.digital_nomads.demoQa.alertFrameWindow.IframePage;
import org.example.digital_nomads.demoQa.alertFrameWindow.WebTablesPage;
import org.example.digital_nomads.demoQa.alertFrameWindow.WindowPage;
import org.example.digital_nomads.demoQa.drivers.DriverManager;
import org.example.digital_nomads.demoQa.helpers.AlertHelper;
import org.example.digital_nomads.demoQa.helpers.BrowserHelper;
import org.example.digital_nomads.demoQa.helpers.IframeHelper;
import org.example.digital_nomads.demoQa.models.UserPracticeForm;
import org.example.digital_nomads.demoQa.pages.ButtonPage;
import org.example.digital_nomads.demoQa.pages.PracticeFormPage;
import org.example.digital_nomads.demoQa.pages.TextBoxPage;
import org.example.digital_nomads.demoQa.utils.Task;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseDemoQaTest {

    public static PracticeFormPage practiceFormPage;
    public static UserPracticeForm userPracticeForm;
    public static ButtonPage buttonPage;
    protected static WebDriver driver;
    protected static TextBoxPage textBoxPage;
    protected static AlertsPage alertsPage;
    protected static AlertHelper alertHelper;
    protected static Task task;
    protected static BrowserHelper browserHelper;
    protected static WindowPage windowPage;
    protected static IframeHelper iframeHelper;
    protected static IframePage iframePage;
    protected static WebTablesPage webTablesPage;


    @BeforeAll
    public static void setUpBrowser() {
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        alertsPage = new AlertsPage();
        alertHelper = new AlertHelper(driver);
        practiceFormPage = new PracticeFormPage();
        buttonPage = new ButtonPage();
        task = new Task();
        browserHelper = new BrowserHelper(driver);
        windowPage = new WindowPage();
        iframeHelper = new IframeHelper(driver);
        iframePage = new IframePage();
        webTablesPage = new WebTablesPage();
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverManager.closeDriver();
    }


}
