package com.xyc.dataprovider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 使用Mysql数据库实现数据的驱动测试
 */

public class DataProviderMysqlTest {

    public WebDriver driver;
    String url = "http://www.baidu.com";
    
    @DataProvider(name="testData")
    public Object[][] words() throws IOException{
        return getTestData("search");
    }
    
    @BeforeMethod  
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "e:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    
    @Test(dataProvider="testData")
    public void test(String searchWord1,String searchWord2,String searchResult){
        driver.get(url);
        driver.findElement(By.id("kw")).sendKeys(searchWord1+" "+searchWord2);
        driver.findElement(By.id("su")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }
    
    //获取Mysql数据库中的测试数据
    public static Object[][] getTestData(String tableName) throws IOException{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bbs";
        String username = "root";
        String password = "123";
        
        List<Object[]> records = new ArrayList<Object[]>();
        try {
            //加载数据库驱动
            Class.forName(driver);
            //获取数据库连接
            Connection connection = DriverManager.getConnection(url,username,password);
            //创建statement对象
            Statement statement = connection.createStatement();
            //准备sql语句
            String sql = "select argument1,argument2,result from " + tableName ;
            //用statement对象执行sql语句
            ResultSet rs = statement.executeQuery(sql);
            //获取ResultSetMetaData对象
            ResultSetMetaData reMetaData = rs.getMetaData();
            //调用getColumnCount()获取所有字段的数目（列数）
            int columnCount = reMetaData.getColumnCount();
            while(rs.next()){
                String fields[] = new String[columnCount];
                int column = 0;
                //遍历所有行数据的所有列数据，并存字符数组中
                for(int columnIndex = 0; columnIndex < columnCount; columnIndex ++){
                    fields[column] = rs.getString(columnIndex +1);
                    column ++;
                }
                records.add(fields);
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
                
            }
            rs.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 定义方法的返回值，将list转换为Object二维数据
        Object[][] results = new Object[records.size()][];
        // 设置二维数每行的值，每行是一个Object对象
        for (int i = 0; i < records.size(); i++) {
            results[i] = (Object[]) records.get(i);
        }
        return results;
    }
}