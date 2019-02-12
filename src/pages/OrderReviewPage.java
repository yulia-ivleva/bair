package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderReviewPage extends HeaderFooter<OrderReviewPage> {
    @FindBy(css = ".checkout-summary__title")
    private WebElement orderReviewTitle;

    @FindBy(css = "button[name=submit]")
    private WebElement placeOrderButton;

    protected OrderReviewPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        throw new UnsupportedOperationException("No direct url to ".getClass().getSimpleName());
    }

    @Override
    protected WebElement getUniqueElement() {
        return orderReviewTitle;
    }

    public OrderConfirmationPage clickPlaceOrder() {
        System.out.println("Clicking 'Place order'");
        placeOrderButton.click();
        return new OrderConfirmationPage(driver, true);
    }
}
