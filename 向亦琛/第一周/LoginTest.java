package com.xyc.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
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
	
	//正确用户名和争取密码，登录成功，控制台输出“登录成功！”
	@Test(priority=5)
	public void loginTest5()throws Exception{
		if (!loginPage.isLoginPage(driver)) {
			driver.get(LoginURL);
		}
		try {
			loginPage.login(driver, "admin","admin2020");
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			assertEquals(false, loginPage.loginStatus(driver));
		}
	}

	
//	@Test
//    public void test1() {
//        Assert.assertEquals(1, 1);
//    }
// 
// @Test
//    public void test2() {
//        Assert.assertEquals(1, 2);
//    }
// 
// @Test
//    public void test3() {
//        Assert.assertEquals(1, 3);
//    }
// 
// @Test
//    public void test4() {
//        Assert.assertEquals(2, 2);
//    }
// 
// @Test
//    public void test5() {
//        Assert.assertEquals(2, 3);
//    }	
}
