package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public abstract class BaseRegistrationTest extends BaseTest {

    @BeforeClass
    public void userRegistration() {
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        String email = String.format("test00+%s@test.com", RandomStringUtils.randomAlphabetic(3));
        String password = RandomStringUtils.randomAlphanumeric(7);
        new LoginPage(driver).navigateTo()
                .clickRegisterLink()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmationPassword(password)
                .selectAgeCheckbox()
                .clickCreateAccountButton();
    }
}
