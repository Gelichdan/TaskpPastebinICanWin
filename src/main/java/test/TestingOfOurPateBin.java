package test;

import driver.InitWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;

public class TestingOfOurPateBin {
    private WebDriver driver;

    @BeforeTest
    public void initDriver() {
        driver = InitWebDriver.setWebDriver();

    }

    @Test
    public void testMethod() throws IllegalArgumentException {
        Steps steps = new Steps(driver);
        steps.creatingNewPasteWithParamFromTask(steps.code1, steps.title1);
    }


    @AfterTest
    public void closeDriver() {
        InitWebDriver.stopWebDriver();
    }


}

