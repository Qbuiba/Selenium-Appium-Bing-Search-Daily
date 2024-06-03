package util;

import config.WebConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BBCScraper {

    private static EdgeDriver driver;

    public static void scrapData() throws IOException, InterruptedException {
        System.setProperty("webdriver.edge.driver", WebConfig.DRIVER_PATH);
        driver = new EdgeDriver();
        driver.manage()
                .window()
                .maximize();

        try {
            // Navigate to BBC homepage
            driver.get("https://www.bbc.com/");
            Thread.sleep(5000);  // Wait for the page to load

            // Click on the first article
            WebElement firstArticle = driver.findElement(By.xpath("(//a[contains(@href, '/news/articles')])[1]"));
            WebElement secondArticle = driver.findElement(By.xpath("(//a[contains(@href, '/news/articles')])[2]"));

            List<WebElement> articles = new ArrayList<>();
            articles.add(firstArticle);
            articles.add(secondArticle);
            if (articles.size() >= 2) {
                articles.get(0)
                        .click();
                Thread.sleep(5000);  // Wait for the article page to load

                // Extract text content from the first article
                String firstArticleText = extractArticleText(driver);
                // Write the first 30 sentences to webdata.txt
                writeSentencesToFile(firstArticleText, "src/test/resources/web_data.txt", 30);

                // Navigate back to the BBC homepage
                driver.navigate()
                        .back();
                Thread.sleep(5000);  // Wait for the page to load

                // Click on the second article
                articles.get(1)
                        .click();
                Thread.sleep(5000);  // Wait for the article page to load

                // Extract text content from the second article
                String secondArticleText = extractArticleText(driver);
                // Write the first 30 sentences to appdata.txt
                writeSentencesToFile(secondArticleText, "src/test/resources/app_data.txt", 30);
            } else {
                System.out.println("Not enough articles found on the BBC homepage.");
            }

            System.out.println("Text has been successfully written to web_data.txt and app_data.txt");
        } finally {
            // Kill the browser and quit the WebDriver
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        }
    }

    private static String extractArticleText(WebDriver driver) {
        List<WebElement> paragraphs = driver.findElements(By.xpath("//p"));
        StringBuilder articleText = new StringBuilder();
        for (WebElement paragraph : paragraphs) {
            articleText.append(paragraph.getText())
                    .append(" ");
        }
        return articleText.toString();
    }

    private static void writeSentencesToFile(String text, String fileName, int numSentences) throws IOException {
        String[] sentences = text.split("[.,] ");
        StringBuilder content = new StringBuilder();

        // Get the first numSentences sentences
        for (int i = 0; i < Math.min(numSentences, sentences.length); i++) {
            content.append(sentences[i])
                    .append(". ");
        }

        // Write the sentences to the specified file with UTF-8 encoding
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            writer.write(content.toString());
        }
    }
}