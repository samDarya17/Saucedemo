package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.LoginPage.LOGIN_BUTTON;

public class CartPage extends BasePage{
    String addButtonByItemName = "//div[text() = '%s']//ancestor::div[@class = 'inventory_item']//button";
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUESHOPPING_BUTTON = By.id("continue-shopping");
    public static final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    public static final By ADDTOCARD_BYTTON = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By INVENTORYPAGE_CHECKER = By.xpath("//*[text()='Products']");
    public static final By CART_CHECKER = By.xpath("//*[text()= 'Your Cart']");
    public static final By CHECKOUT_CHEKER = By.xpath("//*[text() = 'Checkout: Your Information']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }

    public void open() {
        driver.get("https://www.saucedemo.com");
    }
    public void loginAndOpenCart(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(By.xpath("//*[text()= 'Add to cart' and @id ='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@class = 'shopping_cart_link']")).click();
    }
    public void elementIsNotDisplayed(String ElementId) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ElementId)));
    }
    public void openCartButtonClick() {
        driver.findElement(By.xpath("//*[@class = 'shopping_cart_link']")).click();
    }
    public boolean titleOpenCheckOutIsVisible() {
        return driver.findElement(CHECKOUT_CHEKER).isDisplayed();
    }

    public void addItemInCartByItemName(String itemName) {
        driver.findElement(By.xpath(String.format(addButtonByItemName, itemName))).click();
    }

    public String getBackPackItemPriceFromInventory() {
        return driver.findElement(By.xpath("(//div[@class ='inventory_item_price'])[1]")).getText();
    }

    public String getBackPackItemPriceFromCart() {
        return driver.findElement(By.xpath("//div[@class ='inventory_item_price']")).getText();
    }

    public boolean titleContinueShoppingIsVisible() {
        return driver.findElement(INVENTORYPAGE_CHECKER).isDisplayed();


}
}
