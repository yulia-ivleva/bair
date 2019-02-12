package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class HeaderFooter<T extends HeaderFooter> extends BasePage<T> {
    @FindBy(css = ".main-nav__list.level-1>li")
    private List<WebElement> navigationMenu;

    @FindBy(css = ".page-nav__search")
    private WebElement searchIcon;

    @FindBy(css = ".page-search__field")
    private WebElement searchField;

    @FindBy(css = ".search-phrase")
    private WebElement suggestedResultsTitle;

    @FindBy(css = ".product-name,.hit")
    private List<WebElement> suggestedResults;

    @FindBy(css = "#search-suggestions")
    private WebElement searchSuggestionsBlock;

    @FindBy(css = ".utility-menu__link--account ")
    private WebElement myAccountIcon;

    @FindBy(css = ".page-search__button")
    private WebElement searchSubmitButton;

    @FindBy(css = ".mini-cart__total")
    private WebElement cartIcon;

    @FindBy(css = ".button-tertiary.minicart-checkout")
    private WebElement checkoutButtonOnMiniCart;

    @FindBy(css = ".mini-cart__product-name")
    private WebElement productNameOnMiniCart;

    protected HeaderFooter(WebDriver driver) {
        super(driver);
    }

    protected HeaderFooter(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    public List<String> getNavigationCategories() {
        List<String> list = new LinkedList<>();
        for (WebElement menuItem : navigationMenu) {
            String text = menuItem.getText();
            list.add(text);
        }
        return list;
    }

    public HeaderFooter clickNavigationCategory(String name) {
        System.out.println("Clicking navigation category " + name);
        for (WebElement menuItem : navigationMenu) {
            String text = menuItem.getText();
            if (text.equals(name)) {
                menuItem.click();
                return this;
            }
        }
        throw new AssertionError("No category with name: " + name);
    }

    public List<String> getNavigationCategories8() {
        return navigationMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public HeaderFooter clickNavigationCategory8(String name) {
        System.out.println("Clicking navigation category " + name);
        navigationMenu.stream().filter(webElement -> webElement.getText().equals(name)).findFirst()
                .orElseThrow(() -> new AssertionError("No category with name: " + name)).click();
        return this;
    }

    @SuppressWarnings("unchecked")
    public T clickSearchIcon() {
        System.out.println("Clicking the Search icon");
        searchIcon.click();
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T enterSearchKeyword(String searchKeyword) {
        System.out.println("Entering the Search keyword " + searchKeyword);
        enterTextByCharacter(searchKeyword, searchField);
        return (T) this;
    }

    private void enterTextByCharacter(String text, WebElement element) {
        char[] chars = text.toCharArray();
        for (Character x : chars) {
            element.sendKeys(x.toString());
        }
    }

    public SearchResultsPage clickSearchSubmitButton() {
        System.out.println("Clicking the Search submit button");
        searchSubmitButton.click();
        return new SearchResultsPage(driver, true);
    }

    public String getSuggestedResultsTitle() {
        return new WebDriverWait(driver, TEN_SECONDS).until(ExpectedConditions.visibilityOf(suggestedResultsTitle))
                .getText();
    }

    public List<String> getSearchSuggestions() {
        return new WebDriverWait(driver, FIVE_SECONDS).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(suggestedResults))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public ProductDetailsPage clickSearchSuggestion(String name) {
        System.out.println("Clicking search suggestion " + name);
        new WebDriverWait(driver, FIVE_SECONDS).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(suggestedResults));
        suggestedResults.stream().filter(webElement -> webElement.getText().equals(name)).findFirst()
                .orElseThrow(() -> new AssertionError("No suggestion with name: " + name)).click();
        return new ProductDetailsPage(driver, true);
    }

    public LoginPage clickMyAccountIcon() {
        System.out.println("Clicking 'My account' icon");
        myAccountIcon.click();
        return new LoginPage(driver, true);
    }

    @SuppressWarnings("unchecked")
    public T clickCartIcon() {
        System.out.println("Clicking the Cart icon");
        cartIcon.click();
        return (T) this;
    }

    public ShoppingCartPage clickCheckoutButtonOnMiniCart() {
        System.out.println("Clicking Checkout button on mini-cart");
        checkoutButtonOnMiniCart.click();
        return new ShoppingCartPage(driver, true);
    }

    public String getProductNameOnMiniCart() {
        return new WebDriverWait(driver, FIVE_SECONDS).until(ExpectedConditions.visibilityOf(productNameOnMiniCart))
                .getText();
    }
}
