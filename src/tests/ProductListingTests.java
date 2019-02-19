package tests;

import org.testng.annotations.Test;
import pages.ProductListingPage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductListingTests extends BaseTest {
    @Test
    public void productsAreSortedFromLowestToHighest() {
        ProductListingPage productListingPage = new ProductListingPage(driver).navigateTo()
                .clickLowestSorting();
        List<Double> actualPrices = productListingPage.getPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Double::compareTo);
        assertThat("Products are not sorted from lowest to highest price", actualPrices, is(expectedPrices));
    }
}
