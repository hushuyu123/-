package com.xyc.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	//点击CMS-管理文章
	public void managementArticles(WebDriver driver) throws Exception {
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[5]/ul/li[1]/a")).click();
		Thread.sleep(3000);
	}
	
	public boolean isAddsuccess(WebDriver driver)throws Exception{
		boolean flag = true;
		try {
			if (driver.findElement(By.className("table table-hover")).isDisplayed()) {
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return flag;
	}
	
	//点击CMS-管理文章分类
	public void managementKind(WebDriver driver) throws Exception {
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[5]/ul/li[2]/a")).click();
		Thread.sleep(3000);
	}
	
	public boolean isAddKindsuccess1(WebDriver driver)throws Exception{
		boolean flag = true;
		try {
			if (driver.findElement(By.id("acticle_class_from")).isDisplayed()) {
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return flag;
	}
	
	public boolean isAddKindsuccess2(WebDriver driver)throws Exception{
		boolean flag = true;
		try {
			if (driver.findElement(By.xpath("/html/body/div[3]/span[3]")).isDisplayed()) {
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return flag;
	}
	
	//点击CMS-管理单页文章
	public void managementArticle(WebDriver driver) throws Exception{
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[5]/ul/li[3]/a")).click();
		Thread.sleep(3000);
	}

	//点击工具管理-导航设置
	public void navigation(WebDriver driver) throws Exception{
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/ul/li[1]/a")).click();
		Thread.sleep(3000);
	}
	
	//点击工具管理-友情链接
	public void links(WebDriver driver) throws Exception{
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/ul/li[2]/a")).click();
		Thread.sleep(3000);
	}
	
	//点击工具管理-邮件发送
	public void messageSend(WebDriver driver) throws Exception{
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/ul/li[3]/a")).click();
		Thread.sleep(3000);
	}
	
	//点击工具管理-操作日志
	public void operationLog(WebDriver driver) throws Exception{
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/ul[1]/li[6]/ul/li[6]/a")).click();
		Thread.sleep(3000);
	}
	//
}
