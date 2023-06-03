package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

import static driver.DriverManager.getDriver;

@Slf4j
public class Page {
    public Page() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
}
