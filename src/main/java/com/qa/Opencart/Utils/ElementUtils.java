package com.qa.Opencart.Utils;


	

	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.openacrt.Factory.DriverFactory;
	//SRP:SINGLE RESPONSIBILITY PRINCIPLE==>its a design pattern
	public class ElementUtils {
	  private WebDriver driver;
	 // private JavaScriptUtils jsutil;

	     public ElementUtils ( WebDriver driver) {
		  this.driver=driver;
		 // jsutil=new JavaScriptUtils(driver);
	}

		public By getBy(String locatortype,String locatorvalue) {
		By locator=null;
		
		switch(locatortype.toLowerCase().trim()) {
		   case "id":
			locator=By.id(locatorvalue);
			break;
		   case "name":
				locator=By.name(locatorvalue);
				break;
		   case "classname":
				locator=By.className(locatorvalue);
				break;
		   case "linktext":
				locator=By.linkText(locatorvalue);
				break;
		   case "partiallinktext":
				locator=By.partialLinkText(locatorvalue);
				break;
		   case "xpath":
				locator=By.xpath(locatorvalue);
				break;
		   case "cssselector":
				locator=By.cssSelector(locatorvalue);
				break;
				
		   case "tagname":
					locator=By.tagName(locatorvalue);
					break;	
		}
		return locator;
			
		
		
		
		}




		public  WebElement getElement(String locatortype,String locatorvalue) {
			return driver.findElement(getBy(locatortype,locatorvalue));
		}
			
			public  WebElement getElement(By locator) {
				WebElement element=null;
				try {
						element=driver.findElement(locator);
						
				//if (Boolean.parseBoolean(DriverFactory.highlight)) {
					//jsutil.flash(element);
             //  }
				} catch(NoSuchElementException e) {
					System.out.println("Element is not present in the page");
					e.printStackTrace();
				}
         
				return 	element;
				}
			
			
			
			public  void dosendkeys(String locatortype,String locatorvalue,String value) {
				getElement(locatortype,locatorvalue).sendKeys(value);
			}
				 
				 
			public  void dosendkeys(By locator,String value) {
				getElement(locator).clear();
				 getElement(locator).sendKeys(value);
				 

		}
			
			public void doclick(By locator) {
				getElement(locator).click();
				
			}
			public void doclick(String locatortype,String locatorvalue) {
				getElement(locatortype,locatorvalue).click();
			}
			public String getText(By locator) {
				return getElement(locator).getText();
			}
			
			public String getText(String locatortype,String locatorvalue) {
				return getElement(locatortype,locatorvalue).getText();
			}
			//findelements to get all the links available in the same page
			public  List<WebElement> getElements (By locator) {
				return  driver.findElements(locator);
			}
			
			public  int GetElementsCount(By locator) {
				return getElements(locator).size();
			}
			//text for all the links
			public   ArrayList<String> GetElementText(By locator) {
				List<WebElement> elelist =getElements(locator);
				ArrayList<String> eleTextList =new ArrayList<String>();
					
				
				
				for(WebElement e:elelist) {
					String GetTextlinks=e.getText();
					 if(GetTextlinks.length()!=0) {
						 eleTextList.add(GetTextlinks);
		        		 
		        	  }
				}
				return eleTextList;	
			}
		//get attributes for all the images available in the page	
			public  ArrayList<String> GetAttributes(By locator,String attributesname) {
				List<WebElement>Allimgs =getElements(locator);
				ArrayList<String> ATTdetails=new ArrayList<String>();
				
				for(WebElement e:Allimgs) {
					String attsname=e.getAttribute(attributesname);
					if (attsname.length() != 0) {
						ATTdetails.add(attsname);
					}
					
			}
				return ATTdetails;
		}
			//isdisplayed with findelement()
			public  boolean IsElementExist(	By locator) {
				return getElement(locator).isDisplayed();
			}
			//isdisplayed with findelements()
			public  boolean IsElementDisplayed(By locator) {
				if(getElements(locator).size()==1) {
					return true;
				}
				else {
					return false;
				}
			
		}
			//select based dropdown..................
			///utils.......................
			
			/**
			 * select dropdown by index
			 * @param locator
			 * @param index
			 */
			public  void doselectbyIndex(By locator,int index) {
				Select select=new Select(getElement(locator));
			      select.selectByIndex(index);
			}
			
			/**
			 * select dropdown by text available outside
			 * @param locator
			 * @param value
			 */
			public  void doselectbyVisibleText(By locator, String value) {
				
				Select select=new Select(getElement(locator));
			      select.selectByVisibleText(value);
			}
			/**
			 * select dropdown by value (attribute)
			 * @param locator
			 * @param value
			 */
			
			
		public  void doselectbyvalue(By locator, String value) {
				
				Select select=new Select(getElement(locator));
			      select.selectByValue(value);
			}
		
		
		/**
		 * select value from the dropdown by the locator and value
		 * @param locator
		 * @param value
		 */
			public  void doSelectDropDownValue(By locator,String value) {
				List<WebElement>optionlist =getDropDownOptionsList(locator);
				 for(WebElement e:optionlist) {
					 String Options=e.getText();
					 System.out.println();
			
					if(Options.equals(value)) {
						e.click();
						break;
					}
				}
			}
			
			/**
			 * get all the options available in the dropdown
			 * @param locator
			 * @return
			 */
				 public  ArrayList<String> getDropDownOptionsTextList(By locator) {	
						List<WebElement>optionlist =getDropDownOptionsList(locator);
						ArrayList<String> TextLIst=new ArrayList<String>();
							
						for(WebElement e:optionlist) {
								String ALLOptions=e.getText();
								TextLIst.add(ALLOptions);
						}
						return TextLIst;
						}
					
						/**
						 * A function to avoid repeated creation of object in the Select class
						 * Select class is a class default available in JAVA
						 * @param locator
						 * @return
						 */
						
						public  List<WebElement> getDropDownOptionsList(By locator) {
							WebElement elements=driver.findElement(locator);
							Select select1=new Select(elements);
							return select1.getOptions();
						
						
					}
						/**
						 * get the total count of option available in the dropdown
						 * @param locator
						 * @return
						 */
						
						public  int CountOfSelectDropdownList(By locator) {
							return getDropDownOptionsList(locator).size();
						}

					/**
					 * 
					 * @param locator
					 * @return
					 */
					public  List<WebElement> printSelectDropDownValue(By locator) {
						List<WebElement>optionlist =getDropDownOptionsList(locator);
					         for(WebElement e:optionlist) {
							 String Options=e.getText();
							 System.out.println();
					}
					
					return optionlist;
					
					
					
				}
					
					
					
					
					//************************ Actions Utils **************//
					
					public void handleMenuSubMenuLevel2(By parentMenuLocator, By SubMenuLocator) throws InterruptedException {
						Actions act = new Actions(driver);
						act.moveToElement(getElement(parentMenuLocator)).perform();
						Thread.sleep(1500);
						doclick(SubMenuLocator);
						
					}

					public void handleMenuSubMenuLevel4(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
							throws InterruptedException {

						doclick(level1Menu);
						Thread.sleep(1500);
						Actions act = new Actions(driver);
						act.moveToElement(getElement(level2Menu)).perform();
						Thread.sleep(1500);
						act.moveToElement(getElement(level3Menu)).perform();
						Thread.sleep(1500);
						doclick(level4Menu);

					}
					
					public void handleMenuSubMenuLevel4MouseHover(By level1Menu, By level2Menu, By level3Menu, By level4Menu)
							throws InterruptedException {
						
						Actions act = new Actions(driver);
						
						act.moveToElement(getElement(level1Menu)).perform();
						Thread.sleep(1500);
						act.moveToElement(getElement(level2Menu)).perform();
						Thread.sleep(1500);
						act.moveToElement(getElement(level3Menu)).perform();
						Thread.sleep(1500);
						doclick(level4Menu);

					}
					
					public void doActionsClick(By locator) {
						Actions act = new Actions(driver);
						act.click(getElement(locator)).perform();
					}
					
					public void doActionsSendKeys(By locator, String value) {
						Actions act = new Actions(driver);
						act.sendKeys(getElement(locator), value).perform();
					}
	//******************************WAIT UTILS*****************************************
					 /**
					   * An expectation for checking that an element is present on the DOM of a page. This does not
					   * necessarily mean that the element is visible.
					   *
					   * @param locator used to find the element
					   * @return the WebElement once it is located
					   */
					public WebElement WaitforElementPresence(By locator,int timeout) {
						WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
					      return  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					      
					}
					/**
					   * An expectation for checking that an element is present on the DOM of a page and visible.
					   * Visibility means that the element is not only displayed but also has a height and width that is
					   * greater than 0.
					   *
					   * @param locator used to find the element
					   * @return the WebElement once it is located and visible
					   */
					
					public WebElement WaitforElementVisible(By locator,int timeout) {
						 WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(timeout));
				         return wait2.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
					 /**
					   * An expectation for checking an element is visible and enabled such that you can click it.
					   *
					   * @param locator used to find the element
					   * @return the WebElement once it is located and clickable (visible and enabled)
					   */
			
					public WebElement WaitElementTobeClickable(By locator,int timeout) {
						 WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(timeout));
				         return wait2.until(ExpectedConditions.elementToBeClickable(locator));
					}
				
					public  String WaitForURL(String URL,int timeout) {
						WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
						try {
							if(wait.until(ExpectedConditions.urlToBe(URL))){
								return driver.getCurrentUrl();
							}	
						}
					
					catch(Exception e) {
							System.out.println("URL is not found within" +timeout); 
						}
					return null;
					}
					
					
					

					public  String WaitForTitle(String Title,int timeout) {
						WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
						try {
							if(wait.until(ExpectedConditions.titleIs(Title))){
								return driver.getTitle();
							}	
						}
					
					catch(Exception e) {
							System.out.println("Title is not found within" +timeout); 
						}
					return null;
					}
					
					
					public  String WaitfortitleContains(String WaitFriction,int timeout) {
						System.out.println(driver.getTitle());

				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
				try {
					if (wait.until(ExpectedConditions.titleContains(WaitFriction))) {
						return driver.getTitle();
					}
				}
				catch(Exception e){
					System.out.println("Title is not found within" +timeout); 
				}
				return null;
					}
				
					
					

					public  String WaitForURLContains(String URLFriction,int timeout) {
						System.out.println(driver.getCurrentUrl());
						WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
						try {
							if(wait.until(ExpectedConditions.urlContains(URLFriction))){
								return driver.getCurrentUrl();
							}	
						}
					
					catch(Exception e) {
							System.out.println("URL is not found within" +timeout); 
						}
					return null;
					}
						
					
					
	
	
	public  Boolean isPageLoaded(int timeout) {	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	String flag=wait.until(ExpectedConditions.jsReturnsValue("return document.readystate=='complete'")).toString();
		return Boolean.parseBoolean(flag);
	}
	

	public  void WaitFromeFrameandSwitchtoit(By locator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));	
	}
	
	public  void WaitFromeFrameandSwitchtoit(String framelocator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}
	public  Alert WaitforAlert(int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public  String GetTextOfAlert(int timeout) {
		return WaitforAlert(timeout).getText();
	}
	public  void AcceptAlert(int Timeout) {
		WaitforAlert(Timeout).accept();
		
	}
	
	public  void DismissAlert(int timeout) {
		WaitforAlert(timeout).dismiss();
	}
	
	
	public  void sendkeysAlert(int timeout,String value) {
		WaitforAlert(timeout).sendKeys(value);;
	}

	public WebElement WaitforElementsVisible(By locator,int timeout) {
		 WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(timeout));
        return wait2.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
			
			
			
		
			





}
