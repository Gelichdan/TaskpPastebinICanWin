package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    public WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

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

    public PastebinHomePage(WebDriver driver) {
        super(driver);

    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(2));
        return this;
    }

    public WebElement getFieldForCode() {
        return webDriverWait.until(ExpectedConditions.visibilityOf(fieldForCode));
    }

    public WebElement getPasteExpirationContainer() {
        return pasteExpirationContainer;
    }

    public WebElement getSelectedTenMinInterval() {
        return selectedTenMinInterval;
    }

    public WebElement getFieldForTitle() {
        return webDriverWait.until(ExpectedConditions.visibilityOf(fieldForTitle));
    }

    public WebElement getCreateButton() {
        return createButton;
    }
}
