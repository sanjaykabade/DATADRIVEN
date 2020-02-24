package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExcelReader;
import utilities.ExtentManager;






public class TestBase
{

	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoylog");
	public static ExcelReader excel=new ExcelReader("D:\\selenium\\Data_Driven_Project\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp() throws Exception 
	{
		if(driver==null)
		{	
		try {
			fis=new FileInputStream("D:\\selenium\\DATA_DRIVEN\\src\\test\\resources\\properties\\Config.properties");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("config file loaded");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		try {
			fis=new FileInputStream("D:\\selenium\\DATA_DRIVEN\\src\\test\\resources\\properties\\or.properties");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
       try {
		or.load(fis);
		log.debug("or file loaded");
       }
       catch (IOException e) {
		e.printStackTrace();
	}
    
        
      
       System.setProperty("webdriver.gecko.driver","D:\\selenium_backup\\geckodriver.exe");
       driver=new FirefoxDriver();
       log.debug("firefox launch");
       driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");  
       log.debug("navigate to w2automation");
       
       driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
		 wait=new WebDriverWait(driver,5);
      
		}
		
	
	} 

	//create keyword
	public static void clickOn(String locators)
	{
		driver.findElement(By.cssSelector(or.getProperty(locators))).click();
		test.log(LogStatus.INFO, "clicking on:"+locators);
	}
	
	
	public static void type(String locators,String value)
	{
		driver.findElement(By.xpath(or.getProperty(locators))).sendKeys(value);
		test.log(LogStatus.INFO, "typing on:"+locators+" entered value is"+value);
		
	}

    	
	public static void verifyequ(String expect,String actual) throws WebDriverException, IOException
	{
		try 
		{
			Assert.assertEquals(expect, actual);
		}
		catch(Throwable e)
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("D:\\selenium\\Data_Driven_Project\\src\\test\\java\\base\\error1.png"));
			
			//report ng
			  System.setProperty("org.uncommons.reportng.escape-output","false");
				
			Reporter.log("</br>"+"verification failed"+e.getMessage()+"<br>");
			
			Reporter.log("<a target=\"_blank\" href=\"D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error1.png\"><img src=\"D:\\selenium\\Data_Driven_Project\\src\\test\\java\\base\\error1.png\" height=220 weight=230></img></a>");
		        	
			//extent report
			  test.log(LogStatus.FAIL, "verification failed"+e.getMessage()+"</br>");
			  test.log(LogStatus.FAIL, test.addScreenCapture("D:\\selenium\\Data_Driven_Project\\src\\test\\java\\listeners\\error1.png"));
					
			
		}
	}
	
	

	
	@AfterSuite
	public void tearDown()
	{
		log.debug("suucess executed in tearDown");
		
	}
	
	
	
	
	
	
	
	
	
	
}
