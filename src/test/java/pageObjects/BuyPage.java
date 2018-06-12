package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helperFramework.locators;

public class BuyPage {
	private static WebElement element = null;
	   public static WebElement addMoneyLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[1]/div[1]/ul/li[2]/a"));	 
	         return element;	 
	         }
	   public static WebElement insertAddMoneyCardNumberLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id=\"card_0_0\"]"));	 
	         return element;	 
	         }
	   public static WebElement add1EuroToCartLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id=\"pr-6849\"]/div[3]/div/div[2]/button[1]"));
	         return element;	 
	         }
	   public static WebElement dayAddToCartLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//*[@id=\"pr-3102\"]/div[3]/div/div[2]/button[1]"));
	         return element;	 
	         }
}
