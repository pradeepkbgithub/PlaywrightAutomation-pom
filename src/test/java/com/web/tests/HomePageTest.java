package com.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.web.HomePage;
import com.web.base.BaseTest;

public class HomePageTest extends BaseTest{

	@BeforeTest
	public void initPage() {
		homePage=new HomePage(page);
	}
	
	@Test(priority = 1)	
	public void loginPageTitleTest() {
		//homePage=new HomePage(page);
		String actualTitle = homePage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, homePage.expectedTitle());
	}
	
	@Test(priority = 2)
	public void loginURLTest() {
		String actualTitle = homePage.getLoginPageURL();
		Assert.assertEquals(actualTitle, "https://demoblaze.com/");
	}
	
	
	
}
