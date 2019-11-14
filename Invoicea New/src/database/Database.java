package database;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import four.Invoice;


public class Database {
	public static Connection connect;
	public static Statement stmt = null;

	//Creates the code with the studio_id-year-invoic_id 
	public static String CreateCode(int studio_id, int year, int invoice_id) {
		String code = "0" + studio_id + "-" + year + "-00" + invoice_id;
		return code;
	}

	//Search into the DB if the studio has any invoice, if not, create invoice_id 1
	public static int HasInvoice(int studio_id) {
		int invoice_id = 0;
		//Code to select the information
		String cmd = "SELECT * FROM invoice WHERE studio_id = " + studio_id;
		try {
			connect = DBConnect.connectDB();
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
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return invoice_id;	
	}

	//If the studio has no invoice, create a new one starting from studio_id 1
	public static void CreateNewInvoice(int studio_id, int iYear) {
		String cmd = "INSERT INTO invoice(code, studio_id, invoice_id, year) VALUES(?,?,?, ?)";
		String code = CreateCode(studio_id, iYear, 1);

		try{
			connect = DBConnect.connectDB();
			PreparedStatement pstmt = connect.prepareStatement(cmd);
			//Create a new item into the DB in the position 1 with the value defined
			pstmt.setString(1, code);
			pstmt.setInt(2, studio_id);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, iYear);
			//Update the DB
			pstmt.executeUpdate();
			System.out.println("Saved");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
	}

	//If the studio has an invoice, create a new one with invoice_id+1
	public static void CreateInvoice(int studio_id, int invoice_id, int iYear) {
		String cmd = "INSERT INTO invoice(code, studio_id, invoice_id, year) VALUES(?, ?, ?, ?)";
		int inv = invoice_id+1;
		String code = CreateCode(studio_id, iYear, inv);
		try{
			connect = DBConnect.connectDB();
			PreparedStatement pstmt = connect.prepareStatement(cmd);
			pstmt.setString(1, code);
			pstmt.setInt(2, studio_id);
			pstmt.setInt(3, inv);
			pstmt.setInt(4, iYear);
			pstmt.executeUpdate();
			System.out.print("Saved");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
	}

	//Insert a new material into the table
	public static boolean CreateMaterial(String name, String cost, String type){
		String cmd = "INSERT INTO material(material_name, material_cost, material_type) VALUES(?, ?, ?)";
		//In case the user uses , instead of . the program will replace it
		String newCost = cost.replace(",", ".");		

		double dCost = Double.parseDouble(newCost);

		try{
			connect = DBConnect.connectDB();
			PreparedStatement pstmt = connect.prepareStatement(cmd);			
			pstmt.setString(1, name);
			pstmt.setDouble(2, dCost);
			pstmt.setString(3, type);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
	}

	public static void LoadMaterials(){
		Invoice.materialTable.setRowCount(0);
		Invoice.txtSearchMaterial.setText("");;
		String cmd = "SELECT * FROM material";
		int id;
		String name, type, sId, sCost;
		double cost;


		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();
			//Execute the code
			stmt.executeQuery(cmd);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmd);
			//While there's code to be executes, do something
			
			
			
			while(rs.next()) {

				id = rs.getInt("material_id");
				name = rs.getString("material_name");
				type = rs.getString("material_type");
				cost = rs.getDouble("material_cost");

				Invoice.materialTable.insertRow(Invoice.materialTable.getRowCount(), new Object[] {Integer.toString(id), 
						name, type, Double.toString(cost)});
			}

			//If there's some error, return it
		} catch (SQLException e) {
			System.out.print(e);
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}

	public static void SearchMaterial(KeyEvent enter, String materialSearch, String cmd) {
		Invoice.materialTable.setRowCount(0);

		char typed = enter.getKeyChar();
		if(typed == 'a' || typed == 'b' || typed == 'c' || typed == 'd' || typed == 'e'||  typed == 'f' || typed == 'g' || typed == 'h' || typed == 'i' || typed == 'j' || typed == 'k' || typed == 'l' || typed == 'm' || typed == 'n' || typed == 'o' || typed == 'p' || typed == 'q' || typed == 'r' || typed == 's' || typed == 't' || typed == 'u' || typed == 'v' || typed == 'w' || typed == 'x' || typed == 'y' || typed == 'z' ||  
		   typed == 'A' || typed == 'B' || typed == 'C' || typed == 'D' || typed == 'E'||  typed == 'F' || typed == 'G' || typed == 'H' || typed == 'I' || typed == 'J' || typed == 'K' || typed == 'L' || typed == 'M' || typed == 'N' || typed == 'O' || typed == 'P' || typed == 'Q' || typed == 'R' || typed == 'S' || typed == 'T' || typed == 'U' || typed == 'V' || typed == 'W' || typed == 'X' || typed == 'Y' || typed == 'Z' ||
		   typed == '1' || typed == '2' || typed == '3' || typed == '4' || typed == '5' || typed == '6' || typed == '7' || typed == '8' || typed == '9' || typed == '0') {
			if(materialSearch == null) {
				Invoice.materialSearch = Character.toString(typed);					
				if(typed == '1' || typed == '2' || typed == '3' || typed == '4' || typed == '5' || typed == '6' || typed == '7' || typed == '8' || typed == '9' || typed == '0') {
					Invoice.searching = "id";
				}else {
					Invoice.searching = "name";
				}
			}else {
				Invoice.materialSearch = Invoice.materialSearch + Character.toString(typed);
			}			
			
			if(Invoice.searching == "id") {
				Invoice.cmdMaterialSearch = "SELECT * FROM material WHERE material_id LIKE " +"\"" + Invoice.materialSearch + "%\"";
			}else if(Invoice.searching == "name") {
				Invoice.cmdMaterialSearch = "SELECT * FROM material WHERE material_name LIKE " +"\"" + Invoice.materialSearch + "%\"";									
			}
		}
		if(enter.getKeyCode() == KeyEvent.VK_BACK_SPACE && materialSearch.length() > 0) {
			Invoice.materialSearch = Invoice.materialSearch.substring(0, Invoice.materialSearch.length()-1);
		}
		System.out.println(Invoice.materialSearch);
		System.out.println(cmd);
		int id;
		String name, type;
		double cost;		
		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();
			//Execute the code
			stmt.executeQuery(Invoice.materialSearch);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(Invoice.materialSearch);
			//While there's code to be executes, do something
			while(rs.next()) {

				id = rs.getInt("material_id");
				name = rs.getString("material_name");
				type = rs.getString("material_type");
				cost = rs.getDouble("material_cost");
//asdwasad
//w
				Invoice.materialTable.insertRow(Invoice.materialTable.getRowCount(), new Object[] {Integer.toString(id), 
						name, type, Double.toString(cost)});
			}

			//If there's some error, return it
		} catch (SQLException e) {
			System.out.print(e);
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
	}

	public static void EditInvoice(String code) {


	}

	public static void LoadClients() {
		Invoice.clientsTable.setRowCount(0);
		String cmd = "SELECT * FROM studio";
		int id, costumes;
		String address, email, owner, phone, name;
		double bill = 0;


		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();
			//Execute the code
			stmt.executeQuery(cmd);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmd);
			//While there's code to be executes, do something
			while(rs.next()) {

				id = rs.getInt("studio_id");
				costumes = rs.getInt("studio_costumes");

				address = rs.getString("studio_address");
				email = rs.getString("studio_email");
				owner = rs.getString("studio_owner");
				phone = rs.getString("studio_phone");
				name = rs.getString("studio_name");

				bill = rs.getDouble("studio_bill");

//				System.out.println(id + " . " + name + " . " + costumes + " . " + bill + " . " + owner + " . " + address
//						+ " . " + phone + " . " + email);

//								Invoice.clientsTable.insertRow(Invoice.materialTable.getRowCount(), new Object[] {Integer.toString(id), Integer.toString(costumes), 
//										address, email, owner, phone, name, Double.toString(bill)});
			}

			//If there's some error, return it
		} catch (SQLException e) {
			System.out.print(e);
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}		
	}	
}
