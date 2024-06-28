package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static config.AndroidConfig.*;

public class AndroidDriverSetup {
    public static AppiumDriver driver;

    public static void initializeDriver() throws MalformedURLException, InterruptedException {
        if (driver != null) {
            driver.quit();
        }
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        caps.setCapability("automationName", UI_AUTO_NAME);
        caps.setCapability("appPackage", APP_PACKAGE_NAME);
        caps.setCapability("appActivity", APP_ACTIVITY_NAME);
        caps.setCapability("noReset", true);
        driver = new AndroidDriver(new URL(LOCAL_HOST), caps);
        Thread.sleep(1000);
    }

    public static void tearDown() {
        // Terminate the app using the app package name
        ((AndroidDriver) driver).terminateApp("com.microsoft.emmx");
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}

