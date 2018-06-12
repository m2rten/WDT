package appModule;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.ShoppingCartPage;
import utility.*;

public class PaymentAction {

	public static void execute (WebDriver driver) throws InterruptedException{
    JavascriptExecutor js = (JavascriptExecutor) driver; 
    
    Select dropdown = new Select(ShoppingCartPage.paymentMethodsLocator(driver));
    js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", ShoppingCartPage.paymentMethodsLocator(driver));
    MyLogger.testlog("Selecting Swedbank");
    dropdown.selectByValue("286");
    MyLogger.testlog("Confirm Shopping Cart");
    js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", ShoppingCartPage.confirmTicketsLocator(driver));
	ShoppingCartPage.confirmTicketsLocator(driver).click();
	MyLogger.testlog("Shopping Cart Confirmed");
	}
}
