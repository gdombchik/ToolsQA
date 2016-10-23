package com.toolsqa.pageobject.automationpracticeform;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateComponentsPage extends AbstractPage {

	public CreateComponentsPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getLocales() {
		return driver.findElements(By.tagName("h4"));
	}
	
	public List<WebElement> getUnitedStatesLocalization(){
		//return driver.findElements(By.cssSelector("[module='app-us']")); //css selector does not have "@" attribute
		///x:html/x:body/x:div[2]/x:div[8]/x:div[2]/x:div[2]/x:div/x:div/x:div[1]  -->This selects the first span; date
		//return driver.findElements(By.xpath("//div[@module='app-us']/div/div/div[2]")); //This selects all the spans
		return driver.findElements(By.xpath("//div[@module='app-us']/div/div/div[1]/span")); //This selects all the spans
	}
	
	public List<WebElement> getUnitedStatesPluralization(){
		return driver.findElements(By.xpath("//div[@module='app-us']/div/div/div[2]/div/div[*]/ng-pluralize"));
	}
	
	public List<WebElement> getSlovakiaLocalization(){
		return driver.findElements(By.xpath("//div[@module='app-sk']/div/div/div[1]/span"));
	}
	
	public List<WebElement> getSlovakiaPluralization(){
		return driver.findElements(By.xpath("//div[@module='app-sk']/div/div/div[2]/div/div[*]/ng-pluralize"));
	}
}
