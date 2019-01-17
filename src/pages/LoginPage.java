package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends HeaderFooter<LoginPage> {
    @FindBy(css = ".gigya-layout-cell.responsive.under-site-login span")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected LoginPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl + "client/login");
    }

    @Override
    protected void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for login page load")
                .until(ExpectedConditions.visibilityOf(registerLink));
    }

    public RegisterPage clickRegisterLink() {
        System.out.println("Clicking Register link");
        registerLink.click();
        return new RegisterPage(driver, true);
    }
}
