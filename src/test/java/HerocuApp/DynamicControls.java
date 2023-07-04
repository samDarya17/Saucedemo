package HerocuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class DynamicControls extends BaseTest{
    String removeButton = "removeButton";
    @Test
    public void dynamicTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        Instant wait = null;
        wait.until(ExpectedConditions.textToBe(By.id("message"),"It's gone!");




    }
}
