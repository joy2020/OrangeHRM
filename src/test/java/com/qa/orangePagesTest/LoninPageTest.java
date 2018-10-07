package com.qa.orangePagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangeBase.BaseOrange;
import com.qa.orangePages.HomePage;
import com.qa.orangePages.LoginPage;

public class LoninPageTest extends BaseOrange 
{
	LoginPage lp ;
	HomePage hp;
	
	
	public LoninPageTest() 
	{
		super();
	}
	
	@BeforeTest
	public void setUp() 
	{
		initializer();
		lp = new LoginPage();
	}
	
	@Test(priority=1)
	public void testLogin1() 
	{
		String actualTitle = lp.verifyLpTitle();
		System.out.println(actualTitle);
		String expected = "OrangeHRM";
		Assert.assertEquals(actualTitle, expected, "not as expected");
		
	}
	
	@Test(priority=2)
	public void testLogin2() 
	{
		boolean actualFlag = lp.validateLogo();
		System.out.println("Log presence ::" + actualFlag);
		boolean expFlag = true;
		Assert.assertEquals(actualFlag, expFlag, "panel is not present");
		
	}
	
	@Test(priority=3)
	public void TestLogin3() 
	{
		hp = lp.logIn();
	}
	
	@Test(priority=4)
	public void TestLogin4() 
	{
		boolean actualFlag = lp.validateMessage();
		boolean expFlag = true;
		Assert.assertEquals(actualFlag, expFlag, "message is not present");
	}
	
	

}
