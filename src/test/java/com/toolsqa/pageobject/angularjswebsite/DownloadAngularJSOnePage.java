package com.toolsqa.pageobject.angularjswebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.utils.WebDriverUtils;

public class DownloadAngularJSOnePage extends AbstractPage {
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	
	public DownloadAngularJSOnePage(WebDriver driver){
		super(driver);
	}

	public WebElement getTitleLabel() {
		return driver.findElement(By.id("downloadLabel"));
	}

	//branch
	public WebElement getBranch() {
		return driver.findElement(By.cssSelector(".btn.branch-1-5-x"));
	}
	
	//buildMinified
	public WebElement getBuildMinified() {
		return driver.findElement(By.cssSelector(".btn.minified"));
	}
	
	//buildZip
	public WebElement getBuildZip() {
		return driver.findElement(By.cssSelector(".btn.zip"));
	}
	
	//buildUncompressed
	public WebElement getBuildUncompressed() {
		return driver.findElement(By.cssSelector(".btn.uncompressed"));
	}
	
	//cdn
	public WebElement getCdn() {
		return driver.findElement(By.id("cdnURL"));
	}
	
	//getBower
	public WebElement getBower() {
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("input"),"value", "bower");
	}
	
	//getNpm
	public WebElement getNpm() {
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("input"),"value", "npm");
	}
	
	//extras
	public WebElement getExtras() {
		return driver.findElement(By.linkText("Browse additional modules"));
	}
	
	//previousVersions
	public WebElement getPreviousVersions() {
		return driver.findElement(By.linkText("Previous Versions"));
	}
	
	//getDownloadButton
	public WebElement getDownloadButton(){
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.cssSelector(".btn.btn-primary.btn-large"),"href","angular.min.js");
	}
	
	//getCloseButton
	public WebElement getCloseButton(){
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("button"),"class","close");
	}
}
