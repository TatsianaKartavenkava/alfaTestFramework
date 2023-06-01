package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class StartPage extends Page {

    @AndroidFindBy(uiAutomator = "text(\"Вход в Alfa-Test\")")
    MobileElement tittle;

    @AndroidFindBy(uiAutomator = "className(\"android.widget.EditText\").instance(0)")
    MobileElement loginInputField;

    @AndroidFindBy(id = "etPassword")
    MobileElement passwordInputField;

    @AndroidFindBy(xpath = "//android.widget.Button")
    MobileElement buttonGo;

    public boolean isDisplayed() {
        return loginInputField.isDisplayed();
    }

    @Step("Заголовок страницы")
    public StartPage getTittle() {
        tittle.getText();
        return this;
    }

    @Step("Курсор в поле ввода логина")
    public void clickInLoginInput() {
        loginInputField.click();
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
}
