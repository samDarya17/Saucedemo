package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

public class LoginPage extends BasePage {
    public static final By USER_NAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }

    public void openWebsite() {
        driver.get(url);
    }

    public void logInWithValidData() {
        driver.get(url);
        driver.findElement(USER_NAME).sendKeys("standard_user");
        driver.findElement(PASSWORD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void authorization(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMassage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}