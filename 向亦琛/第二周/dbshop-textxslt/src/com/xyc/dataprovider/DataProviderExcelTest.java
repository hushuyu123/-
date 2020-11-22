package com.xyc.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 使用Excel文件进行数据驱动测试
 * 需引入POI jar包
 * @author Administrator
 *
 */
public class DataProviderExcelTest {
    
    public static WebDriver driver;
    String url = "http://www.baidu.com";
    
    @DataProvider(name="testData")
    public static Object[][] words() throws IOException{
        return getTestData("f://","testData.xlsx","Sheet1");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    
    @AfterMethod
    public void AfterMethod(){
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
    
    //从excel中获取测试数据的方法
    public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException{
        //声明一个file文件对象
        File file = new File(filePath+"\\"+fileName);
        //读取文件
        FileInputStream in = new FileInputStream(file);
        //声明Workbook对象
        Workbook workbook = null;
        //获取文件的扩展名
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            //.xlsx类型文件
            workbook = new XSSFWorkbook(in);
        }else {
            //.xls类型的文件
            workbook = new HSSFWorkbook(in);
        }
        //通过sheetName,生成Sheet对象
        Sheet sheet = workbook.getSheet(sheetName);
        //读取sheet1中数据的行数，最后一行减去第一行
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        
        //将excel中的数据存在list中
        List<Object[]> records = new ArrayList<Object[]>();
        //遍历每行数据，去除第一行表头数据，excel的行号与列号都是从0开始
        for(int i=1;i<=rowCount;i++){
            //获取行对象
            Row row = sheet.getRow(i);
            //声明一个数组存放读取的行数据，数组大小用getlastCellNum确定
            String fields[] = new String[row.getLastCellNum()];
            //遍历每列数据
            for(int j=0;j<row.getLastCellNum();j++){
                //调用getCell与getStringCellValue方法获取excel中单元格中的数据
                fields[j] = row.getCell(j).getStringCellValue();    
            }
            records.add(fields);
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
