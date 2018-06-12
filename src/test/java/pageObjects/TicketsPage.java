package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketsPage {
	private static List<WebElement> elements = null;
	private static WebElement element = null;
	   public static WebElement myProfileLocator(WebDriver driver){		   
	         element = driver.findElement(By.linkText("Minu profiil")); 
	         return element;	 
	         }
	   public static WebElement changePasswordLocator(WebDriver driver){		   
	         element = driver.findElement(By.linkText("Muuda parooli")); 
	         return element;	 
	         }
	   public static WebElement oldPasswordLocator(WebDriver driver){		   
	         element = driver.findElement(By.name("old_password")); 
	         return element;	 
	         }
	   public static WebElement newPasswordLocator(WebDriver driver){		   
	         element = driver.findElement(By.name("new_password")); 
	         return element;	 
	         }
	   public static WebElement newPasswordAgainLocator(WebDriver driver){		   
	         element = driver.findElement(By.name("new_password_again")); 
	         return element;	 
	         }
	   public static WebElement confirmPasswordChangeLocator(WebDriver driver){		   
	         elements = driver.findElements(By.xpath("//*[@id=\"name-form\"]/div/input"));
	         System.out.println(elements.get(1).isDisplayed());
	         return elements.get(1);	 
	         }
}
