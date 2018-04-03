package helperFramework;

import org.openqa.selenium.By;

public class locators {
	public static By getLoginLocator (){return By.className("login-item");};
	public static By getAddToCartLocator(){return  By.xpath("//*[@id=\"pr-3110\"]/div[3]/div/div/button");}
	public static By get1DayAddToCartLocator(){return  By.xpath("//*[@id=\"pr-3102\"]/div[3]/div/div[2]/button[1]");}
	
	public static By getConfirmPaymentInNetsLocator(){return  By.xpath("//*[@id=\"wrap\"]/div[1]/fieldset/form/button[1]");}
	public static By getDayPanelLocator(){return  By.xpath("//a[@href='#panel2']");}
	public static By getInsert1DayCardNumberLocator (){return By.id("card_2_0");}
	public static By getReturnToMerchantLocator (){return By.xpath("//*[@id=\"submit-form\"]/button");}
	//*[@id="alerts-container"]/div[2]/div/div/div/span/a[1]
	public static By getDownloadLinkLocator(){return By.xpath("//*[@id=\"alerts-container\"]/div[2]/div/div/div/span/a[1]");}
	

}
