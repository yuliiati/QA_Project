import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement logo = $(byClassName("[class='sw-width-5xs']"));
    private SelenideElement text = $(By.xpath("//h1[contains(text(),'Welcome')]"));
    private SelenideElement coursesTitle = $(By.xpath("(//span[contains(text(), 'Course')])[1]"));
    private SelenideElement courseListTitle = $(By.xpath("(//*[contains(text(), 'Course list')])[1]"));
    private SelenideElement avatarImage = $(By.xpath("//img[contains(@class,'MuiAvatar-img')]"));
    private SelenideElement myProfile = $$(By.xpath("//span[contains(@class,'2rlxtj')]")).get(0);
    private SelenideElement signOut = $$(By.xpath("//span[contains(@class,'2rlxtj')]")).get(1);
    private SelenideElement addCourse = $(By.xpath("//a[contains(@href, 'add-course')]"));

    private SelenideElement h1 = $(By.tagName("h1"));

    private SelenideElement kovalIt = $(By.xpath("(//*[contains(@target, '_blank')])[3]"));
    private SelenideElement facebook = $(By.xpath("(//*[contains(@target, '_blank')])[4]"));
    private SelenideElement twitter = $(By.xpath("(//*[contains(@target, '_blank')])[5]"));
    private SelenideElement instagram = $(By.xpath("(//*[contains(@target, '_blank')])[6]"));

    private SelenideElement signUp = $(By.xpath("(//div[contains(@class, 'start')]//a[1]"));
    private SelenideElement signIn = $(By.xpath("(//div[contains(@class, 'start')]//a[2]"));

    public void followTheCoursesLink() {
        coursesTitle.shouldBe(Condition.visible).click();
    }
    public void followTheCourseListLink() {
        courseListTitle.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    public void followMyProfileLink() {
        avatarImage.shouldBe(Condition.visible).click();
        myProfile.shouldBe(Condition.visible).click();
    }

    public void followTheSignOutButton() {
        avatarImage.shouldBe(Condition.visible).click();
        signOut.shouldBe(Condition.visible).click();
    }

    public void followAddCourseLink() {
        addCourse.shouldBe(Condition.visible).click();
    }
    public String getAvatarImageSrc() {
        return avatarImage.getAttribute("src");
    }

    public boolean correctWelcomeTextIsVisible() {
        text.shouldBe(visible);
        text.shouldHave(text("Welcome"));
        return true;
    }

}
