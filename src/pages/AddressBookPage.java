package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends HeaderFooter<AddressBookPage> {
    @FindBy(css = ".button-icon-plus")
    private WebElement addNewAddressButton;

    @FindBy(css = ".miniaddress__name")
    private WebElement addressName;

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    protected AddressBookPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl + "client/addresses/");
    }

    @Override
    protected WebElement getUniqueElement() {
        return addNewAddressButton;
    }

    public NewAddressPage clickAddNewAddressButton() {
        System.out.println("Clicking 'Add new address' button");
        addNewAddressButton.click();
        return new NewAddressPage(driver, true);
    }

    public String getAddressName() {
        return addressName.getText();
    }
}
