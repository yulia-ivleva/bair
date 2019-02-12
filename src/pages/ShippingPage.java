package pages;

import htmlelements.AddressElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.CheckBox;

public class ShippingPage extends HeaderFooter<ShippingPage> {
    @FindBy(css = ".checkout__fields")
    private AddressElement addressElement;

    @FindBy(css = ".checkout__button")
    private WebElement nextToBillingButton;

    @FindBy(css = "label[for~=dwfrm_singleshipping_shippingAddress_useAsBillingAddress]")
    private CheckBox useThisAddressForBillingCheckbox;

    protected ShippingPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        throw new UnsupportedOperationException("No direct url to ".getClass().getSimpleName());
    }

    @Override
    protected WebElement getUniqueElement() {
        return addressElement;
    }

    public ShippingPage enterFirstName(String firstName) {
        addressElement.enterFirstName(firstName);
        return this;
    }

    public ShippingPage enterLastName(String lastName) {
        addressElement.enterLastName(lastName);
        return this;
    }

    public ShippingPage enterAddress(String address) {
        addressElement.enterAddress(address);
        return this;
    }

    public ShippingPage enterCity(String city) {
        addressElement.enterCity(city);
        return this;
    }

    public ShippingPage enterZipCode(String zipCode) {
        addressElement.enterZipCode(zipCode);
        return this;
    }

    public ShippingPage openStateDropdown() {
        addressElement.openStateDropdown();
        return this;
    }

    public ShippingPage selectState(String stateName) {
        addressElement.selectState(stateName);
        return this;
    }

    public ShippingPage enterPhoneNumber(String phoneNumber) {
        addressElement.enterPhoneNumber(phoneNumber);
        return this;
    }

    public ShippingPage selectUseThisAddressForBillingCheckbox() {
        System.out.println("Selecting 'Use this address for billing' checkbox");
        useThisAddressForBillingCheckbox.select();
        return this;
    }

    public BillingPage clickNext() {
        System.out.println("Clicking Next");
        nextToBillingButton.click();
        return new BillingPage(driver, true);
    }

    public boolean isNextToBillingButtonEnabled() {
        return nextToBillingButton.isEnabled();
    }
}
