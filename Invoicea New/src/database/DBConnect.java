package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection connectDB(){
		Connection connection = null;
		String driver = "";
		String url = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9311205?useSSL=false";
		String user = "sql9311205";
		String password = "g3Ti5WIUeg";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
