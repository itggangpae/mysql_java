package mysql_java;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCMySQL {
	static final String db = "employees";
	static final String id = "user00";
	static final String pass = "user00";
	static String url = "jdbc:mysql://localhost:3306/" + db + "?characterEncoding=UTF-8&serverTimezone=UTC";
	
	public static void main(String[] args) {		
		System.out.println("MySql JDBC 드라이버 로딩중...");
		try {
			// 1. MySql 데이타베이스 드라이버 로딩
			//이전 MySQL 드라이버
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySql JDBC 드라이버 로딩 성공...");

		} catch (ClassNotFoundException e) {
			System.out.println("MySql JDBC 드라이버 로딩 실패...");
			System.out.println(e.getMessage());
			System.exit(0);
		}
		try(Connection connection = DriverManager.getConnection(url, id, pass)) {
			System.out.println("접속 / 로그인 성공");
		} catch (Exception e) {
			System.out.println("접속 / 로그인 실패");
			System.out.println(e.getMessage());
		}
	}
}
