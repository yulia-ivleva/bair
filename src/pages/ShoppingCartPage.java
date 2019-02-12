package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends HeaderFooter<ShoppingCartPage> {
    @FindBy(css = ".cart__title")
    private WebElement cartTitle;

    @FindBy(css = ".product__name")
    private WebElement productName;

    @FindBy(css = ".button-tertiary.button-width-l")
    private WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    protected ShoppingCartPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl + "cart");
    }

    @Override
    protected WebElement getUniqueElement() {
        return cartTitle;
    }

    public String getProductName() {
        return productName.getText();
    }

    public CheckoutLoginPage clickCheckoutButtonByGuest() {
        System.out.println("Clicking 'Checkout' button by Guest user");
        checkoutButton.click();
        return new CheckoutLoginPage(driver, true);
    }
}
