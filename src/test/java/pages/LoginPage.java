package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class LoginPage {

    private final WebDriver driver;
    private final SeleniumHelper helper;

    @FindBy(id = "loginform-username")
    private WebElement usernameInput;
    @FindBy(id = "loginform-password")
    private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement proceedButton;

    public LoginPage(final SeleniumHelper helper) {
        this.helper = helper;
        this.driver = helper.getDriver();
        final WebElement rootElement = helper.waitForVisibilityOfElement(By.className("site-login"));
        PageFactory.initElements(new DefaultElementLocatorFactory(rootElement), this);
    }

    public HomePage login(final String username, final String password) {
        setUsername(username);
        setPassword(password);
        return clickProceed();
    }

    public LoginPage setUsername(final String username) {
        helper.input(usernameInput, username);
        return this;
    }

    public LoginPage setPassword(final String password) {
        helper.input(passwordInput, password);
        return this;
    }

    public HomePage clickProceed() {
        helper.click(proceedButton);
        //helper.waitFor(2000);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return new HomePage(helper);
    }
}
