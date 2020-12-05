package com.webtest.demo;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;


public class Admin_Delete extends BaseTest{

	
	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "12345678");
		webtest.click("xpath=//button[contains(text(),'��̨��¼')]");
	}
	//24,ɾ����Ʒ
	@Test
	public void test24() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'������Ʒ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
	}
	
	//25,ɾ����Ʒ����
	@Test
	public void test25() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�������')]");
		webtest.click("link=��Ʒ����");
		webtest.click("xpath=//a[contains(text(),'ɾ������')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	//26,ɾ�������ʾ
	@Test
	public void test26() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�������')]");
		webtest.click("link=ǰ̨�������");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//27,ɾ�����Է���
	@Test
	public void test27() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("link=���Է���");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//28��ɾ����ƷƷ��
	@Test
	public void test28() throws InterruptedException{
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��ƷƷ��')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//29��ɾ������
	@Test
	public void test29() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'�༭�鿴')]");	
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//30,��ѯɾ��
	@Test
	public void test30() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��Ʒ��ѯ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//31��ɾ����ǩ����Ϣ
	@Test
	public void test31() throws InterruptedException{
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/tag/tagGroup')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//32��ɾ����ͨ��Ʒ��ǩ
	@Test
	public void test32() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=��ͨ��Ʒ��ǩ");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//34,ɾ���ض���Ʒ��ǩ
	@Test
	public void test34() throws InterruptedException { 
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=�ض���Ʒ��ǩ");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");	
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		assertTrue(flag);
		Thread.sleep(3000);
	}
	
	//33,ɾ����Ʒ��ǩ����Ʒ��Ϣ
	@Test
	public void test33() throws InterruptedException {
		boolean flag = false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=�ض���Ʒ��ǩ");
		webtest.click("xpath=//a[contains(text(),'�༭')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		if(webtest.getAlertTest() != null) {
			flag = true;
		}
		assertTrue(flag);
		webtest.click("xpath=//button[contains(text(),'�����ǩ��Ϣ')]");
		Thread.sleep(3000);
	}	
	
}
