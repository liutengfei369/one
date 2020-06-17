package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql:///test?characterEncoding=UTF-8";
	private static final String username = "root";
	private static final String pwd = "root";
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//�õ����ӷ���
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, pwd);
	}
}
