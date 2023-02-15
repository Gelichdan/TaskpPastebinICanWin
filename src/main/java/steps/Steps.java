package steps;

import org.openqa.selenium.WebDriver;
import pages.PastebinHomePage;

import java.time.Duration;

public class Steps {
    private WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }
    public PastebinHomePage creatingNewPasteWithParamFromTask(String code, String title) {
        PastebinHomePage home=new PastebinHomePage(driver);
        home.openPage();
        home.getPasteExpirationContainer().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(home.WAIT_TIMEOUT_SEC));
        home.getSelectedTenMinInterval().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        home.getFieldForTitle().sendKeys(title);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        home.getFieldForCode().sendKeys(code);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        home.getCreateButton().submit();
        return home;

    }
}
