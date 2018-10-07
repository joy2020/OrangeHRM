package com.qa.orangePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangeBase.BaseOrange;

public class LoginPage extends BaseOrange 
{
	@FindBy(xpath = "//div[@id='divUsername' and @class = 'textInputContainer']")
	WebElement panelText;
	
	@FindBy(how = How.XPATH,using =".//input[@id='txtUsername' or @name='txtUsername']")
	WebElement username;
	
	@FindBy(how = How.XPATH,using="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(how = How.XPATH,using="//input[@id='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[contains(text(),'Csrf token validation failed')]")
	WebElement validationMessage;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLpTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo() 
	{
		return panelText.isDisplayed();
		
	}
	
	public HomePage logIn() 
	{
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new HomePage();
	}
	
	public boolean validateMessage() 
	{
		return  validationMessage.isDisplayed();
		
	}
	

}
