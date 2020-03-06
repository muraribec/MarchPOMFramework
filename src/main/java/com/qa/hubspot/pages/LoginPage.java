package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage{
	
	
	//1. Page Factory---Page Object
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signUpLink;
	
	//2. Create Constructor of the LoginPage and Initialize your page object
	public LoginPage(WebDriver driver){
		this.driver=driver;//First driver is coming from BansePage so we had given reference to the local
		PageFactory.initElements(driver, this);//To initialize the Webelement of the Loginpage
		}
	//3. Page Actions/Page Library
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean verifySignupLinkDisplayed(){
		return signUpLink.isDisplayed();
	}
	public HomePage doLogin(String username,String pwd){
		System.out.println("Credentials"+username+ "/" + pwd);
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		TimeUtil.longWait();
		return new HomePage(driver);
		
		
	}
	
	

}
