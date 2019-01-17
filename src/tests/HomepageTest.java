package tests;

import org.testng.annotations.Test;
import pages.Homepage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomepageTest extends BaseTest {

    @Test
    public void topBannerIsDisplayed() {
        String topBannerTitle = new Homepage(driver).navigateTo()
                .getTopBannerTitle();
        assertThat("Wrong top banner title", topBannerTitle, is("Best-in-class performance"));
    }
}
