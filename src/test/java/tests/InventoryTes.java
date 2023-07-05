package tests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class InventoryTest extends BaseTest {
    @Test
    public void addItemToCart0() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        String nameProductInInventory = inventoryPage.getNameProduct("Sauce Labs Bike Light");
        inventoryPage.clickCartButton();

        assertEquals(cartPage.getProductNameInBasketByIndex(0), nameProductInInventory, "Имя товара не совпадает " +
                "или товар отсутствует в корзине");
    }

    @Test
    public void checkProductCounterOnInventoryPageByAddingProductToCart() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");

        assertEquals(inventoryPage.getTextOfProductCounter(), "1",
                "Товар не отображается в красном круге корзины");
    }

    @Test
    public void removeAnItemFromShoppingCartWithoutEnteringIt() {
        loginPage.logInWithValidData();
        inventoryPage.clickAddToCartButton();

        assertEquals(inventoryPage.getTextOfProductCounter(), "1", "товар отсутствует в корзине");
    }

    @Test
    public void goToShoppingCartByClickingOnShoppingCartItem() {
        loginPage.logInWithValidData();
        inventoryPage.clickCartButton();

        assertTrue(cartPage.isPageOpen(), "Пользователь не перешел на страницу: корзина");
    }

}