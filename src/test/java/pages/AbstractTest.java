package pages;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractTest {

    private final String url = "https://demo.milkmanapps.com/site/login";
    private final String chromedriverPath = "/Users/priyankaverma/chromedriver/chromedriver";
    private final String appUsername = "prakhar";
    private final String appPassword = "123";
    private WebDriver driver;
    private HomePage homePage;
    private SeleniumHelper helper;

    @Before
    public void createDriverAndOpenBrowser() {
        if (driver == null) {
            createDriver();
        }
        openBrowser();
        homePage = loginWithGivenCredentials(appUsername, appPassword);
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

    public HomePage loginWithGivenCredentials(final String username, final String password) {
        helper = new SeleniumHelper(driver);
        helper.waitForVisibilityOfElement(By.xpath("//h4[contains(text(),'Mr. Milkman')]"));
        LoginPage loginPage = getLoginPage();
        return loginPage.login(username, password);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(helper);
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
