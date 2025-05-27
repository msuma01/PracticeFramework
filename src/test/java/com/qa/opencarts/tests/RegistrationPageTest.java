package com.qa.opencarts.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencarts.base.BaseTest;
import com.qa.opencarts.constants.AppConstants;
import com.qa.opencarts.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void regsetup() {
		Register=lf.navigateToRegister();
	}
	
	@Test
	public void getPageTitle() {
		String title=Register.getTitlePage();
		System.out.println(title);
	}

	public String getRandomEmail() {
		return "uiautomation"+ System.currentTimeMillis()+"@gmail.com";
	}
	
//	@Test
//	public void userRegisterTest() {
//		Assert.assertTrue(Register.userRegisteration("jikolh","Kllijh", getRandomEmail(), "8797780078","huy@789","yes"));
//	}
	
//	@DataProvider
//	public Object[][]  registerAccount() {
//		return new Object[][] {
//			{"Neetu","Singh","080384089538745","jk@345","yes"},
//			{"Reetu","Sin","08038408955","ljk@345","yes"},
//			{"Hari","Ghani","84089538745","gjk@345","yes"},
//			{"Neu","ghini","0384089538745","djk@345","yes"},
//			{"Neha","Niaha","08038408745","sjk@345","yes"}
//		};
//	}
	
	@DataProvider
	public Object[][]  getregdata() {
		return ExcelUtil.getTestData(AppConstants.REG_SHEETNAME);
			
	}
	
	
		
	
	@Test(dataProvider="getregdata")
	public void userRegisterTest(String Firstname, String Lastname,String Mobile, String Password,String subscribe) {
		Register.userRegisteration(Firstname, Lastname, getRandomEmail(),Mobile,Password, subscribe);
		
		
		
	
		
		
	}
}
