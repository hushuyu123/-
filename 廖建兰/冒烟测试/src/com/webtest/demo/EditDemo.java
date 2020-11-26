package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class EditDemo extends BaseTest {
	/**
	 * 对之前板块实现添加后又进行编辑
	 */
	@DataProvider(name = "Data")
	public Object[][] word() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("D:\\tool\\AddData1.xls", "Sheet5");
	}

	 @Test(dataProvider = "Data")
	public void test_editaddcustom(String add1, String add2, String add3, String add4, String add5, String add6,
			String add7) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[@href='/admin/user/edit/1/other/1']");
		webtest.type("name=user_password", add1);
		webtest.type("name=user_password_con", add2);
		webtest.type("name=user_phone", add3);
		webtest.click("xpath=//a[@href='#user_b']");
		webtest.click("xpath=//button[contains(text(),'添加地址')]");
		webtest.type("name=true_name", add4);
		webtest.selectByValue("id=show_address_area", "35");
		webtest.type("name=address", add5);
		webtest.type("name=zip_code", add6);
		webtest.type("name=mod_phone", add7);
		webtest.click("xpath=//button[contains(text(),'修改')]");
		webtest.click("xpath=//button[contains(text(),'保存客户信息')]");
	}

}
