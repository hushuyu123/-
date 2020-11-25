package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login extends BaseTest {
	// 用户名正确，密码错误
	@Test
	public void testLogin1() throws InterruptedException {
		webtest.open("http://localhost:86/admin");
		Thread.sleep(3000);
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "1234");
		Thread.sleep(2000);
		webtest.submit("admin_login_form");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("账户名或者密码错误！");
		assertEquals(flag, false);
	}

	// 用户名错误
	@Test
	public void testLogin2() throws InterruptedException {

		webtest.open("http://localhost:86/admin");
		Thread.sleep(3000);
		webtest.type("name=user_name", "user");
		webtest.type("name=user_passwd", "123456");
		Thread.sleep(2000);
		webtest.submit("admin_login_form");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("账户名或者密码错误！");
		assertEquals(flag, false);
	}

	// 成功登录
	@Test
	public void testLogin3() throws InterruptedException {

		webtest.open("http://localhost:86/admin");
		Thread.sleep(1000);
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "123456");
		Thread.sleep(2000);
		webtest.submit("admin_login_form");
		Thread.sleep(2000);
		boolean flag = webtest.isTextPresent("账户名或者密码错误！");
		assertEquals(flag, false);

	}

}
