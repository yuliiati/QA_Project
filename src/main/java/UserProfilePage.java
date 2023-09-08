import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class UserProfilePage {

    private SelenideElement selectYourRoleInputField = $(By.xpath("//div[@class='filter-option-inner-inner']"));
    private SelenideElement teacherRoleInputField = $(byXpath("//span[normalize-space()='teacher']"));
    private SelenideElement studentRoleInputField = $(byXpath("//span[normalize-space()='student']"));
    private SelenideElement fullNameInputField = $(By.xpath("//input[contains(@name,'full_name')]"));
    private SelenideElement emailInputField = $(By.xpath("//input[contains(@name,'email')]"));
    private SelenideElement aboutInputField = $(By.xpath("//textarea[contains(@name,'About')]"));
    private SelenideElement fileInputField = $(By.xpath("//input[contains(@type,'file')]"));
    private SelenideElement externalLinkInputField = $(By.xpath("//input[contains(@name,'External Profile URL')]"));
    private SelenideElement majorInputField = $(By.xpath("//input[contains(@name,'Major')]"));
    private SelenideElement updateProfileButton = $(By.xpath("//a[@id='sw-update-profile-btn']"));
    private SelenideElement passwordInputField = $(By.xpath("//input[contains(@placeholder,'Old password')]"));
    private SelenideElement newPasswordInputField = $(By.xpath("//input[contains(@placeholder,'New password')]"));
    private SelenideElement changePasswordButton = $(By.xpath("//a[contains(@id,'change-password')]"));


    public void successfulUpdateProfileWithRoleTeacher() {
        fullNameInputField.shouldBe(visible, Duration.ofSeconds(8)).click();
        fullNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Sean Pen");
        aboutInputField.shouldBe(visible, Duration.ofSeconds(8)).click();
        aboutInputField.setValue("My new info");
        fileInputField.uploadFile(new File("C:\\Users\\49160\\Downloads\\qa_pain.jpg"));
        externalLinkInputField.click();
        externalLinkInputField.setValue("https://link.example.com");
        majorInputField.click();
        majorInputField.setValue("GenTech");
        updateProfileButton.shouldBe(visible).click();
    }

    public void changeRoleFromTeacherToStudent() {
        selectYourRoleInputField.shouldBe(visible).click();
        teacherRoleInputField.shouldBe(visible).click();
        updateProfileButton.scrollTo();
        updateProfileButton.shouldBe(visible).click();
    }
    public void changeRoleToTeacher() {
        selectYourRoleInputField.shouldBe(visible).scrollTo();
        teacherRoleInputField.shouldBe(visible).click();
    }

    public String getCurrentRole() {
        selectYourRoleInputField.shouldBe(visible).click();
        return selectYourRoleInputField.getText();
    }

    public String getCurrentFullName() {
        fullNameInputField.shouldBe(visible).click();
        return fullNameInputField.getText();
    }

    public void tryToUpdateEmail() {
        emailInputField.clear();
        emailInputField.sendKeys("newemail@example.com");
    }

    public String getEmailFieldValue() {
        return emailInputField.getValue();
    }

    public String getCurrentUrl() {
        return url();
    }
    public String getUserInfo() {
        return aboutInputField.shouldBe(visible).getText();
    }

    public String getUserLink() {
        return externalLinkInputField.shouldBe(visible).getValue();
    }

    public String getUserMajor() {
        return majorInputField.shouldBe(visible).getValue();
    }



}
