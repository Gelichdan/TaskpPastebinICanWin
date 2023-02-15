package test;

import driver.InitWebDriver;
import org.openqa.selenium.WebDriver;
import pages.PastebinHomePage;
import steps.Steps;

public class ClassRun {


    public static void main(String[] args) {
        WebDriver driver = InitWebDriver.setWebDriver();
        PastebinHomePage home=new PastebinHomePage(driver);
        Steps steps=new Steps(driver);
        steps.creatingNewPasteWithParamFromTask("Hello from WebDriver","helloweb" );

    }


}