package tests.autorize;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static constants.Constants.BIG_DATA;
import static constants.Constants.NOT_VALID_INPUT;
import static constants.ErrorMassage.ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertFalse;

@Owner("Татьяна Картавенкова")
@Story("Тесты на валидацию поля Логин")
public class CheckInputLoginFieldTest extends BaseAuthorize {

    @Test
    @Description("Проверка разрешенноого множества символов и отображение валидирующего сообщения")
    void testLoginValidationInvalidValue() {
        startPage.setLogin(NOT_VALID_INPUT);
        startPage.clickButtonGo();
        assertThat(startPage.getErrorText()).isEqualTo(ERROR);
    }

    //Вероятно, баг, т.к. в ТЗ указано, что максимально допустимая длина символов 50
    @Test
    @Description("Проверка максимального ввода количества символов")
    void testLoginValidationMaxLength() {
        startPage.setLogin(BIG_DATA);
        assertThat(startPage.enteredValueLogin().length()).isEqualTo(50);
    }

    @Test
    @Description("Проверка разрешенных символов с помощью регулярного выражения")
    void checkErrorMassageWithRegex() {
        startPage.setLogin(NOT_VALID_INPUT);
        String pattern = "^[A-Za-z\\.,/'_\\-\\s]+$";
        assertFalse(NOT_VALID_INPUT.matches(pattern), ERROR);
    }
}

