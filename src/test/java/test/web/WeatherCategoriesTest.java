package test.web;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.webbingsearch.WeatherWebPage;
import util.WebDriverSetup;

public class WeatherCategoriesTest {
    private WeatherWebPage weatherWebPage = new WeatherWebPage();

    @BeforeClass
    public static void setUp() {
        WebDriverSetup.setUp();
    }

    @Test
    public void testWeatherCategories() throws InterruptedException {
        weatherWebPage.navigateToWeather();
        Thread.sleep(5000);
        weatherWebPage.clickAllCategories();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverSetup.tearDown();
    }
}
