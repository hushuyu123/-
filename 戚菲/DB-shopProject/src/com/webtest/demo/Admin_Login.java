package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.webtest.core.BaseTest;



public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin() {
		
		webtest.open("http://localhost:9998");
		
		webtest.click("xpath=//a[contains(text(),'登录')]");
		webtest.type("id=user_name", "qifei");
		webtest.type("id=user_password", "qifei123");
		webtest.type("id=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test
	public void demo1() {
		assertEquals(1, 2);
	}
	@Test
	public void demo2() {
		assertEquals(1, 1);
	}
	@Test
	public void demo3() {
		assertEquals(2, 2);
	}
	@Test
	public void demo4() {
		assertEquals(3, 2);
	}
	@Test
	public void demo5() {
		assertEquals(4, 4);
	}
	@Test
	public void demo6() {
		assertEquals(7, 4);
	}

}
