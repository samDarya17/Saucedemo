package SauseDEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SortProductTest extends BaseTest{
    String userName = "userName";
    String password = "password";
    String loginButton = "loginButton";
    String cartButton = "//a[@class='shopping_cart_link']";

    @Test
    public void checkSortProduct(){
        driver.get(url);
        driver.findElement(By.id(userName)).sendKeys("standard_user");
        driver.findElement(By.id(password)).sendKeys("secret_sauce");
        driver.findElement(By.id(loginButton)).click();


        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        List<String> unsortedNameProduct = new ArrayList<>();
        unsortedNameProduct.add(webElementList.get(0).getText());
        unsortedNameProduct.add(webElementList.get(1).getText());
        unsortedNameProduct.add(webElementList.get(2).getText());
        unsortedNameProduct.add(webElementList.get(3).getText());
        unsortedNameProduct.add(webElementList.get(4).getText());
        unsortedNameProduct.add(webElementList.get(5).getText());
        Collections.sort(unsortedNameProduct);

        WebElement sortA_Z = driver.findElement(By.xpath("//option[@value='az']"));
        sortA_Z.click();

        List<WebElement> webElementListSorted = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        List<String> sortedNameProduct = new ArrayList<>();
        sortedNameProduct.add(webElementListSorted.get(0).getText());
        sortedNameProduct.add(webElementListSorted.get(1).getText());
        sortedNameProduct.add(webElementListSorted.get(2).getText());
        sortedNameProduct.add(webElementListSorted.get(3).getText());
        sortedNameProduct.add(webElementListSorted.get(4).getText());
        sortedNameProduct.add(webElementListSorted.get(5).getText());

        assertEquals(sortedNameProduct,unsortedNameProduct, "Товар не отсортирован");
    }


    }



