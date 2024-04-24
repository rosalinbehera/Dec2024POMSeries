package com.qa.Opencart.PageTests;


	
	import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.Base.BaseTest;
//import com.qa.Opencart.Utils.ExcelUtil;
import com.qa.Opencart.constants.AppConstants;
import io.opentelemetry.api.internal.StringUtils;

	

	public class RegPageTest extends BaseTest {

	@BeforeClass
		public void regSetup() {			
		registerationPage = loginpage.navigateToRegisterPage();
	}
		
		
		@DataProvider
		public Object[][] getUserRegTestData() {
			return new Object[][] {
				{"gaurav", "gupta",  "9876543212", "gg@123", "yes"},
				{"shilpa", "mamiidipelli", "9876543662", "shilpa@123", "no"},
				{"om", "gautam", "9876587653", "om@123", "yes"}

		};
		}
		}
	
//		
//		@DataProvider
//		public Object[][] getUserRegTestDataFromExcel() {
//			return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
//		}
//		
//		
//		@DataProvider(name="csvregdata")
//		public Object[][] getUserRegTestDataFromCSV() {
//			return CSVUtil.csvData(AppConstants.REGISTER_SHEET_NAME);
//		}
//		
//
//		@Test(dataProvider = "csvregdata")
//		public void userRegTest(String firstName, String lastName, String telephone, String password, String subscribe) {
//			
//			
//			
//			Assert.assertTrue(
//					registerationPage.userRegister(firstName, lastName, 
//							StringUtils.getRandomEmailId(), 
//							telephone, password, subscribe));
//			
//			
//
//		}
//		
//
//		
//		
//		
//
//	}
//}
