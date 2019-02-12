package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrderConfirmationPage;
import pages.ProductDetailsPage;
import pages.ShippingPage;
import pages.ShoppingCartPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GuestCheckoutTests extends BaseTest {
    private ProductDetailsPage productDetailsPage;
    private static final String ADDRESS = "110 William Street";
    private static final String CITY = "New York";
    private static final String STATE = "New York";
    private static final String ZIP_CODE = "10038";
    private static final String PHONE_NUMBER = "212 353 0200";
    private static String firstName;
    private static String lastName;

    @BeforeClass
    public void fieldsInitialization() {
        firstName = RandomStringUtils.randomAlphabetic(5);
        lastName = RandomStringUtils.randomAlphabetic(5);
    }

    @BeforeMethod
    public void openProductDetailsPage() {
        productDetailsPage = new ProductDetailsPage(driver).navigateTo();
    }

    @Test
    public void orderIsPlacedWithNo3DVisa() {
        String nameOnCard = RandomStringUtils.randomAlphabetic(5);
        String cardNumber = "4111111111111111";
        String expirationDate = "102020";
        String ccv = "737";
        String email = String.format("test00+%s@test.com", RandomStringUtils.randomAlphabetic(3));
        productDetailsPage.clickAddToCartButton();
        OrderConfirmationPage orderConfirmationPage = new ShoppingCartPage(driver).navigateTo()
                .clickCheckoutButtonByGuest()
                .clickGuestCheckoutButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterAddress(ADDRESS)
                .enterCity(CITY)
                .openStateDropdown()
                .selectState(STATE)
                .enterZipCode(ZIP_CODE)
                .enterPhoneNumber(PHONE_NUMBER)
                .selectUseThisAddressForBillingCheckbox()
                .clickNext()
                .enterNameOnCard(nameOnCard)
                .enterCardNumber(cardNumber)
                .enterExpirationDate(expirationDate)
                .enterCcv(ccv)
                .enterEmail(email)
                .clickNext()
                .clickPlaceOrder();
        assertThat("Order is not placed", orderConfirmationPage.getOrderConfirmationTitle(),
                is("Order complete"));
    }

    @Test
    public void nextToBillingButtonStates() {
        productDetailsPage.clickAddToCartButton();
        ShippingPage shippingPage = new ShoppingCartPage(driver).navigateTo()
                .clickCheckoutButtonByGuest()
                .clickGuestCheckoutButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterAddress(ADDRESS)
                .enterCity(CITY)
                .openStateDropdown()
                .selectState(STATE)
                .enterZipCode(ZIP_CODE);
        assertThat("'Next to billing' button is not disabled", !shippingPage.isNextToBillingButtonEnabled());
        shippingPage.enterPhoneNumber(PHONE_NUMBER);
        sleep(1L);
        assertThat("'Next to billing' button is not enabled", shippingPage.isNextToBillingButtonEnabled());
    }
}
