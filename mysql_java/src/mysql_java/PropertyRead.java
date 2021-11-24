package mysql_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PropertyRead {


	public static void main(String[] args) {	
		InputStream is = null;
		Connection connection = null;
		try{
			File file = new File("db.properties");
			is = new FileInputStream(file); 
			Properties properties = new Properties(); 
			properties.load(is);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String id = properties.getProperty("id");
			String pass = properties.getProperty("password");

			Class.forName(driver);
			System.out.println("드라이버 클래스 로드");

			connection = DriverManager.getConnection(url, id, pass);
			System.out.println("접속 / 로그인 성공");
		} catch (Exception e) {
			System.out.println("데이터베이스 접속 실패");
			System.out.println(e.getMessage());
		}finally {
			try {
				if(is != null) {
					is.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
