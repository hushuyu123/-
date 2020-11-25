package com.xyc.test;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xyc.pageobject.HomePage;
import com.xyc.pageobject.LoginPage;
import com.xyc.util.BaseTest;

public class AddTextKind extends BaseTest{
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
		homePage.managementKind(driver);
	}
	
	//ֻ��д�������� ��ѡ�����״̬(Ĭ��״̬)
	@Test(priority=1)
	public void AddKind1()throws Exception{
		//�����ӷ���
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p[2]/a[1]")).click();
		Thread.sleep(1000);
		
		//��д��������
		int random = new Random().nextInt(200000000);
		driver.findElement(By.xpath("//*[@id=\"article_class_name\"]")).sendKeys(String.valueOf(random));
		Thread.sleep(1000);
		
		//�������
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		
		Thread.sleep(1000);
		assertEquals(true, homePage.isAddKindsuccess1(driver));
		
	}
	
	//����д�������ƣ�ѡ��Ĭ��״̬
	@Test(priority=2)
	public void AddKind2()throws Exception{
		//�����ӷ���
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/p[2]/a[1]")).click();
		Thread.sleep(1000);
		
		//��д��������
//		int random = new Random().nextInt(200000000);
//		driver.findElement(By.xpath("//*[@id=\"article_class_name\"]")).sendKeys(String.valueOf(random));
//		Thread.sleep(1000);
//		
		//�������
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		
		Thread.sleep(1000);
		assertEquals(true, homePage.isAddKindsuccess1(driver));
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/a[1]")).click();
	}
	
	//��ӷ�������
	@Test(priority=3)
	public void AddKind3()throws Exception{
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/table/tbody/tr[1]/td[5]/a[1]")).click();
		
		//��д��������
		int random = new Random().nextInt(200000000);
		driver.findElement(By.xpath("//*[@id=\"article_class_name\"]")).sendKeys(String.valueOf(random));
		Thread.sleep(1000);
		
		//�������
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div/div[1]/div[2]/button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/table/tbody/tr[2]/td[5]/a[5]")).click();
		assertEquals(true, homePage.isAddKindsuccess2(driver));
		
	}

}
