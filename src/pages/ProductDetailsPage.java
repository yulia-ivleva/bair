package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends HeaderFooter<ProductDetailsPage> {
    @FindBy(css = ".title-set__title")
    private WebElement pdpTitle;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    protected ProductDetailsPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl);
    }

    @Override
    protected void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for pdp load")
                .until(ExpectedConditions.visibilityOf(pdpTitle));
    }

    public String getPdpTitle() {
        return pdpTitle.getText();
    }
}
