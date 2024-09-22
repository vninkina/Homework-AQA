import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FourthTest {
    @Test
    public void verifyContinueButton() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement serviceRadio = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[1]"));
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.clear();
        sumInput.sendKeys("100");

        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.clear();
        emailInput.sendKeys("test@yandex.ru");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        Assert.assertTrue(driver.getPageSource().contains("Оплата:"), "Кнопка 'Продолжить' не работает");
        driver.quit();
    }
}