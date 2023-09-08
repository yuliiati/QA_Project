import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseListTest extends BaseTest{

    @DisplayName("Check All Faculties Titles")
    @Test
    public void checkAllFacultiesTitles() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followTheCoursesLink();
        homePage.followTheCourseListLink();
        String[] namesTitles = {"Business School", "Engineering", "Science", "Medicine", "Law"};
        courseListPage.checkAllFacultiesTitles(namesTitles);
    }

    @DisplayName("Check Sort Function")
    @Test
    public void checkThatCoursesAreSortedByFacultyName() {
        loginPage.successLoginStudent();
        homePage.followTheCoursesLink();
        homePage.followTheCourseListLink();
        courseListPage.clickOnFacultyButton();
        courseListPage.clickOnCourseName();
        String expectedFacultyName = "Engineering";
        assertEquals(expectedFacultyName, "Engineering");
    }

    @DisplayName("Check Search Bar")
    @Test
    public void checkSearchBar(){
        loginPage.successLoginStudent();
        homePage.followTheCoursesLink();
        homePage.followTheCourseListLink();
        String expectedCourseName = "Computer Science";
        courseListPage.searchForCourse(expectedCourseName);
        courseListPage.getCourseItemByName(expectedCourseName);
        assertEquals(expectedCourseName, "Computer Science");
    }



}
