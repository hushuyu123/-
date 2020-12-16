package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Admin_CustomerManagement extends BaseTest {
	/*
	 * 
	 * 客户管理模块---廖建兰
	 */
	@DataProvider(name = "testData1")
	public Object[][] words1() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet1");
	}

	@DataProvider(name = "testData2")
	public Object[][] words2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet2");
	}

	@DataProvider(name = "testData3")
	public Object[][] words3() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet3");
	}

	@DataProvider(name = "testData4")
	public Object[][] words4() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet4");
	}

	@DataProvider(name = "testData5")
	public Object[][] words5() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet5");
	}

	@DataProvider(name = "testData6")
	public Object[][] words6() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet6");
	}
	@DataProvider(name = "testData7")
	public Object[][] words7() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet7");
	}
	@DataProvider(name = "testData8")
	public Object[][] words8() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet8");
	}
	@DataProvider(name = "testData9")
	public Object[][] words9() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet9");
	}
	@DataProvider(name = "testData10")
	public Object[][] words10() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet10");
	}
	@DataProvider(name = "testData11")
	public Object[][] words11() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData.xls", "Sheet11");
	}


	// 实现管理客户中的添加新顾客
	@Test(dataProvider = "testData1")
	public void test1(String add1, String add2, String add3, String add4) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新客户')]");
		webtest.selectByValue("name=group_id", "1");
		webtest.type("name=user_name", add1);
		webtest.type("name=user_email", add2);
		webtest.type("name=user_password", add3);
		webtest.type("name=user_password_con", add4);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}
	//实现对添加了的客户进行搜索搜索通过客户姓名
	@Test(dataProvider = "testData2")
	public void test1_asearchByname(String add1) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.type("name=user_name",add1);
		webtest.click("xpath=//button[contains(text(),'搜索')]");
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);		
	}
	@Test(dataProvider = "testData3")
	//实现实现对添加了的客户进行搜索搜索通过电子邮件
	public void test1_asearchByemail(String add1) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.type("name=user_email",add1);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);	
		
	}
	@Test(dataProvider = "testData4")
	//实现对客户进行编辑
	public void test1_edit1(String add1, String add2, String add3, String add4,String add5,String add6) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.type("name=user_password", add1);
		webtest.type("name=user_password_con", add2);
		webtest.click("xpath=//a[@href='#user_b']");
		webtest.click("xpath=//button[contains(text(),'添加地址')]");
		webtest.type("name=true_name", add3);
		webtest.selectByValue("id=show_address_area", "35");
		webtest.type("name=address", add4);
		webtest.type("name=zip_code", add5);
		webtest.type("name=mod_phone",add6);
		webtest.click("xpath=//button[contains(text(),'修改')]");
		webtest.click("xpath=//button[contains(text(),'保存客户信息')]");
	}
	@Test(dataProvider = "testData5")
	//对客户进行余额调整
	public void test1_edit2(String add1, String add2) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[contains(text(),'余额调整')]");
		webtest.type("name=money_change_num", add1);
		webtest.type("name=money_pay_info", add2);
		webtest.click("xpath=//button[contains(text(),'关闭')]");
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}
	//对客户进行积分调整(有点bug，比如通过xpath路径）
	@Test(dataProvider = "testData6")
	public void test1_edit3(String add1, String add2,String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[contains(text(),'积分调整')]");
		webtest.type("name=change_user_integral_num", add1);
		webtest.type("name=change_integral_type_2_num", add2);
		webtest.type("name=integral_log_info", add3);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@aria-hidden='true')]");
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}
	//实现对余额调整进行提前调整
	@Test(dataProvider = "testData5")
	public void test1_edit4(String add1, String add2) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[contains(text(),'余额调整')]");
		webtest.type("name=money_change_num", add1);
		webtest.type("name=money_pay_info", add2);
		webtest.click("xpath=//button[contains(text(),'提前调整')]");
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}
	//实现对积分调整进行提前调整
	@Test(dataProvider = "testData6")
	public void test1_edit5(String add1, String add2,String add3) throws InterruptedException{
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[contains(text(),'积分调整')]");
		webtest.type("name=change_user_integral_num", add1);
		webtest.type("name=change_integral_type_2_num", add2);
		webtest.type("name=integral_log_info", add3);
		Thread.sleep(3000);
		webtest.click("xpath=//button[contains(text(),'提前调整')]");
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}
	
		
	


	// 实现客户扩展信息中的添加扩展信息--实现单选按钮--状态开启，实现是否显示在前台注册页面
	@Test(dataProvider = "testData7")
	public void test2_addradio1(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "radio");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'开启')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}

	// 实现客户扩展信息中的编辑扩展信息demo2--实现单选表单--状态关闭，并允许字段为空，实现是否显示在前台注册页面
	@Test
	public void test2_addradio2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	@Test
	//实现对添加的demo2扩展信息进行删除--实现单选按钮
	public void test2_deleteradio2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
	}
    //实现客户扩展信息中的编辑扩展信息--实现多选表单--状态开启，实现是否显示在前台注册页面
	@Test(dataProvider = "testData8")
	public void test3_addcheckbox1(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "checkbox");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'开启')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	//实现客户扩展信息中的编辑扩展信息--实现多选表单--状态关闭，并允许字段为空，实现是否显示在前台注册页面
	@Test
	public void test3_addcheckbox2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	//实现客户扩展信息中的删除扩展信息
	@Test
	public void test3_addcheckbox3() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	
	//实现客户扩展信息中的编辑扩展信息--实现下拉表单--状态开启，实现是否显示在前台注册页面
	@Test(dataProvider = "testData9")
	public void test4_addselect1(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		Thread.sleep(3000);
		webtest.selectByValue("name=field_type", "select");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//label[contains(text(),'开启')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	//实现多选表单--状态关闭，并允许字段为空，实现是否显示在前台注册页面
	@Test
	public void test4_addselect2() {	
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	@Test
	//实现删除
	public void test4_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
   //实现客户扩展信息中的编辑扩展信息--实现单行文本表单--状态开启，实现是否显示在前台注册页面
	@Test(dataProvider = "testData10")
	public void test5_addtext1(String add1, String add2) throws InterruptedException {
		System.out.println(add1);
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "text");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'开启')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);

	}
	//实现客户扩展信息中的编辑扩展信息--实现单行文本表单--状态关闭，并允许字段为空，实现是否显示在前台注册页面
	@Test 
	public void test5_addtext2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	//实现删除
	@Test
	public void test5_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	
	//实现客户扩展信息中的编辑扩展信息--实现多行文本表单--状态开启，实现是否显示在前台注册页面
	@Test(dataProvider = "testData11")
	public void test6_addtextarea1(String add1, String add2) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'添加扩展信息')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "textarea");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加扩展信息");
		assertEquals(flag, true);
	}
	//实现客户扩展信息中的编辑扩展信息--状态关闭，并允许字段为空，实现是否显示在前台注册页面
	@Test
	public void test6_addtextarea2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'关闭')]");
		webtest.click("xpath=//button[@type='submit']");

	}
	//实现删除
	@Test
	public void test6_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'客户扩展信息')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();

	}
	
	
	
	/**
	 * 实现添加客户组
	 */
	@DataProvider(name = "AddData1")
	public Object[][] addData() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData1.xls", "Sheet1");
	}

	@Test(dataProvider = "AddData1")
	public void test7(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[contains(text(),'添加客户组')]");
		webtest.type("name=user_group_name", add1);
		webtest.type("name=integral_num_start", add2);
		webtest.type("name=integral_num_end", add3);
		webtest.click("name=integral_num_state");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("编辑");
		assertEquals(flag, true);
	}
	@Test
	//对客户组进行编辑--启用客户组
	public void test7_edit() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.click("name=integral_num_state");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag=webtest.isTextPresent("编辑");
		assertEquals(flag, true);
	}
	//对客户组进行删除
	@Test
	public void test7_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户组')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		boolean flag=webtest.isTextPresent("编辑");
		assertEquals(flag, true);
	}
	
	//删除客户余额中的充值记录
	public void test8_detete1() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'客户余额')]");
		webtest.click("xpath=//a[contains(text(),'充值记录')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
	}
	
	/**
	 * 实现添加规则
	 */
	@DataProvider(name = "AddData2")
	public Object[][] addData2() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData1.xls", "Sheet2");
	}

	@Test(dataProvider = "AddData2")
	public void test9_addruleClose(String add1, String add2, String add3, String add4, String add5, String add6)
			throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'添加新规则')]");
		webtest.type("name=integral_rule_name", add1);
		webtest.type("name=integral_rule_info", add2);
		webtest.type("name=integral_rule_start_time", add3);
		webtest.type("name=integral_rule_end_time", add4);
		webtest.selectByValue("name=integral_rule_state", "1");
		webtest.click("xpath=//a[@href='#integral_rule_c']");
		webtest.type("name=shopping_amount", add5);
		webtest.type("name=integral_num", add6);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);
	}
    @Test
	//对规则进行编辑--实现将其关闭
	public void test9_edit() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		webtest.click("xpath=//a[contains(text(),'编辑')]");
		webtest.selectByValue("name=integral_rule_state", "2");
		webtest.click("xpath=//button[contains(text(),'保存积分规则')]");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("编辑");
		assertEquals(flag, true);	
	}
    @Test
    //对规则进行删除
    public void test9_edit_delete() throws InterruptedException {
    	testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'管理积分')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'积分规则')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("添加新规则");
		assertEquals(flag, true);	
    }

    
	//实现对客户的删除
	@Test
	public void ztest10() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'客户管理')]");
		webtest.click("xpath=//a[contains(text(),'管理客户')]");
		webtest.click("xpath=//a[contains(text(),'删除')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("添加新客户");
		assertEquals(flag, true);
	}
	

}
