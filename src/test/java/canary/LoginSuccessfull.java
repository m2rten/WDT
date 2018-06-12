package canary;
		
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import pageObjects.HomePage;
import utility.*;
import appModule.LoginAction;

public class LoginSuccessfull {		
	   private WebDriver driver;	
	   private String testname;
	
		@Test
		public void testLoginToClientWeb()
		{
			Reporter.log("Starting up:" + Constant.URL +"<br>");
	        driver.get(Constant.URL);
	        
	        LoginAction.execute(driver, Constant.Username, Constant.Password);
	        
	        Reporter.log("Reading the welcome message<br>");
	        String messageLogin = HomePage.messageLocator(driver).getText();      
	        messageLogin = messageLogin.trim(); // Remove the blank space before and after the string message
	        
	        Assert.assertEquals(messageLogin, "Sisselogimine õnnestus");	        
	        driver.close();
		}

	    @Parameters({ "headless"})
		@BeforeTest
		public void beforeTest(final ITestContext testContext, boolean headless) {	 
			System.out.println(testContext.getName());	
			driver = webDrivers.getWebDriver(headless);
		    
		}	
	    
		@AfterMethod
		public void tearDown(ITestResult result, Method method) {
			Utility.takeScreenShot(driver,method.getName(), result);
      
		}
		@AfterTest
		public void afterTest() {
			Reporter.log("Closing the driver<br>");
			driver.quit();			
		}		
}	