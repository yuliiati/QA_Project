import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    final String BASE_URL = "https://jere237.softr.app/";

    @Before
    public void setUp(){
        Configuration.timeout=10000;
        Configuration.headless=false;
        Configuration.browser="chrome";
        Configuration.browserSize="1500x900";
        Configuration.fastSetValue=true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
    LandingPage landingPage = new LandingPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    AddNewCoursePage addNewCoursePage = new AddNewCoursePage();
    CourseListPage courseListPage = new CourseListPage();
    UserProfilePage userProfilePage = new UserProfilePage();
    KovalItPage kovalItPage = new KovalItPage();
    FacebookPage facebookPage = new FacebookPage();


}
