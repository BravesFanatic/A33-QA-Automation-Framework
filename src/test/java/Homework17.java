import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    //extends BaseTests - inherits the methods /attributes of basetest class

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        navigateToPage();
        login("demo@class.com", "te$t$tudent");
        searchSong("Gray");
        clickViewAllButton();
        selectFirstSongResult();
        clickAddToPlaylistButton();
        choosePlaylist();

        String expectedPopUpMsg = "Added 1 song into";
        Assert.assertTrue(getPlaylistAddedMsg().contains(expectedPopUpMsg));

        }
//this is the closing curly bracket for the @Test case
//    We will start with creating test methods after that line or the bracket
    public void searchSong (String songTitleKeyword)   {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type=search]")));
        searchField.sendKeys(songTitleKeyword);
    }
    public void clickViewAllButton()  {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.songs h1 button")));
        viewAllBtn.click();
    }
    public void selectFirstSongResult()  {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper tr.song-item:nth-child(1)")));
        firstSongElement.click();
    }
    public void clickAddToPlaylistButton()  {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")));
        addToBtn.click();
    }

    public void choosePlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)")));
        clickPlaylist.click();
    }

    public String getPlaylistAddedMsg() throws InterruptedException {
        WebElement actualPopUpMessage = driver.findElement(By.cssSelector("body > div.alertify-logs.top.right > div"));
        return actualPopUpMessage.getText();

    }

}
