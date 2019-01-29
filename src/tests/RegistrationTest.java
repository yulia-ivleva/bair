package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.RegisterPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {
        loginPage = new LoginPage(driver).navigateTo();
    }

    @Test
    public void userRegistration() {
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        String email = String.format("test00+%s@test.com", RandomStringUtils.randomAlphabetic(3));
        String password = RandomStringUtils.randomAlphanumeric(7);
        LandingPage landingPage = loginPage.clickRegisterLink()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmationPassword(password)
                .selectAgeCheckbox()
                .clickCreateAccountButton();
        assertThat("User is not registered", landingPage.getUserTitle(), is(firstName + " " + lastName));
    }

    @Test
    public void registrationAlreadyRegisteredUser() {
        RegisterPage registerPage = loginPage.clickRegisterLink()
                .enterEmail("test@test.com");
        assertThat("Error message is not displayed", registerPage.getAlreadyExistingEmailError(), is("Email already exists"));
    }
}
