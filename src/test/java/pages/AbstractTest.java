package pages;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SeleniumHelper;

public class AbstractTest {

    private final String url = "https://demo.milkmanapps.com/site/login";
    private final String chromedriverPath = "/Users/priyankaverma/chromedriver/chromedriver";
    private WebDriver driver;
    private SeleniumHelper helper;

    @Before
    public void before() {
        if (driver == null) {
            createDriver();
        }
        openBrowser();
    }

    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        driver = new ChromeDriver();
    }

    public void openBrowser() {
        String windowHandle = driver.getWindowHandle();
        driver.get(url);
        driver.manage().window().maximize();
        driver.switchTo().window(windowHandle);
    }

    private void login() {
        helper = new SeleniumHelper(driver);
        helper.waitForVisibilityOfElement(By.xpath("//h4[contains(text(),'Mr. Milkman')]"));
    }
}
