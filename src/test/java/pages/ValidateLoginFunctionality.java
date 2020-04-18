package pages;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;


public class ValidateLoginFunctionality extends AbstractTest {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void when_login_expect_homePageIsDisplayed() {
        final HomePage homePage = getHomePage();

        softly.assertThat(homePage.isDashboardLabelDisplayed()).isTrue();
    }
}
