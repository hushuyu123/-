package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;
public class Admin_SystemManagement_MoneySet extends BaseTest{
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
		webtest.click("xpath=//a[contains(text(),'货币设置')]");
	}
	
	@Test //13.货币设置中添加欧元
	public void demo1() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid", getExcel1(9, 1));
		
		webtest.type("id=currency_name", getExcel1(9, 2));
		webtest.click("id=currency_code_chzn_o_77");
		webtest.type("id=currency_symbol",getExcel1(9, 3));
		webtest.type("id=currency_decimal", getExcel1(9, 4));
		webtest.type("id=currency_rate", getExcel1(9, 5));
		webtest.click("xpath=//button[@type='submit']");
		String baseUrl = ReadProperties.getPropertyValue("base_url");
		webtest.open(baseUrl);
		assertTrue(webtest.isTextPresent("欧元"));
		
		adminLogin();
	}
	
	
	@Test //14.货币设置的货币信息中货币名称为空
	public void demo2() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid", getExcel1(10, 1));
		
		webtest.type("id=currency_name","");
		webtest.click("id=currency_code_chzn_o_15");
		webtest.type("id=currency_symbol",getExcel1(10, 2));
		webtest.type("id=currency_decimal", getExcel1(10, 3));
		webtest.type("id=currency_rate", getExcel1(10, 4));
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("货币名称不能为空"));
	}
	
	
	@Test //15.货币设置的货币信息中小数位数填入汉字
	public void demo3() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid", getExcel1(11, 1));
		
		webtest.type("id=currency_name",getExcel1(11, 2));   //货币名称
		webtest.click("id=currency_code_chzn_o_77");
		webtest.type("id=currency_symbol",getExcel1(11, 3));
		webtest.type("id=currency_decimal", getExcel1(11, 4)); //小数位数
		webtest.type("id=currency_rate", getExcel1(11, 5));   //货币汇率
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("小数位数必须为数字"));
	}
	
	
	
	@Test //16.货币设置的货币信息中小数位数填入7
	public void demo4() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'添加货币')]");
		webtest.click("id=currency_code_chzn");
		webtest.type("class=valid", getExcel1(12, 1));
		
		webtest.type("id=currency_name", getExcel1(12, 2));   //货币名称
		webtest.click("id=currency_code_chzn_o_77");
		webtest.type("id=currency_symbol",getExcel1(12, 3));
		webtest.type("id=currency_decimal", getExcel1(12, 4)); //小数位数
		webtest.type("id=currency_rate", getExcel1(12, 5));   //货币汇率
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("位数最大为6"));
	}
	
}
