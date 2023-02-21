package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static Constants.Constants.CODE_TASK_ONE;
import static Constants.Constants.TITLE_TASK_ONE;

public class PastebinHomePage extends AbstractPage {

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
        driver.get("https://pastebin.com/");
    }


    public void insertCodeInFieldForCode(String code) {
        fieldForCode.sendKeys(code);
    }
    public void insertTitleinFielfForTitle(String title){
        fieldForTitle.sendKeys(title);
    }
    public void selectTenMinInterval(){
        pasteExpirationContainer.click();
        selectedTenMinInterval.click();
    }
    public CreatedPage createPageTaskOne(){
        insertTitleinFielfForTitle(TITLE_TASK_ONE);
        insertCodeInFieldForCode(CODE_TASK_ONE);
        selectTenMinInterval();
        createButton.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return new CreatedPage(driver);

    }


}

