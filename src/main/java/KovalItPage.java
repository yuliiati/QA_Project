import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class KovalItPage {

    private SelenideElement kovalItLink = $(By.xpath("//a[contains(@href,'figma.com')]"));

    public String getKovalItLinkHref() {
        return kovalItLink.getAttribute("href");
    }
}
