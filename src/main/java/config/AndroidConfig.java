package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidConfig {

    public static final String DEVICE_NAME = "Pixel 3 XL";
    public static final String PLATFORM_NAME = "Android";
    public static final String PLATFORM_VERSION = "12.0";
    public static final String UI_AUTO_NAME = "uiautomator2";
    public static final String APP_PACKAGE_NAME = "com.microsoft.emmx";
    public static final String APP_ACTIVITY_NAME = "com.microsoft.ruby.Main";
    public static final String LOCAL_HOST = "http://127.0.0.1:4723/wd/hub";

}
