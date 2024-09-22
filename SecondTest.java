import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SecondTest {
    @Test
    public void verifyPaymentLogos() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebElement onlineTopupSection = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div"));

        List<WebElement> paymentLogos = onlineTopupSection.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));

        Assert.assertTrue(paymentLogos.size() == 3, "Должно быть 3 логотипа платежных систем");

        for (WebElement logo : paymentLogos) {
            Assert.assertTrue(logo.isDisplayed(), "Логотипы платежных систем отображаются");
            driver.quit();
        }
    }
}

