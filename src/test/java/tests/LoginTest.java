package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{
    @Test
    public void loginUserNameWithValidData(){


        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(inventoryPage.titleIsVisible);

    }
    @Test
    public void loginUserNameShouldBeRequared(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getClass() ,"Epic sadface: Username is required");
    }
    @Test
    public void loginBlockUser(){
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertEquals(loginPage.getErrorMessage() ,"Epic sadface: Sorry, this user has been locked out.");

    }
    @Test
    public void userDoesNotCompleteNamePassword(){
        loginPage.open();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");

    }
    @Test
    public void userEntersSpacesNamePassword(){
        loginPage.open();
        loginPage.login(" "," ");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }
}
