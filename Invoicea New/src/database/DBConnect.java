package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection connectDB() throws SQLException{
		Connection connection = null;
//		String url = "jdbc:mysql://sql305.epizy.com:3306/epiz_25185035_invoicia?useSSL=false";
//		String user = "epiz_25185035";
//		String password = "Kidsindance";
		String url = "jdbc:mysql://remotemysql.com:3306/ZZeQxiV80X?useSSL=false";
        String user = "ZZeQxiV80X";
        String password = "3OPa7vc861";
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
