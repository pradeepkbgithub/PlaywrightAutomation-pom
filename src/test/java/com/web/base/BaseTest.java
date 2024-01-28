package com.web.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.factory.ActionFactory;
import com.factory.PlaywrightFactory;
import com.factory.PropertiesReader;
import com.microsoft.playwright.Page;
import com.pages.web.PageReferences;

public class BaseTest extends PageReferences{
	PlaywrightFactory playwrightFactory;
	protected Page page;
	PropertiesReader propReader;
	protected ActionFactory actionFactory;
	
	String URL="https://demoblaze.com/";
	
	
	@BeforeTest
	public void setup() {
		propReader=new PropertiesReader();
		playwrightFactory=new PlaywrightFactory();
		page=playwrightFactory.initBrowser(propReader.getBrowser(), propReader.isHeadless());
		
		actionFactory=new ActionFactory(page);
		actionFactory.navigateURL(propReader.getUrl());
		
		//homePage=new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
