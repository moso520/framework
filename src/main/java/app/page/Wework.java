package app.page;

import app.page.MainPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Wework {
    public MainPage startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tencent.wework");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".launch.WwMainActivity");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator1");
//        capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);

//you are free to set additional capabilities
        AppiumDriver<MobileElement> driver = new AppiumDriver<>(
                new URL("http://127.0.0.1:4723/wd/hub"), //if it needs to use locally started server
//then the target_ip is 127.0.0.1 or 0.0.0.0
//the default port is 4723
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new MainPage(driver);

    }
}
