package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenEdgeBrowser {
    public static void main(String[] args) {
        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "D:\\HappyCoding\\msedgedriver.exe");

        // Instantiate an EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Print a success message
        System.out.println("Microsoft Edge browser opened and navigated to Google page.");
    }
}
