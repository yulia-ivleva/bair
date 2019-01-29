package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import pages.SearchResultsPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultsTests extends BaseTest {
    @Test
    public void searchResultsPageIsOpened() {
        SearchResultsPage searchResultsPage = new Homepage(driver).navigateTo()
                .clickSearchIcon()
                .enterSearchKeyword("filter")
                .clickSearchSubmitButton();
        assertThat("Search results page is not opened", searchResultsPage.getSearchResultsTitle(), is("84 Results"));
    }
}
