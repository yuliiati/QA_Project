import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KovalItTest extends BaseTest{

//    @Test
    public void kovalItLinkIsCorrect(){
        loginPage.followTheKovalItLink();
        String actualLink = kovalItPage.getKovalItLinkHref();
        String expectedLink = "https://www.figma.com/@kovalit";
        assertEquals(expectedLink, actualLink);
    }
}
