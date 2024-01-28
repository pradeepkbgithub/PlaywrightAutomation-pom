package com.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	Properties prop;
	/**
	 * This method use to initialize the properties from config properties file
	 */
	
	String browser,url,username,password;
	boolean headless;
	
	public PropertiesReader() {
		init_prop();
	}
	
	public Properties init_prop() {
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
			prop=new Properties();
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getProperty(String key) {
		return prop.getProperty(key).trim();
	}
	
	public String getBrowser() {
		return browser=prop.getProperty("browser").trim();
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUrl() {
		return url=prop.getProperty("url").trim();
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username=prop.getProperty("username").trim();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password=prop.getProperty("password").trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHeadless() {
		return headless=Boolean.valueOf(prop.getProperty("headless").trim());
	}

	public void setHeadless(boolean headless) {
		this.headless = headless;
	}
}
