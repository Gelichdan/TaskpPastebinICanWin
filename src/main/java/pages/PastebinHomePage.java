package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    public WebDriverWait webDriverWait;

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement fieldForCode;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationContainer;
    @FindBy(xpath = "//ul[@role='listbox']/li[3]")
    private WebElement selectedTenMinInterval;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement fieldForTitle;
    @FindBy(xpath = "//button[@class='search_btn']")
    private WebElement createButton;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement pasteHighlightingContainer;
    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']/li[contains(text(), 'Bash')]")
    private WebElement selectedBash;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public WebElement getFieldForCode() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        return webDriverWait.until(ExpectedConditions.visibilityOf(fieldForCode));
    }

    public WebElement getPasteExpirationContainer() {
        return pasteExpirationContainer;
    }

    public WebElement getSelectedTenMinInterval() {
        return selectedTenMinInterval;
    }

    public WebElement getFieldForTitle() {
        return webDriverWait.
                until(ExpectedConditions.visibilityOf(fieldForTitle));
    }

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getPasteHighlightingContainer() {
        return pasteHighlightingContainer;
    }

    public WebElement getSelectedBash() {
        return selectedBash;
    }

    public WebElement waitUntilElementVisible(WebElement webElement) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
