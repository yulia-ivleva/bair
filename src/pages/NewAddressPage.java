package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewAddressPage extends HeaderFooter<NewAddressPage> {
    @FindBy(css = "#dwfrm_profile_address_firstName")
    private WebElement firstNameField;

    @FindBy(css = "#dwfrm_profile_address_lastName")
    private WebElement lastNameField;

    @FindBy(css = "#dwfrm_profile_address_address1")
    private WebElement addressField;

    @FindBy(css = "#dwfrm_profile_address_city")
    private WebElement cityField;

    @FindBy(css = "#dwfrm_profile_address_states_stateSelectBoxIt")
    private WebElement stateDropdown;

    @FindBy(css = "#dwfrm_profile_address_states_stateSelectBoxItOptions > li")
    private List<WebElement> states;

    @FindBy(css = "#dwfrm_profile_address_postal")
    private WebElement zipCodeField;

    @FindBy(css = "#dwfrm_profile_address_phone")
    private WebElement phoneNumberField;

    @FindBy(css = ".button-tertiary")
    private WebElement saveAddressButton;

    public NewAddressPage(WebDriver driver) {
        super(driver);
    }

    protected NewAddressPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl);
    }

    @Override
    protected void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for New address page load")
                .until(ExpectedConditions.visibilityOf(saveAddressButton));
    }

    public NewAddressPage enterFirstName(String firstName) {
        System.out.println("Entering the First name: " + firstName);
        clearAndSendKeys(firstNameField, firstName);
        return this;
    }

    public NewAddressPage enterLastName(String lastName) {
        System.out.println("Entering the Last name: " + lastName);
        clearAndSendKeys(lastNameField, lastName);
        return this;
    }

    public NewAddressPage enterAddress(String address) {
        System.out.println("Entering address: " + address);
        clearAndSendKeys(addressField, address);
        return this;
    }

    public NewAddressPage enterCity(String city) {
        System.out.println("Entering city: " + city);
        clearAndSendKeys(cityField, city);
        return this;
    }

    public NewAddressPage enterZipCode(String zipCode) {
        System.out.println("Entering zip code: " + zipCode);
        clearAndSendKeys(zipCodeField, zipCode);
        return this;
    }

    public NewAddressPage openStateDropdown() {
        System.out.println("Opening a state dropdown");
        stateDropdown.click();
        return this;
    }

    public NewAddressPage selectState(String stateName) {
        System.out.println("Selecting a state " + stateName);
        states.stream().filter(webElement -> webElement.getText().equals(stateName)).findFirst()
                .orElseThrow(() -> new AssertionError("No state with such name")).click();
        return this;
    }

    public NewAddressPage enterPhoneNumber(String phoneNumber) {
        System.out.println("Entering phone number: " + phoneNumber);
        clearAndSendKeys(phoneNumberField, phoneNumber);
        return this;
    }

    public AddressBookPage clickSaveAddressButton() {
        System.out.println("Clicking 'Save address' button");
        saveAddressButton.click();
        return new AddressBookPage(driver, true);
    }
}
