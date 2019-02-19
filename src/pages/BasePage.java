package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import utils.ConfigurationUtil;

public abstract class BasePage<T extends BasePage> {
    protected static final long TEN_SECONDS = 10L;
    protected static final long FIVE_SECONDS = 5L;
    protected String baseUrl = ConfigurationUtil.getBaseUrl();
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    protected BasePage(WebDriver driver, boolean waitForLoad) {
        this(driver);
        if (waitForLoad) {
            waitForLoad();
        }
    }

    @SuppressWarnings("unchecked")
    public final T navigateTo() {
        get();
        new WebDriverWait(driver, FIVE_SECONDS)
                .until(driver -> ((JavascriptExecutor) driver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
        waitForLoad();
        return (T) this;
    }

    protected abstract void get();

    protected abstract WebElement getUniqueElement();

    private void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for " + getClass().getSimpleName() + " load")
                .until(ExpectedConditions.visibilityOf(getUniqueElement()));
    }

    void clearAndSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
