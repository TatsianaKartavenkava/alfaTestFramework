package tests.autorize;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static constants.Constants.NOT_VALID_INPUT;
import static constants.ErrorMassage.ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

@Owner("Татьяна Картавенкова")
@Story("Тест проверки кнопки Войти")
public class CheckButtonGoTest extends BaseAuthorize {

    @Test(priority = 1)
    @Description("Проверка невозможности войти с незаполненными полями")
    void testLoginButtonValidation() {
        startPage.clickButtonGo();
        assertThat(startPage.getErrorText()).isEqualTo(ERROR);
    }

    @Test(priority = 2)
    @Description("Проверка невозможности войти с незаполненным полем логин и невалидным паролем")
    void testPasswordInvalidValue() {
        startPage.setPassword(NOT_VALID_INPUT);
        startPage.clickButtonGo();
        assertThat(startPage.getErrorText()).isEqualTo(ERROR);
    }

    @Test(priority = 3)
    @Description("Проверка невозможности войти с незаполненным полем пароль и невалидным логином")
    void testLoginInvalidValue() {
        startPage.setLogin(NOT_VALID_INPUT);
        startPage.clickButtonGo();
        assertThat(startPage.getErrorText()).isEqualTo(ERROR);
    }

    @Test(priority = 4)
    @Description("Проверка невозможности войти с незаполненным полем пароль и невалидным логином")
    void testLoginAndPasswordInvalidValue() {
        startPage.setLogin(NOT_VALID_INPUT);
        startPage.setPassword(NOT_VALID_INPUT);
        startPage.clickButtonGo();
        assertThat(startPage.getErrorText()).isEqualTo(ERROR);
    }

    @Test(priority = 5)
    @Description("Авторизация с валидными логин и пароль")
    void testLoginButtonSuccess() {
        authorize();
        assertTrue(successPage.successTittleDisplayed());
    }
}