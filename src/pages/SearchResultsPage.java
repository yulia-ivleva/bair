package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    protected WebElement getUniqueElement() {
        return searchResultsTile;
    }

    public String getSearchResultsTitle() {
        return searchResultsTile.getText();
    }
}
