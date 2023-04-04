import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String playlistName = "Jose Edited Playlistss";

    @Test
    public void renamePlayList() {
        login("jose@test.com", "te$t$tudent");
        choosePlaylist();
        contextClickChoosePlayList();
        enterPlaylistName();
        Assert.assertEquals(getPlaylistName(), playlistName);
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }

    public void contextClickChoosePlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Edit')]"))).click();
    }

    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE)));//this code simulates a select all and backspace to delete the current playlist name
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3) a")));
       WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3) a"));
       return playlistElement.getText();
 }

}

