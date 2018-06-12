package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.*;

public class HomePage {
	private static WebElement element = null;
	   public static WebElement loginLocator(WebDriver driver){		   
	         element = driver.findElement(By.className("login-item"));	 
	         return element;	 
	         }
	   public static WebElement ticketsViewByUsernameLocator(WebDriver driver){		   
	         element = driver.findElement(By.className("top-bar-username")); 
	         return element;	 
	         }
	   public static WebElement usernameLocator(WebDriver driver){	
		     By elementLocator = By.name("username");
	         element = driver.findElement(elementLocator);	 
			 //helper.waitElementVisibleOnPage(driver, elementLocator,1,"Element Username not visible");
	         return element;	 
	         }
	   public static WebElement passwordLocator(WebDriver driver){		   
	         element = driver.findElement(By.id("password"));	 
	         return element;	 
	         }
	   public static WebElement messageLocator(WebDriver driver){		   
	         element = driver.findElement(By.className("alert-box-content"));	 
	         return element;	 
	         }

	   public static WebElement loginFormLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id='login-form']/div[2]/a"));	 
	         return element;	 
	         }
	   public static WebElement registerButtonLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id=\"login_modal\"]/div[3]/div/a"));	 
	         return element;	 
	         }
	   public static WebElement personalizationFormLocator(WebDriver driver){	
	         element = driver.findElement(By.linkText("Isikusta"));	 
	         return element;	 
	         }
}
