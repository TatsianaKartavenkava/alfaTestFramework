package tests.autorize;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;
import pages.StartPage;
import tests.BaseTest;

public class BaseAuthorize extends BaseTest {
    StartPage startPage;

    @BeforeMethod
    @Override
    public void initializePages() {
        startPage = new StartPage();
    }
}
