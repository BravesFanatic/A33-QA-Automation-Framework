import MyPages.LoginPage;
import org.testng.annotations.Test;

public class POMLoginTests extends BaseTest {

    @Test
    public void validEmailLoginTest() throws InterruptedException {


        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("jose@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

    }
}
