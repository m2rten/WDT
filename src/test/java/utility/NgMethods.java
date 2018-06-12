package utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import utility.*;

public class NgMethods {
public static void myAfterMethod (WebDriver driver, String testname,ITestResult result){
	
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
if (result.getStatus() == ITestResult.FAILURE) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File("target\\sh\\"+testname+"_"+sdf.format(timestamp)+".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}				     
	   } 
else {
	System.out.println("Test success");
	MyLogger.testlog("Test passed", "green");}
driver.quit();
}

public static WebDriver myBeforeTest (boolean headless, String url){	
	final WebDriver driver;
	driver = webDrivers.getWebDriver(headless);
    driver.get(url);
    return driver;
}
}
