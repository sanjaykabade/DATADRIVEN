package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestUtils.TestUtils;
import base.TestBase;

public class Open_Account_Page extends TestBase 
{

	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	  public static void openAccountPage(String customer,String currency) throws InterruptedException
	  {
		
		Thread.sleep(3000);
      	driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[2]")).click();
    
      	driver.findElement(By.xpath("//select[@id='userSelect']")).sendKeys(customer);
      	driver.findElement(By.xpath("//select[@id='currency']")).sendKeys(currency);
    	
      	 
      	driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		
      	test.log(LogStatus.INFO, "open details successfully!!");
	   
	    driver.switchTo().alert().accept();
	  
	  }
	
	
	/*using testutils class 
	@DataProvider
		public static Object[][] getData()
		{
			
			String sheetName="Add_Customer_Page";
			
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
