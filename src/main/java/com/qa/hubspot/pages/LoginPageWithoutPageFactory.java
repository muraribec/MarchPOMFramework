package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;

public class LoginPageWithoutPageFactory extends BasePage{
	ElementActions elementActions;
	//1. Define locators:: Page objects but without using pageFactory
	By emailId = By.id("username");
	By password=By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2.constructor
	public LoginPageWithoutPageFactory(WebDriver driver){
		this.driver=driver;
		elementActions = new ElementActions(driver);
	}
	
	//3 PageActions
	public String getLoginPageTitle(){
		elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
		return elementActions.getPageTitle();
		//return driver.getTitle();
	}
	public boolean verifySignupLinkDisplayed(){
		//return elementActions.getElement(signUpLink).isDisplayed();
		return elementActions.elementIsDisplayed(signUpLink);
		}
	public void doLogin(String username,String pwd){
		elementActions.elementSendKeys(emailId, username);
		elementActions.elementSendKeys(password, pwd);
		elementActions.elementClick(loginButton);
	}
	
	

}
