import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void verifyTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String text = blockTitle.getText();
        if (text.contains("Онлайн пополнение "+"без комиссии")) {
            System.out.println("Название блока найдено");
        } else {
            System.out.println("Ошибка: название блока не найдено");
        }
        driver.quit();
    }
}
