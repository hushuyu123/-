package com.xyc.test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.xyc.pageobject.LoginPage;
import com.xyc.util.BaseTest;

//@Listeners({ JavaMailTestListener.class})
public class LoginTest extends BaseTest{
	LoginPage loginPage = new LoginPage();
	String LoginURL = "http://localhost/index.php/admin";
	//空的用户名和正确密码，登陆失败，控制台输出“用户名错误！”
	@Test(priority=1)
	public void loginTest1()throws Exception{
		if(!loginPage.isLoginPage(driver)){
			driver.get(LoginURL);
		}

		try {
			loginPage.login(driver, "","admin2020");

		} catch (Exception e) {
			System.out.println(e);

		}
		finally {
			assertEquals(false, loginPage.loginStatus(driver));

		}
	}
	
	//空的用户名和错误的密码，登陆失败，控制台输出“用户名错误！”
	@Test(priority=2)
	public void loginTest2() throws Exception{
		if(!loginPage.isLoginPage(driver)){
			driver.get(LoginURL);
		}

		try {
			loginPage.login(driver, "","$z58dSH");

		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			assertEquals(false, loginPage.loginStatus(driver));
		}
	}
	
	//正确用户名和空的密码，登陆失败，控制台输出“密码不正确”
	@Test(priority=3)
	public void loginTest3()throws Exception{
		if (!loginPage.isLoginPage(driver)) {
			driver.get(LoginURL);
		}
		try {
			loginPage.login(driver, "admin","");
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			assertEquals(false, loginPage.loginStatus(driver));
		}
	}
	
	//错误用户名和空的密码，登陆失败，控制台输出“用户名错误！”
	@Test(priority=4)
	public void loginTest4() throws Exception{
			if (!loginPage.isLoginPage(driver)) {
				driver.get(LoginURL);
			}
			try {
				loginPage.login(driver, "adminiy","");
			} catch (Exception e) {
				System.out.println(e);
			}
			finally {
				assertEquals(false, loginPage.loginStatus(driver));
			}
	}
	
	//空的用户名和空的密码，登录失败，控制台输出“用户名错误！”

	@Test(priority=5)

	public void loginTest5() throws Exception{
	if(!loginPage.isLoginPage(driver)){
	driver.get(LoginURL);

	}

	try {
	loginPage.login(driver, "","");

	} catch (Exception e) {
	System.out.println(e);

	}

	finally {
	assertEquals(false, loginPage.loginStatus(driver));

	}

	}
	
	//错误用户名和错误的密码，登录失败，控制台输出“用户名错误！”

	@Test(priority=6)

	public void loginTest6() throws Exception{
	if(!loginPage.isLoginPage(driver)){
	driver.get(LoginURL);

	}

	try {
	loginPage.login(driver, "admim","$z58dSH");

	} catch (Exception e) {
	System.out.println(e);

	}

	finally {
	assertEquals(false, loginPage.loginStatus(driver));

	}

	}
	
	//正确用户名和错误的密码，登录失败，控制台输出“密码不正确”

	@Test(priority=7)

	public void loginTest7() throws Exception{
	if(!loginPage.isLoginPage(driver)){
	driver.get(LoginURL);

	}

	try {
	loginPage.login(driver, "admin","$z58dSH");

	} catch (Exception e) {
	System.out.println(e);

	}

	finally {
	assertEquals(false, loginPage.loginStatus(driver));

	}

	}

	//错误用户名和正确密码，登录失败，控制台输出“用户名错误！”

	@Test(priority=8)

	public void loginTest8() throws Exception{
	if(!loginPage.isLoginPage(driver)){
	driver.get(LoginURL);

	}

	try {
	loginPage.login(driver, "admim","admin2020");

	} catch (Exception e) {
	System.out.println(e);

	}

	finally {
	assertEquals(false, loginPage.loginStatus(driver));

	}

	}
	
	//正确用户名和正确密码，登录成功，控制台输出“登录成功！”
	@Test(priority=9)
	public void loginTest9()throws Exception{
		if (!loginPage.isLoginPage(driver)) {
			driver.get(LoginURL);
		}
		try {
			loginPage.login(driver, "admin","admin2020");
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			assertEquals(true, loginPage.loginStatus(driver));
		}
	}

}
