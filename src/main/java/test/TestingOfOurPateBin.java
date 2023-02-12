package test;

import driver.InitWebDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.PastebinHomePage;
import steps.Steps;

public class TestingOfOurPateBin {
    private WebDriver driver;

    @BeforeTest
    public void initDriver() {
        driver = InitWebDriver.setWebDriver();

    }

    @Test
    public void testMethod() throws IllegalArgumentException{
        PastebinHomePage home = new Steps(driver).
                creatingNewPasteWithParamFromTask("Hello from WebDriver", "helloweb");

    }

    @AfterTest
    public void closeDriver() {
        InitWebDriver.stopWebDriver();
    }


}

