package utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager
{

	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			extent=new ExtentReports("D:\\selenium\\Data_Driven_Project\\test-output\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
		
			extent.loadConfig(new File("D:\\selenium\\Data_Driven_Project\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
			
		}
		
		return extent;
	}
	
}
