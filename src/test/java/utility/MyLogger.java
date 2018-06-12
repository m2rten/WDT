package utility;

import org.testng.Reporter;

public class MyLogger {
	public static void testlog  (String row, String opt )
	{	
		if (opt=="red")
			{
					Reporter.log("<font color=\"red\">"+row+"</font><br>");
			}
		else if (opt=="green")
		{
			Reporter.log("<font color=\"green\">"+row+"</font><br>");
		}
		else if (opt=="orange")
		{
			Reporter.log("<font color=\"orange\">"+row+"</font><br>");
		}
		else {Reporter.log(row+"<br>");}
	}
public static void testlog  (String row)
{
	testlog (row, "");
	
	}
}
