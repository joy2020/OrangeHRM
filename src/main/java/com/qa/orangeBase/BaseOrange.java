package com.qa.orangeBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseOrange 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseOrange() 
	{
		FileInputStream file = null;
		try {
			 file = new FileInputStream("C:\\Users\\Maahi\\eclipse-workspace\\OHRM\\src\\main\\java\\com\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop = new Properties();
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializer()
	{
		String Reqbrowser = prop.getProperty("browser");
		if(Reqbrowser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maahi\\Madhulika\\DifferentDrivers_exedownloads\\ChromeDriver_downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(Reqbrowser.equals("edge")) 
		{
			
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	}
	
	
	

}
