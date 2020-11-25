package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_Edit extends BaseTest{

	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "12345678");
		webtest.click("xpath=//button[contains(text(),'��̨��¼')]");
	}
	
	@DataProvider(name="testData6")
    public Object[][] data3() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","edit1");
    }
	@DataProvider(name="testData15")
    public Object[][] data12() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","test44");
    }
	@DataProvider(name="testData10")
    public Object[][] data7() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","test26");
    }
	@DataProvider(name="testData11")
    public Object[][] data8() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","test29");
    }
	@DataProvider(name="testData12")
    public Object[][] data9() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","test32");
    }
	@DataProvider(name="testData13")
    public Object[][] data10() throws IOException{	    	
		return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","conten");
	}
	    	
	//35���༭��ǩ��
	@Test
	public void test35() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=��Ʒ��ǩ����");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.mouseToElementandClick("xpath=//a[contains(text(),'���ڱ�ǩ')]");
		webtest.click("xpath=//button[contains(@onclick,'tag_group_save_type')]");	
		
	}
	//36,�༭���Է���
	@Test(dataProvider = "testData10")
	public void test36(String attribute_group_name,String attribute_group_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("link=���Է���");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.typeAndClear("name=attribute_group_name", attribute_group_name);
		webtest.typeAndClear("name=attribute_group_sort",attribute_group_sort);
		webtest.click("xpath=//button[contains(text(),'������������Ϣ')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'���������')]");
		assertTrue(flag);
	}
	
	//37,�༭��ͨ��Ʒ��ǩ
	@Test(dataProvider = "testData15")
	public void test37(String goods) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=��ͨ��Ʒ��ǩ");
		webtest.click("xpath=//a[contains(text(),'�༭')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.typeAndClear("id=tag_goods_keyword",goods);
		webtest.click("xpath=//button[contains(text(),'�����ӱ�ǩ��Ʒ')]");
		webtest.click("xpath=//button[contains(text(),'�����ǩ��Ϣ')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�����ͨ��Ʒ��ǩ')]");
		assertTrue(flag);
		
	}
	//38,�༭��Ʒ��ǩ����Ʒ
	@Test(dataProvider = "testData15")
	public void test38(String tag_goods_keyword) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=�ض���Ʒ��ǩ");
		webtest.click("xpath=//a[contains(text(),'�༭')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.typeAndClear("id=tag_goods_keyword", tag_goods_keyword);
		webtest.click("xpath=//button[contains(text(),'�����ӱ�ǩ��Ʒ')]");
		webtest.click("xpath=//button[contains(text(),'�����ǩ��Ϣ')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/tag/addSpecTag')]");
		assertTrue(flag);
	}
	
	//39,�༭��ͨ��Ʒ��ǩ
	@Test
	public void test39() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ��ǩ')]");
		webtest.click("link=��ͨ��Ʒ��ǩ");
		webtest.click("xpath=//a[contains(text(),'�༭')]");	
		webtest.click("xpath=//a[contains(@href,'tag_b')]");
		webtest.click("xpath=//a[contains(text(),'ɾ����ǩ')]");
		webtest.getAlert();
		webtest.alertAccept();
		Thread.sleep(3000);
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�����ͨ��Ʒ��ǩ')]");
		assertTrue(flag);
		
	}
	
	//40,�༭��ƷƷ��
	@Test(dataProvider = "testData12")
	public void test40(String brand_title_extend,String brand_keywords,String brand_description){
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��ƷƷ��')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");	
		webtest.click("xpath=//a[contains(text(),'���������Ż�')]");	
		webtest.type("id=brand_title_extend", brand_title_extend);
		webtest.type("id=brand_keywords", brand_keywords);
		webtest.type("id=brand_description", brand_description);
		webtest.click("xpath=(//button[contains(text(),'����Ʒ��')])[2]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/brand/add')]");
		assertTrue(flag);
	}
	
	
	//41,�༭����
	@Test(dataProvider = "testData11")
	public void test41(String attribute_group_id,String attribute_name,String frontside_sort) throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("link=����");
		webtest.click("xpath=//a[contains(text(),'�༭')]");	
		int Num=Integer.parseInt(attribute_group_id);
		webtest.selectByIndex("id=attribute_group_id", Num);
		webtest.typeAndClear("name=attribute_name", attribute_name);
		webtest.typeAndClear("name=frontside_sort",frontside_sort);
		webtest.click("xpath=//button[contains(text(),'����������Ϣ')]");	
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'/admin/goods/attribute/add')]");
		assertTrue(flag);
		
	}
	
	//42���༭��Ʒ��Ϣ
	@Test(dataProvider = "testData6")
	public void test42(String name,String item) {
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'������Ʒ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.typeAndClear("name=goods_name", name);
		webtest.typeAndClear("name=goods_item", item);
		webtest.click("xpath=(//button[contains(@onclick,'goods_save_type')])[2]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(@href,'add')]");
		assertTrue(flag);
	}
	
	//43,�༭�鿴�ظ���Ʒ����
	@Test(dataProvider = "testData13")
	public void test43(String content) {
		admin();
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'��Ʒ����')]");
		webtest.click("xpath=//a[contains(text(),'�༭�鿴')]");	
		webtest.click("xpath=//a[contains(text(),'���ۻظ�')]");	
		webtest.type("id=reply_comment_content", content);
		webtest.click("xpath=//button[contains(text(),'�ظ���Ʒ����')]");
		
		boolean flag=webtest.isDisplayed("xpath=//*[contains(text(),'�ظ����ݣ�')]");
		assertTrue(flag);
	}
	
}
