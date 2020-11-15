package com.xyc.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public String LoginBackstageURL = "http://localhost/index.php/admin";
	UseBrowser useBrowser = new UseBrowser();
	public static WebDriver driver;
	@BeforeSuite
	public void start()throws Exception{
		try {
			driver = useBrowser.startFirefox(LoginBackstageURL);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	@AfterSuite
	public void end()throws Exception{
		useBrowser.tearDownBrowser();
	}

}
