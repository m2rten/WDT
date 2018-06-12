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

public class Utility {
public static void takeScreenShot (WebDriver driver, String testname, ITestResult result){
	
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
}
public static void mywait(int secs){

try {
	Thread.sleep (secs*1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}
}
