package com.toolsqa.pageobject.automationpracticeform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends AbstractPage{	
	public LandingPage(WebDriver driver){
		super(driver);
	}

	public WebElement getDownLoadAngularJSOneButton() {
		return driver.findElement(By.cssSelector(".btn.btn-large.btn-primary.download-btn"));
	}
	
	public DownloadAngularJSOnePage navigateToDownloadAngularJSOnePage(){
		getDownLoadAngularJSOneButton().click();
		return new DownloadAngularJSOnePage(driver);
	}
	
	public TheBasicsPage navigateToTheBasicsPage(){
		return new TheBasicsPage(driver);
	}
	
	public AddSomeControlPage navigateToAddSomeControlPage(){
		return new AddSomeControlPage(driver);
	}
	
	public WireUpABackendPage navigateToWireUpABackendPage(){
		return new WireUpABackendPage(driver);
	}
	
	public CreateComponentsPage navigateToCreateComponentsPage(){
		return new CreateComponentsPage(driver);
	}
}
