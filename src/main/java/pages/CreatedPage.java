package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedPage extends AbstractPage {

    @FindBy(xpath = "//ol")
    public WebElement textArea;
    @FindBy(xpath = "//div[@class='left']/*[@class='btn -small h_800']")
    public WebElement highLightingIndicator;
    @FindBy(xpath = "//div[@class='info-top']")
    public WebElement titleIndicator;




    public CreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLightingIndicatorForCheck() {
        return highLightingIndicator.getText();

    }
    public String getTextAreaForCheck(){
        return textArea.getText();
    }
    public String getTitleIndicatorForCheck(){
        return titleIndicator.getText();
    }

}
