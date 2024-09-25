package PaymentForm;

import org.example.PaymentForm;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PaymentFormTests {
    WebDriver driver;
    PaymentForm paymentForm;

    // В блоке BeforeClass производится подготовка к тестам.
    @BeforeClass
    public void setUp() {

        // Создание экземпляра класса WebDriver и открытие сайта "https://www.mts.by/"
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

                // Всплывающее окно cookie
        try {
            WebElement cookie = driver.findElement(By.id("cookie-agree"));
            cookie.click();
        } catch (NoSuchElementException n) {
            n.printStackTrace();
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }

        // Создание экземпляра класса paySectionPage
        paymentForm = new PaymentForm(driver);
    }

    // Поверка названия блока
    @Test
    public void checkName() {
        // Вызов метода getHeaderText класса paySectionPage
        Assert.assertEquals(paymentForm.getHeaderText(),
                "Онлайн пополнение\nбез комиссии", "Название блока не соответсвует требуему!");
    }

    // Проверка отображения логотипов в блоке оплаты
    @Test
    public void paysLogosIsExist() {
        for (int i = 1; i <= 5; i++) {
            // Вызов метода isLogoDisplayed класса paySectionPage
            Assert.assertTrue(paymentForm.isLogoDisplayed(i), "Логотип " + i + " не отображается.");
        }
    }

    // Проверка корректности плейсхолдеров
    @Test
    public void checkPlaceholders() {

        // Массив с ожидаемыми плейсхолдерами
        String[] placeholders = {"Номер телефона", "Номер абонента", "Номер счета на 44", "Номер счета на 2073"};

        for (int i = 0; i < 4; i++) {

            // Вызов метода selectPayOptions класса paySectionPage
            paymentForm.selectPayOptions(i);

            // Возвращенный из метода getPlaceholderPhoneNumber массив записывается в массив s
            String[] s = paymentForm.getPlaceholderPhoneNumber(i, placeholders);

            // Проверяется соответствие фактического и ожидаемого текста плейсхолдеров
            Assert.assertEquals(s[0], s[1], "Неверный плейсхолдер в поле номер");
            Assert.assertEquals(paymentForm.getPlaceholderSum(),
                    "Сумма", "Неверный плейсхолдер в поле сумма");
            Assert.assertEquals(paymentForm.getPlaceholderEmail(),
                    "E-mail для отправки чека", "Неверный плейсхолдер в поле email");
        }
    }

    // Проверка ссылки "Подробнее о сервисе"
    @Test
    public void testLinkIsCorrect() {
        // Вызов метода clickLink класса paySectionPage
        paymentForm.clickLink();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "Ссылка ведет на неправильную страницу!");

        // Возврат на главную страницу
        driver.navigate().back();
    }

    // Проверка кнопки "Продолжить"
    @Test
    public void checkContinueButton() {
        paymentForm.enterPhoneAndSum("(29)777-77-77", "100");

        // Вызов метода isContinueButtonEnabled класса paySectionPage
        Assert.assertTrue(paymentForm.isContinueButtonEnabled(), "Кнопка продолжить не кликабельна");
    }


    //Проверка фрейма оплаты
    @Test
    public void checkPayFrame() {
        // Вызов метода enterPhoneAndSum класса paySectionPage
        paymentForm.enterPhoneAndSum("(29)777-77-77", "100");

        // Вызов метода clickContinueButton класса paySectionPage
        paymentForm.clickContinueButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Переключение на фрейм
        driver.switchTo().frame(driver.findElement(By.cssSelector("body > div.bepaid-app > div > iframe")));

        //Проверка суммы в заголовке и на кнопке
        Assert.assertEquals(paymentForm.getSumInFrame(),
                "100.00 BYN", "Сумма в заголовке не соответствует ранее введенной");
        Assert.assertEquals(paymentForm.getSumOnButton(),
                "Оплатить 100.00 BYN", "Сумма на кнопке не соответствует ранее введенной");

        //Проверка номера телефона в заголовке
        Assert.assertEquals(paymentForm.getPhoneInFrame(),
                "Оплата: Услуги связи Номер:375297777777", "Номер телефона не соответствует ранее введенному");

        // Проверка плейсхолдеров фрейма оплаты
        Assert.assertEquals(paymentForm.getPlaceholderCardNumber(),
                "Номер карты", "Неверный плейсхолдер в поле номер карты");
        Assert.assertEquals(paymentForm.getPlaceholderValidity(),
                "Срок действия", "Неверный плейсхолдер в поле срок действия");
        Assert.assertEquals(paymentForm.getPlaceholderCVC(),
                "CVC", "Неверный плейсхолдер в поле CVC");
        Assert.assertEquals(paymentForm.getPlaceholderName(),
                "Имя держателя (как на карте)", "Неверный плейсхолдер в поле Имя держателя");


        // Проверка отображения логотипов во фрейме
        for (int i = 1; i <= 4; i++) {
            Assert.assertTrue(paymentForm.isLogoInFrameDisplayed(i), "Логотип " + i + " не отображается.");
        }

        // Закрытие окна оплаты
        paymentForm.closePopup();

        // Возврат на основной фрейм
        driver.switchTo().parentFrame();
    }

    // Закрытие драйвера после проведения тестов
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}