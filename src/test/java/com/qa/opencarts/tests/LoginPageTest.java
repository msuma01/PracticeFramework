package com.qa.opencarts.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencarts.base.BaseTest;
import com.qa.opencarts.constants.AppConstants;
import com.qa.opencarts.pages.AccountsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100: design open cart login page")
@Feature("Feature 101: login feature")
@Story("US 120: All the features related to open cart login page")
@Owner("Suma")
@Link(name = "LoginPage", url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login")
public class LoginPageTest extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Description("login page title test....")
	@Feature("Feature 400: title test feature")
	@Test 
	public void LoginPageTitleTest() {
		String acttitle= lf.getLoginPageTitle();
		Assert.assertEquals(acttitle,AppConstants.LOGIN_PAGE_TITLE);
		
		
	}
	@Severity(SeverityLevel.NORMAL)
	@Description("login page url test....")
	@Feature("Feature 401: title test feature")
	
	@Test 
	public void LoginPageUrlTest() {
		String acturl= lf.getLoginPageUrl();
		Assert.assertTrue(acturl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
		
	

}
	@Severity(SeverityLevel.CRITICAL)
	@Description("login page forgot pwd link exist test....")
	@Issue("Bug-123")
	@Test
	public void forgotPwdLinkTest() {
	Boolean bl=	lf.IsForgotPwdLinkExists();
	Assert.assertEquals(true, bl);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("login page logo test....")
	@Test
	public void LogoExistsTest() {
	Boolean bl=	lf.checkLogo();
	Assert.assertEquals(true, bl);
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("user is able to login....")
	
	@Test(priority=Integer.MAX_VALUE)
	public void verifyPageTest() {
	   AccountsPage acc=lf.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(acc.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
}

