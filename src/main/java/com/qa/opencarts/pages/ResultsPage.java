package com.qa.opencarts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencarts.constants.AppConstants;
import com.qa.opencarts.utils.Element_Util;

public class ResultsPage {
	
	private WebDriver driver;
	private Element_Util el;
	
	private  By searchHeader = By.cssSelector("div#content h2");
	private By results = By.cssSelector("div.product-thumb");
	
	public ResultsPage(WebDriver driver) {
		this.driver= driver;
		el = new Element_Util(driver);
	}
	
	public String getSearchHeader() {
		String Header=el.WaitForElementVisibile(searchHeader, AppConstants.DEFAULT_SHORT_TIMEOUT).getText();
		System.out.println(Header);
		return Header;
		
	}
	public int getSearchResultsCount() {
		int resultcount= el.WaitForElementsVisible(results, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		System.out.println("Search Result Count is =====>>"+resultcount);
		return resultcount;
		
	}
	
	public  ProductInfoPage selectProduct(String productName) {
		System.out.println("Selecting Product:"+productName);
		el.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
}