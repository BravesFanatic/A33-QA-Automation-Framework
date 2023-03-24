import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login("jose@test.com", "te$t$tudent");
        clickPlaySong();
        Assert.assertTrue(isSongPlaying());
    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
        public void clickPlaySong() {
            WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
            WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
            playNextButton.click();
            playButton.click();
        }
    }