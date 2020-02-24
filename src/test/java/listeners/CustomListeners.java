package listeners;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import TestUtils.TestUtils;
import base.TestBase;



public class CustomListeners extends TestBase implements ITestListener {

	
	public void onTestStart(ITestResult result)
	  {  
	 test=rep.startTest(result.getName().toUpperCase());
	/*	//runmodes-Y
		
	  if(!TestUtils.isTestRunnable(result.getName(), excel))
	  {
		  throw new SkipException("skipping the test case"+result.getName().toUpperCase()+ "as Run Mode is No");
		  
	  }
	 */
	 }  

	
	
		public void onTestSuccess(ITestResult result)
		{  
		
			test.log(LogStatus.PASS, result.getName().toUpperCase()+" pass");
			rep.endTest(test);
			rep.flush();
			 test.log(LogStatus.PASS, test.addScreenCapture("D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error.png"));
				
			System.out.println("Success of test cases and its details are : "+result.getName());  
		}  
		  
		public void onTestFailure(ITestResult result) 
		{  
			   System.setProperty("org.uncommons.reportng.escape-output","false");
				
      		

			   test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed eith exception:"+result.getThrowable());
			   test.log(LogStatus.FAIL, test.addScreenCapture("D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error.png"));
				
      			
			   //convert simple view into HTML view.
			  Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Vaibhav\\Pictures\\Screenshots\\Screenshot (6).png\">ScRENSHOT</a>");

			   Reporter.log("</br>");
			   
			   Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Vaibhav\\Pictures\\Screenshots\\Screenshot (6).png\"><img src=\"C:\\Users\\Vaibhav\\Pictures\\Screenshots\\Screenshot (6).png\" height=200 weight=210></img></a>");

			  
			/*   
			   TakesScreenshot ts=(TakesScreenshot)driver;
				
		  try {
				FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),new File("D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error.png"));
			  } 
			 
			   catch (WebDriverException e)
			 {
				e.printStackTrace();
		     } catch (IOException e)
			 
			 {
				e.printStackTrace();
			 }

		  Reporter.log("<a target=\"_blank\" href=\"D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error.png\"><img src=\"D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error.png\" height=200 weight=210></img></a>");
        */
		  
			   rep.endTest(test);
			   rep.flush();
		}  
		  
		public void onTestSkipped(ITestResult result)
		{  
		System.out.println("Skip of test cases and its details are : "+result.getName());  
		}  
		  
		public void onTestFailedButWithinSuccessPercentage(ITestResult result)
		{  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		}  
		  
		public void onStart(ITestContext context) 
		{  
		}  
		  
		public void onFinish(ITestContext context)
		{  
		}  
		
}  
	
	
	
	

