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

	//Creates the code with the studio_id-year-invoic_id 
	public static String CreateCode(int studio_id, int year, int invoice_id) {
		String code = "0" + studio_id + "-" + year + "-00" + invoice_id;
		return code;
	}
	   
	//Search into the DB if the studio has any invoice, if not, create invoice_id 1
	public static int HasInvoice(int studio_id) {
		//Makes the connection with the DB
		connect = DBConnect.connectDB();
		int invoice_id = 0;
		//Code to select the information
		String cmd = "SELECT * FROM invoices WHERE studio_id = " + studio_id;
		try {
			//Create the code
			stmt = connect.createStatement();
			//Execute the code
			stmt.executeQuery(cmd);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmd);
			//While there's code to be executes, do something
			while(rs.next()) {
				invoice_id++;
			}
		//If there's some error, return it
		} catch (SQLException e) {
			System.out.print(e);
		} 
		return invoice_id;	
	}

	//If the studio has no invoice, create a new one starting from studio_id 1
	public static void CreateNewInvoice(int studio_id, int iYear) {
		connect = DBConnect.connectDB();
		String cmd = "INSERT INTO invoice(code, studio_id, invoice_id, year) VALUES(?,?,?, ?)";
		String code = CreateCode(studio_id, iYear, 1);
		try (Connection conn = connect;
                PreparedStatement pstmt = conn.prepareStatement(cmd)) {
			//Create a new item into the DB in the position 1 with the value defined
			pstmt.setString(1, code);
            pstmt.setInt(2, studio_id);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, iYear);
            //Update the DB
            pstmt.executeUpdate();
            System.out.print("Saved");
		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	//If the studio has an invoice, create a new one with invoice_id+1
	public static void CreateInvoice(int studio_id, int invoice_id, int iYear) {
		connect = DBConnect.connectDB();
		String cmd = "INSERT INTO invoices(code, studio_id, invoice_id, year) VALUES(?, ?, ?, ?)";
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
	
	//Insert a new material into the table
	public static void CreateMaterial(String name, String cost, String type){
		connect = DBConnect.connectDB();
		String cmd = "INSERT INTO material(material_name, material_cost, material_type) VALUES(?, ?, ?)";
		try (Connection conn = connect;
                PreparedStatement pstmt = conn.prepareStatement(cmd)) {
			pstmt.setString(1, name);
            pstmt.setString(2, cost);
            pstmt.setString(3, type);
            pstmt.executeUpdate();
            System.out.print("Material Added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	
}
