package com.factory;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class ActionFactory extends PlaywrightFactory {
	//Page page;
	
	public ActionFactory(Page page) {
		//this.page=page;
	}
	
	
//	public Page navigateURL(Page page, String url) {
//		page.navigate(url);
//		page.waitForLoadState();
//		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//		return page;
//	}
	
	public Page navigateURL( String url) {
		getPage().navigate(url);
		getPage().waitForLoadState();
		getPage().waitForLoadState(LoadState.DOMCONTENTLOADED);
		return getPage();
	}
	
	
	/**
	 * take screenshot
	 */
	
	public static String takeScreenshot() {
		String path=System.getProperty("user.dir")+"/test-results/screenshot/"+System.currentTimeMillis()+".png";
		
		getPage().screenshot(new Page.ScreenshotOptions()
				.setPath(Paths.get(path))
				.setFullPage(true));
		return path;
	}
	
}
