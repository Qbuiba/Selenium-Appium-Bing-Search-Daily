package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidConfig {
    public static AppiumDriver driver;

    public static void initializeDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 XL");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("appPackage", "com.microsoft.emmx");
        caps.setCapability("appActivity", "com.microsoft.ruby.Main");
        caps.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
