package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


public class DatabaseBackup extends BaseTest{
	
	@BeforeClass
	public void loginFirst() throws Exception {
		webtest.open("http://localhost/index.php/admin");

		webtest.type("id=user_name", getExcel(0, 0));
		webtest.type("id=user_passwd", getExcel(0, 1));
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);

		webtest.click("xpath=//a[contains(text(),'工具管理')]");
		webtest.click("xpath=//a[contains(text(),'数据库备份')]");
		Thread.sleep(2000);
	}
	
	//备份数据库
		@Test(priority=1)
		public void Demo1()throws Exception{
			//点击备份当前系统数据
			webtest.click("xpath=//a[@class=\"btn btn-small btn-primary\"]");
			Thread.sleep(1000);
			
			//true
			assertEquals(true, webtest.isTextPresent("导入"));
			Thread.sleep(1000);
		}
		
		//删除数据库
		@Test(priority=2)
		public void Demo2()throws Exception{
			//点击删除当前系统数据
			webtest.click("xpath=//a[text()='删除']");
			Thread.sleep(1000);
			
			//弹出框选择确定
			System.out.println(getDriver().switchTo().alert().getText());
			getDriver().switchTo().alert().accept();
			Thread.sleep(1000);
			
			//false
			assertEquals(true, webtest.isTextPresent("导入"));
			
		}
}
