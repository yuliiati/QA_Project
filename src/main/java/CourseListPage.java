import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CourseListPage {
    private SelenideElement facultyItemsList = $(By.xpath("//div[@class='tag-list-container MuiBox-root css-14ius3w']"));
    private SelenideElement engineeringElementButton = $$(By.xpath("//div[contains(@class,'tag-list-container MuiBox-root css-14ius3w')]//span[contains(@class,'css-u95dmd')]")).get(1);
    private SelenideElement searchBar = $(By.xpath("//input[contains(@class, 'input')]"));
    private SelenideElement courseItemName = $(By.xpath("//h3[contains(@class, '') and 'rec2d']"));
    private SelenideElement linkElement = $(By.xpath("//link[contains(@href, 'course-list')]"));

    public void checkAllFacultiesTitles(String[] titles){
        facultyItemsList.shouldBe(visible);
    }
    public void clickOnFacultyButton(){
        engineeringElementButton.shouldBe(visible).click();
    }
    public void clickOnCourseName(){
        engineeringElementButton.shouldBe(visible).click();
    }

    public void searchForCourse(String courseName) {
        searchBar.shouldBe(visible).click();
        searchBar.setValue(courseName);
    }

    public SelenideElement getCourseItemByName(String expectedCourseName) {
        courseItemName.shouldBe(visible);
        return courseItemName.shouldHave(text(expectedCourseName));
    }

    public String getCurrentUrl() {
        return url();
    }

}
