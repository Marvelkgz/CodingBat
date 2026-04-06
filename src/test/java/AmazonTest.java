import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
@Tag("E2E")
public class AmazonTest extends BaseDemoQaTest {

    @Test
    void amazon() throws InterruptedException {
        browserHelper.open("https://www.amazon.com");
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" + Keys.RETURN);
        List<WebElement> brands = driver.findElements(By.cssSelector("#brandsRefinements ul li a"));
        for (WebElement brand : brands){
            brand.click();
        }

    }
}
