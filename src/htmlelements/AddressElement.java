package htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

public class AddressElement extends HtmlElement {
    @FindBy(css = "input[name*=firstName]")
    private TextInput firstNameField;

    @FindBy(css = "input[name*=lastName]")
    private TextInput lastNameField;

    @FindBy(css = "input[name*=address1]")
    private TextInput addressField;

    @FindBy(css = "input[name*=city]")
    private TextInput cityField;

    @FindBy(css = "span[name*=states]")
    private TextInput stateDropdown;

    @FindBy(css = "ul[id*=stateSelectBoxItOptions] > li")
    private List<WebElement> states;

    @FindBy(css = "input[name*=postal]")
    private TextInput zipCodeField;

    @FindBy(css = "input[name*=phone]")
    private TextInput phoneNumberField;

    private void clearAndSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void enterFirstName(String firstName) {
        System.out.println("Entering the First name: " + firstName);
        clearAndSendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        System.out.println("Entering the Last name: " + lastName);
        clearAndSendKeys(lastNameField, lastName);
    }

    public void enterAddress(String address) {
        System.out.println("Entering address: " + address);
        clearAndSendKeys(addressField, address);
    }

    public void enterCity(String city) {
        System.out.println("Entering city: " + city);
        clearAndSendKeys(cityField, city);
    }

    public void enterZipCode(String zipCode) {
        System.out.println("Entering zip code: " + zipCode);
        clearAndSendKeys(zipCodeField, zipCode);
    }

    public void openStateDropdown() {
        System.out.println("Opening a state dropdown");
        stateDropdown.click();
    }

    public void selectState(String stateName) {
        System.out.println("Selecting a state " + stateName);
        states.stream().filter(webElement -> webElement.getText().equals(stateName)).findFirst()
                .orElseThrow(() -> new AssertionError("No state with such name")).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        System.out.println("Entering phone number: " + phoneNumber);
        clearAndSendKeys(phoneNumberField, phoneNumber);
    }
}
