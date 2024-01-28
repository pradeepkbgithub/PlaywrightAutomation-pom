package com.pages.web;

import com.microsoft.playwright.Page;

public class LoginPage  {
	// https://magento.softwaretestingboard.com/	 ptest2024@gmail.com / Testp@2024
	// https://demoblaze.com/	ptest2023 / P@test2023

	// 1. String locator
	private String Username_INPUTTXT="#loginusername";
	private String Password_INPUTTXT="#loginpassword";
	private String Login_In_BTN="button[onclick='logIn()']";
	
	private Page page;
	
	//2. page constuctor 
	public LoginPage(Page page) {
		this.page=page;
	}
	
	// 3 page action/method
	
	
	
	public void login(String username, String password) {
		page.fill(Username_INPUTTXT, username);
		page.fill(Password_INPUTTXT, password);
		page.click(Login_In_BTN);
		page.waitForLoadState();
	}
	
	
}
