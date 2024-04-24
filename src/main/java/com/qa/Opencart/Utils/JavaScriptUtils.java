package com.qa.Opencart.Utils;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptUtils {
private WebDriver driver;
public JavaScriptUtils(WebDriver driver) {
	this.driver=driver;	
}

public String JsgetTite() {
	JavascriptExecutor js	=(JavascriptExecutor)driver;
	return js.executeScript("return document.title;").toString();
}

public String JsGetURL() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	return js.executeScript("return document.URL;").toString();
}

public Object JSGoback() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	return js.executeScript("return document.go(-1);");
}

public Object JSGoForward() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	return js.executeScript("return document.go(1);");
}

	public Object JSBrowserRefresh() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js.executeScript("return document.go(0);");
	}

public void JsAlert(String Message) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("alert('"+ Message +"')");
}
public void JsGeneratePrompt(String Message) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("prompt('"+ Message +"')");


}
public void JsGenerateConfirmPopup(String Message) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("Confirm('"+ Message +"')");
}

public String GetInnerTExt() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	return js.executeScript("return document.documentElement.innerText").toString();
}

public void Scrolldown() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
}

public void ScrollUp() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
}

public void ScrolltoMiddle() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)");
}

public void ScrolltoHeight(String height) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(0,'"+ height+ "')");
}

public void ScrollintoView(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);",element);
}



public void chromeedgesafarizoom(String Zoomsize) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.body.style.zoom='+Zoomsize+'%");
}

public void zoomFirefox(String zoomPercentage) {
	String zoom = "document.body.style.MozTransform = 'scale("+zoomPercentage+")'";
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript(zoom);

}

public void drawBorder(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].style.border='3px solid red'", element);
}

public void flash(WebElement element) {
	String bgcolor = element.getCssValue("backgroundColor");//red
	for (int i = 0; i < 10; i++) {
		changeColor("rgb(0,200,0)", element);// green
		changeColor(bgcolor, element);// red
	}
}

private void changeColor(String color, WebElement element) {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

	try {
		Thread.sleep(20);
	} catch (InterruptedException e) {
	}
}






	
	


	

	
	
		
		

	


 {
 }
 
 }


