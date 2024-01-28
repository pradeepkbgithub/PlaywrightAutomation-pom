package com.web.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.web.DashboardPage;
import com.pages.web.HomePage;
import com.pages.web.LoginPage;
import com.web.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@BeforeTest
	public void initPage() {
		loginPage=new LoginPage(page);
		dashboardPage=new DashboardPage(page);
	}
	
	@Test(priority = 1)	
	public void loginPageTitleTest() {
		homePage=new HomePage(page);
		String actualTitle = homePage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, homePage.expectedTitle());
	}
	
	@Test(priority = 2)
	public void loginURLTest() {
		String actualTitle = homePage.getLoginPageURL();
		Assert.assertEquals(actualTitle, "https://demoblaze.com/");
	}
	
	@Test(priority = 3)
	public void navigateToLoginPageTest() {
		//loginPage=
		homePage.navigateToLoginPage();
	}
	
	
	@Test(priority = 4)
	public void loginTest() {
		//loginPage.clickSingInLink();
		loginPage.login("ptest2023", "P@test2023");
		//dashboardPage=new DashboardPage(page);
		if(dashboardPage.verifyLogoutLink()) {
			System.out.println("User got successfully login in...... ");
		} else {
			System.out.println("Not able to login................... ");
		}
		String verifyWelcomeText = dashboardPage.verifyWelcomeText();
		Assert.assertEquals(verifyWelcomeText, "Welcome ptest20231");
	}
}
