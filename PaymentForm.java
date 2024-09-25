package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// В классе PaymentForm собраны локаторы и методы для тестирования блока оплаты и фрейма
public class PaymentForm {
    private WebDriver driver;

    // Конструктор
    public PaymentForm(WebDriver driver) {
        this.driver = driver;
    }

    // Метод возвращает заголовок блока оплаты
    public String getHeaderText() {
        WebElement header = driver.findElement(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2"));
        return header.getText();
    }

    // Метод провераяет отображение логотипов платежных систем
    public boolean isLogoDisplayed(int index) {
        WebElement logo = driver.findElement(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(" + index + ") > img"));
        return logo.isDisplayed();
    }

    // Метод принимает индекс и массив ожидаемых значений плейсхолдера поля номер ...
    public String[] getPlaceholderPhoneNumber(int index, String[] expected) {
        String[] s = new String[2];

        // В зависимости от значения индекса в массив s записывается фактический и ожидаемый результаты
        switch (index) {
            case 0:
                WebElement number = driver.findElement(By.id("connection-phone"));
                s[0] = number.getAttribute("placeholder");
                s[1] = expected[index];
                break;
            case 1:
                WebElement homeInternet = driver.findElement(By.id("internet-phone"));
                s[0] = homeInternet.getAttribute("placeholder");
                s[1] = expected[index];
                break;
            case 2:
                WebElement installmentPlan = driver.findElement(By.id("score-instalment"));
                s[0] = installmentPlan.getAttribute("placeholder");
                s[1] = expected[index];
                break;
            case 3:
                WebElement debt = driver.findElement(By.id("score-arrears"));
                s[0] = debt.getAttribute("placeholder");
                s[1] = expected[index];
        }

        // ... и возвращает массив с фактическим и ожидаемым результатом
        return s;
    }

    // Метод возвращает значение плейсхолдера поля сумма.
    public String getPlaceholderSum() {
        WebElement placeholderSum = driver.findElement(By.id("connection-sum"));
        return placeholderSum.getAttribute("placeholder");
    }

    // Метод возвращает значение плейсхолдера поля Email.
    public String getPlaceholderEmail() {
        WebElement placeholderEmail = driver.findElement(By.id("connection-email"));
        return placeholderEmail.getAttribute("placeholder");
    }


    // Метод принимает индекс и выбирает один из вариантов оплаты
    public void selectPayOptions(int i) {
        WebElement payOptionsSelector = driver.findElement(By.className("select__wrapper"));
        payOptionsSelector.click();
        switch (i) {
            case 0:
                WebElement phoneService = driver.findElement(By.xpath(
                        "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
                phoneService.click();
                break;
            case 1:
                WebElement homeInternet = driver.findElement(By.xpath(
                        "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"));
                homeInternet.click();
                break;
            case 2:
                WebElement installmentPlan = driver.findElement(By.xpath(
                        "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"));
                installmentPlan.click();
                break;
            case 3:
                WebElement debt = driver.findElement(By.xpath(
                        "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
                debt.click();
        }
    }

    // Метод переходит по ссылке "Подробнее о сервисе"
    public void clickLink() {
        WebElement link = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a"));
        link.click();
    }

    // Метод вводит в поля номер и сумма данные переданные в параметрах
    public void enterPhoneAndSum(String phone, String sum) {
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        phoneField.sendKeys(phone);
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.sendKeys(sum);
    }

    // Метод проверяет кликабельность кнопки "Продолжить"
    public boolean isContinueButtonEnabled() {
        WebElement cont = driver.findElement(By.xpath(
                "//*[@id=\"pay-connection\"]/button"));
        return cont.isEnabled();
    }

    // Метод закрывает фрейм оплаты
    public void closePopup() {
        WebElement close = driver.findElement(By.cssSelector(
                "body > app-root > div > div > app-header > header > div > app-back-navigation > div > div > svg-icon"));
        close.click();
    }

    // Метод нажимает кнопку "Продолжить"
    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
    }

    // Метод возвращает сумму в заголовке фрейма
    public String getSumInFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]")));
        WebElement sumInFrame = driver.findElement(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]"));
        return sumInFrame.getText();
    }

    // Метод возвращает сумму на кнопке
    public String getSumOnButton() {
        WebElement sumOnButton = driver.findElement(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        return sumOnButton.getText();
    }

    // Метод возвращает номер телефона в заголовке фрейма
    public String getPhoneInFrame() {
        WebElement phone = driver.findElement(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        return phone.getText();
    }

    // Метод возвращает значение плейсхолдера поля Номер карты
    public String getPlaceholderCardNumber() {
        WebElement cardNumber = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
        return cardNumber.getText();
    }

    // Метод возвращает значение плейсхолдера поля Срок действия
    public String getPlaceholderValidity() {
        WebElement validity = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]"));
        return validity.getText();
    }

    // Метод возвращает значение плейсхолдера поля CVC
    public String getPlaceholderCVC() {
        WebElement cvc = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        return cvc.getText();
    }

    // Метод возвращает значение плейсхолдера поля Имя держателя
    public String getPlaceholderName() {
        WebElement name = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        return name.getText();
    }

    // Метод принимает индекс и проверяет отображение логотопов платежных систем в поле Номер карты
    public boolean isLogoInFrameDisplayed(int index) {
        WebElement logo;
        if (index <= 3) {

            // В поле содержится три постоянных логотипа ...
            logo = driver.findElement(By.xpath(
                    "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[" + index + "]"));
        } else {

            // ... и один рандомный
            logo = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div"));
        }
        return logo.isDisplayed();
    }
}
