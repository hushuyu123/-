package com.xyc.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UseBrowser {
	public static WebDriver driver;
	//启动火狐浏览器
	public WebDriver startFirefox(String url)throws Exception {
		try {
			System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			System.out.println("成功打开火狐浏览器！");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("打卡火狐浏览器出错了"+e);
		}
		
		return driver;
		
	}
	
	//关闭浏览器
	public void tearDownBrowser()throws Exception {
		try {
			Thread.sleep(3000);
			driver.close();
			System.out.println("成功关闭浏览器！");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("关闭浏览器时出错了"+e);
		}
		
	}

}
