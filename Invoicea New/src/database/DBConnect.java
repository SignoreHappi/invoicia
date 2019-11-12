package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection connectDB() throws SQLException{
		Connection connection = null;
		String driver = "";
		String url = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9311205?useSSL=false";
		String user = "sql9311205";
		String password = "g3Ti5WIUeg";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("Connection opened");
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
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
