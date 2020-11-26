package com.webtest.demo;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.webest.core.BaseTest;

public class Demo3 extends BaseTest{
	/*
	 * 实现板块的搜索、添加功能
	 * 
	 */
	//搜索客户
	@Test
	public void test1_searchByname() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.type("name=user_name", "qianx8");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("管理客户 - (客户数：1)");
		assertEquals(flag, true);
	}
	@Test
	public void test1_searchByemail() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.type("name=user_email", "2591365420@qq.com");
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("管理客户 - (客户数：1)");
		assertEquals(flag, true);
	}
	/**
	 * 管理积分中添加积分规则
	 * @throws InterruptedException 
	 */
	@Test
	public void test2() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name", "添加新规则");
		webtest.type("name=integral_rule_info", "添加新规则");
		webtest.type("name=integral_rule_start_time", "2020-11-20 15:08");
		webtest.type("name=integral_rule_end_time", "2020-12-20 15:80");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount","500");
		webtest.type("name=integral_num","100");
		webtest.click("xpath=//a[@href='#integral_rule_b']");
		webtest.selectByValue("name=integral_rule_user_type", "user_group");
		webtest.click("xpath=//input[contains(text(),'普通会员')]");
		webtest.click("xpath=//a[@href='#integral_rule_d']");
		webtest.selectByValue("name=integral_rule_goods_type", "class_goods");
		webtest.click("xpath=//label[contains(text(),'家用电器')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}
	
	
	

}
