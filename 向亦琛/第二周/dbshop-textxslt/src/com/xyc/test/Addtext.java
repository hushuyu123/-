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
		
		//�����������
		Thread.sleep(1000);
		homePage.managementArticles(driver);
	}
	
	//�������ʱֻѡ�������򣬲���д���±���
	@Test(priority=1)
	public void addAtrticle1()throws Exception {
		
		//����������
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p[2]/a[1]")).click();
		
		//�ҵ��������ǩ
		driver.findElement(By.xpath("//*[@id=\"article_class_id\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[2]/div/select/option[2]")).click();
	
		 //���ݹ�����������ı�������
		 int random = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).sendKeys(String.valueOf(random));
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("/html/body>p")).sendKeys("�Զ�������--"+random);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		 
		 //ǰ��ǰ̨��֤
		 //driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		 assertEquals(true, homePage.isAddsuccess(driver));
		 Thread.sleep(2000);
		 }
	
	//�������ʱֻд���±��ⲻ��д������
	@Test(priority=2)
	public void addAtrticle2()throws Exception {
		//�������
		int random1 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).sendKeys(String.valueOf(random1));
	
		//�ҵ��������ǩ
		driver.findElement(By.xpath("//*[@id=\"article_class_id\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[2]/div/select/option[1]")).click();
			
		 //���ݹ�����������ı�������
		 int random2 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).sendKeys(String.valueOf(random2));
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("/html/body>p")).sendKeys("�Զ�������--"+random);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		 
		 //driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		 assertEquals(true, homePage.isAddsuccess(driver));
		 Thread.sleep(2000);
	}
	
	//�������ʱ��д�����������
	@Test(priority=3)
	public void addAtrticle3()throws Exception {
		//����������
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p[2]/a[1]")).click();
				
		//�������
		int random1 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_title\"]")).sendKeys(String.valueOf(random1));
	
		//�ҵ��������ǩ
		driver.findElement(By.xpath("//*[@id=\"article_class_id\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[2]/div[2]/div[2]/div/select/option[3]")).click();
			
		 //���ݹ�����������ı�������
		 int random2 = new Random().nextInt(200000000);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"article_writer\"]")).sendKeys(String.valueOf(random2));
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("/html/body>p")).sendKeys("�Զ�������--"+random);
		 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		 
		 //driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li[3]/a")).click();
		 assertEquals(true, homePage.isAddsuccess(driver));
		 
//		 driver.navigate().to("http://localhost/index.php/admin/cms/cms");
		 Thread.sleep(2000);
	}
	
	
}
