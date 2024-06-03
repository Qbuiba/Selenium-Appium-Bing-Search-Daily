package test.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.androidpage.BingSearchPageAndroid;
import util.AndroidDriverSetup;
import util.Reader;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static config.WebConfig.*;
import static util.AndroidDriverSetup.driver;


public class BingAndroidSearch {

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        AndroidDriverSetup.initializeDriver();
    }

    @Test
    public void androidBingSearch() throws InterruptedException, IOException {
        BingSearchPageAndroid searchPage = new BingSearchPageAndroid(driver);
        List<String> dataSearch = Reader.dataSearch(SEARCH_PATH + ANDROID_FILE_NAME);

        for (String searchTerm : dataSearch) {
            System.out.println(searchTerm);
            searchPage.clickSearchBoxHome();
            searchPage.sendkeySearchHeader(searchTerm);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            Thread.sleep(5000);
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10)"));
            driver.navigate()
                    .back();
        }
    }

    @After
    public void tearDown() {
        AndroidDriverSetup.tearDown();
    }

}
