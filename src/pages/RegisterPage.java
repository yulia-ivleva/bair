package pages;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends HeaderFooter<RegisterPage> {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    protected RegisterPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {

    }

    @Override
    protected void waitForLoad() {

    }
}
