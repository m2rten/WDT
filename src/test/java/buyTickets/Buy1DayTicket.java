package buyTickets;		

import utility.webDrivers;
import pageObjects.BuyPage;
import utility.*;
import helperFramework.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import appModule.LoginAction;
import appModule.PaymentAction;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;	
import java.lang.reflect.Method;
import appModule.PaymentAction;
import org.testng.Reporter;

public class Buy1DayTicket {		
	   private WebDriver driver;	
	   boolean elementNotFound;
	  
		@Test
		public void testBuyDayTicket() throws InterruptedException
		{
	    	By dayPanelLocator = locators.getDayPanelLocator();
	        By insert1DayCardNumberLocator = locators.getInsert1DayCardNumberLocator(); // Insert Card Number
	        By confirmTicketsLocator = By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/div/div/input"); // Confirm Tickets

	        By confirmPaymentInNetsLocator =locators.getConfirmPaymentInNetsLocator();
	        By returnToMerchantLocator=locators.getReturnToMerchantLocator();
	        By downloadLinkLocator =locators.getDownloadLinkLocator();
	        
	        String cardNumber = "70060151327";      


	        driver.get(Constant.URL);
	        Reporter.log("Starting up:" + Constant.URL+"<br>");
	        LoginAction.execute(driver, Constant.Username, Constant.Password);
	        
	        Reporter.log("Clicking the one day accordion<br>");	        
	        driver.findElement(dayPanelLocator).click();
	        
	        Reporter.log("Insert card number: "+cardNumber+"<br>");	
	        driver.findElement(insert1DayCardNumberLocator).sendKeys(cardNumber);
	        
	        MyLogger.testlog("Clicking 'Add to cart'");	
	        BuyPage.dayAddToCartLocator(driver).click();
	        
	        
	        PaymentAction.execute(driver);
	        MyLogger.testlog("Confirming payment in Nets");
		    driver.findElement(confirmPaymentInNetsLocator).click();
		    driver.findElement(returnToMerchantLocator).click();

	        boolean pdfExists = driver.findElements( downloadLinkLocator).size() != 0 ;
	        Assert.assertTrue(pdfExists,"PDF Link does not exist ");
	        MyLogger.testlog("Check e-mail "+Constant.Username+"for ticket","orange");  
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

			driver.quit();			
		}		
}	