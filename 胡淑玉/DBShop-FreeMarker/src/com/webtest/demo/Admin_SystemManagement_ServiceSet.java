package com.webtest.demo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_SystemManagement_ServiceSet extends BaseTest{
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
		webtest.mouseToElement("xpath=//a[contains(text(),'在线客服设置')]");
	}
	
	@Test  //44.在线客服设置中添加客服
	public void demo1() throws IOException, InterruptedException {

		first();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", getExcel1(27, 1));
		webtest.selectByIndex("id=online_group_id", 1);
		webtest.selectByIndex("id=online_type", 2);
		webtest.type("id=online_account",  getExcel1(27, 2));
		webtest.typeAndClear("id=online_sort",  getExcel1(27, 3));
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@Test  //45.在线客服设置的在线客服成员中添加在线客服选择通讯工具‘腾讯QQ’
	public void demo2() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", getExcel1(28, 1));
		webtest.selectByIndex("id=online_group_id", 1);
		webtest.selectByVisibleText("id=online_type", "腾讯QQ");
		webtest.type("id=online_account",  getExcel1(28, 2));
		webtest.typeAndClear("id=online_sort",  getExcel1(28, 3));
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("客服2"));
	}
	
	
	@Test  //46.在线客服设置的在线客服成员中删除客服
	public void demo3() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a[2]");
		webtest.alertAccept();
	}
	
	@Test  //47.在线客服设置的在线客服成员中在编辑基本信息中删除客服
	public void demo4() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a");
		webtest.click("xpath=//a[contains(text(),'删除在线客服')]");
		Thread.sleep(2000);
		webtest.alertAccept();
		Thread.sleep(2000);
	}
	
	
	@Test  //48.在线客服设置的在线客服成员中将客服的客服状态设置为禁用
	public void demo5() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a");
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("客服2"));
	}
	
	
	@Test  //49.在线客服设置的在线客服成员中编辑基本信息时不选择客服组名称
	public void demo6() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", getExcel1(29, 1));
		webtest.selectByVisibleText("id=online_type", "腾讯QQ");
		webtest.type("id=online_account", getExcel1(29, 2));
		webtest.typeAndClear("id=online_sort", getExcel1(29, 3));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("请选择客户组"));
	}
	
	@Test  //50.在线客服设置的在线客服分组中将‘1’组的客服组状态禁用
	public void demo7() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'在线客服分组')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'1组')]/../td[6]/a");
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("1组"));
		
	}
	
}
