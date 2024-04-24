package com.qa.openacrt.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.Opencart.logger.Log;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions CO;
	private FirefoxOptions FO;
	private EdgeOptions EO;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		CO = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			//System.out.println("Running in Chrome Headless mode");
			Log.info("Running in Chrome Headless mode");
			CO.addArguments("--headless");
			
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			//System.out.println("Running in Chrome incongnitomode");
			Log.info("Running in Chrome incongnitomode");
			CO.addArguments("--incognito");
			

		}
		if (Boolean.parseBoolean(prop.getProperty("highlight").trim())) {
			//System.out.println("Running in Chrome incongnitomode");
			Log.info("Running in Chrome with highlights");
			CO.addArguments("--highlight");
			

		}
		return CO;
	}

	public FirefoxOptions getFirefoxOptions() {
		FO = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			//System.out.println("Running in Firefox Headless mode");
			Log.info("Running in Firefox Headless mode");
			FO.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			//System.out.println("Running in Firefox incongnitomode");
			Log.info("Running in Firefox incongnitomode");
			FO.addArguments("--incognito");
		}
		return FO;
	}

	public EdgeOptions getEdgeOptions() {
		EO = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("Running in Edge Headless mode");
			EO.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			System.out.println("Running in Edge incongnitomode");
			EO.addArguments("--inprivate");
		}
		return EO;
	}
}
