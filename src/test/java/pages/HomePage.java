package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class HomePage {

    private final SeleniumHelper helper;

    @FindBy(xpath = "//h3[contains(text(),'Dashboard')]")
    private WebElement dashboardLabel;

    public HomePage(final SeleniumHelper helper) {
        this.helper = helper;
        final WebElement rootElement = helper.waitForVisibilityOfElement(By.id("app"));
        PageFactory.initElements(new DefaultElementLocatorFactory(rootElement), this);
    }

    public boolean isDashboardLabelDisplayed() {
        return helper.isDisplayed(dashboardLabel);
    }
}
