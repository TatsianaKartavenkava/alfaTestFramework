package configurator;

import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static configurator.CapabilitiesConstant.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS;
import static io.appium.java_client.remote.MobileCapabilityType.*;

public class CapabilityConfigurator {

    public CapabilityConfigurator() {
    }

    public static DesiredCapabilities setCommonCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability(DEVICE_NAME, MY_DEVICE_NAME);
        capabilities.setCapability(PLATFORM_VERSION, MY_PLATFORM_VERSION);
        capabilities.setCapability(UDID, MY_DEVICE_NAME);
        capabilities.setCapability(AUTO_ACCEPT_ALERTS, true);
        capabilities.setCapability(APP, MY_APP);
        capabilities.setCapability(APP_PACKAGE, MY_APP_PACKAGE);
        capabilities.setCapability(CLEAR_SYSTEM_FILES, true);

        return capabilities;
    }

    @SneakyThrows
    public static URL getAppiumServerURL() {
        return new URL(String.format("http://%s:%s/wd/hub",
                HOST,
                PORT));
    }
}
