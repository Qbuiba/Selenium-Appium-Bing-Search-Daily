package pages.androidpage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPageAndroid {

    AppiumDriver driver;

    public BingSearchPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"com.microsoft.emmx:id/search_box_text\"]")
    WebElement searchboxHome;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"com.microsoft.emmx:id/url_bar\"]")
    WebElement searchboxHeader;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"sb_form_q\"]")
    WebElement submitForm;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id=\"sb_form_go\"]")
    WebElement submitButton;

    public void clickSearchBoxHome() {
        searchboxHome.click();
    }

    public void sendkeySearchHeader(String strKey) {
        searchboxHeader.sendKeys(strKey);
    }

    public void clearSearchHeader() {
        searchboxHome.clear();
    }

    public void clearSubmitForm() {
        submitForm.clear();
    }

    public void sendkeySubmitForm(String key) {
        submitForm.sendKeys(key);
    }

    public void clickSearchButton() {
        submitButton.click();
    }
}
