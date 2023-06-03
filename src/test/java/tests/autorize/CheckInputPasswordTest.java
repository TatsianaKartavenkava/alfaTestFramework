package tests.autorize;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static constants.Constants.BIG_DATA;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckInputPasswordTest extends BaseAuthorize {

    //Вероятно, баг, т.к. в ТЗ указано, что максимально допустимая длина символов 50
    @Test
    @Description("Проверка максимального ввода количества символов")
    void testPassValidationMaxLength() {
        startPage.setPassword(BIG_DATA);
        assertThat(startPage.enteredValuePass().length()).isEqualTo(50);
    }
}