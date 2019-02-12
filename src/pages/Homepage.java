package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        driver.get(baseUrl + "home");
    }

    @Override
    protected WebElement getUniqueElement() {
        return topBannerTitle;
    }

    public String getTopBannerTitle() {
        return topBannerTitle.getText();
    }
}
