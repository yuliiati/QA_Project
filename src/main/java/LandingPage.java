import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LandingPage {

    private SelenideElement header = $(By.cssSelector("[category='Header']"));
    private SelenideElement aboutUs = $(By.xpath("//a[contains(@href, 'about-us')]"));
    private SelenideElement courses = $(By.xpath("//a[contains(@href, 'courses-grid-non-logged')]"));
    private SelenideElement professors = $(By.xpath("//a[contains(@href, 'teacher')]"));
    private SelenideElement mainSignIn = $(By.xpath("(//a[contains(@href, 'sign-in')])[0]"));
    private SelenideElement mainSignUp = $(By.xpath("(//a[contains(@href, 'sign-up')])[0]"));

}
