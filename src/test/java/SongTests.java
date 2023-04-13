import MyPages.HomePage;
import MyPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongTests extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jose@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.clickPlayNext();
        homePage.clickPlay();
        Assert.assertTrue(homePage.isSongPlaying());


    }
}