package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.CheckBox;

public class RegisterPage extends HeaderFooter<RegisterPage> {
    @FindBy(css = "input[name='profile.firstName'][data-screenset-roles=instance]")
    private WebElement firstNameField;

    @FindBy(css = "input[name='profile.lastName'][data-screenset-roles=instance]")
    private WebElement lastNameField;

    @FindBy(css = "input[name=email][data-screenset-roles=instance]")
    private WebElement emailField;

    @FindBy(css = "input[name=password][data-screenset-roles=instance]")
    private WebElement passwordField;

    @FindBy(css = "input[name=passwordRetype][data-screenset-roles=instance]")
    private WebElement confirmPasswordField;

    @FindBy(css = ".pt_account .gigya-age-consent")
    private CheckBox ageCheckbox;

    @FindBy(css = ".gigya-input-submit[data-screenset-roles=instance]")
    private WebElement createAccountButton;

    @FindBy(css = ".gigya-error-msg.gigya-error-msg-active[data-screenset-roles=instance]")
    private WebElement alreadyExistingEmailError;

    protected RegisterPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        throw new UnsupportedOperationException("No direct url to ".getClass().getSimpleName());
    }

    @Override
    protected WebElement getUniqueElement() {
        return firstNameField;
    }

    public RegisterPage enterFirstName(String firstName) {
        System.out.println("Entering the First name: " + firstName);
        clearAndSendKeys(firstNameField, firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        System.out.println("Entering the Last name: " + lastName);
        clearAndSendKeys(lastNameField, lastName);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        System.out.println("Entering email: " + email);
        clearAndSendKeys(emailField, email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        System.out.println("Entering password: " + password);
        clearAndSendKeys(passwordField, password);
        return this;
    }

    public RegisterPage enterConfirmationPassword(String confirmationPassword) {
        System.out.println("Entering confirmation password: " + confirmationPassword);
        clearAndSendKeys(confirmPasswordField, confirmationPassword);
        return this;
    }

    public RegisterPage selectAgeCheckbox() {
        System.out.println("Selecting 'Age' checkbox");
        ageCheckbox.select();
        return this;
    }

    public LandingPage clickCreateAccountButton() {
        System.out.println("Clicking 'Create account' button");
        createAccountButton.click();
        return new LandingPage(driver, true);
    }

    public String getAlreadyExistingEmailError() {
        return new WebDriverWait(driver, FIVE_SECONDS).until(ExpectedConditions.visibilityOf(alreadyExistingEmailError))
                .getText();
    }
}
