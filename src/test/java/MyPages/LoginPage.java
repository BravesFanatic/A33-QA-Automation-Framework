package MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{


//    Page Factory

    @FindBy(css = "[type='email']")
    WebElement emailFieldLocator;

    @FindBy(css = "[type='password']")
    WebElement passwordFieldLocator;

    @FindBy(css = "[type='submit']")
    WebElement submitBtnLocator;

//    POM
    private By emailField = By.cssSelector("[type='email']");
    private By passwordField = By.cssSelector("[type='password']");
    private By submitBtn = By.cssSelector("[type='submit']");
    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPage clickSubmit()   {
        submitBtnLocator.click();
        return this;

    }
    public LoginPage providePassword(String password) {
        passwordFieldLocator.clear();
        passwordFieldLocator.sendKeys(password);
        return this;

    }
    public LoginPage provideEmail(String email) {
        emailFieldLocator.clear();
        emailFieldLocator.sendKeys(email);
        return this;
    }
}