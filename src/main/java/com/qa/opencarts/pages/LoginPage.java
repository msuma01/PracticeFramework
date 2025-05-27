package com.qa.opencarts.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencarts.constants.AppConstants;
import com.qa.opencarts.utils.Element_Util;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private Element_Util ele;
	
	
	//1. private By locators: page objects
      private By Username = By.id("input-email"); 
	  private By Password = By.id("input-password");
	  private By loginBtn = By.xpath("//input[@type='submit']");
	  private By  forgotPwdLink = By.linkText("Forgotten Password");
	  private By registerLink = By.linkText("Register");
	  private By logo = By.cssSelector("img.img-responsive");
	
	//2.Public Page Constructor...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ele = new Element_Util(driver);
	}
	
	@Step("getting login page title value")
	
	public String getLoginPageTitle() {
		String title = ele.getPageTitleContains(AppConstants.LOGIN_PAGE_TITLE,AppConstants.DEFAULT_SHORT_TIMEOUT );
		System.out.println(title);
		return title;
		
	}
	@Step("getting login page url value")
	public String getLoginPageUrl() {
		
		String url=ele.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIMEOUT);
	    System.out.println(url);
	    return url;
	     
	}
	@Step("checking isForgotPwdLink exist on the login page....")	
	public boolean IsForgotPwdLinkExists() {
		return ele.IsElementDisplayed(forgotPwdLink);
	}
	
	@Step("login with username : {0} and password: {1}")
	public AccountsPage doLogin(String userName, String pwd ) {
		System.out.println("credentials are: Username" +userName +"Password"+  pwd);
		ele.WaitForElementVisibile(Username, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(userName);;
		ele.doSendKeys(Password, pwd);
		ele.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	@Step("checking logo exist on the login page....")
	public boolean checkLogo() {
		
		return ele.IsElementDisplayed(logo);
		
	}
	
	public RegistrationPage navigateToRegister() {
		 ele.doClick(registerLink);
		 return new RegistrationPage(driver);
	}


}