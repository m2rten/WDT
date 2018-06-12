package settings;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.TicketsPage;
import utility.Constant;
import utility.NgMethods;
import utility.Utility;


public class ChangePassword {
	   private WebDriver driver;	 
		@Test
		public void changePassword() 
		{
			LoginAction.execute(driver, Constant.Username, Constant.Password);
			HomePage.ticketsViewByUsernameLocator(driver).click();
			TicketsPage.myProfileLocator(driver).click();
			TicketsPage.changePasswordLocator(driver).click();
			TicketsPage.oldPasswordLocator(driver).sendKeys(Constant.Password);
			TicketsPage.newPasswordLocator(driver).sendKeys(Constant.NewPassword);
			TicketsPage.newPasswordAgainLocator(driver).sendKeys(Constant.NewPassword);
			TicketsPage.confirmPasswordChangeLocator(driver).click();
			assertEquals(HomePage.messageLocator(driver).getText().trim(),"Parool uuendatud");
			HomePage.ticketsViewByUsernameLocator(driver).click();
			TicketsPage.myProfileLocator(driver).click();
			TicketsPage.changePasswordLocator(driver).click();
			TicketsPage.oldPasswordLocator(driver).sendKeys(Constant.NewPassword);
			TicketsPage.newPasswordLocator(driver).sendKeys(Constant.Password);
			TicketsPage.newPasswordAgainLocator(driver).sendKeys(Constant.Password);
			TicketsPage.confirmPasswordChangeLocator(driver).click();
			assertEquals(HomePage.messageLocator(driver).getText().trim(),"Parool uuendatud");
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
