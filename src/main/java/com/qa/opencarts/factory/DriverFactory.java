package com.qa.opencarts.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;
import com.qa.opencarts.Error.AppErrors;
import com.qa.opencarts.exceptions.BrowserException;

public class DriverFactory {
	

	WebDriver driver;
    Properties prop;
    
    public static String isHighlight;
    public static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	/**
	 * This method is used to initialize the driver
	 * @param browserName
	 * @return WEbdriver
	 */
	
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		
		System.out.println("Please Pass the browserName:"+browserName);
		isHighlight=prop.getProperty("highlight");
		OptionsManager op = new OptionsManager(prop);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver(op.getChromeOptions());
			tlDriver.set(new ChromeDriver(op.getChromeOptions()));
			
			break;
		case "firefox":
			//driver = new FirefoxDriver(op.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(op.getFirefoxOptions()));
		break;

		case "edge" :
		//driver = new EdgeDriver(op.getEdgeOptions());
			tlDriver.set(new EdgeDriver(op.getEdgeOptions()));
		break;
		default:
			System.out.println(AppErrors.INVALID_BROWSER_MSG+browserName+"is invalid");
			throw new BrowserException(AppErrors.INVALID_BROWSER_MSG); 
			
		}
	
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
		
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	/*
	 * This method is used to initialize the properties from config file
	 */
	
	//mvn clean install -Denv="qa"
	public Properties initprop() {
		prop = new Properties();
		
		FileInputStream ip=null;
		String envName= System.getProperty("env");
		System.out.println("Running tests on env"+envName);
		try {
		if(envName==null) {
			System.out.println("env is null.... Hence running the tests on env qa");
			 ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			
		}
		else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;
			case "stg":
				ip = new FileInputStream("./src/test/resources/config/stg.config.properties");
				break;
			case "dev":
				ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;	
			case "prod":
				ip = new FileInputStream("./src/test/resources/config/config.properties");
				break;		
				

			default:
				System.out.println("Please Enter the right Environment Name"+envName);
				throw new BrowserException("************INVALID ENVIRONMENT***********"+envName);
				
			}
		}
		prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
		e.printStackTrace();
		}
		
		
		
		return prop;
		
	}
	
	/**
	 * take screenshot
	 */
	
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);//temp dir
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()+ ".png";
		File destination = new File(path);
		try {
	       Files.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	
}
