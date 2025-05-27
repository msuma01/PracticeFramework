package com.qa.opencarts.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencarts.base.BaseTest;
import com.qa.opencarts.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountsPageTest  extends BaseTest{
	@BeforeClass
	public void accsetup() {
		acc=lf.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void AccountPageTitleTest() {
		String acttitle= acc.getAccountsPageTitle();
		Assert.assertEquals(acttitle,AppConstants.ACCOUNTS_PAGE_TITLE);
		
		
	}
	
	@Test
	public void isLogOutLinkExists() {
		Assert.assertTrue(acc.isLogoutlinkExist());
	}
	
	@Test
	public void accPageHeadersCountTest() {
		Assert.assertEquals(acc.getTotalAccountsPageHeaderCount(),AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
		
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actualHeadersList=acc.getAccountPageHeaders();
		Assert.assertEquals(actualHeadersList,AppConstants.EXPECTED_PAGE_HEADERS_LIST);
	}
	
//	@DataProvider
//	public Object[][] getsearchKey() {
//		return  new Object[][] {
//			{"macbook",3},
//			{"imac",1},
//			{"samsung",2}
//		};
//	}
//	
//	@Description("search functionality test")
//	@Severity(SeverityLevel.CRITICAL)
//	@Test(dataProvider="getsearchKey")
//	public void searchCountTest(String searchKey, int searchCount) {
//		resPage=accPage.dosearch(searchKey);
//	   Assert.assertEquals(resPage.getSearchResultsCount(), searchCount);
//	}
	
	
	@DataProvider
	public Object[][] getsearchKey() {
		return  new Object[][] {
			{"macbook",3},
			{"imac",1},
			{"samsung",2}
		};
	}
	
	@Description("search functionality test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider="getsearchKey")
	public void searchcounttest(String searchkey, int searchcount) {
		rp=acc.doSearch(searchkey);
	Assert.assertEquals(rp.getSearchResultsCount(), searchcount);
		
	}

	@DataProvider
	public Object[][] getsearchData() {
		return  new Object[][] {
			{"macbook","MacBook Air"},
			{"macbook","MacBook Pro"},
			{"imac", "iMac"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"samsung","Samsung Galaxy Tab 10.1"}
		};
	}
	
	@Test(dataProvider="getsearchData")
	public void searchTest(String searchkey, String Productname) {
		rp=acc.doSearch(searchkey);
		pip=rp.selectProduct(Productname);
		Assert.assertEquals(pip.getProductHeader(),Productname);
	}
	
		
		
		}

//	
//	//@Description("search functionality test")
//	//@Severity(SeverityLevel.CRITICAL)
//	@Test(dataProvider="getsearchKey")
//	public void searchCountTest(String searchKey, int searchCount) {
//		rp=acc.doSearch(searchKey);
//	   Assert.assertEquals(rp.getSearchResultsCount(), searchCount);
//	}
//	
//	
//	
//	@DataProvider
//	public Object[][] getsearchData() {
//		return  new Object[][] {
//			{"macbook","MacBook Air"},
//			{"macbook","MacBook Pro"},
//			{"imac", "iMac"},
//			{"samsung","Samsung SyncMaster 941BW"},
//			{"samsung","Samsung Galaxy Tab 10.1"}
//		};
//	}
	

