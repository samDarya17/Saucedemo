package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {
    public static final By INVENTORY_TITLE = By.xpath("//span[text()='Products']");
    public static final By CART_BUTTON = By.xpath("//a[@class='shopping_cart_link']");
    public static final By PRODUCT_COUNTER = By.xpath("//span[@class='shopping_cart_badge']");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    String addButtonByItemName = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    String productPrice = "//div[text()='%s']//ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    String name = "//div[text()='%s']//ancestor::div[@class='inventory_item']//div[@class='inventory_item_name']";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(INVENTORY_TITLE);
    }

    public void addItemToCartByItemName(String itemName) {
        driver.findElement(By.xpath(String.format(addButtonByItemName, itemName))).click();
    }

    public String getNameProduct(String itemName) {
        return driver.findElement(By.xpath(String.format(name, itemName))).getText();
    }

    public String getPrice(String itemName) {
        return driver.findElement(By.xpath(String.format(productPrice, itemName))).getText();
    }

    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getTextOfProductCounter() {
        return driver.findElement(PRODUCT_COUNTER).getText();
    }


}