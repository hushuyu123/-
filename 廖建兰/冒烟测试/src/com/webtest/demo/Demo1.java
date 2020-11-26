package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Demo1 extends BaseTest {
	/*
	 * ��Ӫ����ģ��
	 * 
	 */
	@DataProvider(name = "Data")
	public Object[][] word() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData2.xls", "Sheet1");
	}

	@Test(dataProvider = "Data")
	public void test1(String add1, String add2, String add3, String add4, String add5, String add6)
			throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�Żݴ�������')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����¹���')]");
		webtest.type("name=promotions_name", add1);
		webtest.type("name=promotions_info", add2);
		webtest.type("name=promotions_start_time", add3);
		webtest.type("name=promotions_end_time", add4);
		webtest.click("xpath=//a[@href='#promotions_c']");
		webtest.type("name=shopping_amount", add5);
		webtest.type("name=shopping_discount", add6);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("�Żݴ�������");
		assertEquals(flag, true);
	}

	@DataProvider(name = "Data1")
	public Object[][] word1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData2.xls", "Sheet2");
	}
	@Test(dataProvider = "Data1")
	public void test2(String add1, String add2, String add3, String add4, String add5, String add6, String add7,
			String add8, String add9) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.click("xpath=//a[contains(text(),'�Ż�ȯ')]");
		webtest.click("xpath=//a[contains(text(),'����Ż�ȯ')]");
		webtest.type("name=coupon_name", add1);
		webtest.type("name=coupon_info", add2);
		webtest.click("xpath=//a[contains(text(),'�Żݹ���')]");
		webtest.type("name=shopping_amount",add3);
		webtest.type("name=shopping_discount",add4);
		webtest.click("xpath=//a[contains(text(),'��ȡ����')]");
		webtest.type("name=get_coupon_start_time", add5);
		webtest.type("name=get_coupon_end_time", add6);
		webtest.type("name=get_shopping_amount", add7);
		webtest.click("xpath=//a[contains(text(),'ʹ�ù���')]");
		webtest.type("name=coupon_start_time",add8 );
		webtest.type("name=coupon_end_time", add9);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("����Ż�ȯ");
		assertEquals(flag, true);
	}


	@DataProvider(name = "Data2")
	public Object[][] word2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData2.xls", "Sheet3");
	}
	@Test(dataProvider = "Data2")
	public void test10(String add1, String add2, String add3, String add4, String add5) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'ר�����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'ר������')]");
		webtest.click("xpath=//a[contains(text(),'���ר��')]");
		webtest.type("name=theme_name",add1);
		webtest.type("name=theme_sign",add2);
		webtest.selectByValue("name=theme_template", "default");
		webtest.click("xpath=//a[contains(text(),'���������Ż�')]");
		webtest.type("name=theme_extend_name", add3);
		webtest.type("name=theme_keywords", add4);
		webtest.type("name=theme_description",add5);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("���ר��");
		assertEquals(flag, true);
	}

	

}
