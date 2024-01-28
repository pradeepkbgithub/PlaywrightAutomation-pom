package com.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.web.DashboardPage;
import com.web.base.BaseTest;

public class DashboardPageTest extends BaseTest{

	@BeforeTest
	public void initPage() {
		dashboardPage=new DashboardPage(page);
	}
	
	@Test(priority = 5)	
	public void userWelcomeTextTest() {
		String verifyWelcomeText = dashboardPage.verifyWelcomeText();
		Assert.assertEquals(verifyWelcomeText, "Welcome ptest2023");
	}
	
	@Test(priority = 6)	
	public void logoutLinkTest() {
		Assert.assertEquals(dashboardPage.verifyLogoutLink(), false);
	}
}
