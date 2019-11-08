package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import four.Invoice;

public class Database {
	public static Connection connect;
	public static Statement stmt = null;;

	
	public static String CreateCode(int studio_id, int year, int invoice_id) {
		String code = "0" + studio_id + "-" + year + "-00" + invoice_id;
		return code;
	}
	   
	public static int HasInvoice(int studio_id) {
		connect = DBConnect.connectDB();
		int invoice_id = 0;
		String cmd = "SELECT * FROM invoices WHERE studio_id = " + studio_id;
		try {
			stmt = connect.createStatement();
			stmt.executeQuery(cmd);
			ResultSet rs = stmt.executeQuery(cmd);
			while(rs.next()) {
				invoice_id++;
			}
			
		} catch (SQLException e) {
			System.out.print(e);
		} 
//comment
		
		
		return invoice_id;
		
	}

	public static void CreateNewInvoice(int studio_id, int iYear) {
		connect = DBConnect.connectDB();
		String cmd = "INSERT INTO invoices(code, studio_id, invoice_id, year) VALUES(?,?,?, ?)";
		String code = CreateCode(studio_id, iYear, 1);
		try (Connection conn = connect;
                PreparedStatement pstmt = conn.prepareStatement(cmd)) {
			pstmt.setString(1, code);
            pstmt.setInt(2, studio_id);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, iYear);
            pstmt.executeUpdate();
            System.out.print("Saved");
		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
		
	}

	public static void CreateInvoice(int studio_id, int invoice_id, int iYear) {
		connect = DBConnect.connectDB();
		
		String cmd = "INSERT INTO invoices(code, studio_id, invoice_id, year) VALUES(?, ?,?, ?)";
		int inv = invoice_id+1;
		String code = CreateCode(studio_id, iYear, inv);
		try (Connection conn = connect;
                PreparedStatement pstmt = conn.prepareStatement(cmd)) {
			pstmt.setString(1, code);
            pstmt.setInt(2, studio_id);
            pstmt.setInt(3, inv);
            pstmt.setInt(4, iYear);
            pstmt.executeUpdate();
            System.out.print("Saved");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}
	
	
	public static void CreateMaterial(String name, String cost){
		connect = DBConnect.connectDB();
		
		
		
		String cmd = "INSERT INTO material(name, cost) VALUES(?, ?)";
		try (Connection conn = connect;
                PreparedStatement pstmt = conn.prepareStatement(cmd)) {
			pstmt.setString(1, name);
            pstmt.setString(2, cost);
            pstmt.executeUpdate();
            System.out.print("Material Added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
}
