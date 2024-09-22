import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirdTest {
    @Test
    public void verifyLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement link = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        link.click();
        Assert.assertTrue(driver.getPageSource().contains("Оплата банковской картой"), "Ошибка: ссылка не работает");
        driver.quit();
        }
}