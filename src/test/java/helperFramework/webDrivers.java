package helperFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;



public class webDrivers {
	
	private static WebDriver driver;	
	
	public static WebDriver getWebDriver  (boolean headless)
	{
		
  	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
  	ChromeOptions options = new ChromeOptions();
  	if (headless) 
  	{
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
  	}
		driver = new ChromeDriver(options);
		return driver;
	}
	

}
