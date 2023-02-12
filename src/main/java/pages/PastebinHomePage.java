package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement fieldForCode;
    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-expiration-container']/span[@role='presentation']")
    private WebElement pasteExpirationContainer;
    @FindBy(xpath = "//*[@id='postform-expiration']")
    private WebElement selectedTenMinInterval;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement fieldForTitle;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(2));
        return this;
    }

    private void pasteCode(String code) {
        fieldForCode.sendKeys(code);
    }

    private void pasteTitle(String title) {
        fieldForTitle.sendKeys(title);
    }

    public PastebinHomePage creatingNewPasteWithParamFromTask(String code, String title) {
        pasteCode(code);
        pasteTitle(title);
        pasteExpirationContainer.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT_SEC));

        Select select=new Select(selectedTenMinInterval);
        select.selectByVisibleText("10 Minutes");
        pasteExpirationContainer.click();




        return this;

    }
}
