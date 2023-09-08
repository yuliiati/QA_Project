import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @DisplayName("Successful Login with role Teacher")
    @Test
    public void loginTeacherWithValidData() {
        loginPage.successLoginTeacher();
        assertTrue(homePage.correctWelcomeTextIsVisible());
    }

    @DisplayName("Unsuccessful Login with Invalid Password")
    @Test
    public void loginTeacherWithInvalidPassword(){
        loginPage.invalidPasswordTeacher();
        String expectedErrorMessage = "Invalid email or password";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage);    }

    @DisplayName("Successful Login with role Student")
    @Test
    public void loginStudentWithValidData() {
        loginPage.successLoginStudent();
        assertTrue(homePage.correctWelcomeTextIsVisible());
    }

    @DisplayName("Unsuccessful Login with Invalid Email for role Student")
    @Test
    public void loginStudentWithInvalidEmail(){
        loginPage.invalidEmailStudent();
        String expectedErrorMessage = "Invalid email or password";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @DisplayName("Recovery Password Form Displayed")
    @Test
    public void resetPasswordFormIsVisible(){
        loginPage.pushTheMainSignInButton();
        loginPage.followTheForgotPasswordLink();
        resetPasswordPage.urlIsCorrect();
    }

    @DisplayName("Logo is correct")
    @Test
    public void logoImageIsVisible(){
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        loginPage.logoIsDisplayed();
    }
    @DisplayName("Welcome image is correct")
    @Test
    public void landingImageIsVisible(){
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        assertTrue(loginPage.landingImageIsCorrect());

    }
    @DisplayName("Sign in attributes is correct")
    @Test
    public void signInAttributesAreDisplayed(){
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        assertTrue(loginPage.signInAttributesAreDisplayed());
    }

}
