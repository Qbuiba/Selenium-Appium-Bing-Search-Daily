package test.web;

import config.WebConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.webbingsearch.BingSearchWebPage;
import util.BBCScraper;
import util.Reader;
import util.WebDriverSetup;

import java.io.IOException;
import java.util.List;

import static config.WebConfig.*;

public class BingWebSearchTest {
    private BingSearchWebPage bingSearchWebPage = new BingSearchWebPage();

    @BeforeClass
    public static void setUp() throws IOException, InterruptedException {

        BBCScraper.scrapData();
        WebDriverSetup.setUp();
    }

    @Test
    public void testBingSearchWeb() throws InterruptedException, IOException {
        List<String> dataSearch = Reader.dataSearch(SEARCH_PATH + WEB_FILE_NAME);
        int count = 1;
        for (String query : dataSearch) {
            bingSearchWebPage.navigateToBing();
            Thread.sleep(5000);
            bingSearchWebPage.performSearch(query);
            System.out.println("Search time: " + count++);
            Thread.sleep(5000);
        }
    }

    @AfterClass
    public static void tearDown() {
        WebDriverSetup.tearDown();
    }
}
