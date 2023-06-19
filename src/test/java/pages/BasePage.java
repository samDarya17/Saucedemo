package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

   final String URL = "https://www.saucedemo.com/v1/";

   public BasePage(WebDriver driver) {
       this.driver = driver;
   }


}
