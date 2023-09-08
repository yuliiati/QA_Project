import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ResetPasswordPage {

    private SelenideElement resetPasswordPageLink = $(byXpath("//title[contains(text(), 'Forgot password')]"));

    public void urlIsCorrect(){
        assertTrue(WebDriverRunner.getWebDriver().
                getCurrentUrl().contains("forgot-password"));
    }
//    public void resetPasswordFormOpened(){
//        resetPasswordPageLink.shouldHave(text("Please, enter your email to restore your password"));
//    }




}
