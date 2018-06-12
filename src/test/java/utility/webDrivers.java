package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Parameters;



public class webDrivers {
	
	private static WebDriver driver;	
	
	public static WebDriver getWebDriver  (boolean headless)
	{
		
  	System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
  	
  	Reporter.log("Creating a new WebDriver<br>");
  	ChromeOptions options = new ChromeOptions();
  	if (headless) 
  	{   Reporter.log("Browser  is headless<br>");
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080");
  	}
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

}
