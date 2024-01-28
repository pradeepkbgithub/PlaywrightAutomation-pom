package com.pages.web;

import com.microsoft.playwright.Page;

public class HomePage  {
	private String LOGIN_PAGE_TITLE="STORE";
	private String Login_LINK="#login2";
	
	private Page page;

	public HomePage(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		return page.title();
	}
	
	public String getLoginPageURL() {
		String url = page.url();
		System.out.println("URL : "+url);
		return url;
	}
	
	public String expectedTitle() {
		return LOGIN_PAGE_TITLE;
	}
	
	
	public void navigateToLoginPage() {
		page.locator(Login_LINK).click();
		page.waitForLoadState();
		//return new LoginPage(page);
	}
}
