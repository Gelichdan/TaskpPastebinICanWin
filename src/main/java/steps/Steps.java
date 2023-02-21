package steps;

import org.openqa.selenium.WebDriver;
import pages.CreatedPaste;
import pages.PastebinHomePage;

import java.time.Duration;

public class Steps {
    public String title1="helloweb";
    public String code1="Hello from WebDriver";
    private WebDriver driver;
    public String code2="git config --global user.name  'New Sheriff in Town'\n" +
            "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
            "git push origin master --force";
    public String title2="how to gain dominance among developers";
    public String highlighting="Bash";
    CreatedPaste paste;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public CreatedPaste creatingNewPasteWithParamFromTask(String code, String title) {
        this.code1=code;
        this.title1=title;
        PastebinHomePage home = new PastebinHomePage(driver);
        home.openPage();
        home.getPasteExpirationContainer().click();
        home.waitUntilElementVisible(home.getSelectedTenMinInterval()).click();
        home.getFieldForCode().sendKeys(code);
        home.getCreateButton().submit();


        return paste;

    }

    public CreatedPaste creatingPasteWithParamOfSecondTask(String code, String title) {
        this.code2 = code;
        this.title2 = title;
        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.openPage();
        homePage.getFieldForCode().sendKeys(code);
        homePage.getFieldForTitle().sendKeys(title);
        homePage.getPasteExpirationContainer().click();
        homePage.getSelectedTenMinInterval().click();
        homePage.waitUntilElementVisible(homePage.getPasteHighlightingContainer()).click();
        homePage.waitUntilElementVisible(homePage.getSelectedBash()).click();
        homePage.getCreateButton().submit();
        paste=new CreatedPaste(driver);
        return paste;


    }
}
