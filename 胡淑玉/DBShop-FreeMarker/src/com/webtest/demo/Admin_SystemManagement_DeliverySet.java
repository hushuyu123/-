package com.webtest.demo;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_SystemManagement_DeliverySet extends BaseTest{
	@BeforeMethod
	public void adminLogin() throws IOException {

		webtest.open("http://localhost:86/admin");
		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'配送设置')]");
	}
	
	@Test(priority = 0)  //22.配送管理编辑中将配送状态设置为关闭
	public void demo1() throws IOException, InterruptedException {
		
		
		first();
		webtest.click("xpath=//a[contains(text(),'动态API')]/../../li[1]");
		webtest.click("xpath=//table[@class='table table-hover']/tbody/tr/td[7]/a");
		
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		
		baseLogin();
		webtest.runJs("window.scrollBy(0,600)");
		Thread.sleep(3000);
		webtest.click("xpath=//button[@class='add-to-cart cart-1-8']");
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		webtest.runJs("window.scrollBy(0,550)");
		webtest.click("xpath=//div[@id='cart_step']/form/div/div[11]/label[3]/input");
		webtest.runJs("window.scrollBy(0,800)");
		assertFalse(webtest.isElementPresent("xpath=//input[@value='确认订单']"));
	
	}
	
	
	
	@Test  //23.配送设置的动态API将状态设置为开启
	public void demo2() throws IOException, InterruptedException {
		
		first();
		webtest.click("link=动态API");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[@type='submit']");
		
		
	}
	
	@Test  //24.配送设置的动态API中填写完信息后点击刷新
	public void demo3() throws IOException, InterruptedException {
		
		first();
		webtest.click("link=动态API");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		
		webtest.selectByVisibleText("id=api_type", "企业版");
		webtest.type("id=api_key", getExcel1(15, 1));
		
		webtest.click("xpath=//button[contains(text(),'刷新')]");
		assertFalse(webtest.isTextPresent("123"));
	}
	
	
}
