package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;



public class Test_Login extends BaseTest{

	public void loginout() {
		webtest.open("http://localhost:86/user/login");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'�˳�')]");
		}
	}
	@DataProvider(name="testData2" )
    public Object[][] data() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","login");
    }
	
	//��������6,��¼�ɹ�
	//��������7,����ʱ�����������
	//��������8����¼ʱ���������֤��
    @Test(dataProvider = "testData2",priority = 1)
	public void testLogin(String name,String pwd,String code) throws InterruptedException {
    	webtest.open("http://localhost:86/user/login");
		webtest.type("name=user_name", name);
		webtest.type("name=user_password", pwd);
		webtest.type("name=captcha_code", code);
		webtest.click("xpath=//button[contains(text(),'��Ա��¼')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(flag);
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'�˳�')]");
		}
	}
    
    
    @DataProvider(name="testData3")
    public Object[][] data2() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","findpwd");
    }
//	 9���һ�����ɹ�
//  10,�һ�����ʱ��ʹ�ô����û���
//  11,�һ�����ʱ��ʹ�ô�������
    @Test(dataProvider = "testData3",priority = 2)
	public void testFindPwd(String name,String email,String code) throws InterruptedException {
    	loginout();
   		webtest.click("xpath=//a[contains(text(),'��Ա��������')]");
   		webtest.type("name=user_name", name);
   		webtest.type("name=user_email", email);
   		webtest.type("name=captcha_code", code);
   		webtest.click("xpath=//button[contains(text(),'�ύ�һ�����')]");
   		
   		boolean flag=webtest.isDisplayed("xpath=//div//h4[contains(text(),'�Ѿ�����������')]");
		assertTrue(flag);
	}
    
    @Test
	public void test13() throws InterruptedException {
    	webtest.open("http://localhost:86/admin/home");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "12345678");
		webtest.click("xpath=//button[contains(text(),'��̨��¼')]");
		
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�ϵͳ')]");
		assertTrue(flag);
		
	}
    
}