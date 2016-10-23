package com.toolsqa.pageobject.automationpracticeform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.utils.WebDriverUtils;

public class TheBasicsPage extends AbstractPage {
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	private WebElement name;
	
	public TheBasicsPage(WebDriver driver){
		super(driver);
	}

	public WebElement getNameInputTag() {
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("input"),"placeholder","Enter a name here");
	}
	
	public WebElement getNameMessage() {
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("h1"),"class","ng-bind");
	}
}
