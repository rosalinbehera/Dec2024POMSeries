package com.qa.openacrt.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.Opencart.Exceptions.BrowserException;
import com.qa.Opencart.logger.Log;

public class DriverFactory {
WebDriver driver;
Properties prop;
//OptionsManager OptionsManager;
//public static String highlight;
public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();

	public WebDriver initializeDriver(Properties prop) {
		
		String Browsername=prop.getProperty("browser");
		
		//System.out.println("The browsername is:" +Browsername);
		Log.info("The browsername is:" +Browsername);
		
		//highlight=prop.getProperty(highlight);
		
		//OptionsManager=new OptionsManager(prop);
		switch (Browsername.toLowerCase().trim()) {
		case "chrome":
			//driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver()); ;
			
			//driver=new ChromeDriver(OptionsManager.getChromeOptions());
			
			break;
		case "firefox":
			//driver=new FirefoxDriver();
			//driver=new FirefoxDriver(OptionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver());
			
			break;
		case "edge":
			//driver=new EdgeDriver();
			//driver=new EdgeDriver(OptionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver()); 
			
			break;
		case "safari":
			//driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
			
			break;

		default:
			//System.out.println("Please Enter the correct browser name");
			Log.error("Please Enter the correct browser name");
			throw new BrowserException("Browser not found"+Browsername);
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
		
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties initproperties() {
		// envName=qa,stage,prod,uat,dev
		// mvn clean install -Denv="qa"
		FileInputStream ip = null;
		prop = new Properties();

		String envName = System.getProperty("env");
		System.out.println("Running tests on Env: " + envName);

		try {
			if (envName == null) {
				System.out.println("No env is given...hence running it on QA env...");
				ip = new FileInputStream(".\\src\\test\\resource\\config\\config.QA.properties");
			} else {

				switch (envName.toLowerCase().trim()) {
				case "QA":
					ip = new FileInputStream(".\\src\\test\\resource\\config\\config.QA.properties");
					break;
				case "dev":
					ip = new FileInputStream(".\\src\\test\\resource\\config\\config.dev.properties");
					break;
				case "stage":
					ip = new FileInputStream(".\\src/test/resources/config/config.stage.properties");
					break;
				case "uat":
					ip = new FileInputStream(".\\src\\test\\resource\\config\\config.uat.properties");
					break;
				case "prod":
					ip = new FileInputStream(".\\src\\test\\resource\\config\\config.prod.properties");
					break;

				default:
					System.out.println("plz pass the right env name... " + envName);
					throw new FrameworkException("Environment not found" + " : " + envName);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;

	}
	
	
	
	
	/**
	 * take screenshot
	 */
	
	public static String getScreenshot(String methodName) {
		
	
			File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		//temp directory
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";

		File destination = new File(path);

		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	
	
	
}
