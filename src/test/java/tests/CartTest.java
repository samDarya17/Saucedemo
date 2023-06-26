package tests;

import org.testng.annotations.Test;

import static pages.CartPage.*;

public class CartTest extends BaseTest{

        @Test
        public void CartButtonIsWorking() {
            cartPage.loginAndOpenCart();
            cartPage.titleOpenCartIsVisible();
        }

        @Test
        public void CheckOutButtonIsWorking() {
            cartPage.loginAndOpenCart();
            driver.findElement(CHECKOUT_BUTTON).click();
            cartPage.titleOpenCheckOutIsVisible();
        }

        @Test

        public void ContinueButtonIsWorking() {
            cartPage.loginAndOpenCart();
            driver.findElement(CONTINUESHOPPING_BUTTON).click();
            cartPage.titleContinueShoppingIsVisible();

        }

        @Test
        public void RemoveButtonIsWorking() {
            loginPage.open();
            loginPage.login("standard_user", "secret_sauce");
            cartPage.addItemInCartByItemName("Sauce Labs Backpack");
            cartPage.openCartButtonClick();
            driver.findElement(REMOVE_BUTTON).click();
            cartPage.elementIsNotDisplayed("remove-sauce-labs-backpack");
            cartPage.titleOpenCartIsVisible();

        }

        @Test
        public void CheckOutPriceCorrect() {
            loginPage.open();
            loginPage.login("standard_user", "secret_sauce");
            cartPage.addItemInCartByItemName("Sauce Labs Backpack");
            String InventoryItemPrice = cartPage.getBackPackItemPriceFromInventory();
            cartPage.openCartButtonClick();
            String CartItemPrice = cartPage.getBackPackItemPriceFromCart();
            if (InventoryItemPrice.equals(CartItemPrice)) {
                cartPage.titleOpenCartIsVisible();
            }


        }
    }

