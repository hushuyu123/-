<<<<<<< HEAD
package com.webtest.dataprovider;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MysqlDataProvider {
	

	
	public  Object[][] getTestDataByMysql(String sql) {
		String url = "jdbc:mysql://127.0.0.1:3306/mymovie";
		List<Object[]> records = new ArrayList<Object[]>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(url, "root", "123456");
			if (!conn.isClosed()) {
				System.out.println("è¿æ¥æ•°æ®åº“æˆåŠŸ");
			}
			// Statementé‡Œé¢å¸¦æœ‰å¾ˆå¤šæ–¹æ³•ï¼Œæ¯”å¦‚executeUpdateå¯ä»¥å®ç°æ’å…¥ï¼Œæ›´æ–°å’Œåˆ é™¤ç­‰
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//å¾—åˆ°æ•°æ®é›†çš„ç»“æ„
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cols = rsMetaData.getColumnCount();
			System.out.println(cols);
			while (rs.next()) {
				String fields[] = new String[cols];

				int col=0;
				for (int i = 0; i < cols; i++) {
					fields[col] = rs.getString(i+1);//è¯»å–å½“å‰è¡ŒæŒ‡å®šçš„åˆ—
					col++;
				}
				records.add(fields);
			
			}
			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}


}
=======
package com.webtest.dataprovider;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MysqlDataProvider {
	

	
	public  Object[][] getTestDataByMysql(String sql) {
		String url = "jdbc:mysql://127.0.0.1:3306/mymovie";
		List<Object[]> records = new ArrayList<Object[]>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(url, "root", "123456");
			if (!conn.isClosed()) {
				System.out.println("Á¬½ÓÊı¾İ¿â³É¹¦");
			}
			// StatementÀïÃæ´øÓĞºÜ¶à·½·¨£¬±ÈÈçexecuteUpdate¿ÉÒÔÊµÏÖ²åÈë£¬¸üĞÂºÍÉ¾³ıµÈ
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//µÃµ½Êı¾İ¼¯µÄ½á¹¹
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cols = rsMetaData.getColumnCount();
			System.out.println(cols);
			while (rs.next()) {
				String fields[] = new String[cols];

				int col=0;
				for (int i = 0; i < cols; i++) {
					fields[col] = rs.getString(i+1);//¶ÁÈ¡µ±Ç°ĞĞÖ¸¶¨µÄÁĞ
					col++;
				}
				records.add(fields);
			
			}
			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}


}
>>>>>>> 701e65264fd61398875288292bcacefd03779345
