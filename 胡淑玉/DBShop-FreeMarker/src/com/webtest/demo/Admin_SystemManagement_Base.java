package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

public class Admin_SystemManagement_Base extends BaseTest {
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
		webtest.click("xpath=//a[contains(text(),'系统设置')]");
		
	}
	
	@Test  //1.文件过大
	public void demo1() throws InterruptedException, IOException {  
		first();
		webtest.type("name=shop_logo", getExcel1(2,1));
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("exceeds the defined ini size"));

		
	}
	
	@Test  //2.文件不是图片
	public void demo2() throws InterruptedException, IOException { 
		first();
		webtest.type("name=shop_logo",getExcel1(3,1));
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("扩展名不允许"));

		
	}
	
	@Test  //3.网站名称为空
	public void demo3() throws InterruptedException, IOException {  
		first();
		webtest.typeAndClear("id=shop_name", "");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("网站名称不能为空"));
	}
	
	@Test  //4.打开暂时关闭选项
	public void demo4() throws InterruptedException, IOException { 
		//进行关闭
		first();
		webtest.runJs("window.scroll(0,document.body.scrollHeight)");
		webtest.click("id=shop_close");
		webtest.click("xpath=//button[@type='submit']");
		webtest.open(ReadProperties.getPropertyValue("base_url").toString());
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("系统升级中"));
		
		//打开，防止干扰其他用例
		adminLogin();
		first();
		webtest.runJs("window.scroll(0,document.body.scrollHeight)");
		webtest.click("id=shop_close");
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@Test  //5.开启邮件状态
	public void demo5() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'邮件服务器')]");
		webtest.click("id=email_service_state");
		webtest.typeAndClear("id=send_from_mail",getExcel1(4, 1));
		webtest.typeAndClear("id=send_name", getExcel1(4, 2));
		webtest.click("xpath=//button[@type='submit']");
	}
	
	
	@Test  //6.邮件地址不正确
	public void demo6() throws IOException, InterruptedException {
		first();
		webtest.click("xpath=//a[contains(text(),'邮件服务器')]");
		webtest.click("id=email_service_state");
		webtest.typeAndClear("id=send_from_mail", getExcel1(5, 1));
		webtest.typeAndClear("id=send_name", getExcel1(5, 2));
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("请正确填写邮件地址"));
	}
	
	@Test  //7.发件人名称为空
	public void demo7() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'邮件服务器')]");
		webtest.click("id=email_service_state");
		webtest.typeAndClear("id=send_from_mail",getExcel1(6, 1));
		webtest.typeAndClear("id=send_name","");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("发件人名称不能为空"));
	}
	
	@Test  //8.关闭登录时验证码验证
	public void demo8() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'验证码设置')]");
		webtest.click("id=user_login_captcha");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("验证码"));
	
	}
	
	@Test  //9.打开二维码
	public void demo9() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'二维码设置')]");
		webtest.click("id=shop_QRcode");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		Thread.sleep(2000);
		assertTrue(webtest.isElementPresent("xpath=//div[@class='header-info']/img"));
		
	}
	
	@Test  //10.打开订单设置中的选择送货时间显示
	public void demo10() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'订单设置')]");
		webtest.click("id=user_shipping_date");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		webtest.click("id=J_miniCart");
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		webtest.click("xpath=//input[@value='下一步']");
		assertTrue(webtest.isTextPresent("只工作日送货 "));
		
	}
	
	@Test  //11.在前台底部功能中添加图片和链接地址
	public void demo11() throws IOException, InterruptedException { 
		first();
		webtest.click("xpath=//a[contains(text(),'前台底部')]");
		webtest.type("name=image_1",getExcel1(7, 1));
		webtest.type("name=image_url_1",getExcel1 (7, 2));
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//a[contains(text(),'前台底部')]");
		assertFalse(webtest.isTextPresent("www.baidu.com"));
	}
}
