package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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

    public WebDriver getDriver() {
        return driver;
    }

    public void input(final WebElement input, final String text) {
        new WebDriverWait(driver, 20).ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                .until((ExpectedCondition<Boolean>) webDriver -> {
                    click(input);
                    input.clear();
                    input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    input.sendKeys(Keys.DELETE);
                    input.sendKeys(Keys.TAB);
                    click(input);
                    input.sendKeys(text);
                    return input.getAttribute("value").equals(text);
                });
    }

    public void click(final WebElement element) {
        new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(WebDriverException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element),
                        ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    public boolean isDisplayed(final WebElement element) {
        return isDisplayed(element, 5);
    }

    public boolean isDisplayed(final WebElement element, final long timeOutInSeconds) {
        try {
            new WebDriverWait(driver, timeOutInSeconds).pollingEvery(200, TimeUnit.MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitFor(final long timeoutInMS) {
        try {
            wait(timeoutInMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
