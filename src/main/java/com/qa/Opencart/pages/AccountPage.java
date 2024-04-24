package com.qa.Opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtils;

public class AccountPage {
	private WebDriver driver;
	private ElementUtils eleutil;
	
	private By loogoutLink=By.linkText("Logout");
	private By Myaccount=By.linkText("My Account");
	private By header=By.cssSelector("div#content h2");
	private By Search=By.name("search");
	private By searchicon=By.cssSelector("div#search button");
	
	
	
	public AccountPage(WebDriver driver) {
		this. driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
	
	
	public  String getaccountPageTitle() {
	String title=eleutil.WaitForTitle("My Account", 30);
	System.out.println(title);
	return title;
		
	
	}
	
	public String getaccountpageURL() {
		String URL=eleutil.WaitForURLContains("route=account/account", 30);
		System.out.println(URL);
		return URL;
	}
	
	public Boolean islogoutLinkExist() {
		return eleutil.WaitforElementVisible(loogoutLink, 5).isDisplayed();
	}
	
	public Boolean ismyAccntLinkExist() {
		return eleutil.WaitforElementVisible(Myaccount, 5).isDisplayed();
	}
	
	public ArrayList<String> getaccntpageHeaders() {
		List<WebElement> headerelelist=eleutil.getElements(header);
		ArrayList<String> headerList=new ArrayList<String>();
		for(WebElement e:headerelelist) {
			String text=e.getText();
			headerList.add(text);
		}
		return headerList;
	
	}
	
	public Searchresultpage Dosearch(String serachkey) {
		eleutil.dosendkeys(Search, serachkey);
		eleutil.doclick(searchicon);
		
		return new Searchresultpage(driver);
	}
	
	
	
	
}
