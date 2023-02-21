package test;

import driver.InitWebDriver;
import org.openqa.selenium.WebDriver;
import pages.CreatedPaste;
import pages.PastebinHomePage;

public class Run2 {
    public static void main(String[] args) {
        WebDriver driver=InitWebDriver.setWebDriver();

        driver.get("https://pastebin.com/BYGevEDb");
        CreatedPaste paste=new CreatedPaste(driver);
        String getTextForTetArea=paste.titleIndicator.getText();
        System.out.println(getTextForTetArea);
    }
}
