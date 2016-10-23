package com.toolsqa.pageobject.automationpracticeform;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.utils.WebDriverUtils;

public class AutomationPracticeFormPage extends AbstractPage{
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);

	public AutomationPracticeFormPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getAutomationPracticeFormMenuOption(){
		//return driver.findElement(By.partialLinkText("Automation Practice Form"));
		//return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("a"),"href","http://toolsqa.com/automation-practice-form/");
		
		//WebElement demoSitesMenuOption = driver.findElement(By.partialLinkText("DEMO SITES"));
		
		//webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("a"),"class","ripple");
		
		//webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.xpath("//a/span[1]/span/span"),"class","ripple");
		
		//List<WebElement> webElements = driver.findElements(By.xpath("//a/span[1]/span/span"));
		//List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='primary-menu']/li[9]/a/span[1]/span/span"));
		List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='primary-menu']/li[9]"));
		
		for(WebElement webElement : webElements){
			System.out.println("-->" +  webElement.getText());
		}
		
		//System.out.println("--> " + webElements);
		
		System.out.println(driver.getTitle());
		
		//id('primary-menu')/x:li[9]/x:a/x:span[1]/x:span/x:span
		
		
		//driver.findElement(By.xpath("id('primary-menu')/li[9]/a/span[1]/span/span"));
		
		//Actions action = new Actions(driver);
		 
        //action.moveToElement(demoSitesMenuOption).build().perform();
        
        //driver.findElement(By.linkText("Automation Practice Form")).click();
		
		return null; 
	}
	
	public String getAutomationPracticeFormTitle(){
		return driver.getTitle();
	}
	
	public WebElement getPartialLinkTest(){
		return driver.findElement(By.partialLinkText("Partial Link Test"));
	}
	
	public WebElement getLinkTest(){
		return driver.findElement(By.linkText("Link Test"));
	}
	
}
