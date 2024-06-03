package pages.webbingsearch;

import config.WebConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.WebDriverSetup;

import java.util.List;

public class WeatherWebPage {
    private final String listButtonXpath = "//div[@id='m-switcher']/div/div/div/button";

    public void navigateToWeather() {
        WebDriverSetup.getDriver()
                .navigate()
                .to(WebConfig.WEATHER_URL);
    }

    public void clickAllCategories() throws InterruptedException {
        List<WebElement> categoriesButtons = WebDriverSetup.getDriver()
                .findElements(By.xpath(listButtonXpath));
        for (WebElement categoryButton : categoriesButtons) {
            categoryButton.click();
            Thread.sleep(5000);
        }
    }
}
