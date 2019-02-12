package tests;

import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTests extends BaseTest {
    @Test
    public void productIsAddedToCart() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver).navigateTo()
                .clickAddToCartButton();
        assertThat("Product is not displayed on mini-cart", productDetailsPage.getProductNameOnMiniCart(),
                is("Classic 203 Slim"));
        ShoppingCartPage shoppingCartPage = productDetailsPage.clickCartIcon()
                .clickCheckoutButtonOnMiniCart();
        assertThat("Product is not displayed on cart page", shoppingCartPage.getProductName(),
                is("Classic 203 Slim"));
    }
}
