package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_OperationManagement extends BaseTest {
	/*
	 * ��Ӫ����ģ��--�ν���
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
		boolean flag = webtest.isTextPresent("�Żݴ�������");
		assertEquals(flag, true);
	}

	@Test
	// ʵ�ֶ�����йر�
	public void test1_edit1() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�Żݴ�������')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.selectByValue("name=rule_state", "2");
		webtest.click("xpath=//button[contains(text(),'�����������')]");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);

	}
//ʵ�ֶ�������Ʒ��Χ
	@Test
	public void test1_edit2() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�Żݴ�������')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//a[@href='#promotions_d']");
		webtest.selectByValue("name=promotions_goods_type", "brand_goods");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);
		
	}
	@Test
	// ʵ�ֶ���ɾ������
	public void test1_edit3() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�Żݴ�������')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);
	}

	// ����Ż�ȯ
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
		webtest.type("name=shopping_amount", add3);
		webtest.type("name=shopping_discount", add4);
		webtest.click("xpath=//a[contains(text(),'��ȡ����')]");
		webtest.type("name=get_coupon_start_time", add5);
		webtest.type("name=get_coupon_end_time", add6);
		webtest.type("name=get_shopping_amount", add7);
		webtest.click("xpath=//a[contains(text(),'ʹ�ù���')]");
		webtest.type("name=coupon_start_time", add8);
		webtest.type("name=coupon_end_time", add9);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����Ż�ȯ");
		assertEquals(flag, true);
	}
	//���������б༭��ʵ��������ȡ��ʽ--���ֱ�ӻ�ȡ
	@Test
	public void test2_edit1() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.click("xpath=//a[contains(text(),'�Ż�ȯ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//a[@href='#coupon_b']");
		webtest.selectByValue("name=get_coupon_type", "click");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����Ż�ȯ");
		assertEquals(flag, true);
		
	}
	@Test
	//���������б༭��ʵ��������ȡ��ʽ--���ֱ�ӻ�ȡ
	public void test2_edit2() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.click("xpath=//a[contains(text(),'�Ż�ȯ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//a[@href='#coupon_b']");
		webtest.selectByValue("name=get_coupon_type", "register");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����Ż�ȯ");
		assertEquals(flag, true);
	}
	//�༭��Ʒָ����Ʒ����Ϊ��Ʒ����
	@Test
	public void test2_edit3() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.click("xpath=//a[contains(text(),'�Ż�ȯ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//a[@href='#coupon_d']");
		webtest.selectByValue("name=coupon_goods_type", "class_goods");
		webtest.click("xpath=//label[contains(text(),'���õ���')]");
		Thread.sleep(3000);
		webtest.click("xpath=//label[contains(text(),'�����')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����Ż�ȯ");
		assertEquals(flag, true);
	}

//ʵ�ֶ���ر�
	@Test
	public void test2_edit4() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.click("xpath=//a[contains(text(),'�Ż�ȯ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.selectByValue("name=coupon_state", "2");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);
	}
	

	// ʵ�ֶ���ɾ��
	@Test
	public void test2_edit5() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.click("xpath=//a[contains(text(),'�Ż�ȯ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����Ż�ȯ");
		assertEquals(flag, true);
	}

	@Test(dataProvider = "Data2")
	public void test3(String add1, String add2, String add3, String add4, String add5) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'ר�����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'ר������')]");
		webtest.click("xpath=//a[contains(text(),'���ר��')]");
		webtest.type("name=theme_name", add1);
		webtest.type("name=theme_sign", add2);
		webtest.selectByValue("name=theme_template", "default");
		webtest.click("xpath=//a[contains(text(),'���������Ż�')]");
		webtest.type("name=theme_extend_name", add3);
		webtest.type("name=theme_keywords", add4);
		webtest.type("name=theme_description", add5);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("���ר��");
		assertEquals(flag, true);
	}

	// ��ר����й������
	@Test(dataProvider = "Data3")
	public void test3_edit1(String add1, String add2, String add3, String add4, String add5)
			throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'ר�����')]");
		webtest.click("xpath=//a[contains(text(),'ר������')]");
		webtest.click("xpath=//a[contains(text(),'�������')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.type("name=ad_slide_text_1", add1);
		webtest.type("name=ad_slide_text_2", add2);
		webtest.type("name=ad_slide_text_3", add3);
		webtest.type("name=ad_slide_text_4", add4);
		webtest.type("name=ad_slide_text_5", add5);
		webtest.click("xpath=//button[@type='submit']");
	}

	@Test
	// ��ר����б༭--�������
	public void test3_edit2() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'ר�����')]");
		webtest.click("xpath=//a[contains(text(),'ר������')]");
		webtest.selectByValue("name=theme_state", "2");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);
	}

	/**
	 * ɾ��
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test3_edit2_delete() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'��Ӫ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'ר�����')]");
		webtest.click("xpath=//a[contains(text(),'ר������')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
	}

}
