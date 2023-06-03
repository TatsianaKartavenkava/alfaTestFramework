package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverManager.getDriver;

@Getter
public class StartPage extends Page {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Вход в Alfa-Test')]")
    private MobileElement tittle;

    @AndroidFindBy(id = "etUsername")
    private MobileElement loginInputField;

    @AndroidFindBy(id = "etPassword")
    private MobileElement passwordInputField;

    @AndroidFindBy(uiAutomator = "text(\"Вход\")")
    private MobileElement buttonGo;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Введены неверные данные')]")
    private MobileElement validationError;

    public boolean tittleIsDisplayed() {
        return tittle.isDisplayed();
    }

    @Step("Заголовок страницы")
    public String getTittle() {
        return tittle.getText();
    }

    @Step("Текст валидационной ошибки")
    public String getErrorText() {
        waitForElementToBeVisible(validationError, 10);
        return validationError.getText();
    }

    @Step("Курсор в поле ввода логина")
    public void clickInLoginInput() {
        loginInputField.click();
    }

    @Step("Получаем аттрибуты поля логин")
    public String enteredValueLogin() {
        return loginInputField.getAttribute("text");
    }

    @Step("Получаем аттрибуты поля пароль")
    public String enteredValuePass() {
        return passwordInputField.getAttribute("text");
    }

    @Step("Курсор в поле ввода пароля")
    public void clickInPasswordInput() {
        passwordInputField.click();
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonGo() {
        buttonGo.click();
    }

    @Step("Ввод логина")
    public StartPage setLogin(String login) {
        loginInputField.clear();
        loginInputField.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля")
    public StartPage setPassword(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        return this;
    }

    private void waitForElementToBeVisible(MobileElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
