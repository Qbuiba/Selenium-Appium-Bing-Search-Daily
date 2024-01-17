package androidbingsearch;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MicrosoftStartPage {

    AppiumDriver driver;

    public MicrosoftStartPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@resource-id=\"com.microsoft.amp.apps.bingnews:id/sa_hp_searchbox_container\"]")
    WebElement searchBoxContainer;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"com.microsoft.amp.apps.bingnews:id/sapphire_search_header_input\"]")
    WebElement searchHeader;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"com.microsoft.amp.apps.bingnews:id/iab_address_bar_text_view\"]")
    WebElement addressBarTextView;

    public void clickSearchContainer() {
        searchBoxContainer.click();
    }

    public void sendkeySearchHeader(String key) {
        searchHeader.sendKeys(key);
    }

    public void clearSearchHeader() {
        searchHeader.clear();
    }

    public void clickAddressBar() {
        addressBarTextView.click();
    }
}
