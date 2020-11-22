package com.xyc.test;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xyc.pageobject.HomePage;
import com.xyc.pageobject.LoginPage;
import com.xyc.util.BaseTest;

public class Addtext extends BaseTest{
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	String LoginURL = "http://localhost/index.php/admin";
	
	@BeforeClass
	public void loginFirst() throws Exception {
		Thread.sleep(2000);
		if (!loginPage.isLoginPage(driver)) {
			driver.get(LoginURL);
		}
		try {
			loginPage.login(driver, "admin","admin2020");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//点击管理文章
		Thread.sleep(1000);
		homePage.managementArticles(driver);
	}
	
	//添加文章时只选择下拉框，不填写文章标题
	@Test(priority=1)
	public void addAtrticle1()throws Exception {
		
		//点击添加文章
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p[2]/a[1]")).click();
		
		//找到下拉框标签
		driver.findElement(By.xpath("//*[@id=\"article_class_id\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[2]/div/select/option[2]")).click();
	
		 //根据规则随机生成文本框内容
		 int random = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).sendKeys(String.valueOf(random));
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("/html/body>p")).sendKeys("自动化测试--"+random);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		 
		 //前往前台验证
		 //driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		 assertEquals(true, homePage.isAddsuccess(driver));
		 Thread.sleep(2000);
		 }
	
	//添加文章时只写文章标题不填写下拉框
	@Test(priority=2)
	public void addAtrticle2()throws Exception {
		//输入标题
		int random1 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).sendKeys(String.valueOf(random1));
	
		//找到下拉框标签
		driver.findElement(By.xpath("//*[@id=\"article_class_id\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[2]/div/select/option[1]")).click();
			
		 //根据规则随机生成文本框内容
		 int random2 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).sendKeys(String.valueOf(random2));
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("/html/body>p")).sendKeys("自动化测试--"+random);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		 
		 //driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		 assertEquals(true, homePage.isAddsuccess(driver));
		 Thread.sleep(2000);
	}
	
	//添加文章时填写标题和下拉框
	@Test(priority=3)
	public void addAtrticle3()throws Exception {
		//点击添加文章
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p[2]/a[1]")).click();
				
		//输入标题
		int random1 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).sendKeys(String.valueOf(random1));
	
		//找到下拉框标签
		driver.findElement(By.xpath("//*[@id=\"article_class_id\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[2]/div/select/option[3]")).click();
			
		 //根据规则随机生成文本框内容
		 int random2 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).sendKeys(String.valueOf(random2));
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("/html/body>p")).sendKeys("自动化测试--"+random);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		 
		 //driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		 assertEquals(true, homePage.isAddsuccess(driver));
		 
//		 driver.navigate().to("http://localhost/index.php/admin/cms/cms");
		 Thread.sleep(2000);
	}
	
	
}
