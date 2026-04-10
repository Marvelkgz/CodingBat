import demoQa.BaseDemoQaTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Tag("E2E")
public class AmazonTest extends BaseDemoQaTest {

    @Test
    void amazon() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        browserHelper.open("https://www.amazon.com");
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" + Keys.RETURN);

        // Узнаём количество брендов один раз
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("#brandsRefinements ul li a")));
        int brandCount = driver.findElements(By.cssSelector("#brandsRefinements ul li a")).size();

        for (int i = 0; i < brandCount; i++) {
            // Каждый раз ищем элементы заново — список уже не устаревший
            List<WebElement> brands = driver.findElements(By.cssSelector("#brandsRefinements ul li a"));
            wait.until(ExpectedConditions.elementToBeClickable(brands.get(i)));
            brands.get(i).click();

            // Ждём загрузки страницы перед следующей итерацией
            Thread.sleep(2000);
        }
    }
}