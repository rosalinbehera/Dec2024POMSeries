package com.qa.Opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtils;
import com.qa.Opencart.constants.AppConstants;

public class RegisterationPage {
	
	
	WebDriver driver;
	ElementUtils eleutil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '0']");
	private By agreeCheckBox = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");

	private By sucessMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegisterationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public boolean userRegister(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {

		eleutil.WaitforElementVisible(this.firstName, 10).sendKeys(firstName);
		eleutil.dosendkeys(this.lastName, lastName);
		eleutil.dosendkeys(this.email, email);
		eleutil.dosendkeys(this.telephone, telephone);
		eleutil.dosendkeys(this.password, password);
		eleutil.dosendkeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleutil.doclick(subscribeYes);
		} else {
			eleutil.doclick(subscribeNo);
		}

		eleutil.doclick(agreeCheckBox);
		eleutil.doclick(continueBtn);

		String regSuccessMessg = eleutil.WaitforElementVisible(sucessMessg, 5).getText();
		System.out.println(regSuccessMessg);

		if (regSuccessMessg.equals(AppConstants.USER_REG_SUCCESS_MESSG)) {
			eleutil.doclick(logoutLink);
			eleutil.doclick(registerLink);
			return true;
		}
		return false;

	}

}
