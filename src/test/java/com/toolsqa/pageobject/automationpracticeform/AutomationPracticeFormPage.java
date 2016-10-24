package com.toolsqa.pageobject.automationpracticeform;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;
import com.toolsqa.utils.WebDriverUtils;

public class AutomationPracticeFormPage extends AbstractPage{
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);

	public AutomationPracticeFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void getAutomationPracticeFormMenuOption(){
		//return driver.findElement(By.partialLinkText("Automation Practice Form"));
		//return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("a"),"href","http://toolsqa.com/automation-practice-form/");
		//webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("a"),"class","ripple");
		//webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.xpath("//a/span[1]/span/span"),"class","ripple");
		//List<WebElement> webElements = driver.findElements(By.xpath("//a/span[1]/span/span"));
		//List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='primary-menu']/li[9]/a/span[1]/span/span"));
		//List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='primary-menu']/li[9]"));
			
		/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		Predicate<WebDriver> predicate = new Predicate<WebDriver>()
				{
					public boolean apply(WebDriver arg0) {
						WebElement demoSitesMenuOption = driver.findElement(By.partialLinkText("DEMO SITES"));
						if(demoSitesMenuOption != null)
						{
							System.out.println("Target element found");
							Actions action = new Actions(driver); 
					        action.moveToElement(demoSitesMenuOption).build().perform(); 
					        WebElement subElement = driver.findElement(By.linkText("Automation Practice Form"));
					        action.moveToElement(subElement);
					        action.click();
					        action.perform();
					        return true;
						}
						System.out.println("Target element not found - GBD");
						return false;
					}
				};

		wait.until(predicate);*/
		
		WebElement demoSitesMenuOption = driver.findElement(By.partialLinkText("DEMO SITES"));
		Actions action = new Actions(driver); 
        action.moveToElement(demoSitesMenuOption).build().perform(); 
        WebElement subElement = driver.findElement(By.linkText("Automation Practice Form"));
        action.moveToElement(subElement);
        action.click();
        action.perform();
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
	
	public WebElement getFirstName(){
		return driver.findElement(By.name("firstname"));
	}
	
	public WebElement getLastName(){
		return driver.findElement(By.name("lastname"));
	}
	
	public List<WebElement> getSexRadioButtons(){
		return driver.findElements(By.name("sex"));
	}
	
	public WebElement getSexRadioButtonValue(){
		return driver.findElement(By.name("sex"));
	}
}
