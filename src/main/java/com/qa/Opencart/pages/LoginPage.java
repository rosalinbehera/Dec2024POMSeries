package com.qa.Opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtils;
import com.qa.Opencart.Utils.TimeUtils;
import com.qa.Opencart.logger.Log;







public class LoginPage {
private WebDriver driver;
private ElementUtils eleutil;
	//Private By locator
	private By Emailid=By.id("input-email");
	private By Password=By.id("input-password");
	private By ForgottenPwdLink=By.linkText("Forgotten Password");
	private By login=By.xpath("//input[@value='Login']");
	private By registerLink = By.linkText("Register");
	
	
	
	//Public page class constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtils(driver);
	}
	
	
	
	//Public page class Method/Action
	public String getLoginPageTitle() {
		 String title=	eleutil.WaitfortitleContains("Account Login", 20);
	
	System.out.println(title);
	return title;
	}
	
	public String getLoginPageURL() {
		String URL=eleutil.WaitForURLContains("route=account/login", 20);
	
		System.out.println("login page URL is"+URL);
		return URL;
		}
	
	public Boolean isForgotPwdLinkExist() {
		return eleutil.IsElementDisplayed(ForgottenPwdLink);
		
		}
	
	public AccountPage Dologin(String username,String pwd) {
		//System.out.println("user credentials:"+username+" "+pwd);
		Log.info("user credentials:"+username+" "+pwd);
		eleutil.WaitforElementVisible(Emailid, 20).sendKeys(username);
		eleutil.dosendkeys(Password, pwd);
		eleutil.doclick(login);
		return new  AccountPage(driver);
	
	}
	
	
	public RegisterationPage navigateToRegisterPage() {
		eleutil.WaitforElementsVisible(registerLink, TimeUtils.DEFAULT_Long_TIME).click();
		return new RegisterationPage(driver);
	}
}
