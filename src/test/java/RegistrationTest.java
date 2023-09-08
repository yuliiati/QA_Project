import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Condition.have;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest{

    @DisplayName("Successful Registration with role Teacher")
//    @Test //todo asserts
    public void successfulRegistrationTeacher() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.selectTeacherRole();
        registrationPage.enterFullName("Carl");
        registrationPage.enterEmail(("i.paanda230@gmail.com"));
        registrationPage.enterPassword(("Password"));
        registrationPage.clickTermsAndConditions();
        registrationPage.pushSignUpButton();
        assertTrue(homePage.correctWelcomeTextIsVisible());
    }

    @DisplayName("Successful Registration with role Student")
//    @Test
    public void successfulRegistrationStudent() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.selectStudentRole();
        registrationPage.enterFullName("Tomas Lee");
        registrationPage.enterEmail(("tomaslee@gmail.com"));
        registrationPage.enterPassword(("12312355"));
        registrationPage.clickTermsAndConditions();
        registrationPage.pushSignUpButton();
        assertTrue(homePage.correctWelcomeTextIsVisible());
    }

    @DisplayName("Unsuccessful Registration Teacher without Terms")
    @Test
    public void registrationTeacherWithoutTerms() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.selectTeacherRole();
        registrationPage.enterFullName("Carl");
        registrationPage.enterEmail(("i.paanda23@gmail.com"));
        registrationPage.enterPassword(("NewPassword"));
        registrationPage.pushSignUpButton();
        registrationPage.requiredMessage(String.valueOf(have(Condition.attribute("warning"))));
    }

    @DisplayName("Unsuccessful Registration Student without Password")
    @Test
    public void registrationStudentWithEmptyPassword() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.selectStudentRole();
        registrationPage.enterFullName("Tomas Lee");
        registrationPage.enterEmail(("my_email@gmail.com"));
        registrationPage.enterPassword((" "));
        registrationPage.pushSignUpButton();
        registrationPage.requiredMessage(String.valueOf(have(Condition.attribute("warning"))));
    }

    @DisplayName("Successful navigation to Terms page")
//    @Test
    public void weAreOnTheTermsPage() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.clickTermsLinkAndCheckPage();
    }

    @DisplayName("Successful navigation to Policy page")
//    @Test
    public void weAreOnThePolicyPage() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.clickPolicyLinkAndCheckPage();
    }

//    @Test
    public void checkPasswordVisibility() {
        registrationPage.pushTheMainSignUpButton();
        registrationPage.enterPassword(("NewPassword"));
        registrationPage.verifyPasswordVisibility("NewPassword");
    }


}
