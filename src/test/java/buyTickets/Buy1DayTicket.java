package buyTickets;		
import java.io.File;
import java.io.IOException;
import helperFramework.helper;
import helperFramework.webDrivers;
import helperFramework.locators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;	
import java.lang.reflect.Method;

public class Buy1DayTicket {		
	   private WebDriver driver;	
	   private String testname;
	   boolean elementNotFound;
	  
		@Test
		public void testBuyDayTicket()
		{
	    	By loginLocator = locators.getLoginLocator();
	    	By dayPanelLocator = locators.getDayPanelLocator();
	        By usernameLocator = By.name("username");
	        By passwordLocator = By.id("password");
	        By loginFormLocator =  By.xpath("//*[@id='login-form']/div[2]/a");
	        By cardInsertFormLocator =  By.xpath("//*[@id='login-form']/div[2]/a");
	        By messageLocator =  By.className("alert-box-content");
	        By insert1DayCardNumberLocator = locators.getInsert1DayCardNumberLocator(); // Insert Card Number
	        By add1DayToCartLocator = locators.get1DayAddToCartLocator(); // Add To Cart
	        By confirmTicketsLocator = By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/div/div/input"); // Confirm Tickets
	        By paymentMethodsLocator = By.id("payment_method"); // Payment Methods
	        By confirmPaymentInNetsLocator =locators.getConfirmPaymentInNetsLocator();
	        By returnToMerchantLocator=locators.getReturnToMerchantLocator();
	        By downloadLinkLocator =locators.getDownloadLinkLocator();
	        
	        String cardNumber = "70060151327";
	        String baseUrl = "http://tallinn.dev.ridango.com/";
	        String expectedTitle = "Tallinn";
	        String actualTitle = "";
	        String username="marten@ridango.com";
	        String password="tere123";
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        driver.get(baseUrl);
	        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below		
	        driver.manage().window().maximize();

	        // This  will scroll down the page by  1000 pixel vertical		

	        driver.findElement(loginLocator).click();

	        waitElementVisibleOnPage(driver, usernameLocator ,1,"Element Username not visible");
	        driver.findElement(usernameLocator).sendKeys(username);
	        System.out.println("New");
	        actualTitle = driver.getTitle();

	        driver.findElement(passwordLocator).sendKeys(password);
	        driver.findElement(loginFormLocator).submit();
	        try {
	        	System.out.println("Sleeping");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	
	        String messageLogin = driver.findElement(messageLocator).getText();
	        messageLogin = messageLogin.trim(); // Remove the blank space before and after the string message


	       // helper helperObj;
			// Insert card number
	        // Assert.assertEquals(helperObj.isElementPresent(driver,insertCardNumberLocator),true,"Element text input card number not visible");
	        driver.findElement(dayPanelLocator).click();
	        driver.findElement(insert1DayCardNumberLocator).sendKeys(cardNumber);

	        driver.findElement(add1DayToCartLocator).click();
	        
	        // Select payment methods (credit card)
            
            /* Assert.assertEquals(messageLogin, "Sisselogimine ơnnestus");*/
	            WebElement element =driver.findElement(paymentMethodsLocator);
	            Select dropdown = new Select(driver.findElement(paymentMethodsLocator));
	            js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);

	            dropdown.selectByValue("286");

		    driver.findElement(confirmTicketsLocator).click();
		    driver.findElement(confirmPaymentInNetsLocator).click();
		    driver.findElement(returnToMerchantLocator).click();

	        boolean pdfExists = driver.findElements( downloadLinkLocator).size() != 0 ;
	        Assert.assertTrue(pdfExists,"PDF Link does not exist ");
	        driver.close();	
		}
	    public static void waitElementVisibleOnPage(WebDriver driver,By elementLocator,int timer,String messageFault){
	        boolean elementNotFound = false;
	        WebDriverWait waitElement = new WebDriverWait(driver, timer);
	        try{
	        WebElement element = waitElement.until(
	                ExpectedConditions.visibilityOfElementLocated(elementLocator));
	        }catch(Exception e){
	            elementNotFound = true;
	            Assert.assertFalse(elementNotFound,messageFault+" "+ elementLocator);
	        }
	    }
	    @Parameters({ "headless"})
		@BeforeTest
		public void beforeTest(final ITestContext testContext, boolean headless) {	 
			System.out.println(testContext.getName());	
			driver = webDrivers.getWebDriver(headless);
		    
		}		
		@AfterMethod
		public void tearDown(ITestResult result, Method method) {
				testname = method.getName();
				System.out.println ("Tear down");
			   if (result.getStatus() == ITestResult.FAILURE) {
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					// Now you can do whatever you need to do with it, for example copy somewhere
					try {
						FileUtils.copyFile(scrFile, new File("target\\sh\\"+"buy"+".png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				      //your screenshooting code goes here
				   }       
		}
		@AfterTest
		public void afterTest() {

			driver.quit();			
		}		
}	