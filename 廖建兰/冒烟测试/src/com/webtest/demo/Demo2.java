package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Demo2 extends BaseTest{
	/*
	 * 实现添加客户组
	 */
	@DataProvider(name = "AddData1")
	public Object[][] addData() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData1.xls", "Sheet1");
	}

	@Test(dataProvider = "AddData1")
	public void test4(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[contains(text(),'添加客户组')]");
		webtest.type("name=user_group_name", add1);
		webtest.type("name=integral_num_start", add2);
		webtest.type("name=integral_num_end", add3);
		webtest.click("name=integral_num_state");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("添加客户 组");
		assertEquals(flag, true);
	}

	/*
	 * 实现添加规则
	 */
	@DataProvider(name = "AddData2")
	public Object[][] addData1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData1.xls", "Sheet2");
	}

	@Test(dataProvider = "AddData2")
	public void test5(String add1, String add2, String add3, String add4) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name", add1);
		webtest.type("name=integral_rule_info", add2);
		webtest.type("name=integral_rule_start_time", "2020-11-20 15:08");
		webtest.type("name=integral_rule_end_time", "2020-12-20 15:80");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount", add3);
		webtest.type("name=integral_num", add4);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}

	@DataProvider(name = "AddData3")
	public Object[][] addData2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData1.xls", "Sheet4");
	}

	@Test(dataProvider = "AddData3")
	public void test5_addruleClose(String add1,String add2,String add3,String add4,String add5,String add6) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name",add1);
		webtest.type("name=integral_rule_info", add2);
		webtest.type("name=integral_rule_start_time",add3);
		webtest.type("name=integral_rule_end_time", add4);
		webtest.selectByValue("name=integral_rule_state", "2");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount",add5);
		webtest.type("name=integral_num",add6);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}
	


}
