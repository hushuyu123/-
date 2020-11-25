package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_Set extends BaseTest{
	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "12345678");
		webtest.click("xpath=//button[contains(text(),'��̨��¼')]");
	}
    @DataProvider(name="testData5")
    public Object[][] data2() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","sreach");
    }
    @DataProvider(name="testData10")
    public Object[][] data7() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","test26");
    }
    @DataProvider(name="testData13")
    public Object[][] data10() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","conten");
    }
    
	//44,������Ʒ���ƽ�������
    //45,������ƷID��Χ������Ʒ
    //46��������Ʒ���Ų�����Ʒ
	@Test(dataProvider = "testData5")
	public void test46(String name,String start_id,String end_id, String id) {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'������Ʒ')]");
		webtest.type("name=goods_name", name);
		webtest.type("name=start_goods_id", start_id);
		webtest.type("name=end_goods_id", end_id);
		webtest.type("name=goods_item", id);
		webtest.click("xpath=//button[contains(@onclick,'edit_type')]");
		
		boolean flag=webtest.isDisplayed("class=icon-arrow-left");
		assertTrue(flag);
	}

	//47,Ԥ����Ʒ
	@Test
	public void test47() {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'������Ʒ')]");
		webtest.click("xpath=//a[contains(text(),'��ƷԤ��')]");
		
	}

	//48,����ֵ����
	@Test(dataProvider = "testData10")
	public void test48(String input1,String input2) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(@href,'/admin/goods/attribute')]");
		webtest.click("xpath=//a[contains(text(),'����ֵ����')]");
		webtest.typeAndClear("id=value_name", input1);
		webtest.typeAndClear("id=value_sort",input2);
		webtest.click("xpath=//button[contains(text(),'��������ֵ')]");
		
	}	
	
	//49,��Ʒ��������
	@Test
	public void test49() {
		boolean flag=false;
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("id=goods_index");
		webtest.click("xpath=//button[contains(text(),'���������Ʒ����')]");
		webtest.getAlert();
		if(webtest.getAlertTest() != null) {
			flag = true;
		}	
		webtest.alertAccept();
		webtest.click("xpath=//button[contains(text(),'������������')]");
		
		assertTrue(flag);
	}
	
	//50,��Ʒ��ѯ�ظ�
	@Test(dataProvider = "testData13")
	public void test50(String content) {
		admin();
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��Ʒ��ѯ')]");
		webtest.click("xpath=//a[contains(text(),'��ѯ�ظ�')]");	
		webtest.type("id=reply_ask_content", content);
		webtest.click("xpath=//button[contains(text(),'�ظ���Ʒ��ѯ')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//*[contains(text(),'�ظ����ݣ�')]");
		assertTrue(flag);
	}
	
}
