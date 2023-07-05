package tests;

import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void compareProductDataInShoppingCartWithProductDataInCatalog(){
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        String nameProduct = inventoryPage.getNameProduct("Sauce Labs Bike Light");
        inventoryPage.clickAddToCartButton();

        assertEquals(cartPage.getProductNameInBasketByIndex(0),nameProduct,"Товар не совпадает");
    }
    @Test
    public void comparePriceOfProductInCartWithPriceInCatalog() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        String priceInCatalog = inventoryPage.getPrice("Sauce Labs Bike Light");
        inventoryPage.clickCartButton();

        assertEquals(cartPage.getPriceInCartByNameProduct("Sauce Labs Bike Light"),priceInCatalog,
                "Цена не совпадает");

    }

    @Test
    public void clickContinueShoppingButton() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Backpack");
        inventoryPage.clickCartButton();
        cartPage.clickContinueShoppingButton();

        assertTrue(inventoryPage.isPageOpen(), "Пользователь не вернулся на страницу inventory");
    }

    @Test
    public void removeAnItemFromShoppingCartByClickingRemoveButton(){
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Backpack");
        inventoryPage.clickCartButton();
        int size = cartPage.getSizeListProduct();

        assertEquals(size,"1","Товар отсутствует в корзине");

        cartPage.clickRemoveButton("Sauce Labs Backpack");

        assertEquals(cartPage.getSizeListProduct(),"0","Товар не удален из корзины");

    }

    @Test
    public void pressCheckoutButton() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Backpack");
        inventoryPage.clickCartButton();
        cartPage.clickCheckoutButton();

        assertTrue(checkoutPage.isPageOpen(), "Пользователь не перешел на страницу Checkout");
    }


}