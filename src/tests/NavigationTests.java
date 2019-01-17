package tests;

import org.testng.annotations.Test;
import pages.Homepage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NavigationTests extends BaseTest {

    @Test
    public void getNavigationMenuTitles() {
        Homepage homepage = new Homepage(driver).navigateTo();
        List<String> expectedCategories = Arrays.asList("Air purifiers", "Filters", "Air monitors", "Customer support");
        assertThat("Categories titles are wrong", homepage.getNavigationCategories(), is(expectedCategories));
    }
}
