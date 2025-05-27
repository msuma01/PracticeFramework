package com.qa.opencarts.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencarts.factory.DriverFactory;
import com.qa.opencarts.pages.AccountsPage;
import com.qa.opencarts.pages.LoginPage;
import com.qa.opencarts.pages.ProductInfoPage;
import com.qa.opencarts.pages.RegistrationPage;
import com.qa.opencarts.pages.ResultsPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage lf;
	protected AccountsPage acc;
	protected ResultsPage rp;
	protected ProductInfoPage pip;
	protected RegistrationPage Register;
	
	//protected SoftAssert softAssert ;
	@Parameters({"browser"})
	
	@BeforeTest
	public void setup(@Optional("chrome") String browserName) {
		
		df = new DriverFactory();
		prop = df.initprop();
		//check if browser parameter is coming from testng.xml
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		
		driver = df.initDriver(prop);
		lf = new LoginPage(driver);
		//softAssert= new SoftAssert();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
