package com.webtest.demo;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.webest.core.BaseTest;

public class Demo3 extends BaseTest{
	/*
	 * ʵ�ְ�����������ӹ���
	 * 
	 */
	//�����ͻ�
	@Test
	public void test1_searchByname() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		Thread.sleep(3000);
		webtest.type("name=user_name", "qianx8");
		webtest.click("xpath=//button[contains(text(),'����')]");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("����ͻ� - (�ͻ�����1)");
		assertEquals(flag, true);
	}
	@Test
	public void test1_searchByemail() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		Thread.sleep(3000);
		webtest.type("name=user_email", "2591365420@qq.com");
		webtest.click("xpath=//button[contains(text(),'����')]");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("����ͻ� - (�ͻ�����1)");
		assertEquals(flag, true);
	}
	/**
	 * �����������ӻ��ֹ���
	 * @throws InterruptedException 
	 */
	@Test
	public void test2() throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�������')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'���ֹ���')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����¹���')]");
		webtest.type("name=integral_rule_name", "����¹���");
		webtest.type("name=integral_rule_info", "����¹���");
		webtest.type("name=integral_rule_start_time", "2020-11-20 15:08");
		webtest.type("name=integral_rule_end_time", "2020-12-20 15:80");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount","500");
		webtest.type("name=integral_num","100");
		webtest.click("xpath=//a[@href='#integral_rule_b']");
		webtest.selectByValue("name=integral_rule_user_type", "user_group");
		webtest.click("xpath=//input[contains(text(),'��ͨ��Ա')]");
		webtest.click("xpath=//a[@href='#integral_rule_d']");
		webtest.selectByValue("name=integral_rule_goods_type", "class_goods");
		webtest.click("xpath=//label[contains(text(),'���õ���')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("����¹���");
		assertEquals(flag, true);
	}
	
	
	

}
