package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListingPage extends HeaderFooter<ProductListingPage> {
    @FindBy(css = ".js-refinement-link.refinement__link.link-no-event[title='Sorted by Lowest']")
    private WebElement lowestSorting;

    @FindBy(css = ".product-sales-price")
    private List<WebElement> productPrices;

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    protected ProductListingPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl + "air-purifiers/");
    }

    @Override
    protected WebElement getUniqueElement() {
        return lowestSorting;
    }

    public ProductListingPage clickLowestSorting() {
        System.out.println("Clicking Lowest sorting");
        lowestSorting.click();
        return this;
    }

    public List<Double> getPrices() {
        return new WebDriverWait(driver, FIVE_SECONDS).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(productPrices))
                .stream().map(WebElement::getText).map(s -> s.replace("$", ""))
                .map(s -> s.replace(",", "")).map(Double::new)
                .collect(Collectors.toList());
    }
}
