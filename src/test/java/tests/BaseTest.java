package tests;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static driver.DriverManager.*;

public abstract class BaseTest {
    private static AppiumDriver<MobileElement> driver;
    private static DriverManager driverManager;

    @BeforeClass
    @Step("Создание драйвера")
    public static void instantiateDriver() {
        driver = driverManager.getDriver();
    }

    @AfterClass
    @Step("Закрытие драйвера")
    public static void teardownDriver() {
        closeDriver();
        stopService();
       // closeEmulator();

    }

    @Step("Инициализация страниц")
    public abstract void initializePages();
}
