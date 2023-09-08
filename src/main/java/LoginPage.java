import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertTrue;

public class LoginPage {

    private SelenideElement emailField = $(By.cssSelector("[name='email']"));
    private SelenideElement passwordField = $(By.cssSelector("[name='password']"));
    private SelenideElement loginButton = $(By.xpath("//*[@id='sw-sign-in-submit-btn']"));
    private SelenideElement mainSignInButton = $$(By.xpath("//a[contains(@href, 'sign-in')]")).get(0);
    private SelenideElement signInAttributes = $(By.xpath("//*[@id='signin']"));
    private SelenideElement forgotPasswordLink = $(By.xpath("//a[normalize-space()='Forgot password']"));
    private SelenideElement errorMessage = $(byXpath("//div[contains(@class,'error-message login-error d-block')]"));
    private SelenideElement logo = $(By.xpath("//img[contains(@src, '18b8b7679a6c.svg')]"));
    private SelenideElement kovalItLink = $(byXpath("//a[contains(@href,'figma.com')]"));
    private SelenideElement facebookLink = $(byXpath("//a[contains(@href,'facebook.com')]"));
    private SelenideElement twitterLink = $(byXpath("//a[contains(@href,'twitter.com')]"));
    private SelenideElement instagramLink = $(byXpath("//a[contains(@href,'instagram.com')]"));


    public void pushTheMainSignInButton(){
        mainSignInButton.shouldBe(visible, Duration.ofSeconds(3)).click();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void followTheForgotPasswordLink(){
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void logoIsDisplayed(){
        logo.shouldBe(visible);
        logo.shouldHave(attribute("src"));
    }

    public boolean signInAttributesAreDisplayed(){
        signInAttributes.shouldBe(visible);
        return true;
    }

    public boolean landingImageIsCorrect(){
        logo.shouldHave(attributeMatching("src",
                ".*softr-prod\\.imgix\\.net/.*"));
        return true;
    }

    public void followTheKovalItLink() {
        kovalItLink.shouldBe(visible).click();
    }

    public void followTheFacebookLink() {
        facebookLink.shouldBe(visible).click();
    }

    public void successLoginStudent() {
        mainSignInButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        emailField.shouldBe(visible).click();
        emailField.setValue("malik@example.com");
        passwordField.shouldBe(visible).click();
        passwordField.setValue("123456");
        loginButton.shouldBe(visible).click();
    }

    public void successLoginTeacher() {
        mainSignInButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        emailField.shouldBe(visible).click();
        emailField.setValue("i.paanda23@gmail.com");
        passwordField.shouldBe(visible).click();
        passwordField.setValue("NewPassword");
        loginButton.shouldBe(visible).click();
    }
    public void invalidEmailStudent() {
        mainSignInButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        emailField.shouldBe(visible).click();
        emailField.setValue("malikexample.com");
        passwordField.shouldBe(visible).click();
        passwordField.setValue("123456");
        loginButton.shouldBe(visible).click();
    }
    public void invalidPasswordTeacher() {
        mainSignInButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        emailField.shouldBe(visible).click();
        emailField.setValue("i.paanda23@gmail.com");
        passwordField.shouldBe(visible).click();
        passwordField.setValue("11100111");
        loginButton.shouldBe(visible).click();
    }

    public String getCurrentUrl() {
        return url();
    }


}
