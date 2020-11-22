package com.xyc.dataprovider;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @DataProviderע���ʹ��
 * ʹ��DataProvider�ṩ������������ʽ�� 
 * ��һ�֣�һ�����ڲ��Դ���Ͳ������ݷ���ͬһ�����У� 
 * �ڶ��֣������е������ṩ������д��һ�������棬���������ݱȽ϶�ʱ�����ַ�������ά����
 */
public class DataProviderTest {
    
    private static WebDriver driver;
    
    // @DataProvide ��Ϊ�����ṩ�ߣ��ṩ�������飬����������test�����ͻ�ִ�м���
    // @DataProvide ע�ⶨ�嵱ǰ�����еķ���ֵ������Ϊ���Խű��Ĳ������ݼ��������������ݼ�����ΪsearchWords
    @DataProvider(name="searchWords")
    public static Object[][] words(){
        return new Object[][]{{"������","����","���˶�"},{"����","����","����"},{"����Σ��","���","����ɭ"}};
    }
    
    //�����е�3�������ֱ�ʹ��searchWords�������ݼ��е�ÿ��һά�����е����ݽ��и�ֵ���˲��Է����ᱻ����3��
    @Test(dataProvider="searchWords")
    public void test(String searchWords1, String searchWords2, String SearchResult){
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys(searchWords1 +" "+ searchWords2);
        driver.findElement(By.id("su")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(searchWords1 +">>>>" +searchWords2+">>>>"+SearchResult);
        //�ж�����������Ƿ�������������������Ĺؼ���
        Assert.assertTrue(driver.getPageSource().contains(SearchResult));
        driver.quit();
    }
    
    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "e:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
