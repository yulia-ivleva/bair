package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage<LandingPage> {
    @FindBy(css = ".account__customer-name")
    private WebElement userTitle;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    protected LandingPage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl + "client/my-account");
    }

    @Override
    protected void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for My account landing page load")
                .until(ExpectedConditions.visibilityOf(userTitle));
    }

    public String getUserTitle() {
        return new WebDriverWait(driver, FIVE_SECONDS)
                .until(ExpectedConditions.visibilityOf(userTitle)).getText();
    }
}
