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
}
