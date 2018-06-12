package appModule;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;


import pageObjects.HomePage;
import utility.Constant;

public class LoginAction {	
	
	
	public static void execute (WebDriver driver, String username, String password){
		
	Reporter.log("Clicking on log in button<br>");
	HomePage.loginLocator (driver).click();
	
	Reporter.log("Inserting username:" + username+"<br>");
    HomePage.usernameLocator(driver).sendKeys(username);
    
    Reporter.log("Inserting password:" + password+"<br>");
    HomePage.passwordLocator(driver).sendKeys(password);
    
    Reporter.log("Submitting the form<br>");
    HomePage.loginFormLocator(driver).submit();
    
    String messageLogin = HomePage.messageLocator(driver).getText();      
    messageLogin = messageLogin.trim(); // Remove the blank space before and after the string message
    
    Assert.assertEquals(messageLogin, "Sisselogimine õnnestus");	    

	}
}
