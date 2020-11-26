package com.webtest.demo;

import org.testng.annotations.Test;

import com.webest.core.BaseTest;

public class DeleteDemo extends BaseTest{
	/**
	 * 实现删除功能
	 */
	@Test
	public void test_detelecustom() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[@onclick='user_del_js(1);']");
		webtest.alertAccept();
	}
	@Test
	public void test_deletecustomextends() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[@onclick='return field_del_js(1);']");
		webtest.alertAccept();
	}
	@Test
	public void test_deletecustomgroups() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[@onclick='return group_del_js(9);;']");
		webtest.alertAccept();
	}
	@Test
	public void test_deleterule() throws InterruptedException {
		testLogin();
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		webtest.click("xpath=//a[@href='/admin/user/integral/delIntegralRule/1']");
		webtest.alertAccept();
	}
	/**
	 * 运营管理模块
	 */
	
	@Test
	public void test_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		webtest.click("xpath=//a[@href='/admin/goods/promotions/del/1']");
		webtest.alertAccept();
	}

}
