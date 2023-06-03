package tests.autorize;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

@Owner("Татьяна Картавенкова")
@Story("Тесты на проверку видимости и доступности заголовка")
public class CheckTittleVisibilityTest extends BaseAuthorize {

    @Test
    @Description("Проверка отображения Заголовка")
    void checkVisibilityTittle() {
        assertThat(startPage.tittleIsDisplayed()).isEqualTo(true);
    }

    @Test
    @Description("Проверка доступности заголовка")
    public void testTittleText() {
        assertEquals(startPage.getTittle(), "Вход в Alfa-Test");
    }
}