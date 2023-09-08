import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileTest extends BaseTest{

    @DisplayName("Student not can change role to Teacher")
    @Test @Description("Impossible to change role")
    public void studentNotCanChangeRoleToTeacher() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginStudent();
        homePage.followMyProfileLink();
        userProfilePage.changeRoleFromTeacherToStudent();
        String currentRole = userProfilePage.getCurrentRole();
        userProfilePage.changeRoleToTeacher();
        String changedRole = userProfilePage.getCurrentRole();
        assertNotEquals(changedRole, currentRole);
        System.out.println(currentRole);
    }

    @DisplayName("Teacher can successfully update all fields in Profile")
    @Test
    public void teacherCanUpdateProfile() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followMyProfileLink();
        userProfilePage.successfulUpdateProfileWithRoleTeacher();
        String currentName = userProfilePage.getCurrentFullName();
        String updatedInfo = userProfilePage.getUserInfo();
        String updatedLink = userProfilePage.getUserLink();
        String updatedMajor = userProfilePage.getUserMajor();
        assertEquals("Sean Pen", currentName);
        assertEquals("My new info", updatedInfo);
        assertEquals("https://link.example.com", updatedLink);
        assertEquals("GenTech", updatedMajor);
        String updatedAvatar = homePage.getAvatarImageSrc();
        String currentAvatarURL = "https://v5.airtableusercontent.com/v1/20/20/1694080800000/Axo74esZeU6_GW83vb-JCg/iL0C" +
                "_DBIGayPFwJkQdj_zC2HMzw7F5-wak_f0Hs0pxPYdDv4xaX4EGAxtQ1RkNhVlzv2TIEc8TKWZ5TKTJ-nlg/o0hMnW-09otr5TmxEUuUYELSfxyjUbcQg9irnCD9lXs";
        assertNotEquals(currentAvatarURL, updatedAvatar);
        System.out.println(currentAvatarURL);
        System.out.println(updatedAvatar);
    }

    @DisplayName("Teacher not can update Email")
    @Test
    public void teacherCanNotUpdateEmail() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followMyProfileLink();
        userProfilePage.tryToUpdateEmail();
        String currentEmailValue = userProfilePage.getEmailFieldValue();
        assertEquals("i.paanda23@gmail.com", currentEmailValue);
    }
}
