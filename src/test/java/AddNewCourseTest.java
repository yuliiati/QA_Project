import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNewCourseTest extends BaseTest{


    @DisplayName("Successful add course with role Teacher")
//    @Test
    public void successfulAddCourseWithRoleTeacher() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followAddCourseLink();
        addNewCoursePage.addValueToCourseName();
        addNewCoursePage.clickOnFacultyDropDown();
        addNewCoursePage.addValueToDescription();
        addNewCoursePage.uploadCoverPhoto();
        addNewCoursePage.clickOnStartDateInput();
        addNewCoursePage.clickOnEndDateInput();
        addNewCoursePage.pushTheAddButton();
        String actualCourseName = addNewCoursePage.getCourseNameValue();
        assertEquals("QA With Selenide", actualCourseName);
    }

    @DisplayName("Add course with invalid End date")
//    @Test
    public void unsuccessfulAddCourseWithPastEndDate() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followAddCourseLink();
        addNewCoursePage.addValueToCourseName();
        addNewCoursePage.clickOnFacultyDropDown();
        addNewCoursePage.addValueToDescription();
        addNewCoursePage.uploadCoverPhoto();
        addNewCoursePage.clickOnStartDateInput();
        addNewCoursePage.invalidEndDateInput();
        addNewCoursePage.pushTheAddButton();
    }

    @DisplayName("Successful upload Cover Photo")
//    @Test
    public void successUploadCoverPhoto() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followAddCourseLink();
        addNewCoursePage.uploadCoverPhoto();
    }

    @DisplayName("Error messages with Empty Fields are displayed")
    @Test
    public void errorMessageIsVisibleWithEmptyFields() {
        loginPage.pushTheMainSignInButton();
        loginPage.successLoginTeacher();
        homePage.followAddCourseLink();
        addNewCoursePage.addValueToCourseName();
        addNewCoursePage.pushTheAddButton();

        assertEquals("Faculty is required", addNewCoursePage.getFacultyErrorMessage());
        assertEquals("Course description is required", addNewCoursePage.getDescriptionErrorMessage());
        assertEquals("Course start date is required", addNewCoursePage.getStartDateErrorMessage());
        assertEquals("Course end date is required", addNewCoursePage.getEndDateErrorMessage());
    }


}
