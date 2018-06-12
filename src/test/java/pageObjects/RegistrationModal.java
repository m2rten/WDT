package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationModal  {
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	   public static WebElement enterEmailLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/form[1]/input[2]"));	 
	         return element;
	         }
	   public static WebElement agreeTermsLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/form[1]/div[1]/div[1]/input[1]"));	 
	         return element;
	         }
	   public static WebElement registerAccountLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath(" /html[1]/body[1]/div[4]/div[2]/form[1]/div[2]/input[1]"));	 
	         return element;
	         }
	   
	   
	  
}
