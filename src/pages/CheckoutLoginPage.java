package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutLoginPage extends HeaderFooter<CheckoutLoginPage> {
    @FindBy(css = ".gigya-box-title[data-screenset-roles='template,instance,instance']")
    private WebElement checkoutLoginFormTitle;

    @FindBy(css = "button[name=dwfrm_login_unregistered]")
    private WebElement guestCheckoutButton;

    protected CheckoutLoginPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        throw new UnsupportedOperationException("No direct url to ".getClass().getSimpleName());
    }

    @Override
    protected WebElement getUniqueElement() {
        return checkoutLoginFormTitle;
    }

    public boolean isGuestCheckoutButtonDisplayed() {
        return isElementDisplayed(guestCheckoutButton);
    }

    public ShippingPage clickGuestCheckoutButton() {
        System.out.println("Clicking 'Guest checkout' button");
        guestCheckoutButton.click();
        return new ShippingPage(driver, true);
    }
}
