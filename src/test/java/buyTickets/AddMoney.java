package buyTickets;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.*;
import pageObjects.*;
import utility.*;

public class AddMoney {
	   private WebDriver driver;	
	   private String testname;
	
		@Test
		public void addMoneyToCard() throws InterruptedException
		{
	        LoginAction.execute(driver, Constant.Username, Constant.Password);	 
	        
	        MyLogger.testlog("Clicking on add Money accordion");
	        BuyPage.addMoneyLocator(driver).click();
	        
	        MyLogger.testlog("Adding card number:"+Constant.CardNumber);
	        BuyPage.insertAddMoneyCardNumberLocator(driver).sendKeys(Constant.CardNumber);
	        
	        MyLogger.testlog("Adding 1 euro to card");
	        BuyPage.add1EuroToCartLocator(driver).click();
	        
	        MyLogger.testlog("Getting the sum in the Cart");
	        ShoppingCartPage.shoppigCartSumLocator(driver).getText();
	        
	        MyLogger.testlog("Verifying that the cart has 1 euros");
	        assertEquals(ShoppingCartPage.shoppigCartSumLocator(driver).getText(), "KOGUSUMMA\n1.00 EUR");
	        
	        
		}
		
		@Test (dependsOnMethods = { "addMoneyToCard" })
		public void addMoneyToPersonalCode() throws InterruptedException
		{
	
	        driver.get(Constant.URL);;	        
	        BuyPage.addMoneyLocator(driver).click();
	        MyLogger.testlog("Inserting card number: 38212132724");
	        BuyPage.insertAddMoneyCardNumberLocator(driver).sendKeys("38212132724");
	        MyLogger.testlog("Clicking on one euro add");
	        BuyPage.add1EuroToCartLocator(driver).click();
	        MyLogger.testlog("Verifying that the cart has 2 euros");
	        assertEquals(ShoppingCartPage.shoppigCartSumLocator(driver).getText(), "KOGUSUMMA\n2.00 EUR");
	        PaymentAction.execute(driver);
		}
	    @Parameters({"headless"})
		@BeforeClass
		public void beforeClass(final ITestContext testContext, boolean headless) {	
	    	System.out.println(testContext.getName());	
	    	driver = webDrivers.getWebDriver(headless);
	        driver.get(Constant.URL);
		    
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
