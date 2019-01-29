package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends HeaderFooter<SearchResultsPage> {
    @FindBy(css = ".search-results__title")
    private WebElement searchResultsTile;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    protected SearchResultsPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl + "search/?q=filter&lang=en_US");
    }

    @Override
    protected void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for Search results load")
                .until(ExpectedConditions.visibilityOf(searchResultsTile));
    }

    public String getSearchResultsTitle() {
        return searchResultsTile.getText();
    }
}
