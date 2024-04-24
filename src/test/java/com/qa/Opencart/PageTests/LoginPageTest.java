package com.qa.Opencart.PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Opencart.Base.BaseTest;

public class LoginPageTest extends BaseTest{

	
	@Test(priority=1)
	public void loginpagetitleTest() {
		String ActlTitle=loginpage.getLoginPageTitle();
		Assert.assertEquals(ActlTitle, "Account Login");
	}
	

	@Test(priority=2)
	public void loginpageurlTest() {
		String Actlurl=loginpage.getLoginPageURL();
		Assert.assertTrue(Actlurl.contains("route=account/login"));
	}
	
	

	@Test(priority=3)
	public void isForgotPwdLinkExistTest() {
		Boolean linkExist=loginpage.isForgotPwdLinkExist();
	Assert.assertTrue(linkExist.TRUE);
	}
	

	@Test(priority=4)
	public void DologinTest() {
		accntpage=loginpage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertEquals(accntpage.getaccountPageTitle(), "My Account");
	
	}
	
	
	
	
	
	
	
	
	
}
