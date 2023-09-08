import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    private SelenideElement signUpText = $(byClassName("h2"));
    private SelenideElement selectYourRoleInputField = $(By.xpath("//div[@class='filter-option-inner-inner']"));
    private SelenideElement teacherRoleInputField = $(byXpath("//span[normalize-space()='teacher']"));
    private SelenideElement studentRoleInputField = $(byXpath("//span[normalize-space()='student']"));
    private SelenideElement fullNameFieldInputField = $(By.xpath("//input[contains(@id, 'full_name')]"));
    private SelenideElement emailInputField = $(byAttribute("placeholder", "Email"));
    private SelenideElement passwordInputField = $(byAttribute("placeholder", "Password"));
    private SelenideElement termsAndPolicyCheckbox = $(By.xpath("//span[contains(@class, 'checkmark')]"));
    private SelenideElement termsLink = $(By.xpath("(//*[contains(@target, '_blank')])[1]"));
    private SelenideElement policyLink = $(By.xpath("(//*[contains(@target, '_blank')])[2]"));
    private SelenideElement policyPageText = $(By.xpath("//h1/strong"));
    private SelenideElement termsPageText = $(By.xpath("//span[contains(text(), 'Terms and')]"));
    private SelenideElement signUpButton = $(By.cssSelector("[id='sw-sign-up-submit-btn']"));
    private SelenideElement mainSignUpButton = $$(By.xpath("//a[contains(@href, 'sign-up')]")).get(0);
    private SelenideElement errorMessageEmptyFields = $(byXpath("//img[contains(@src, 'warning')]"));
    private SelenideElement requiredFieldsMessage = $(byXpath("//div[contains(@class, 'signup-error')]"));


    public void pushTheMainSignUpButton() {
        mainSignUpButton.click();
    }

    public void selectTeacherRole() {
        selectYourRoleInputField.shouldBe(visible);
        selectYourRoleInputField.scrollTo().click();
        teacherRoleInputField.shouldHave(text("teacher")).click();
    }

    public void selectStudentRole() {
        selectYourRoleInputField.shouldBe(visible);
        selectYourRoleInputField.scrollTo().click();
        studentRoleInputField.shouldHave(text("student")).click();
    }

    public void enterFullName(String usernameValue) {
        fullNameFieldInputField.shouldBe(visible, Duration.ofSeconds(10));
        fullNameFieldInputField.setValue(usernameValue);
    }

    public void enterEmail(String emailValue) {
        emailInputField.shouldBe(visible);
        emailInputField.setValue(emailValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.setValue(passwordValue);
    }

    public void clickTermsAndConditions() {
        termsAndPolicyCheckbox.shouldBe(visible);
        termsAndPolicyCheckbox.click();
    }

    public void pushSignUpButton() {
        signUpButton.click();
    }

    public void requiredMessage(String expectedText) {
        errorMessageEmptyFields.should(exist);
    }

    public void clickTermsLinkAndCheckPage() {
        termsLink.shouldBe(visible).click();
        termsPageText.shouldBe(visible, Duration.ofSeconds(5));
        termsPageText.shouldHave(attribute("span", "Terms and Conditions for the Use of the Softr Platform"));
    }

    public void clickPolicyLinkAndCheckPage() {
        policyLink.shouldBe(visible, Duration.ofSeconds(8)).click();
        policyPageText.shouldBe(visible);
        policyPageText.shouldHave(attribute("strong", "Privacy Policy"));
    }

    public void verifyPasswordVisibility(String expectedPassword) {
        passwordInputField.shouldBe(visible);
        passwordInputField.shouldHave(attribute("value", expectedPassword));
    }

}
