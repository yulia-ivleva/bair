package tests;

import org.testng.annotations.Test;
import pages.ProductDetailsPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDetailsTests extends BaseTest {
    @Test
    public void toolTipTextIsDisplayed() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver).navigateTo();
        assertThat("Tooltip text is not displayed", productDetailsPage.getRoomSizeTooltipContent(),
                is("Room size recommendation calculated according to ANSI/AHAM AC-1"));
    }
}
