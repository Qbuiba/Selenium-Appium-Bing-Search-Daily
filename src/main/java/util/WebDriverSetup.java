package util;

import config.WebConfig;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetup {

    private static EdgeDriver driver;

    private static WebDriverWait wait;

    public static void setUp() {
        System.setProperty("webdriver.edge.driver", WebConfig.DRIVER_PATH);
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage()
                .window()
                .maximize();
    }

    public static EdgeDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
