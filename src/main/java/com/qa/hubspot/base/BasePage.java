package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.util.TimeUtils;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Murari Kumar
 *
 */
public class BasePage {
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method is used to Initialize the WebDriver
	 * @param prop
	 * @return WebDriver
	 */
	public WebDriver initialize_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser" + "browserName"
					+ "is not define in the properties file, please give the correct broser name");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		return driver;
	}
	/**
	 * This method used to Initialize the Properties and return the properties reference 
	 * @return
	 */
	public Properties initialize_Properties(){
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\LENOVO PC\\workspace\\Webservice-Framework\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
	

}
