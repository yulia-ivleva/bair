package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends HeaderFooter<Homepage> {
    @FindBy(css = ".module__box.ajusttop > .module__title.banner__title-top")
    private WebElement topBannerTitle;

    public Homepage(WebDriver driver) {
        super(driver);
    }

    protected Homepage(WebDriver driver, boolean waitForLoad) {
        super(driver, waitForLoad);
    }

    @Override
    protected void get() {
        driver.get(baseUrl);
    }

    @Override
    protected void waitForLoad() {
        new WebDriverWait(driver, TEN_SECONDS).withMessage("Waiting for homepage load")
                .until(ExpectedConditions.visibilityOf(topBannerTitle));
    }

    public String getTopBannerTitle() {
        return topBannerTitle.getText();
    }
}
