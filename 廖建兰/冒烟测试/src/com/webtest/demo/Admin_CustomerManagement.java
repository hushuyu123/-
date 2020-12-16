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
	 * �ͻ�����ģ��---�ν���
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


	// ʵ�ֹ���ͻ��е�����¹˿�
	@Test(dataProvider = "testData1")
	public void test1(String add1, String add2, String add3, String add4) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����¿ͻ�')]");
		webtest.selectByValue("name=group_id", "1");
		webtest.type("name=user_name", add1);
		webtest.type("name=user_email", add2);
		webtest.type("name=user_password", add3);
		webtest.type("name=user_password_con", add4);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����¿ͻ�");
		assertEquals(flag, true);
	}
	//ʵ�ֶ�����˵Ŀͻ�������������ͨ���ͻ�����
	@Test(dataProvider = "testData2")
	public void test1_asearchByname(String add1) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.type("name=user_name",add1);
		webtest.click("xpath=//button[contains(text(),'����')]");
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);		
	}
	@Test(dataProvider = "testData3")
	//ʵ��ʵ�ֶ�����˵Ŀͻ�������������ͨ�������ʼ�
	public void test1_asearchByemail(String add1) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.type("name=user_email",add1);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);	
		
	}
	@Test(dataProvider = "testData4")
	//ʵ�ֶԿͻ����б༭
	public void test1_edit1(String add1, String add2, String add3, String add4,String add5,String add6) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.type("name=user_password", add1);
		webtest.type("name=user_password_con", add2);
		webtest.click("xpath=//a[@href='#user_b']");
		webtest.click("xpath=//button[contains(text(),'��ӵ�ַ')]");
		webtest.type("name=true_name", add3);
		webtest.selectByValue("id=show_address_area", "35");
		webtest.type("name=address", add4);
		webtest.type("name=zip_code", add5);
		webtest.type("name=mod_phone",add6);
		webtest.click("xpath=//button[contains(text(),'�޸�')]");
		webtest.click("xpath=//button[contains(text(),'����ͻ���Ϣ')]");
	}
	@Test(dataProvider = "testData5")
	//�Կͻ�����������
	public void test1_edit2(String add1, String add2) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.click("xpath=//a[contains(text(),'������')]");
		webtest.type("name=money_change_num", add1);
		webtest.type("name=money_pay_info", add2);
		webtest.click("xpath=//button[contains(text(),'�ر�')]");
		boolean flag = webtest.isTextPresent("����¿ͻ�");
		assertEquals(flag, true);
	}
	//�Կͻ����л��ֵ���(�е�bug������ͨ��xpath·����
	@Test(dataProvider = "testData6")
	public void test1_edit3(String add1, String add2,String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.click("xpath=//a[contains(text(),'���ֵ���')]");
		webtest.type("name=change_user_integral_num", add1);
		webtest.type("name=change_integral_type_2_num", add2);
		webtest.type("name=integral_log_info", add3);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@aria-hidden='true')]");
		boolean flag = webtest.isTextPresent("����¿ͻ�");
		assertEquals(flag, true);
	}
	//ʵ�ֶ�������������ǰ����
	@Test(dataProvider = "testData5")
	public void test1_edit4(String add1, String add2) {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.click("xpath=//a[contains(text(),'������')]");
		webtest.type("name=money_change_num", add1);
		webtest.type("name=money_pay_info", add2);
		webtest.click("xpath=//button[contains(text(),'��ǰ����')]");
		boolean flag = webtest.isTextPresent("����¿ͻ�");
		assertEquals(flag, true);
	}
	//ʵ�ֶԻ��ֵ���������ǰ����
	@Test(dataProvider = "testData6")
	public void test1_edit5(String add1, String add2,String add3) throws InterruptedException{
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.click("xpath=//a[contains(text(),'���ֵ���')]");
		webtest.type("name=change_user_integral_num", add1);
		webtest.type("name=change_integral_type_2_num", add2);
		webtest.type("name=integral_log_info", add3);
		Thread.sleep(3000);
		webtest.click("xpath=//button[contains(text(),'��ǰ����')]");
		boolean flag = webtest.isTextPresent("����¿ͻ�");
		assertEquals(flag, true);
	}
	
		
	


	// ʵ�ֿͻ���չ��Ϣ�е������չ��Ϣ--ʵ�ֵ�ѡ��ť--״̬������ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test(dataProvider = "testData7")
	public void test2_addradio1(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�����չ��Ϣ')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "radio");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'����')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}

	// ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣdemo2--ʵ�ֵ�ѡ��--״̬�رգ��������ֶ�Ϊ�գ�ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test
	public void test2_addradio2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'�ر�')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	@Test
	//ʵ�ֶ���ӵ�demo2��չ��Ϣ����ɾ��--ʵ�ֵ�ѡ��ť
	public void test2_deleteradio2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
	}
    //ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--ʵ�ֶ�ѡ��--״̬������ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test(dataProvider = "testData8")
	public void test3_addcheckbox1(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�����չ��Ϣ')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "checkbox");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'����')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	//ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--ʵ�ֶ�ѡ��--״̬�رգ��������ֶ�Ϊ�գ�ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test
	public void test3_addcheckbox2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'�ر�')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	//ʵ�ֿͻ���չ��Ϣ�е�ɾ����չ��Ϣ
	@Test
	public void test3_addcheckbox3() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	
	//ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--ʵ��������--״̬������ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test(dataProvider = "testData9")
	public void test4_addselect1(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�����չ��Ϣ')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		Thread.sleep(3000);
		webtest.selectByValue("name=field_type", "select");
		webtest.type("name=field_radio_checkbox_select", add3);
		webtest.click("xpath=//label[contains(text(),'����')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	//ʵ�ֶ�ѡ��--״̬�رգ��������ֶ�Ϊ�գ�ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test
	public void test4_addselect2() {	
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'�ر�')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	@Test
	//ʵ��ɾ��
	public void test4_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
   //ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--ʵ�ֵ����ı���--״̬������ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test(dataProvider = "testData10")
	public void test5_addtext1(String add1, String add2) throws InterruptedException {
		System.out.println(add1);
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�����չ��Ϣ')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "text");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'����')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);

	}
	//ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--ʵ�ֵ����ı���--״̬�رգ��������ֶ�Ϊ�գ�ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test 
	public void test5_addtext2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'�ر�')]");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	//ʵ��ɾ��
	@Test
	public void test5_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	
	//ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--ʵ�ֶ����ı���--״̬������ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test(dataProvider = "testData11")
	public void test6_addtextarea1(String add1, String add2) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�����չ��Ϣ')]");
		webtest.type("name=field_name", add1);
		webtest.type("name=field_title", add2);
		webtest.selectByValue("name=field_type", "textarea");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//label[contains(text(),'�ر�')]");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�����չ��Ϣ");
		assertEquals(flag, true);
	}
	//ʵ�ֿͻ���չ��Ϣ�еı༭��չ��Ϣ--״̬�رգ��������ֶ�Ϊ�գ�ʵ���Ƿ���ʾ��ǰ̨ע��ҳ��
	@Test
	public void test6_addtextarea2() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//label[contains(text(),'�ر�')]");
		webtest.click("xpath=//button[@type='submit']");

	}
	//ʵ��ɾ��
	@Test
	public void test6_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'�ͻ���չ��Ϣ')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();

	}
	
	
	
	/**
	 * ʵ����ӿͻ���
	 */
	@DataProvider(name = "AddData1")
	public Object[][] addData() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel.getTestDataByExcel("data\\AddData1.xls", "Sheet1");
	}

	@Test(dataProvider = "AddData1")
	public void test7(String add1, String add2, String add3) throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ���')]");
		webtest.click("xpath=//a[contains(text(),'��ӿͻ���')]");
		webtest.type("name=user_group_name", add1);
		webtest.type("name=integral_num_start", add2);
		webtest.type("name=integral_num_end", add3);
		webtest.click("name=integral_num_state");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		boolean flag=webtest.isTextPresent("�༭");
		assertEquals(flag, true);
	}
	@Test
	//�Կͻ�����б༭--���ÿͻ���
	public void test7_edit() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ���')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.click("name=integral_num_state");
		webtest.click("xpath=//button[@type='submit']");
		boolean flag=webtest.isTextPresent("�༭");
		assertEquals(flag, true);
	}
	//�Կͻ������ɾ��
	@Test
	public void test7_delete() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ���')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		boolean flag=webtest.isTextPresent("�༭");
		assertEquals(flag, true);
	}
	
	//ɾ���ͻ�����еĳ�ֵ��¼
	public void test8_detete1() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�ͻ����')]");
		webtest.click("xpath=//a[contains(text(),'��ֵ��¼')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
	}
	
	/**
	 * ʵ����ӹ���
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
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�������')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'���ֹ���')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'����¹���')]");
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
		boolean flag = webtest.isTextPresent("����¹���");
		assertEquals(flag, true);
	}
    @Test
	//�Թ�����б༭--ʵ�ֽ���ر�
	public void test9_edit() throws InterruptedException {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�������')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'���ֹ���')]");
		webtest.click("xpath=//a[contains(text(),'�༭')]");
		webtest.selectByValue("name=integral_rule_state", "2");
		webtest.click("xpath=//button[contains(text(),'������ֹ���')]");
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("�༭");
		assertEquals(flag, true);	
	}
    @Test
    //�Թ������ɾ��
    public void test9_edit_delete() throws InterruptedException {
    	testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'�������')]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[contains(text(),'���ֹ���')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		Thread.sleep(3000);
		boolean flag = webtest.isTextPresent("����¹���");
		assertEquals(flag, true);	
    }

    
	//ʵ�ֶԿͻ���ɾ��
	@Test
	public void ztest10() {
		testLogin();
		webtest.click("xpath=//a[contains(text(),'�ͻ�����')]");
		webtest.click("xpath=//a[contains(text(),'����ͻ�')]");
		webtest.click("xpath=//a[contains(text(),'ɾ��')]");
		webtest.alertAccept();
		boolean flag = webtest.isTextPresent("����¿ͻ�");
		assertEquals(flag, true);
	}
	

}
