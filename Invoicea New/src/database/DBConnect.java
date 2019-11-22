package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection connectDB() throws SQLException{
		Connection connection = null;
		String url = "jdbc:mysql://remotemysql.com:3306/ZYebHXfmH9?useSSL=false";
		String user = "ZYebHXfmH9";
		String password = "AIRtr96APu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	public static void CloseDatabase() {
		try {
			Connection connect = DBConnect.connectDB();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
