package com.qa.Opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtils;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtils eleutil;
	private Map<String,String> productmap=new HashMap<String ,String>();
	
	private By image=By.cssSelector("ul.thumbnails img");
	private By productdetailsinfo=By.xpath("(//div[@class='col-sm-4'])[2]//ul[1]//li");
	private By productpriceinfo=By.xpath("(//div[@class='col-sm-4'])[2]//ul[2]//li");
	private By header=By.cssSelector("div.col-sm-4 h1");
	private By addtocart=By.xpath("//button[text()='Add to Cart']");
	private By successmsg=By.cssSelector("div.alert-dismissible");
	private By shoppingcart=By.xpath("//a[text()='shopping cart']");
	
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this. driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
	public int productimagecount() {
		
		int totalimages=eleutil.GetElementsCount(image);
		System.out.println(totalimages);
		return totalimages;
	}
	
	public String getproductheader() {
		String headerdetails=eleutil.WaitforElementsVisible(header, 5).getText();
		System.out.println(headerdetails);
		return headerdetails;
	}
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	
	public void getproductmetaDetails() {
		List<WebElement> metadata=eleutil.getElements(productdetailsinfo);
		for(WebElement e:metadata) {
			String text=e.getText();
			String metakey=text.split(":")[0].trim();
			String metavalue=text.split(":")[1].trim();
			 productmap.put(metakey, metavalue);	
			
		}
		
}
	//$2,000.00
	//Ex Tax: $2,000.00
	
	public void getProductPriceDetails() {
		List<WebElement> pricedata=eleutil.getElements(productpriceinfo);
		String productprice=pricedata.get(0).getText();
	         String Extax=pricedata.get(1).getText();
	         
	         productmap.put("price",productprice);
	         
	         productmap.get(productprice);
	         String tax=Extax.split(":")[0].trim();
	         String taxamount=Extax.split(":")[1].trim();
	         productmap.put("amount",taxamount);
	         System.out.println("Productprice is:"+productprice);
	         System.out.println("EX-tax amount is:"+taxamount);
	}
	
	
	
	public Map<String,String> getproductmapdetails() {
		productmap.put("Header",getproductheader());
		productmap.put("Image",String.valueOf(productimagecount()) );
		getproductmetaDetails();
		getProductPriceDetails();
		System.out.println("product Details: \n" + productmap);
		return productmap;
	}
	
	
	public void addtocart() {
		eleutil.WaitforElementsVisible(addtocart, 5).click();
		
	}
	
	public String getSuccessmsg() {
		addtocart();
		String successmessage=eleutil.WaitforElementVisible(successmsg, 10).getText();
		System.out.println(successmessage);
		return successmessage;
	}
	
	
	public ShopingCartPage gotoShopingCart() {
		getSuccessmsg();
		eleutil.doclick(shoppingcart);
		return new ShopingCartPage(driver);
	}
	
	
	
	
	
}
