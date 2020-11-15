package demo1;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo {
	@Test
		public void test1() throws InterruptedException {
			String front_url="	http://localhost/index.php/";
			System.setProperty("webdriver.gecko.driver", "D:\\Abr\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "D:\\DemoCH15\\firefox.exe");
			WebDriver driver = new FirefoxDriver();
			Thread.sleep(5000);
			driver.get(front_url);
			Thread.sleep(5000);
			driver.findElement(By.linkText("登录")).click();
			driver.findElement(By.name("user_name")).sendKeys("admin1");
			driver.findElement(By.name("user_password")).sendKeys("123456");
			driver.findElement(By.name("captcha_code")).sendKeys("11111");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			driver.quit();	
		}
		
		@Test
		public void test2() throws InterruptedException {
			String front_url="	http://localhost/admin";
			System.setProperty("webdriver.gecko.driver", "D:\\Abr\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "D:\\DemoCH15\\firefox.exe");
			WebDriver driver = new FirefoxDriver();
			Thread.sleep(5000);
			driver.get(front_url);
			Thread.sleep(5000);
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_passwd")).sendKeys("12345678");
			driver.findElement(By.className("btn")).click();
			Thread.sleep(3000);
			driver.quit();	
		}
		
		@Test
		public void test3() throws InterruptedException {
			String front_url="	http://localhost/admin";
			System.setProperty("webdriver.gecko.driver", "D:\\Abr\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "D:\\DemoCH15\\firefox.exe");
			WebDriver driver = new FirefoxDriver();
			Thread.sleep(5000);
			driver.get(front_url);
			Thread.sleep(5000);
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_passwd")).sendKeys("12345678");
			driver.findElement(By.className("btn")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("运营管理")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("优惠促销规则")).click();
			driver.findElement(By.linkText("添加新规则")).click();
			driver.findElement(By.name("promotions_name")).sendKeys("大促销");
			driver.findElement(By.name("promotions_info")).sendKeys("对许多商品进行促销");
			driver.findElement(By.name("promotions_start_time")).sendKeys("2020-11-17 10:14:52");
			driver.findElement(By.name("promotions_end_time")).sendKeys("2020-11-27 10:14:52");
			driver.findElement(By.linkText("促销规则")).click();
			driver.findElement(By.name("shopping_amount")).sendKeys("500");
			driver.findElement(By.name("shopping_discount")).sendKeys("100");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.quit();
		}
		@Test
		public void test4() throws InterruptedException {
			String front_url="http://localhost/admin";
			System.setProperty("webdriver.gecko.driver", "D:\\Abr\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "D:\\DemoCH15\\firefox.exe");
			WebDriver driver = new FirefoxDriver();
			Thread.sleep(5000);
			driver.get(front_url);
			Thread.sleep(5000);
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_passwd")).sendKeys("12345678");
			driver.findElement(By.className("btn")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("客户管理")).click();
			Thread.sleep(3000);	
			driver.findElement(By.linkText("管理客户")).click();
			driver.quit();
					
		}
		
		@Test
		public void test5() {
			System.out.println("hello");
		}
		@Test
		public void test6() {
			assertEquals(1, 2);
		}
		@Test
		public void test7() {
			assertEquals(3, 4);
		}
		@Test
		public void test8() {
			assertEquals(4, 5);
		}
		
		

}
