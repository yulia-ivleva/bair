package tests;

import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utils.ConfigurationUtil;

public abstract class BaseLoginTest extends BaseTest {

    @BeforeClass
    public void loginToSite() {
        new LoginPage(driver).navigateTo()
                .enterEmail(ConfigurationUtil.getUserEmail())
                .enterPassword(ConfigurationUtil.getUserPassword())
                .clickSignInButton();
    }
}
