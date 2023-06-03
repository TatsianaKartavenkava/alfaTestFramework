package tests;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static driver.DriverManager.*;

public abstract class BaseTest {
    private static AppiumDriver<MobileElement> driver;
    private static DriverManager driverManager;

    @BeforeSuite
    @Step("Создание драйвера")
    public static void instantiateDriver() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    @Step("Перезапуск приложения")
    public void reset() {
        resetApp();
    }

    @AfterSuite
    @Step("Закрытие драйвера")
    public static void tearDownDriver() {
        closeDriver();
        stopService();
    }

    @Step("Инициализация страниц")
    public abstract void initializePages();
}
