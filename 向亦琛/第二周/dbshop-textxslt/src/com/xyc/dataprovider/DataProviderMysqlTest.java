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
 * ʹ��Mysql���ݿ�ʵ�����ݵ���������
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
    
    //��ȡMysql���ݿ��еĲ�������
    public static Object[][] getTestData(String tableName) throws IOException{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bbs";
        String username = "root";
        String password = "123";
        
        List<Object[]> records = new ArrayList<Object[]>();
        try {
            //�������ݿ�����
            Class.forName(driver);
            //��ȡ���ݿ�����
            Connection connection = DriverManager.getConnection(url,username,password);
            //����statement����
            Statement statement = connection.createStatement();
            //׼��sql���
            String sql = "select argument1,argument2,result from " + tableName ;
            //��statement����ִ��sql���
            ResultSet rs = statement.executeQuery(sql);
            //��ȡResultSetMetaData����
            ResultSetMetaData reMetaData = rs.getMetaData();
            //����getColumnCount()��ȡ�����ֶε���Ŀ��������
            int columnCount = reMetaData.getColumnCount();
            while(rs.next()){
                String fields[] = new String[columnCount];
                int column = 0;
                //�������������ݵ����������ݣ������ַ�������
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
        // ���巽���ķ���ֵ����listת��ΪObject��ά����
        Object[][] results = new Object[records.size()][];
        // ���ö�ά��ÿ�е�ֵ��ÿ����һ��Object����
        for (int i = 0; i < records.size(); i++) {
            results[i] = (Object[]) records.get(i);
        }
        return results;
    }
}