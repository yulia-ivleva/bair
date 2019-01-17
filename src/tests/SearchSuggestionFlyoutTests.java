package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.ProductDetailsPage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSuggestionFlyoutTests extends BaseTest {
    private Homepage homepage;

    @BeforeMethod
    public void openHomepage() {
        homepage = new Homepage(driver).navigateTo();
    }

    @Test
    public void searchSuggestionFlyoutText() {
        homepage.clickSearchIcon()
                .enterSearchKeyword("blueair");
        assertThat("Search Flyout is not opened", homepage.getSuggestedResultsTitle(), is("Suggested Results"));
    }

    @Test
    public void getSearchSuggestions() {
        homepage.clickSearchIcon()
                .enterSearchKeyword("blue 121 particle");
        List<String> expectedSuggestions = Arrays.asList("Blue Pure 121 Particle and Carbon Filter", "Blue in Air purifiers",
                "Blue Filters in Filters", "How can I get the most of my Blue product?",
                "How small is a micron and why does it matter?");
        assertThat("Search suggestion elements are wrong",
                homepage.getSearchSuggestions(), is(expectedSuggestions));
    }

    @Test
    public void clickSearchSuggestion() {
        String productTitle = "Blue Pure 121 Particle and Carbon Filter";
        ProductDetailsPage productDetailsPageTitle = homepage.clickSearchIcon()
                .enterSearchKeyword("blue 121 particle")
                .clickSearchSuggestion(productTitle);
        assertThat("Wrong product title on PDP",
                productDetailsPageTitle.getPdpTitle(), is(productTitle));
    }
}
