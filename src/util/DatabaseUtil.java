package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	// 定义一个获取数据库连接的方法
	public Connection getConnection() {
		String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=HospitalManagementSystem";
		String id = "sa", password = "qq265081";
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return conn;
	}

	// 关闭数据库连接
	public void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DatabaseUtil dUtil = new DatabaseUtil();
		Connection connection = dUtil.getConnection();
		dUtil.close(connection);
	}

}
