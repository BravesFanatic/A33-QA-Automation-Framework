import MyPages.HomePage;
import MyPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{

    @Test
    public void renamePlaylist() {

        String playlistName = "Jose Edited Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("jose@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.doubleClickPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertEquals(homePage.getPlaylistName(), playlistName);
    }
}
