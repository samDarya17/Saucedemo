package Locator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locator extends locator.BaseTest {
    String AddToCartButtonLocatorForBackBack = ("//div/button[@class='btn btn_primary " +
            "btn_small btn_inventory' " +
            "and @name='add-to-cart-sauce-labs-backpack']");
    String AddToCartButtonLocatorForBikeFlashLight = ("//div/button[text()='Add to cart' " +
            "and @name='add-to-cart-sauce-labs-bike-light'] ");
    String UserNameFieldLocator = ("//div/input[contains(@id,'user')]");
    String PasswordCredentials = ("//div[contains(text(),'secret_sauce')]");
    String LoginCredentials = (" //*[text()='Accepted usernames are:']//ancestor::div[1]");//вообще
    // не понимаю это
    String AddToCartButtonLocatorDescendant = (" //div[@id='inventory_container']//descendant:" +
            ":div[4]/div[2]/button");
    String AddToCartButtonLocatorFollowing = (" //div[@id='inventory_container']//following:" +
            ":div[4]/div[2]/div[2]/button[1]");


    @Test
    public void Scenario(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath(UserNameFieldLocator)).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        driver.findElement(By.xpath(AddToCartButtonLocatorForBackBack)).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String ProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String ProductPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        Assert.assertEquals(ProductName,"Sauce Labs Backpack","Bad");
        Assert.assertEquals(ProductPrice,"$29.99","Bad");


    }
}
