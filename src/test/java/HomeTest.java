import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Thread.sleep;

public class HomeTest extends BaseTest{

    @DisplayName("Check Home Page Image")
    @Test
    public void checkHomePageImage() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginStudent();
        homePage.correctWelcomeTextIsVisible();
    }

    @DisplayName("User can go to My Profile Page")
    @Test
    public void goToProfilePage() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginStudent();
        homePage.followMyProfileLink();
        String currentUrl = userProfilePage.getCurrentUrl();
        String expectedUrl = "https://jere237.softr.app/user-profile";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @DisplayName("Successful Sign Out Student")
    @Test
    public void successSignOut() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginStudent();
        homePage.followTheSignOutButton();
        String currentUrl = loginPage.getCurrentUrl();
        String expectedUrl = "https://jere237.softr.app/#";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @DisplayName("Successful navigation to Courses Page")
    @Test
    public void goToCoursesPage() throws InterruptedException {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginStudent();
        sleep(6000);
        homePage.followTheCoursesLink();
        sleep(6000);
        homePage.followTheCourseListLink();
        sleep(6000);
        String currentCoursesUrl = courseListPage.getCurrentUrl();
        String expectedCoursesUrl = "https://jere237.softr.app/course-list";
        Assert.assertEquals(expectedCoursesUrl, currentCoursesUrl);
    }
}
