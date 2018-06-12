package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helperFramework.locators;

public class SharkLasersPage {
	private static WebElement element = null;
	   public static WebElement setNameLocator(WebDriver driver){		   
	         element = driver.findElement(By.id("inbox-id"));	 
	         return element;	 
	         }
	   public static WebElement saveEmailLocator(WebDriver driver){		   
	         element = driver.findElement(By.className("save"));	 
	         return element;	 
	         }
	   public static WebElement registrationEmail(WebDriver driver){		   
	         element = driver.findElement(By.partialLinkText("noreply@pilet.ee"));	 
	         return element;	 
	         }
	  
	   public static WebElement registrationLink(WebDriver driver){		   
	         element = driver.findElement(By.partialLinkText("http://tallinn.dev.ridango.com/"));	 
	         return element;	 
	         }
}
