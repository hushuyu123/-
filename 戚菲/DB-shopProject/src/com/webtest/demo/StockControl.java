package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class StockControl extends BaseTest{

	public void first() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[contains(text(),'系统管理')]");
		webtest.mouseToElement("xpath=//a[contains(text(),'状态设置')]");
	}
	
//	@Test //36.库存状态管理中把有货的库存状态排序填写为‘aaaa’
	public void demo1() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=state_sort", getExcel(22, 1));
		webtest.click("xpath=//button[@type='submit']");
		String new_sort=webtest.getText("xpath=//td[contains(text(),'有货状态')]/../td[4]");
		assertEquals("aaaa",new_sort);
		
	}
	
	@Test //37.库存状态管理中把有货的库存状态名称填写为‘123’
	public void demo2() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=stock_state_name", getExcel(23, 1));
		webtest.click("xpath=//button[@type='submit']");
		String new_name=webtest.getText("xpath=//td[contains(text(),'有货状态')]/../td[2]");
		assertEquals("123  (默认)",new_name);
		
	}
	
	
	@Test //38.库存状态管理中把有货的库存状态名称填写为空
	public void demo3() throws IOException, InterruptedException {
		
		first();
		webtest.click("xpath=//a[contains(text(),'库存状态')]");
		webtest.click("xpath=//td[contains(text(),'有货状态')]/../td[5]/a");
		webtest.typeAndClear("id=stock_state_name", "");
		webtest.click("xpath=//button[@type='submit']");
		
		assertTrue(webtest.isTextPresent("库存状态名称不能为空"));
		
	}
}
