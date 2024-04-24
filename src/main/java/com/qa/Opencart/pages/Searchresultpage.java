package com.qa.Opencart.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtils;

public class Searchresultpage {
WebDriver driver;
private ElementUtils eleutil;

By serachProducts=By.cssSelector("div.product-thumb");
By selectproduct=By.cssSelector("div.product-thumb a");

	public Searchresultpage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
		
	}
	
	public int getsearchproductcounts() {
		int products= eleutil.GetElementsCount(serachProducts);
	return 	products;
	}
	
	public ProductInfoPage selectproduct(String productname) {
		System.out.println("searching for product: " + productname);
		eleutil.WaitforElementsVisible(By.linkText(productname), 10).click();
		return  new ProductInfoPage(driver);
	}
	

}
