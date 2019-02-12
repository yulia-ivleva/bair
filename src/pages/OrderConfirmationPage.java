package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends HeaderFooter<OrderConfirmationPage> {
    @FindBy(css = ".checkout-confirm__title")
    private WebElement orderConfirmationTitle;

    protected OrderConfirmationPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        throw new UnsupportedOperationException("No direct url to ".getClass().getSimpleName());
    }

    @Override
    protected WebElement getUniqueElement() {
        return orderConfirmationTitle;
    }

    public String getOrderConfirmationTitle() {
        return orderConfirmationTitle.getText();
    }
}
