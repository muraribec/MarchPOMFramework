package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageWithoutPageFactory;

public class LoginPageWithoutPageFactoryTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPageWithoutPageFactory loginPageNPF;
	HomePage homePage;
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		loginPageNPF = new LoginPageWithoutPageFactory(driver);		
	}
	@Test(priority=1)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPageNPF.verifySignupLinkDisplayed());
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
