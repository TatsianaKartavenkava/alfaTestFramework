package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Optional;

import static configurator.CapabilityConfigurator.getAppiumServerURL;
import static configurator.CapabilityConfigurator.setCommonCapabilities;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_DURATION;

@Slf4j
public class DriverManager {

    private static AppiumDriver<MobileElement> driver;
    private static AppiumDriverLocalService appiumDriverLocalService;

    public DriverManager() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            driver = createDriver();
            log.info("Driver was successfully created");
        }
        return driver;
    }

    @SneakyThrows
    public static AppiumDriver<MobileElement> createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(APP_WAIT_DURATION, "10000");
        capabilities.merge(setCommonCapabilities(capabilities));

        return new AndroidDriver(getAppiumServerURL(), capabilities);
    }

    public static void resetApp() {
        driver.resetApp();
    }

    public static void closeDriver() {
        driver.quit();
        log.info("Driver closed");
    }

    public static void stopService() {
        Optional.ofNullable(appiumDriverLocalService).ifPresent(service -> {
            service.stop();
            log.info("Appium server stopped");
        });
    }
}
