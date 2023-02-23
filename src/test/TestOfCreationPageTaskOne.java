package test;

import driver.InitWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreatedPage;
import pages.PastebinHomePage;



public class TestOfCreationPageTaskOne {
    private WebDriver driver;

    @BeforeTest
    public void initDriver() {
        driver = InitWebDriver.setWebDriver();

    }

    @Test
    public void testMethod() throws IllegalArgumentException, InterruptedException {
        PastebinHomePage pastebinHomePage=new PastebinHomePage(driver);
        CreatedPage createdPage=pastebinHomePage.createPageTaskOne();
        Assert.assertEquals("helloweb", createdPage.getTitleIndicatorForCheck());
    }


    @AfterTest
    public void closeDriver() {
        InitWebDriver.stopWebDriver();
    }


}

