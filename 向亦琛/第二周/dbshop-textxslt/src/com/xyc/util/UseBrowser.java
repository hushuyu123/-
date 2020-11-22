package com.xyc.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UseBrowser {
	public static WebDriver driver;
	//������������
	public WebDriver startFirefox(String url)throws Exception {
		try {
			System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			System.out.println("�ɹ��򿪻���������");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�򿨻�������������"+e);
		}
		
		return driver;
		
	}
	
	//�ر������
	public void tearDownBrowser()throws Exception {
		try {
			Thread.sleep(3000);
			driver.close();
			System.out.println("�ɹ��ر��������");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ر������ʱ������"+e);
		}
		
	}

}
