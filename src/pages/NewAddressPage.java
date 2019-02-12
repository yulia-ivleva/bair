package pages;

import htmlelements.AddressElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAddressPage extends HeaderFooter<NewAddressPage> {
    @FindBy(css = ".button-tertiary")
    private WebElement saveAddressButton;

    @FindBy(css = ".account__address-detail__form")
    private AddressElement addressElement;

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
    protected WebElement getUniqueElement() {
        return saveAddressButton;
    }

    public NewAddressPage enterFirstName(String firstName) {
        addressElement.enterFirstName(firstName);
        return this;
    }

    public NewAddressPage enterLastName(String lastName) {
        addressElement.enterLastName(lastName);
        return this;
    }

    public NewAddressPage enterAddress(String address) {
        addressElement.enterAddress(address);
        return this;
    }

    public NewAddressPage enterCity(String city) {
        addressElement.enterCity(city);
        return this;
    }

    public NewAddressPage enterZipCode(String zipCode) {
        addressElement.enterZipCode(zipCode);
        return this;
    }

    public NewAddressPage openStateDropdown() {
        addressElement.openStateDropdown();
        return this;
    }

    public NewAddressPage selectState(String stateName) {
        addressElement.selectState(stateName);
        return this;
    }

    public NewAddressPage enterPhoneNumber(String phoneNumber) {
        addressElement.enterPhoneNumber(phoneNumber);
        return this;
    }

    public AddressBookPage clickSaveAddressButton() {
        System.out.println("Clicking 'Save address' button");
        saveAddressButton.click();
        return new AddressBookPage(driver, true);
    }
}
