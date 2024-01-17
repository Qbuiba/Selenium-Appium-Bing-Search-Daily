package webbingsearch;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reader.Reader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BingWebSearch {

    private static EdgeDriver driver;
    private static WebDriverWait wait;

    WebElement searchTextbox;

    List<WebElement> categoriesButtons;

    String fileName = "dataForBingSearch.txt";
    String bingURL = "https://bing.com";

    private String weatherStartPage = "https://www.msn.com/en-us/weather/maps/radar/?type=radar";

    private String listButtonXpath = "//div[@id='m-switcher']/div/div/div/button";

    @BeforeClass
    public static void setUp() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }


    @Test
    public void testBingSearch() throws InterruptedException, IOException {

        driver.navigate().to(bingURL);
        Thread.sleep(3000);


        List<String> dataSearch = Reader.dataSearch(fileName);
        int count = 1;
        for (String e : dataSearch) {
            driver.navigate().to(bingURL);
            Thread.sleep(2000);
            searchTextbox = driver.findElement(By.id("sb_form_q"));
            searchTextbox.clear();
            searchTextbox.sendKeys(e);
            System.out.println(e);
            searchTextbox.submit();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='b_results']")));
            System.out.println("Search time: " + count++);
            Thread.sleep(3000);
        }

    }

    @Test
    public void testWeatherCategories() throws InterruptedException {

        driver.navigate().to(weatherStartPage);
        Thread.sleep(5000);

        categoriesButtons = driver.findElements(By.xpath(listButtonXpath));

        for (WebElement categoryButton : categoriesButtons) {
            categoryButton.click();
            Thread.sleep(5000);
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
