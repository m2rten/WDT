package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	private static WebElement element = null;
	   public static WebElement paymentMethodsLocator(WebDriver driver){		   
	         element = driver.findElement(By.id("payment_method"));	 
	         return element;	 
	         }
	   public static WebElement shoppigCartSumLocator(WebDriver driver){		   
		   JavascriptExecutor js = (JavascriptExecutor) driver; 
	       element  = driver.findElement(By.className( "sc-total-row"));
	       //System.out.println(element);
		   js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
	       System.out.println(element.getText()) ;
		   return element;	 
	         }
	   public static WebElement confirmTicketsLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/div/div/input"));	 
	   	     return element;
	         }
}


