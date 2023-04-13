package MyPages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

//    POM
    private By firstUserPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By playlistNameField = By.cssSelector("input[name='name']");
    private By playlistNameText = By.cssSelector(".playlist:nth-child(3) a");

//    Page Factory

    @FindBy(css = "img.avatar")
    WebElement avatarElement;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstUserPlaylistElement;
    @FindBy(css = "input[name='name']")
    WebElement playlistNameFieldElement;
    @FindBy(css = ".playlist:nth-child(3) a")
    WebElement playlistNameTextElement;
    @FindBy(css = "div#searchForm input[type=search]")
    WebElement searchField;
    @FindBy(css = "section.songs h1 button")
    WebElement viewAllBtn;
    @FindBy(css = "#songResultsWrapper tr.song-item:nth-child(1)")
    WebElement firstSongElement;
    @FindBy(css = "#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")
    WebElement addToBtn;
    @FindBy(css = "#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(5)")
    WebElement clickPlaylist;
    @FindBy(css = "div.success.show")
    WebElement actualPopUpMessage;
    @FindBy(css = "[data-testid='sound-bar-play']")
    WebElement soundBar;
    @FindBy(xpath = "//i[@data-testid='play-next-btn']")
    WebElement playNextButton;
    @FindBy(css = "[data-testid='play-btn'")
    WebElement playButton;

    @FindBy(css =".playlist:nth-child(3)")
    WebElement emptyPlaylist;

    @FindBy(css =".btn-delete-playlist")
    WebElement deletePlaylist;

    @FindBy(css ="div.success.show")
    WebElement notificationMsg;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void doubleClickPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(firstUserPlaylistElement));
        actions.doubleClick(firstUserPlaylistElement).perform();
    }
    public void enterPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOf(playlistNameFieldElement));
        playlistNameFieldElement.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));//this code simulates a select all and backspace to delete the current playlist name
        playlistNameFieldElement.sendKeys(playlistName);
        playlistNameFieldElement.sendKeys(Keys.ENTER);
    }
    public String getPlaylistName() {
        wait.until(ExpectedConditions.visibilityOf(playlistNameTextElement));
        return playlistNameTextElement.getText();
    }
    public boolean isAvatarDisplayed(){
        return avatarElement.isDisplayed();
    }
    public void searchSong (String songTitleKeyword)   {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(songTitleKeyword);
    }
    public void clickViewAllButton()  {
        wait.until(ExpectedConditions.visibilityOf(viewAllBtn));
        viewAllBtn.click();
    }
    public void selectFirstSongResult()  {
        wait.until(ExpectedConditions.visibilityOf(firstSongElement));
        firstSongElement.click();
    }
    public void clickAddToPlaylistButton()  {
        wait.until(ExpectedConditions.visibilityOf(addToBtn));
        addToBtn.click();
    }
    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOf(clickPlaylist));
        clickPlaylist.click();
    }
    public String getPlaylistAddedMsg()  {
        wait.until(ExpectedConditions.visibilityOf(actualPopUpMessage));
        return actualPopUpMessage.getText();
    }
    public boolean isSongPlaying() {
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        return soundBar.isDisplayed();
    }
    public void clickPlayNext() throws InterruptedException {
        playNextButton.click();
    }
    public void clickPlay(){
        playButton.click();
    }

    public void openPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(emptyPlaylist));
        emptyPlaylist.click();
    }
    public void clickDeletePlaylistBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(deletePlaylist));
        deletePlaylist.click();
    }
    public String getDeletedPlaylistMsg() {
        wait.until(ExpectedConditions.elementToBeClickable(notificationMsg));
        return notificationMsg.getText();
    }
}





