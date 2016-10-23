package com.toolsqa.pageobject.automationpracticeform;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
	}
	
	public LandingPage navigateToWebApp(){
		driver.navigate().to("http://angularjs.org");
		return new LandingPage(driver);
	}
	
	public void closeDriver(){
		driver.quit();
	}
	
}
