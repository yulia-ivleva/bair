package tests;

import org.testng.annotations.Test;
import pages.CheckoutLoginPage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutLoginTests extends BaseTest {
    @Test
    public void guestCheckoutButtonIsNotDisplayedForSubscriptionProducts() {
        new ProductDetailsPage(driver).navigateTo()
                .selectFilterSubscriptionCheckbox()
                .selectFirstFilterShippingDate()
                .clickAddToCartButton();
        CheckoutLoginPage checkoutLoginPage = new ShoppingCartPage(driver).navigateTo()
                .clickCheckoutButtonByGuest();
        assertThat("Guest checkout button is displayed", !checkoutLoginPage.isGuestCheckoutButtonDisplayed());
    }
}
