package pages.webbingsearch;

import config.WebConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.WebDriverSetup;

public class BingSearchWebPage {
    public void navigateToBing() {
        WebDriverSetup.getDriver()
                .navigate()
                .to(WebConfig.BING_URL);
    }

    public void performSearch(String query) throws InterruptedException {
        WebElement searchTextbox = WebDriverSetup.getDriver()
                .findElement(By.id("sb_form_q"));
        searchTextbox.clear();
        searchTextbox.sendKeys(query);
        searchTextbox.submit();
        WebDriverSetup.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='b_results']")));
        scrollToEndOfPage();
    }

    private void scrollToEndOfPage() throws InterruptedException {
        Long documentHeight = (Long) ((JavascriptExecutor) WebDriverSetup.getDriver()).executeScript("return document.body.scrollHeight");
        int scrollIncrement = 100;
        for (int i = 0; i < documentHeight; i += scrollIncrement) {
            ((JavascriptExecutor) WebDriverSetup.getDriver()).executeScript("window.scrollTo(0, " + i + ")");
            Thread.sleep(50);
        }
    }
}
