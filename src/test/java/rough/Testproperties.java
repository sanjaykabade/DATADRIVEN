package rough;

import java.io.FileInputStream;
import java.util.Properties;
//import java.util.Properties;

public class Testproperties 
{

	public static void main(String[] args) throws Exception
	{
	Properties config=new Properties();
    FileInputStream fis=new FileInputStream("D:\\selenium\\DATA_DRIVEN\\src\\test\\resources\\properties\\Config.properties");
    
	config.load(fis);
	System.out.println(config.getProperty("browser"));	
		
		
	Properties or=new Properties();
	FileInputStream fis1=new FileInputStream("D:\\selenium\\DATA_DRIVEN\\src\\test\\resources\\properties\\OR.properties");
	or.load(fis1);
	
	//driver.findElements(by.cssSelector(or.getProperty("bmlbtn"))).click;
	System.out.println(or.getProperty("bmlbtn"));
	
	
	
	}
	
	
	
	
}
