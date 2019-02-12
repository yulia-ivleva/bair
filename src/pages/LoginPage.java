package pages;

import htmlelements.LoginElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HeaderFooter<LoginPage> {
    @FindBy(css = ".gigya-layout-cell.responsive.under-site-login span")
    private WebElement registerLink;

    private LoginElement loginElement;

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
    protected WebElement getUniqueElement() {
        return registerLink;
    }

    public RegisterPage clickRegisterLink() {
        System.out.println("Clicking Register link");
        registerLink.click();
        return new RegisterPage(driver, true);
    }

    public LoginPage enterEmail(String email) {
        loginElement.enterEmail(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        loginElement.enterPassword(password);
        return this;
    }

    public LandingPage clickSignInButton() {
        loginElement.clickSignInButton();
        return new LandingPage(driver, true);
    }
}
