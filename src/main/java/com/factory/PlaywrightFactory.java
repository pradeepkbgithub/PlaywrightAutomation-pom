package com.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	private static ThreadLocal<Playwright> tlPlaywrightr = new ThreadLocal<Playwright>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<Browser>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<BrowserContext>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<Page>();

	public static Playwright getPlaywright() {
		return tlPlaywrightr.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

	public Page initBrowser(String browserName, boolean headless) {
		System.out.println("Browser name is: " + browserName);

		// playwright = Playwright.create();
		tlPlaywrightr.set(Playwright.create());

		switch (browserName.toUpperCase()) {
		case "CHROMIUM":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
			break;
		case "FIREFOX":
			//browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
			break;
		case "SAFARI":
		case "WEBKIT":
			//browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
			break;
		case "CHROME":
			//browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(headless)));
			break;
		case "CHROME_BETA":
			//browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome_beta").setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome_beta").setHeadless(headless)));
			break;
		case "MSEDGE":
			//browser = playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(headless)));
			break;
		default:
			System.out.println("Please pass the right browser name!!!!!!!!!!!");
			break;
		}

		//browserContext = browser.newContext();
		tlBrowserContext.set(getBrowser().newContext());
		//page = browserContext.newPage();
		tlPage.set(getBrowserContext().newPage());

		//return page;
		return getPage();
	}

}
