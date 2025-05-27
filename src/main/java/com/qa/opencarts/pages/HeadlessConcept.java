package com.qa.opencarts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadlessConcept {
	public static void main (String[] args) throws InterruptedException {
		//headless : no browser
		//testing is done behind the scene
		
		//chrome: ChromeOptions
		//furefoxOptions
		//edgeOptions
//		
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--incognito");
		//co.addArguments("--headless");
		
//		WebDriver driver = new ChromeDriver(co);
		//incognito
		
		//FirefoxOptions fo = new FirefoxOptions();
		//fo.addArguments("--headless");
//		WebDriver driver = new FirefoxDriver(fo);
//		fo.addArguments("--incognito");
		
		EdgeOptions eo = new EdgeOptions();
		//eo.addArguments("--headless");
		WebDriver driver = new EdgeDriver(eo);
		eo.addArguments("--Inprivate");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Forgotten Password")).click();
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
	}

}
