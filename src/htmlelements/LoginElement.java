package htmlelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Login form")
@FindBy(css = "#gigya-login-form")
public class LoginElement extends HtmlElement {
    @FindBy(css = "input[name=username][data-screenset-roles=instance]")
    private TextInput emailField;

    @FindBy(css = "input[name=password][data-screenset-roles=instance]")
    private TextInput passwordField;

    @FindBy(css = "input[type=submit][data-screenset-roles=instance]")
    private Button signInButton;

    public void enterEmail(String email) {
        System.out.println("Entering email: " + email);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        System.out.println("Entering password: " + password);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        System.out.println("Clicking 'Sign in' button");
        signInButton.click();
    }
}
