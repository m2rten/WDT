package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalizePage {
	private static WebElement element = null;
	   public static WebElement cardIDLocator(WebDriver driver){		   
	         element = driver.findElement(By.name("card_id") );	 
	         return element;	 
	         }
	   public static WebElement personalCodeLocator(WebDriver driver){		   
	         element = driver.findElement(By.name("personal_code") );	 
	         return element;	 
	         }
	   public static WebElement idCardNumberLocator(WebDriver driver){		   
	         element = driver.findElement(By.name("id_card_number") );	 
	         return element;	 
	         }
	   public static WebElement submitPersonalizationLocator(WebDriver driver){		   
	         element = driver.findElement(By.xpath("//input[@value='Salvesta']"));	 
	         return element;	 
	         }
	   public static WebElement personalizationLResultocator(WebDriver driver){		   
	         element = driver.findElement(By.className("alert-box-content"));	 
	         return element;	 
	         }   
}
