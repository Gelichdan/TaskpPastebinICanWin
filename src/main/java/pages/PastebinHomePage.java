package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.*;

public class PastebinHomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement fieldForCode;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']//following-sibling::*")
    private WebElement pasteExpirationContainer;
    @FindBy(xpath = "//ul[@role='listbox']/li[3]")
    private WebElement selectedTenMinInterval;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement fieldForTitle;
    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createButton;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']//following-sibling::*")
    private WebElement pasteHighlightingContainer;
    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']/li[contains(text(), 'Bash')]")
    private WebElement selectedBash;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://pastebin.com/");
    }


    public void insertCodeInFieldForCode(String code) {
        fieldForCode.sendKeys(code);
    }

    public void insertTitleInFieldForTitle(String title) {
        fieldForTitle.sendKeys(title);
    }

    public void selectTenMinInterval() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(pasteExpirationContainer)).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(selectedTenMinInterval)).click();
    }

    public CreatedPage createPageTaskOne() throws InterruptedException {
        insertTitleInFieldForTitle(TITLE_TASK_ONE);
        insertCodeInFieldForCode(CODE_TASK_ONE);
        selectTenMinInterval();
        createButton.submit();
        Thread.sleep(11000);
        return new CreatedPage(driver);

    }

    public void selectBashInHighlighting() {
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(pasteHighlightingContainer)).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(selectedBash)).click();
    }

    public CreatedPage createPageTaskTwo() throws InterruptedException {
        insertTitleInFieldForTitle(TITLE_TASK_TWO);
        insertCodeInFieldForCode(CODE_TASK_TWO);
        selectTenMinInterval();
        selectBashInHighlighting();
        createButton.submit();
        Thread.sleep(11000);
        return new CreatedPage(driver);
    }

}

