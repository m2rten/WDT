package settings;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.LoginAction;
import pageObjects.*;
import utility.Constant;
import utility.NgMethods;
import utility.Utility;
import utility.webDrivers;


public class CreateUser {
	   private WebDriver driver;	 
	   JavascriptExecutor js = (JavascriptExecutor) driver; 
		@Test
		public void createUser() throws AWTException 
		{
			   Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			   final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			  String email = "rid"+sdf.format(timestamp);
			
			    String newTab =null;
			    ((JavascriptExecutor)driver).executeScript("window.open()");
			    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1));
			    driver.get(Constant.SLURL); 
			    

			 //   SharkLasersPage.setNameLocator(driver).click();
			    //SharkLasersPage.setNameLocator(driver).clear();
			    Actions actions = new Actions(driver);
			    actions.moveToElement(SharkLasersPage.setNameLocator(driver));
			    actions.click();
			   for (int i=0;i<50;i++)
			   {
				   actions.sendKeys(Keys.BACK_SPACE);
			   }
			   actions.sendKeys(email);
			    actions.build().perform();
			    
	
			    SharkLasersPage.saveEmailLocator(driver).click();
			    driver.switchTo().window(tabs.get(0));
			    HomePage.loginLocator(driver).click();
			    actions = new Actions(driver);
			    actions.moveToElement(HomePage.registerButtonLocator(driver));
			    actions.perform();
			    Utility.mywait(1);
			    HomePage.registerButtonLocator(driver).click();
			    RegistrationModal.enterEmailLocator(driver).sendKeys(email+"@sharklasers.com");
			    RegistrationModal.agreeTermsLocator(driver).click();
			    RegistrationModal.registerAccountLocator(driver).click();		    
			    assertEquals(HomePage.messageLocator(driver).getText().trim(), "Registreerumine õnnestus. Teie sisestatud emaili aadressile saadeti link parooli seadmiseks.");
			    driver.switchTo().window(tabs.get(1));
			    Utility.mywait(60);
			    SharkLasersPage.registrationEmail(driver).click();
			    SharkLasersPage.registrationLink(driver).click();
			    Utility.mywait(3);
		}
	
	  @Parameters({"headless"})
	  @BeforeTest
	  public void beforeTest(boolean headless) {
		 driver =  NgMethods.myBeforeTest(headless, Constant.URL);
	  }

	  @AfterMethod
	  public void afterMethod(ITestResult result, Method method) {
		  NgMethods.myAfterMethod(driver,method.getName(), result);
	  }

}
