package webbingsearch;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WeatherMapsPage {

    @Test
    public void testDriver() {
        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");

        // Create an instance of EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to a website
        driver.get("https://www.bing.com");

        // Find the search input field and enter a query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Wait for a few seconds to see the results
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();


    }
}
