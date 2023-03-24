import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver = null;

    public WebDriverWait wait = null;

    public String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters("baseUrl")
    public void launchBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        url = baseUrl;
        driver.get(url);
    }
    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }
    public void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void login(String email, String password) throws InterruptedException {
//        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
//        emailField.sendKeys(email);
//
//        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
//        passwordField.sendKeys(password);
//
//        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
//        submitButton.click();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
    public void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }
    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }
    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }
    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
}