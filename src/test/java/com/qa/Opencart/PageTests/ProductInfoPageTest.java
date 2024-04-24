package com.qa.Opencart.PageTests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Opencart.Base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	 

	@BeforeClass
	public void productinfoesetup() {
		accntpage=loginpage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
		
		
		@Test
		public void productimagecountTest() {
			searchresultpage=accntpage.Dosearch("MacBook Pro");
			productinfopage=searchresultpage.selectproduct("MacBook Pro");
		int actualcount=productinfopage.productimagecount();
		Assert.assertEquals(actualcount, 4);
		}
		@Test
		public void productheaderTest() {
			searchresultpage=accntpage.Dosearch("MacBook Pro");
			productinfopage=searchresultpage.selectproduct("MacBook Pro");
			Assert.assertEquals(productinfopage.getproductheader(),"MacBook Pro");
		}
		@Test
		public void productmapdataTest() {
			
			searchresultpage=accntpage.Dosearch("MacBook Pro");
			productinfopage=searchresultpage.selectproduct("MacBook Pro");
			
			Map<String,String> productactmap=productinfopage.getproductmapdetails();
			

			softAssert.assertEquals(productactmap.get("Brand"), "Apple");
			softAssert.assertEquals(productactmap.get("Product Code"),"Product 18");
			softAssert.assertEquals(productactmap.get("Reward Points"),"800");
			softAssert.assertEquals(productactmap.get("Availability"),"In Stock");
			softAssert.assertEquals(productactmap.get("price"), "$2,000.00");
			softAssert.assertEquals(productactmap.get("taxamount"), "$2,000.00");
			
			
		}
		
		@Test
		public void addProductToCartTest() {
			searchresultpage=accntpage.Dosearch("MacBook Pro");
			productinfopage=searchresultpage.selectproduct("MacBook Pro");
			String actualmsg=productinfopage.getSuccessmsg();
			Assert.assertTrue(actualmsg.contains("Success"), "product added to cart");
		}
		
		@Test
		public void shopingcartTest() {
			searchresultpage=accntpage.Dosearch("MacBook Pro");
			productinfopage=searchresultpage.selectproduct("MacBook Pro");
			productinfopage.gotoShopingCart();
		}

}



