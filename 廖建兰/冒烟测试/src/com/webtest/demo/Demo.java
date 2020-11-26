package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Demo extends BaseTest {
	@DataProvider(name = "testData1")
	public Object[][] words1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData.xls", "Sheet1");
	}

	@DataProvider(name = "testData2")
	public Object[][] words2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData.xls", "Sheet2");
	}

	@DataProvider(name = "testData3")
	public Object[][] words3() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData.xls", "Sheet8");
	}

	@DataProvider(name = "testData4")
	public Object[][] words4() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData.xls", "Sheet4");
	}

	@DataProvider(name = "testData5")
	public Object[][] words5() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData.xls", "Sheet7");
	}

	@DataProvider(name = "testData6")
	public Object[][] words6() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData.xls", "Sheet6");
	}

	/*
	 * 
	 * 客户管理模块
	 */
	// 实现管理客户中的添加新顾客
	 @Test(dataProvider = "testData1")
	public void test1(String add1, String add2, String add3, String add4) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新客户')]");
		webtest.selectByValue("name=group_id", "1");
		webtest.type("name=user_name", add1);
		webtest.type("name=user_email", add2);
		webtest.type("name=user_password", add3);
		webtest.type("name=user_password_con", add4);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}

	// 实现客户扩展信息中的添加扩展信息
	 @Test(dataProvider = "testData2")
	public void test2_addradio(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "radio");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	@Test(dataProvider = "testData3")
	public void test3_addcheckbox(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "checkbox");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "testData4")
	public void test4_addselect(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		Thread.sleep(3000);
		webtest.selectByValue("name=field_type", "select");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "testData5")
	public void test5_addtext(String add1,String add2) throws InterruptedException {
		System.out.println(add1);		
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "text");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);

	}

	@Test(dataProvider = "testData6")
	public void test6_addtextarea(String add1, String add2) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "textarea");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

}
