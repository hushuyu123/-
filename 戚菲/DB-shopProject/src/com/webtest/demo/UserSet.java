package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

public class UserSet extends BaseTest {

	
	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'客户设置')]");
	}
	
	@Test  //12.可用登录名全部进行勾选
	public void demo1() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'注册与登录')]");
		webtest.click("name=login_email_state");
		webtest.click("name=login_phone_state");
		webtest.click("xpath=//button[@type='submit']");
		
		String baseUrl = ReadProperties.getPropertyValue("base_url");
		webtest.open(baseUrl);
		
		webtest.click("xpath=//a[contains(text(),'登录')]");
		webtest.type("id=user_name", getExcel(13, 1));
		webtest.type("id=user_password", getExcel(13, 2));
		webtest.type("id=captcha_code", getExcel(13, 3));
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		assertTrue(webtest.isElementPresent("xpath=//a[text(),'退出']"));
		
	
	}
}
