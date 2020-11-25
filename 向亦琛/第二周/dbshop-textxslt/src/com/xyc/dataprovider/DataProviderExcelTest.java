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
 * ʹ��Excel�ļ�����������������
 * ������POI jar��
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
    
    //��excel�л�ȡ�������ݵķ���
    public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException{
        //����һ��file�ļ�����
        File file = new File(filePath+"\\"+fileName);
        //��ȡ�ļ�
        FileInputStream in = new FileInputStream(file);
        //����Workbook����
        Workbook workbook = null;
        //��ȡ�ļ�����չ��
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            //.xlsx�����ļ�
            workbook = new XSSFWorkbook(in);
        }else {
            //.xls���͵��ļ�
            workbook = new HSSFWorkbook(in);
        }
        //ͨ��sheetName,����Sheet����
        Sheet sheet = workbook.getSheet(sheetName);
        //��ȡsheet1�����ݵ����������һ�м�ȥ��һ��
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        
        //��excel�е����ݴ���list��
        List<Object[]> records = new ArrayList<Object[]>();
        //����ÿ�����ݣ�ȥ����һ�б�ͷ���ݣ�excel���к����кŶ��Ǵ�0��ʼ
        for(int i=1;i<=rowCount;i++){
            //��ȡ�ж���
            Row row = sheet.getRow(i);
            //����һ�������Ŷ�ȡ�������ݣ������С��getlastCellNumȷ��
            String fields[] = new String[row.getLastCellNum()];
            //����ÿ������
            for(int j=0;j<row.getLastCellNum();j++){
                //����getCell��getStringCellValue������ȡexcel�е�Ԫ���е�����
                fields[j] = row.getCell(j).getStringCellValue();    
            }
            records.add(fields);
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
