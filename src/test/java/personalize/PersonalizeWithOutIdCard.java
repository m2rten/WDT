package personalize;

import org.testng.annotations.Test;

import appModule.LoginAction;
import pageObjects.HomePage;
import pageObjects.PersonalizePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import utility.*;
public class PersonalizeWithOutIdCard {
private WebDriver driver;
  @Test
  public void personalizeWithWrongIdCardNumber() {
	  LoginAction.execute(driver, Constant.Username, Constant.Password);
	  MyLogger.testlog("Going to personalize tab");
	  HomePage.personalizationFormLocator(driver).click();
	  PersonalizePage.cardIDLocator(driver).sendKeys(Constant.CardNumber);
	  MyLogger.testlog("Entering personal code "+Constant.PersonalCode);
	  PersonalizePage.personalCodeLocator(driver).sendKeys(Constant.PersonalCode);
	  MyLogger.testlog("Entering id card number which is not related to the id card "+ Constant.WrongIdCardNumber);
	  PersonalizePage.idCardNumberLocator(driver).sendKeys(Constant.WrongIdCardNumber);
	  MyLogger.testlog("Submiting the form");
	  PersonalizePage.submitPersonalizationLocator(driver).click();
	  MyLogger.testlog("Read the alert box:");
	  String message = PersonalizePage.personalizationLResultocator(driver).getText().trim() ;
	  MyLogger.testlog(message);
	  Assert.assertEquals(PersonalizePage.personalizationLResultocator(driver).getText().trim() , Constant.personalizationResultWrongIdCard);

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
