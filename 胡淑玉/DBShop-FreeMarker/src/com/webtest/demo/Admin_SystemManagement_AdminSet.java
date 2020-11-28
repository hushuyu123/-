package com.webtest.demo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_SystemManagement_AdminSet extends BaseTest{
	@BeforeMethod
	public void adminLogin() throws IOException {

		webtest.open("http://localhost:86/admin");
		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	public void first() throws InterruptedException, IOException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=管理员设置");
		Thread.sleep(3000);
	}
	
	
	@Test //39.管理员设置中的管理员的基本信息，将登录密码填入‘123’
	public void demo1() throws IOException, InterruptedException {

		first();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", getExcel1(24, 1));
		webtest.typeAndClear("id=admin_password_con", getExcel1(24, 2));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("至少输入6位密码"));
	}
	


	@Test //40.管理员设置中的管理员的基本信息，将登录密码填入21个1
	public void demo2() throws IOException, InterruptedException {

		first();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", getExcel1(25, 1));
		webtest.typeAndClear("id=admin_password_con", getExcel1(25, 2));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("密码最长为20位"));
	}
	
	@Test  //41.管理员设置中的管理员的基本信息，将登录密码和确认密码输入不一致
	public void demo3() throws IOException, InterruptedException {
		first();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", getExcel1(26, 1));
		webtest.typeAndClear("id=admin_password_con", getExcel1(26, 2));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("两次输入的密码不一致"));
	}
	
	
	@Test   //42.管理员设置中的管理员组的权限设置的全部权限取消
	public void demo4() throws IOException, InterruptedException {
		first();
		webtest.click("link=管理员组");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'管理员')]/../td[3]/a");
		webtest.click("xpath=//a[contains(text(),'权限设置')]");
		webtest.click("name=purview[purviewAll]");
		assertEquals(webtest.isChecked("name=purview[purviewAll]"), false);
	}
	
	@Test   //43.点击管理员设置中的管理员下的管理员组的‘管理员’链接
	public void demo5() throws IOException, InterruptedException {
		first();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("link=管理员");
		assertTrue(webtest.isTextPresent("编辑管理员组"));
	}
	
	
}
