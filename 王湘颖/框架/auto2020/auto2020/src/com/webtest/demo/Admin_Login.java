package com.webtest.demo;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.webtest.core.BaseTest;



public class Admin_Login extends BaseTest{
	
	@Test
	public void testLogin() {
		webtest.open("http://localhost:86/user/login");
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//input[@type='submit']");

	}
	
	

}
