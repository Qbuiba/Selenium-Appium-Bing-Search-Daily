package androidbingsearch;

import io.appium.java_client.AppiumDriver;
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
        //appPackage = com.microsoft.emmx
        //app Activity = com.microsoft.ruby.Main
        caps.setCapability("appPackage", "com.microsoft.emmx");
        caps.setCapability("appActivity", "com.microsoft.ruby.Main");

        //appPackage for microsoftstart = com.microsoft.amp.apps.bingnews
        // app Activity = com.microsoft.sapphire.app.main.MainSapphireActivity
//       caps.setCapability("appPackage", "com.microsoft.amp.apps.bingnews");
//       caps.setCapability("appActivity", "com.microsoft.sapphire.app.main.MainSapphireActivity");
        caps.setCapability("noReset", true);
//        caps.setCapability("unicodeKeyboard", "true");
//        caps.setCapability("resetKeyboard", "true");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

    }

    @Test
    public void androidBingSearch() throws InterruptedException, IOException {

        //This section for Edge application
        BingSearchPage searchPage = new BingSearchPage(driver);

        searchPage.clickSearchBoxHome();
        searchPage.sendkeySearchHeader("element");

        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(2000);

        List<String> dataSearch = Reader.dataSearch(fileName);
        for (String a : dataSearch) {
            System.out.println(a);
            searchPage.clearSubmitForm();
            searchPage.sendkeySubmitForm(a);
            searchPage.submitButton.click();
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(4000);
        }
    }


    @After
    public void tearDown() {
        ((AndroidDriver) driver).closeApp();
    }

}
