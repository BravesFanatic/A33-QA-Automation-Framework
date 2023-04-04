package MyPages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private By firstUserPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By playlistNameField = By.cssSelector("input[name='name']");
    private By playlistNameText = By.cssSelector(".playlist:nth-child(3) a");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public void doubleClickPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstUserPlaylist));
        WebElement playlistElement = driver.findElement(firstUserPlaylist);
        actions.doubleClick(playlistElement).perform();

    }

    public void enterPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistNameField));
        WebElement playlistInputField = driver.findElement(playlistNameField);
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE)));//this code simulates a select all and backspace to delete the current playlist name
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistNameText));
        WebElement playlistElement = driver.findElement(playlistNameText);
        return playlistElement.getText();
    }
}
