package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class SuccessPage extends Page {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Вход в Alfa-Test')]")
    MobileElement successTittle;

    @Step("Отображается заголовок входа в приложение")
    public boolean successTittleDisplayed() {
        return successTittle.isDisplayed();
    }
}