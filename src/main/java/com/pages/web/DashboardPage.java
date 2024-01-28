package com.pages.web;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;

public class DashboardPage {
private String Welcome_TXT="#nameofuser";
	
	private String Log_Out_LINK="#logout2";
	
	private Page page;
	
	
	public DashboardPage(Page page) {
		this.page=page;
	}
	
	public String verifyWelcomeText() {
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		page.waitForSelector(Log_Out_LINK);
		Locator locator = page.locator(Welcome_TXT);
		PlaywrightAssertions.assertThat(locator).containsText("Welcome");
		return locator.textContent();
	}
	
	public void clickSingOutLink() {
		page.click(Log_Out_LINK);
		page.waitForLoadState();
	}
	
	public boolean verifyLogoutLink() {
		return page.isVisible(Log_Out_LINK);
	}
	
}
