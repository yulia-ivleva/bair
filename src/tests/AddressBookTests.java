package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pages.AddressBookPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookTests extends BaseRegistrationTest {

    @Test
    public void addNewAddress() {
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        String address = "110 William Street";
        String city = "New York";
        String state = "New York";
        String zipCode = "10038";
        String phoneNumber = "212 353 0200";
        AddressBookPage addressBookPage = new AddressBookPage(driver).navigateTo()
                .clickAddNewAddressButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterAddress(address)
                .enterCity(city)
                .openStateDropdown()
                .selectState(state)
                .enterZipCode(zipCode)
                .enterPhoneNumber(phoneNumber)
                .clickSaveAddressButton();
        assertThat("New address is not saved", addressBookPage.getAddressName(), is(firstName + " " + lastName));
    }
}
