package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtils.TestUtils;
import base.TestBase;

public class Add_Customer_Page extends TestBase
{

	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
  public static void addCustomerPage(String firstname,String lastname,String postcode,String alerttext) throws InterruptedException
  {
	
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.center > button:nth-child(1)")).click();
	   Thread.sleep(2000);
	  driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input")).sendKeys(firstname);
	  
	  
	  driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input")).sendKeys(lastname);
	  
	  
	
	   driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input")).sendKeys(postcode);
	 
	   driver.findElement(By.cssSelector("body > div.ng-scope > div > div.ng-scope > div > div.ng-scope > div > div > form > button")).click();
	  
	    
		
	   Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	   Assert.assertTrue(alert.getText().contains(alerttext));
       Thread.sleep(4000);
	   //Assert.fail("customer not added");
       alert.accept();
       Thread.sleep(3000);
  }  
  
	/* testutils common class
   @DataProvider
	public static Object[][] getData()
	{
		
		String sheetName="Open_Account_Page";
		
     int rows=excel.getRowCount(sheetName);		
		int cols=excel.getColumnCount(sheetName);
		
		Object[][] data=new Object[rows-1][cols];
	
		for(int rowNum=2;rowNum<=rows;rowNum++)
		{
			for(int colNum=0;colNum<cols;colNum++)
			{
				
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			 
			}
			
		}
		
		return data;
	}
	
	*/
}
