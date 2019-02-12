package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingPage extends HeaderFooter<BillingPage> {
    @FindBy(css = "input[name=dwfrm_billing_paymentMethods_creditCard_owner]")
    private WebElement nameOnCardField;

    @FindBy(css = ".input-text.creditcard")
    private WebElement cardNumberField;

    @FindBy(css = "#expirationDate")
    private WebElement expirationDateField;

    @FindBy(css = "input[name*=dwfrm_billing_paymentMethods_creditCard_cvn]")
    private WebElement ccvField;

    @FindBy(css = "#dwfrm_billing_billingAddress_email_emailAddress")
    private WebElement emailField;

    @FindBy(css = "button[name=dwfrm_billing_save][type=submit]")
    private WebElement nextButton;

    protected BillingPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        throw new UnsupportedOperationException("No direct url to ".getClass().getSimpleName());
    }

    @Override
    protected WebElement getUniqueElement() {
        return nameOnCardField;
    }

    public BillingPage enterNameOnCard(String nameOnCard) {
        System.out.println("Entering name on card " + nameOnCard);
        clearAndSendKeys(nameOnCardField, nameOnCard);
        return this;
    }

    public BillingPage enterCardNumber(String cardNumber) {
        System.out.println("Entering card number " + cardNumber);
        clearAndSendKeys(cardNumberField, cardNumber);
        return this;
    }

    public BillingPage enterExpirationDate(String expirationDate) {
        System.out.println("Entering expiration date " + expirationDate);
        expirationDateField.click();
        expirationDateField.sendKeys(expirationDate);
        return this;
    }

    public BillingPage enterCcv(String ccv) {
        System.out.println("Entering ccv " + ccv);
        clearAndSendKeys(ccvField, ccv);
        return this;
    }

    public BillingPage enterEmail(String email) {
        System.out.println("Entering the email " + email);
        clearAndSendKeys(emailField, email);
        return this;
    }

    public OrderReviewPage clickNext() {
        System.out.println("Clicking Next");
        new WebDriverWait(driver, FIVE_SECONDS).until(ExpectedConditions.elementToBeClickable(nextButton))
                .click();
        return new OrderReviewPage(driver, true);
    }
}
