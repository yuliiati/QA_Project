import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FacebookPage {
    private SelenideElement facebookLink = $(byXpath("//a[contains(@href,'facebook.com')]"));

    public String getFacebookLinkHref() {
        return facebookLink.getAttribute("href");
    }
}
