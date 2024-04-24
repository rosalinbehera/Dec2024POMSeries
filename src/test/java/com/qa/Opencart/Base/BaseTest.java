package com.qa.Opencart.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


import com.qa.Opencart.pages.AccountPage;
import com.qa.Opencart.pages.LoginPage;
import com.qa.Opencart.pages.ProductInfoPage;
import com.qa.Opencart.pages.RegisterationPage;
import com.qa.Opencart.pages.Searchresultpage;
import com.qa.Opencart.pages.ShopingCartPage;
import com.qa.openacrt.Factory.DriverFactory;

public class BaseTest {
	
	 protected Properties prop;
	protected LoginPage loginpage;
	protected AccountPage accntpage;
	protected Searchresultpage searchresultpage;
	protected ProductInfoPage productinfopage;
	protected SoftAssert softAssert ;
	protected ShopingCartPage shopingCartPage;
	protected RegisterationPage registerationPage;
	
	protected WebDriver driver;
	DriverFactory df;
	
	@Parameters({"browser"})
	

	@BeforeTest
	public void setup(String browsername) {
		df=new DriverFactory();
		prop=df.initproperties();
		driver=df.initializeDriver(prop);
		
		if (browsername!=null) {
			prop.setProperty("browser", browsername);
		}
	
		loginpage=new LoginPage(driver);
		softAssert = new SoftAssert();
		
	}
	
	@AfterTest
	
	public void Teardown() {
		driver.quit();
	}
}



