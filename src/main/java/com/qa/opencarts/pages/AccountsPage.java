package com.qa.opencarts.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencarts.constants.AppConstants;
import com.qa.opencarts.utils.Element_Util;

public class AccountsPage {
	private WebDriver driver;
	private Element_Util el;
	
	
	 private By logoutlink = By.linkText("Logout"); 
	 private By headers = By.cssSelector("div#content h2");
	 private By search = By.name("search");
	 private By searchIcon = By.cssSelector("button.btn-default");
	 
	 public AccountsPage(WebDriver driver) {
		 this.driver = driver;
		el = new Element_Util(driver);
		 
	 }
	 
	 
	 public String getAccountsPageTitle() {
			
		String title=  el.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIMEOUT);
		 System.out.println(title);
		 return title;
			
		}
	 
	 public boolean isLogoutlinkExist() {
			return	el.IsElementDisplayed(logoutlink);
		}
	 
	 public int getTotalAccountsPageHeaderCount() {
		 return el.WaitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
	 }
	 
	 public List<String>  getAccountPageHeaders() {
	List<WebElement> headerslist	= el.WaitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
	List<String> headersvaluelist = new ArrayList<String>();
	for(WebElement e: headerslist) {
		String header =e.getText();
		headersvaluelist.add(header);
		
	}
	return headersvaluelist;
		 
		 
	 }
	 
	 public ResultsPage doSearch(String searchkey) {
		 System.out.println("searchkey ===>"+searchkey);
		 
		WebElement searchele= el.WaitForElementVisibile(search,AppConstants.DEFAULT_MEDIUM_TIMEOUT );
		el.doSendKeysclear(searchele, searchkey);

		 el.doClick(searchIcon);
		 return new ResultsPage(driver);
	 }

}
