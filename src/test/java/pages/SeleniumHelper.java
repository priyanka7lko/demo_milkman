package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {

    private final WebDriver driver;

    public SeleniumHelper(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibilityOfElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibilityOfElement(final By element) {
        return waitForVisibilityOfElement(driver.findElement(element));
    }
}
