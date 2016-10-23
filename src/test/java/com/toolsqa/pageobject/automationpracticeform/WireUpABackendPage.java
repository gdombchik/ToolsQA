package com.toolsqa.pageobject.automationpracticeform;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.utils.WebDriverUtils;

public class WireUpABackendPage extends AbstractPage {
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	  
	public WireUpABackendPage(WebDriver driver){
		super(driver);
	}
	
	public List<WebElement> getJavaScriptProjectLinks() {
		return driver.findElements(By.xpath("//tr[*]/td[1]/a"));
	}

	public List<WebElement> getJavaScriptProjectDescriptions() {
		return driver.findElements(By.xpath("//tr[*]/td[2]"));
	}
	
	public List<WebElement> getJavaScriptProjectEditLinks() {
		return driver.findElements(By.xpath("//tr[*]/td[3]/a"));
	}
	
	public WebElement getSearchInputTag(){
		return driver.findElement(By.id("projects_search"));
	}
	
	public WebElement getJavaScriptProjectsEditName(){
		return driver.findElement(By.name("name"));
	}
	
	public WebElement getJavaScriptProjectsEditWebsite(){
		return driver.findElement(By.name("site"));
	}

	public WebElement getJavaScriptProjectsEditDescription(){
		return driver.findElement(By.name("description"));
	}
	
	public WebElement getJavaScriptProjectsEditSaveButton(){
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("button"),"ng-click","editProject.save()");
	}
}
