import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FacebookTest extends BaseTest{
//    @Test
    public void facebookLinkIsCorrect(){
        loginPage.followTheFacebookLink();
        String actualLink = facebookPage.getFacebookLinkHref();
        String expectedLink = "https://facebook.com/mycompany";
        assertEquals(expectedLink, actualLink);
    }
}
