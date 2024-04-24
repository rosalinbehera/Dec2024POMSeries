package com.qa.Opencart.PageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Opencart.Base.BaseTest;

public class SearchResultTest extends BaseTest {

	@BeforeClass
	public void searchpagesetup() {
		accntpage=loginpage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void searchResultTest() {
		searchresultpage=accntpage.Dosearch("mac book");
		Assert.assertEquals(searchresultpage.getsearchproductcounts(), 6)	;
	}
	
	
	public void selectproductTest() {
		searchresultpage.selectproduct("MacBook Pro");
	}
	
	
	
}
