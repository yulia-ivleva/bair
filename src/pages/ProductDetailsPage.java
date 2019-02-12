package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import utils.ConfigurationUtil;

public class ProductDetailsPage extends HeaderFooter<ProductDetailsPage> {
    @FindBy(css = ".title-set__title")
    private WebElement pdpTitle;

    @FindBy(css = ".js-addtocart-btn")
    private WebElement addToCartButton;

    @FindBy(css = ".spare__subscription")
    private CheckBox filterSubscriptionCheckbox;

    @FindBy(css = ".js-subscription-datefrom")
    private WebElement firstFilterShippingDateField;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    protected ProductDetailsPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(ConfigurationUtil.getPdpUrl());
    }

    @Override
    protected WebElement getUniqueElement() {
        return pdpTitle;
    }

    public String getPdpTitle() {
        return pdpTitle.getText();
    }

    public ProductDetailsPage clickAddToCartButton() {
        System.out.println("Clicking 'Add to cart' button");
        addToCartButton.click();
        return this;
    }

    public ProductDetailsPage selectFilterSubscriptionCheckbox() {
        System.out.println("Selecting 'Filter subscription' checkbox");
        filterSubscriptionCheckbox.select();
        return this;
    }

    public ProductDetailsPage selectFirstFilterShippingDate() {
        System.out.println("Selecting the first filter shipping Date");
        firstFilterShippingDateField.sendKeys(Keys.ENTER);
        return this;
    }
}
