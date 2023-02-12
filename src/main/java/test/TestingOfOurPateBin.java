package test;

import driver.InitWebDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AbstractPage;
import pages.PastebinHomePage;

public class TestingOfOurPateBin {

    public static void main(String[] args) {
       WebDriver driver=InitWebDriver.setWebDriver();
        PastebinHomePage home=new PastebinHomePage(driver);
        home.openPage().
                creatingNewPasteWithParamFromTask("Hello from WebDriver","helloWeb" );

    }


}
