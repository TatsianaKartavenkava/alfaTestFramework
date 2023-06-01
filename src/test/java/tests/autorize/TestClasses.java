package tests.autorize;

import org.testng.annotations.Test;

public class TestClasses extends BaseAuthorize {

    @Test
    public void goToPage() {
        startPage.isDisplayed();
        startPage.clickInLoginInput();
        startPage.setLogin("Login-1");
        startPage.clickButtonGo();
    }
}
