package com.xyc.dataprovider;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @DataProvider注解的使用
 * 使用DataProvider提供数据有两种形式： 
 * 第一种：一种是在测试代码和测试数据放在同一个类中； 
 * 第二种：把所有的数据提供都单独写在一个类里面，当测试数据比较多时，这种方法利于维护。
 */
public class DataProviderTest {
    
    private static WebDriver driver;
    
    // @DataProvide 作为数据提供者，提供几组数组，则引用他的test方法就会执行几次
    // @DataProvide 注解定义当前方法中的返回值对象作为测试脚本的测试数据集，并将测试数据集命名为searchWords
    @DataProvider(name="searchWords")
    public static Object[][] words(){
        return new Object[][]{{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};
    }
    
    //方法中的3个参数分别使用searchWords测试数据集中的每个一维数组中的数据进行赋值，此测试方法会被调用3次
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
        //判断搜索结果中是否包含测试数据中期望的关键词
        Assert.assertTrue(driver.getPageSource().contains(SearchResult));
        driver.quit();
    }
    
    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "e:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
