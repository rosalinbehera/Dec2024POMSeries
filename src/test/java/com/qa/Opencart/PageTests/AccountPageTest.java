package com.qa.Opencart.PageTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Opencart.Base.BaseTest;

public class AccountPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accSetup() {
		accntpage = loginpage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void accntpagetitleTest() {
		String ActlTitle=accntpage.getaccountPageTitle();
		Assert.assertEquals(ActlTitle, "My Account","Title is correct");
	}
	

	@Test(priority=2)
	public void AccountpageurlTest() {
		String Actlurl=accntpage.getaccountpageURL();
		Assert.assertTrue(Actlurl.contains("route=account/account"));
	}
	
	

	@Test(priority=3)
	public void isMyaccntLinkExistTest() {
		Boolean linkExist=accntpage.ismyAccntLinkExist();
	Assert.assertTrue(linkExist.TRUE);
}
	@Test(priority=4)
	public void islogoutLinkExistTest() {
		Boolean linkExist=accntpage.islogoutLinkExist();
	Assert.assertTrue(linkExist.TRUE);
	
	
}
	@Test(priority=5)
	public void getaccntpagehaederTest() {
		List<String> headers=accntpage.getaccntpageHeaders();
		System.out.println(headers);
	}
	@Test(priority=6)
	public void dosearchAccntpageTest() {
		accntpage.Dosearch("macbook");
	}
	
	
}
