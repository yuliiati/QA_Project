import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class AddNewCoursePage {
    private SelenideElement courseName = $(By.xpath("//input[contains(@id, 'CourseName')]"));
    private SelenideElement faculty = $(By.xpath("//div[contains(@field, 'Faculty')]"));
    private SelenideElement facultyEngineering = $(By.xpath("//li[contains(@data-value, 'Engineering')]"));
    private SelenideElement description = $(By.xpath("//textarea[contains(@id, 'Description')]"));
    private SelenideElement coverPhoto = $(By.xpath("//input[contains(@id, 'CoverPhoto')]"));
    private SelenideElement startDateInput = $$(By.xpath("//div[contains(@class, 'formControl')]")).get(3);
    private SelenideElement endDateInput = $(By.xpath("//input[contains(@id, 'Enddate')]"));
    private SelenideElement addButton = $(By.cssSelector("[type='submit']"));
    private SelenideElement clickOnEmptySpace = $(By.xpath("//div[contains(@class, 'form-holder')]"));

    public void addValueToCourseName() {
        courseName.shouldBe(visible, Duration.ofSeconds(8)).click();
        courseName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "QA With Selenide");
        String expectedValue = "QA With Selenide";
        assertEquals(expectedValue, courseName.getValue());
    }

    public void clickOnFacultyDropDown() {
        faculty.shouldBe(visible).click();
        facultyEngineering.click();
    }
    public void addValueToDescription() {
        description.shouldBe(visible).click();
        description.setValue("Speed up your work with Selenide");
    }
    public void uploadCoverPhoto() {
        String script = "arguments[0].style.display = 'block';";
        Selenide.executeJavaScript(script, coverPhoto);
        coverPhoto.sendKeys("C:\\Users\\49160\\Downloads\\qa_pain.jpg");
    }
    public void clickOnStartDateInput() {
        startDateInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        startDateInput.setValue("2023-08-01");
    }
    public void clickOnEndDateInput() {
        endDateInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        endDateInput.setValue("2023-08-31");
    }
    public void invalidEndDateInput() {
        endDateInput.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        endDateInput.setValue("2022-08-31");
    }
    public void pushTheAddButton() {
        addButton.shouldBe(visible, Duration.ofSeconds(6)).click();
    }

    public String getCourseNameValue() {
        String inputValue = coverPhoto.getAttribute("value");
        return inputValue;
    }

    public String getFacultyErrorMessage() {
        return $(By.xpath("//span[contains(text(), 'Faculty is required')]")).getText();
    }

    public String getDescriptionErrorMessage() {
        return $(By.xpath("//span[contains(text(), 'Course description is required')]")).getText();
    }

    public String getStartDateErrorMessage() {
        return $(By.xpath("//span[contains(text(), 'Course start date is required')]")).getText();
    }

    public String getEndDateErrorMessage() {
        return $(By.xpath("//span[contains(text(), 'Course end date is required')]")).getText();
    }

}
