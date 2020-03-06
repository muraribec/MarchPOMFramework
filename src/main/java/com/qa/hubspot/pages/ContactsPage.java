package com.qa.hubspot.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;
public class ContactsPage extends BasePage{	
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
	WebElement createContactBtn;
	@FindBy(id="UIFormControl-7")
	WebElement eamil;
	@FindBy(id="UIFormControl-8")
	WebElement firstName;
	@FindBy(id="UIFormControl-10")
	WebElement lastName;
	@FindBy(id="UIFormControl-14")
	WebElement jobTitle;
	/*@FindBy(xpath="//li//div[text()='Create contact']")
	WebElement createcontactLastBtn;*/	
	@FindBy(xpath="//li[1]/button")
	WebElement createcontactLastBtn;
	
	public ContactsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void createNewContacts(String emailVal,String firstname,String lastname,String jobtitle){
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Explicitly wait
		WebDriverWait wait = new WebDriverWait(driver,20 );	
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		createContactBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(eamil));
		eamil.sendKeys(emailVal);
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstname);
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastname);
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobtitle);
		TimeUtil.longWait();
		wait.until(ExpectedConditions.elementToBeClickable(createcontactLastBtn));
		createcontactLastBtn.click();
	}
	
}
