package TestUtils;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.TestBase;
import utilities.ExcelReader;

public class TestUtils extends TestBase
{  
	
	
	
	
	
	
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m)
	{
		
		String sheetName=m.getName();	
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
	
	
	public static boolean isTestRunnable(String testname,ExcelReader excel)
	{
		
	   int rows=excel.getRowCount("test_suite");	
		
	   for(int rNum=2;rNum<=rows;rNum++)
	   {
		   String testcase=excel.getCellData("test_suite", "TCID", rNum);
	   
	     if(testcase.equalsIgnoreCase(testname))
	     {
	    	 String runmode=excel.getCellData("test_suite", "runmode", rNum);
	        
	    	 if(runmode.equalsIgnoreCase("Y"))
	        return true;
	    	 else
	    		 return false;
	     
	     }
	   }
	 return false;
	}
	
	

}
