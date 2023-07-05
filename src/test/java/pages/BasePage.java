package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://www.saucedemo.com/";
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public abstract boolean isPageOpen();

    public boolean isExist(By locator){
        try
        {return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}