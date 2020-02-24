package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;





public class BankManagerLoginPage extends TestBase
{
	
        @Test(priority=1)
		public void loginAsBankManager() throws WebDriverException, IOException, InterruptedException
		{
        	
            verifyequ("vaibhav","sanjay");
        	
            Thread.sleep(3000);
			log.debug("inside login page");
			
			 //using normal way
			//driver.findElement(By.cssSelector(or.getProperty("bmlbtn"))).click();
		      
			 //using keyword
			Thread.sleep(3000);
			clickOn("bmlbtn");
			log.debug("login successfull!!");

		   //fourcefully failed
		   //Assert.fail("login not successfull");
		   
		   /* in customlisteners class when test is failed
		   Reporter.log("login suceesfully!!");

		   //convert simple view into HTML view.
		   System.setProperty("org.uncommons.reportng.escape-output","false");
		  Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Vaibhav\\Pictures\\Screenshots\\Screenshot (6).png\">ScRENSHOT</a>");

		   Reporter.log("</br>");
		   
		   Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Vaibhav\\Pictures\\Screenshots\\Screenshot (6).png\"><img src=\"C:\\Users\\Vaibhav\\Pictures\\Screenshots\\Screenshot (6).png\" height=200 weight=210></img></a>");
		 */
		}
	
	
}
