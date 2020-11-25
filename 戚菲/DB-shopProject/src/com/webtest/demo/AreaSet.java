package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AreaSet extends BaseTest{

	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.click("xpath=//a[contains(text(),'地区管理')]");
		
	}
	
//	@Test  //30.地区管理中删除北京市
	public void demo1() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a[2]");
		webtest.alertAccept();
		assertTrue(webtest.isTextPresent("地区删除失败，该地区还有下级地区存在"));
	}
	
//	@Test //31.地区管理中将北京市的地区排序改为‘2’
	public void demo2() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/span");
		webtest.typeAndClear("id=edit_region_sort1",getExcel(19, 1));
		webtest.click("xpath=//button[contains(text(),'保存')]");
	}
	
	
//	@Test //32.在西城区的下级地区中添加地区
	public void demo3() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", getExcel(20, 1));
		webtest.click("xpath=//button[contains(text(),'保存')]");
	}
	
	
	@Test //33.在西城区的下级地区中添加地区，其中地区名称为空
	public void demo4() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", "");
		webtest.click("xpath=//button[contains(text(),'保存')]");
		assertTrue(webtest.isTextPresent("请输入地区名称"));
	}
	
	
//	@Test //34.将西城区下添加的地区删除
	public void demo5() throws IOException, InterruptedException {
		first();
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
	public void demo6() throws IOException, InterruptedException {
		adminLogin();
		first();
		webtest.click("xpath=//td[contains(text(),'北京市')]/../td[5]/a");
		webtest.click("xpath=//td[contains(text(),'西城区')]/../td[5]/a");
		webtest.click("xpath=//a[contains(text(),'添加地区')]");
		webtest.typeAndClear("id=region_name", getExcel(21,1));
		webtest.typeAndClear("id=region_sort", "");
		
		
		webtest.click("xpath=//button[contains(text(),'保存')]");
		String sort = webtest.getText("xpath=//td[contains(text(),'A县')]/../td[4]");
		System.out.println("排序为空保存后地区排序为："+sort);
		assertEquals("255", sort);
	}
	
	
	
	
}
