package androidbingsearch;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import reader.Reader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class BingAndroidSearch {

    public static AppiumDriver driver = null;
    DesiredCapabilities caps;
    String fileName = "dataForBingSearch.txt";

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3 XL");
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("appPackage", "com.microsoft.emmx");
        caps.setCapability("appActivity", "com.microsoft.ruby.Main");
        caps.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

    }

    @Test
    public void androidBingSearch() throws InterruptedException, IOException {

        //This section for Edge application
        BingSearchPage searchPage = new BingSearchPage(driver);

        List<String> dataSearch = Reader.dataSearch(fileName);
        for (String a : dataSearch) {
            System.out.println(a);
            searchPage.clickSearchBoxHome();
            searchPage.sendkeySearchHeader(a);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(5000);
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10)"));
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() {
        ((AndroidDriver) driver).closeApp();
    }

}
