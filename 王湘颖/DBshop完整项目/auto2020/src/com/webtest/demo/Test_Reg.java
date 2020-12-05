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


public class Test_Reg extends BaseTest{
	
	public void loginout() {
		webtest.open("http://localhost:86/user/register");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'�˳�')]");
		}
	}
	@DataProvider(name="testData1")
    public Object[][] data() throws IOException{
    	return ExcelDataProvider.getTestDataByExcel("E:\\ATestObject\\data\\da.xlsx","reg");
    }
	
//	1��ע��ɹ�
//	2,ע�����볬���涨λ��
//	3��ע��ʱʹ���Ѿ����ڵĻ�Ա��
//	4,ע��ʱ���������֤��
	@Test(dataProvider = "testData1")
	public void test_reg(String name,String pwd,String cpwd,String email,String code) throws InterruptedException {
		loginout();
		webtest.type("name=user_name", name);
		webtest.type("name=user_password", pwd);
		webtest.type("name=user_com_passwd", cpwd);
		webtest.type("name=user_email", email);
		webtest.type("name=captcha_code", code);
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(flag);
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'�˳�')]");
		}
	}
	
//	5,����ѡ��ע��Э�顱
	@Test
	public void test5_reg(){
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "25673989@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(flag);
	}
}