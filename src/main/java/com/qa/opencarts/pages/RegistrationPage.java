package com.qa.opencarts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencarts.constants.AppConstants;
import com.qa.opencarts.utils.Element_Util;

public class RegistrationPage {
	private WebDriver driver;
	private Element_Util el;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		el = new Element_Util(driver);
	}
	
	
	public String getTitlePage() {
		String title= el.getPageTitleIs(AppConstants.REGISTER_PAGE_TITLE,AppConstants.DEFAULT_MEDIUM_TIMEOUT );
		System.out.println(title);
		return title;
	}
	
	
	public boolean userRegisteration(String firstName, String lastName, String email, String telephone, String password, String subscribe) {

		el.WaitForElementVisibile(this.firstName, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(firstName);

		el.doSendKeys(this.lastName, lastName);
		el.doSendKeys(this.email, email);
		el.doSendKeys(this.telephone, telephone);
		el.doSendKeys(this.password, password);
		el.doSendKeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			el.doClick(subscribeYes);
		} else {
			el.doClick(subscribeNo);
		}

		el.doClick(agreeCheckBox);
		el.doClick(continueButton);

		String successMesg = el.WaitForElementVisibile(successMessg, AppConstants.DEFAULT_MEDIUM_TIMEOUT).getText();
		System.out.println(successMesg);
		

		if (successMesg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)) {
			el.doClick(logoutLink);
			el.doClick(registerLink);
			return true;
		} else {
			return false;
		}

	}
	
	
	

}
