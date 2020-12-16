package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_OperationManagement extends BaseTest {
	/*
	 * 运营管理模块--廖建兰
	 * 
	 */
	//"data\\AddData2.xls"
	@DataProvider(name = "Data")
	public Object[][] word() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet1");
	}

	@DataProvider(name = "Data1")
	public Object[][] word1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet5");
	}

	@DataProvider(name = "Data2")
	public Object[][] word2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet3");
	}

	@DataProvider(name = "Data3")
	public Object[][] word3() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData2.xls", "Sheet4");
	}

	@Test(dataProvider = "Data")
	public void test1(String add1, String add2, String add3, String add4, String add5, String add6)
			throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=promotions_name", add1);
		webtest.type("name=promotions_info", add2);
		webtest.type("name=promotions_start_time", add3);
		webtest.type("name=promotions_end_time", add4);
		webtest.click("xpath=//a[@href='#promotions_c']");
		webtest.type("name=shopping_amount", add5);
		webtest.type("name=shopping_discount", add6);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("优惠促销规则");
		assertEquals(flag, true);
	}

	@Test
	// 实现对其进行关闭
	public void test1_edit1() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.selectByValue("name=rule_state", "2");
		webtest.click("xpath=//button[contains(text(),'保存促销规则')]");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);

	}
//实现对扩大商品范围
	@Test
	public void test1_edit2() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//a[@href='#promotions_d']");
		webtest.selectByValue("name=promotions_goods_type", "brand_goods");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);
		
	}
	@Test
	// 实现对其删除功能
	public void test1_edit3() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'优惠促销规则')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);
	}

	// 添加优惠券
	@Test(dataProvider = "Data1")
	public void test2(String add1, String add2, String add3, String add4, String add5, String add6, String add7,
			String add8, String add9) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'添加优惠券')]");
		webtest.type("name=coupon_name", add1);
		webtest.type("name=coupon_info", add2);
		webtest.click("xpath=//a[contains(text(),'优惠规则')]");
		webtest.type("name=shopping_amount", add3);
		webtest.type("name=shopping_discount", add4);
		webtest.click("xpath=//a[contains(text(),'获取规则')]");
		webtest.type("name=get_coupon_start_time", add5);
		webtest.type("name=get_coupon_end_time", add6);
		webtest.type("name=get_shopping_amount", add7);
		webtest.click("xpath=//a[contains(text(),'使用规则')]");
		webtest.type("name=coupon_start_time", add8);
		webtest.type("name=coupon_end_time", add9);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加优惠券");
		assertEquals(flag, true);
	}
	//对其它进行编辑，实现其它获取方式--点击直接获取
	@Test
	public void test2_edit1() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//a[@href='#coupon_b']");
		webtest.selectByValue("name=get_coupon_type", "click");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加优惠券");
		assertEquals(flag, true);
		
	}
	@Test
	//对其它进行编辑，实现其它获取方式--点击直接获取
	public void test2_edit2() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//a[@href='#coupon_b']");
		webtest.selectByValue("name=get_coupon_type", "register");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加优惠券");
		assertEquals(flag, true);
	}
	//编辑商品指定商品类型为商品分类
	@Test
	public void test2_edit3() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//a[@href='#coupon_d']");
		webtest.selectByValue("name=coupon_goods_type", "class_goods");
		webtest.click("xpath=//label[contains(text(),'家用电器')]");
		Thread.sleep(3000);
		webtest.click("xpath=//label[contains(text(),'电冰箱')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加优惠券");
		assertEquals(flag, true);
	}

//实现对其关闭
	@Test
	public void test2_edit4() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.selectByValue("name=coupon_state", "2");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);
	}
	

	// 实现对其删除
	@Test
	public void test2_edit5() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.click("xpath=//a[contains(text(),'优惠券')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加优惠券");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "Data2")
	public void test3(String add1, String add2, String add3, String add4, String add5) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'专题管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'专题设置')]");
		webtest.click("xpath=//a[contains(text(),'添加专题')]");
		webtest.type("name=theme_name", add1);
		webtest.type("name=theme_sign", add2);
		webtest.selectByValue("name=theme_template", "default");
		webtest.click("xpath=//a[contains(text(),'搜索引擎优化')]");
		webtest.type("name=theme_extend_name", add3);
		webtest.type("name=theme_keywords", add4);
		webtest.type("name=theme_description", add5);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加专题");
		assertEquals(flag, true);
	}

	// 对专题进行广告设置
	@Test(dataProvider = "Data3")
	public void test3_edit1(String add1, String add2, String add3, String add4, String add5)
			throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'专题管理')]");
		webtest.click("xpath=//a[contains(text(),'专题设置')]");
		webtest.click("xpath=//a[contains(text(),'广告设置')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.type("name=ad_slide_text_1", add1);
		webtest.type("name=ad_slide_text_2", add2);
		webtest.type("name=ad_slide_text_3", add3);
		webtest.type("name=ad_slide_text_4", add4);
		webtest.type("name=ad_slide_text_5", add5);
		webtest.click("xpath=//button[@type='submit']");
	}

	@Test
	// 对专题进行编辑--将其禁用
	public void test3_edit2() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'专题管理')]");
		webtest.click("xpath=//a[contains(text(),'专题设置')]");
		webtest.selectByValue("name=theme_state", "2");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);
	}

	/**
	 * 删除
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test3_edit2_delete() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'运营管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'专题管理')]");
		webtest.click("xpath=//a[contains(text(),'专题设置')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
	}

}
