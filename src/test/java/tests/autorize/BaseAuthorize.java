package tests.autorize;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import pages.StartPage;
import pages.SuccessPage;
import tests.BaseTest;

import static constants.Constants.VALID_LOGIN;
import static constants.Constants.VALID_PASSWORD;

public class BaseAuthorize extends BaseTest {

    StartPage startPage;
    SuccessPage successPage;

    @BeforeMethod
    @Override
    public void initializePages() {
        startPage = new StartPage();
        successPage = new SuccessPage();
    }

    @Step("Авторизация с валидными данными")
    public void authorize() {
        startPage.clickInLoginInput();
        startPage.setLogin(VALID_LOGIN);
        startPage.clickInPasswordInput();
        startPage.setPassword(VALID_PASSWORD);
        startPage.clickButtonGo();
    }
}
