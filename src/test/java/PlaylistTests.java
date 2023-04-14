import MyPages.HomePage;
import MyPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {
    @Test (priority=2)
    public void addSongToPlaylist()  {

        String addSongExpectedPopUpMsg = "Added 1 song into";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jose@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.searchSong("Pluto");
        homePage.clickViewAllButton();
        homePage.selectFirstSongResult();
        homePage.clickAddToPlaylistButton();
        homePage.choosePlaylist();
        Assert.assertTrue(homePage.getPlaylistAddedMsg().contains(addSongExpectedPopUpMsg));
    }

    @Test (priority=1)
    public void deletePlaylist()   {

        String deletedPlaylistExpectedPopUpMsg = "Deleted playlist";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jose@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.openPlaylist();
        homePage.clickDeletePlaylistBtn();
        Assert.assertTrue(homePage.getDeletedPlaylistMsg().contains(deletedPlaylistExpectedPopUpMsg));
    }

    @Test
    public void renamePlaylist() {

        String playlistName = "Jose Edited Playlist";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("jose@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.doubleClickPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertEquals(homePage.getPlaylistName(), playlistName);

    }





}
