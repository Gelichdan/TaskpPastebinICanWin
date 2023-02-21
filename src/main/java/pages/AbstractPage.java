package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    WebDriver driver;

    protected abstract void openPage();

    public long WAIT_TIMEOUT_SEC = 5;


    AbstractPage(WebDriver driver) {
        this.driver = driver;

    }
}
