package tests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void logInWithValidData() {
        loginPage.logInWithValidData();

        assertTrue(inventoryPage.isPageOpen());
    }

    @Test
    public void leaveUserFieldEmpty() {
        loginPage.openWebsite();
        loginPage.isPageOpen();
        loginPage.authorization("", "secret_sauce");

        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test
    public void leavePasswordFieldEmpty() {
        loginPage.openWebsite();
        loginPage.isPageOpen();
        loginPage.authorization("standard_user", "");

        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Password is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test
    public void lockedOutUser() {
        loginPage.openWebsite();
        loginPage.isPageOpen();
        loginPage.authorization("locked_out_user", "secret_sauce");

        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Sorry, this user has been locked out.",
                "Текст сообщения неверный или отсутствует");
    }

    @Test
    public void inputDataOfAnUnregisteredUser() {
        loginPage.openWebsite();
        loginPage.isPageOpen();
        loginPage.authorization("A_b_c_d_f", "12_34_56");

        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username and password do not match any user in this service",
                "Текст сообщения неверный или отсутствует");

    }

}