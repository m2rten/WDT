package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class helper {
    public static void waitElementVisibleOnPage(WebDriver driver,By elementLocator,int timer,String messageFault){
        boolean elementNotFound = false;
        WebDriverWait waitElement = new WebDriverWait(driver, timer);
        try{
        WebElement element = waitElement.until(
                ExpectedConditions.visibilityOfElementLocated(elementLocator));
        }catch(Exception e){
            elementNotFound = true;
            Assert.assertFalse(elementNotFound,messageFault+" "+ elementLocator);
        }
    }
}
