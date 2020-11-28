package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
public class Admin_SystemManagement_StockControl extends BaseTest{
	@BeforeMethod
	public void adminLogin() throws IOException {

		webtest.open("http://localhost:86/admin");
		webtest.type("id=user_name", "admin");
		webtest.type("id=user_passwd", "123456");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	public void messageReminderSetting() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'消息提醒设置')]");
		Thread.sleep(2000);
	}
	
	public void onlineService() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'在线客服设置')]");
	}
	public void administrator() throws InterruptedException, IOException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("link=管理员设置");
		Thread.sleep(3000);
	}
	public void areaSetting() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'地区管理')]");
		
	}
	public void stateSetting() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'状态设置')]");
	}
	
	@Test(priority = 1)  //26.消息提醒设置的邮件管理设置中的基本信息的管理员接收邮箱1设为空
	public void demo26() throws IOException, InterruptedException {
		messageReminderSetting();
		webtest.click("link=电子邮件提醒设置");
		webtest.typeAndClear("id=admin_receive_email", "");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("管理员接收邮件不能为空"));
	}
	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'状态设置')]");
	}
	
	@Test(priority = 1)  //27.消息提醒设置的邮件管理设置中的基本信息的管理员接收邮箱1设为“123456789”
	public void demo27() throws IOException, InterruptedException {
		messageReminderSetting();
		webtest.click("link=电子邮件提醒设置");
		webtest.typeAndClear("xpath=//label[contains(text(),'管理员接收邮箱1')]/../div/input", getExcel1(17, 1));
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("请正确填写邮件地址"));
	}
	
	
	@Test(priority = 1)  //28.消息提醒设置的邮件管理设置中的提交订单的消息内容中将‘网站名称’按钮点击10次
	public void demo28() throws IOException, InterruptedException {
		
		messageReminderSetting();
		webtest.click("link=电子邮件提醒设置");
		webtest.click("xpath=//a[contains(text(),'提交订单')]");
		for(int i=0;i<10;i++) {
			webtest.click("xpath=//a[contains(text(),'网站名称')]");
		}
		webtest.click("xpath=//button[@type='submit']");
	
	}
	
	
	@Test(priority = 1)  //29.消息提醒设置的邮件管理设置中的提交订单的消息内容中将‘网站名称’按钮点击10次保存后再刷新页面
	public void demo29() throws IOException, InterruptedException {
	
		messageReminderSetting();
		webtest.click("link=电子邮件提醒设置");
		webtest.click("xpath=//a[contains(text(),'提交订单')]");
		webtest.typeAndClear("id=submit_order", getExcel1(18, 1));
		for(int i=0;i<10;i++) {
			webtest.click("xpath=//button[contains(text(),'网站名称')]");
		}
		String oldString = webtest.getText("id=submit_order");
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//a[contains(text(),'刷新')]");
		webtest.click("xpath=//a[contains(text(),'提交订单')]");
		String newString = webtest.getText("id=submit_order");
		assertEquals(oldString, newString);
		
	}
	
	@Test(priority = 2)  //25.消息提醒设置的手机短信提醒设置中，将管理员手机号填写为“11111111”
	public void demo25() throws IOException, InterruptedException {
		messageReminderSetting();
		webtest.click("link=手机短信提醒设置");
		webtest.typeAndClear("id=admin_phone", getExcel1(16, 1));
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("手机号填写不正确"));
	}
	
	@Test  //30.地区管理中删除北京市
	public void demo30() throws IOException, InterruptedException {
		areaSetting();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a[2]");
		webtest.alertAccept();
		assertTrue(webtest.isTextPresent("地区删除失败，该地区还有下级地区存在"));
	}
	
	@Test //31.地区管理中将北京市的地区排序改为‘2’
	public void demo31() throws IOException, InterruptedException {
		areaSetting();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/span");
		webtest.typeAndClear("id=edit_region_sort1",getExcel1(19, 1));
		webtest.click("xpath=//button[contains(text(),'保存')]");
	}
	
	
	@Test //32.在西城区的下级地区中添加地区
	public void demo32() throws IOException, InterruptedException {
		areaSetting();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", getExcel1(20, 1));
		webtest.click("xpath=//button[contains(text(),'保存')]");
	}
	
	
	@Test //33.在西城区的下级地区中添加地区，其中地区名称为空
	public void demo33() throws IOException, InterruptedException {
		areaSetting();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", "");
		webtest.click("xpath=//button[contains(text(),'保存')]");
		assertTrue(webtest.isTextPresent("请输入地区名称"));
	}
	
	
	@Test //34.将西城区下添加的地区删除
	public void demo34() throws IOException, InterruptedException {
		areaSetting();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("id=select_checkbox_state_1");
		webtest.selectByVisibleText("id=allEdit","删除");
		webtest.click("xpath=//button[contains(text(),'提交操作')]");
		webtest.alertAccept();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("提交操作"));
	}
	
	
	@Test //35.在西城区的下级地区中添加地区，其中地区排序为空
	public void demo35() throws IOException, InterruptedException {
		adminLogin();
		areaSetting();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", getExcel1(21,1));
		webtest.typeAndClear("id=region_sort", "");
		
		
		webtest.click("xpath=//button[contains(text(),'保存')]");
		String sort = webtest.getText("xpath=//td[contains(text(),'A县')]/../td[4]");
		System.out.println("排序为空保存后地区排序为："+sort);
		assertEquals("255", sort);
	}
	
	@Test //36.库存状态管理中把有货的库存状态排序填写为‘aaaa’
	public void demo36() throws IOException, InterruptedException {
		stateSetting();
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=state_sort", getExcel1(22, 1));
		webtest.click("xpath=//button[@type='submit']");
		String new_sort=webtest.getText("xpath=//td[contains(text(),'有货状态')]/../td[4]");
		assertEquals("aaaa",new_sort);
		
	}
	
	@Test //37.库存状态管理中把有货的库存状态名称填写为‘123’
	public void demo37() throws IOException, InterruptedException {
		stateSetting();
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=stock_state_name", getExcel1(23, 1));
		webtest.click("xpath=//button[@type='submit']");
		String new_name=webtest.getText("xpath=//td[contains(text(),'有货状态')]/../td[2]");
		assertEquals("123  (默认)",new_name);
		
	}
	
	
	@Test //38.库存状态管理中把有货的库存状态名称填写为空
	public void demo38() throws IOException, InterruptedException {
		stateSetting();
		webtest.mouseToElement("xpath=//a[contains(text(),'状态设置')]");
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=stock_state_name", "");
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("库存状态名称不能为空"));
		
	}
	
	@Test //39.管理员设置中的管理员的基本信息，将登录密码填入‘123’
	public void demo39() throws IOException, InterruptedException {

		administrator();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", getExcel1(24, 1));
		webtest.typeAndClear("id=admin_password_con", getExcel1(24, 2));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("至少输入6位密码"));
	}
	


	@Test //40.管理员设置中的管理员的基本信息，将登录密码填入21个1
	public void demo40() throws IOException, InterruptedException {

		administrator();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", getExcel1(25, 1));
		webtest.typeAndClear("id=admin_password_con", getExcel1(25, 2));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("密码最长为20位"));
	}
	
	@Test  //41.管理员设置中的管理员的基本信息，将登录密码和确认密码输入不一致
	public void demo41() throws IOException, InterruptedException {
		administrator();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'admin')]/../td[6]/a");
		webtest.typeAndClear("id=admin_password", getExcel1(26, 1));
		webtest.typeAndClear("id=admin_password_con", getExcel1(26, 2));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("两次输入的密码不一致"));
	}
	
	
	@Test   //42.管理员设置中的管理员组的权限设置的全部权限取消
	public void demo42() throws IOException, InterruptedException {
		administrator();
		webtest.click("link=管理员组");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'管理员')]/../td[3]/a");
		webtest.click("xpath=//a[contains(text(),'权限设置')]");
		webtest.click("name=purview[purviewAll]");
		assertEquals(webtest.isChecked("name=purview[purviewAll]"), false);
	}
	
	@Test   //43.点击管理员设置中的管理员下的管理员组的‘管理员’链接
	public void demo43() throws IOException, InterruptedException {
		administrator();
		webtest.click("link=管理员");
		Thread.sleep(2000);
		webtest.click("link=管理员");
		assertTrue(webtest.isTextPresent("编辑管理员组"));
	}
	
	@Test  //44.在线客服设置中添加客服
	public void demo44() throws IOException, InterruptedException {

		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", getExcel1(27, 1));
		webtest.selectByIndex("id=online_group_id", 1);
		webtest.selectByIndex("id=online_type", 2);
		webtest.type("id=online_account",  getExcel1(27, 2));
		webtest.typeAndClear("id=online_sort",  getExcel1(27, 3));
		webtest.click("xpath=//button[@type='submit']");
		
	}
	
	@Test  //45.在线客服设置的在线客服成员中添加在线客服选择通讯工具‘腾讯QQ’
	public void demo45() throws IOException, InterruptedException {
		
		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", getExcel1(28, 1));
		webtest.selectByIndex("id=online_group_id", 1);
		webtest.selectByVisibleText("id=online_type", "腾讯QQ");
		webtest.type("id=online_account",  getExcel1(28, 2));
		webtest.typeAndClear("id=online_sort",  getExcel1(28, 3));
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		
		assertTrue(webtest.isTextPresent("客服2"));
	}
	
	
	@Test  //46.在线客服设置的在线客服成员中删除客服
	public void demo46() throws IOException, InterruptedException {
		
		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a[2]");
		webtest.alertAccept();
	}
	
	@Test  //47.在线客服设置的在线客服成员中在编辑基本信息中删除客服
	public void demo47() throws IOException, InterruptedException {
		
		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a");
		webtest.click("xpath=//td[contains(text(),'删除在线客服')]");
		webtest.alertAccept();
	}
	
	
	@Test  //48.在线客服设置的在线客服成员中将客服的客服状态设置为禁用
	public void demo48() throws IOException, InterruptedException {
		
		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'客服2')]/../td[7]/a");
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("客服2"));
	}
	
	
	@Test  //49.在线客服设置的在线客服成员中编辑基本信息时不选择客服组名称
	public void demo49() throws IOException, InterruptedException {
		
		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服成员')]");
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'添加在线客服')]");
		webtest.type("id=online_name", getExcel1(29, 1));
		webtest.selectByVisibleText("id=online_type", "腾讯QQ");
		webtest.type("id=online_account", getExcel1(29, 2));
		webtest.typeAndClear("id=online_sort", getExcel1(29, 3));
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("请选择客户组"));
	}
	
	@Test  //50.在线客服设置的在线客服分组中将‘1’组的客服组状态禁用
	public void demo50() throws IOException, InterruptedException {
		
		onlineService();
		webtest.click("xpath=//a[contains(text(),'在线客服分组')]");
		Thread.sleep(2000);
		webtest.click("xpath=//td[contains(text(),'1组')]/../td[6]/a");
		webtest.click("xpath=//input[@value='0']");
		webtest.click("xpath=//button[@type='submit']");
		baseLogin();
		assertFalse(webtest.isTextPresent("1组"));
		
	}
	
}
