package test;

import driver.InitWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreatedPage;
import pages.PastebinHomePage;

public class TestOfParamMatchesTaskTwo {
    private WebDriver driver;

    @BeforeTest
    public void initDriver() {
        driver = InitWebDriver.setWebDriver();
    }

    @Test
    public void testMethodForTitleMatch() throws InterruptedException {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        CreatedPage createdPage = pastebinHomePage.createPageTaskTwo();
        Assert.assertEquals("how to gain dominance among developers", createdPage.getTitleIndicatorForCheck());
    }

    @Test
    public void testMethodForCodeMatch() throws InterruptedException {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        CreatedPage createdPage = pastebinHomePage.createPageTaskTwo();
        Assert.assertEquals("git config --global user.name  'New Sheriff in Town'\n" +
                "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
                " git push origin master --force", createdPage.getTextAreaForCheck());
    }

    @Test
    public void testMethodForHighlightingMatch() throws InterruptedException {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        CreatedPage createdPage = pastebinHomePage.createPageTaskTwo();
        Assert.assertEquals("BASH", createdPage.getLightingIndicatorForCheck());
    }


    @AfterTest
    public void closeDriver() {
        InitWebDriver.stopWebDriver();
    }
}
