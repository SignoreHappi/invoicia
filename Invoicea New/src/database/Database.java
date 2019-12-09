package database;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.table.DefaultTableModel;

import four.Invoice;
import Utilities.Strin;



//ALTER TABLE material AUTO_INCREMENT = 100  - > CODE TO CHANGE ID VALUE


public class Database extends Invoice{
	public static Connection connect;
	public static Statement stmt = null;

	public static void ExportDB() throws InterruptedException, IOException {
		String cmd = "mysqldump -h remotemysql.com -P 3306 -u ZYebHXfmH9 -p AIRtr96APu –database ZYebHXfmH9 > backup.sql";		
		Process runtimeProcess =Runtime.getRuntime().exec(cmd);
		int processComplete = runtimeProcess.waitFor();
		if(processComplete == 0){

			System.out.println("Backup taken successfully");

		} else {

			System.out.println("Could not take mysql backup");

		}
	}

	//Creates the code with the studio_id-year-invoic_id 
	public static String CreateCode(int studio_id, int year, int invoice_id) {	
		String dash = "-00";
		if(invoice_id > 9) {
			dash = "-0";
		}else if(invoice_id > 99) {
			dash = "-";
		}


		String code = "0" + studio_id + "-" + year + dash + invoice_id;
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
			System.out.println("Has Invoice");
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

	public static void SaveInvoices(int studio_id, String invcName) {
		/*
		 * CODES FOR SAVE
		 * 
		 * 101  	 - Sets the name of the invoice as Test, gives a random year
		 * Fill 	 - Creates 5 invoices with name Fill for each studio with random years
		 * Clear all - Delete all the invoices created by fill, if none, does nothing
		 * 
		 * */
		int year;


		if(invcName.equals("101")) {
			invcName = "Test" + 1 + "";
			year = (int) (Math.random() * 20 );
			//			System.out.println("random year: " + iYear);
			if(year < 10) {
				//				System.out.println("aaaaaaaaaa");
				//				String year = "0" + iYear;
				//				System.out.println(year);
				//				iYear = Integer.parseInt(year);
				//				System.out.println(iYear);
			}
		}else if(invcName.equals("Fill")) {

		}else if(invcName.equals("Clear all")) {

		}

	}

	//If the studio has no invoice, create a new one starting from studio_id 1
	public static void CreateNewInvoice(int studio_id, int iYear, String invcName) {
		Invoice.result = 0;
		String cmd = "INSERT INTO invoice(code, invoice_name, studio_id, invoice_id, year) VALUES(?, ?, ?, ?, ?)";
		String code = null;


		if(invcName.equals("101") || invcName.equals("Fill") || invcName.equals("Clear all")) {
			SaveInvoices(studio_id, invcName);
		}else {
			code = CreateCode(studio_id, iYear, 0);
			try{
				connect = DBConnect.connectDB();
				PreparedStatement pstmt = connect.prepareStatement(cmd);
				//Create a new item into the DB in the position 1 with the value defined
				pstmt.setString(1, code);
				pstmt.setString(2, invcName);
				pstmt.setInt(3, studio_id);
				pstmt.setInt(4, 1);
				pstmt.setInt(5, iYear);
				//Update the DB
				pstmt.executeUpdate();

				Invoice.writeOutput("Invoice Saved", "Studio ID: " + studio_id + "; Name: " + invcName + "; Year: " + iYear);
			} catch (SQLException e) {
				System.out.println("Create New Invoice");
				System.out.println(e);
				System.out.println(e.getMessage());
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

	//If the studio has an invoice, create a new one with invoice_id+1
	public static int CreateInvoice(int studio_id, int invoice_id, int iYear, String invcName) {
		Invoice.result = 0;
		String cmd = "INSERT INTO invoice(code, invoice_name, studio_id, invoice_id, year) VALUES(?, ?, ?, ?, ?)";
		int inv = invoice_id+1;
		String code = null;
		//\\//FOR TESTING ONLY	 //\\//		//\\//		//\\//		//\\//		//\\//		//\\//


		if(invcName.equals("101")) {
			invcName = "Test" + inv + "";
			iYear = (int) (Math.random() * 20 );
			System.out.println("random year: " + iYear);
			if(iYear < 10) {
				String year = "0" + iYear;
				System.out.println(year);
				iYear = Integer.parseInt(year);
			}
		}
		//\\//		//\\//		//\\//		//\\//		//\\//		//\\//		//\\//		//\\//
		code = CreateCode(studio_id, iYear, inv);

		try{
			connect = DBConnect.connectDB();
			PreparedStatement pstmt = connect.prepareStatement(cmd);
			pstmt.setString(1, code);
			pstmt.setString(2, invcName);
			pstmt.setInt(3, studio_id);
			pstmt.setInt(4, inv);
			pstmt.setInt(5, iYear);
			pstmt.executeUpdate();
			//			System.out.print("Saved");

			Invoice.writeOutput("Invoice Saved", "Studio ID: " + studio_id + "; Name: " + invcName + "; Year: " + iYear);
			return 1;
		} catch (SQLException e) {
			System.out.println("Create Invoice");
			System.out.println(e.getMessage());
			return 2;
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}

	}

	//Insert a new material into the table
	public static boolean CreateMaterial(String name, String cost, String type){
		String material_name = null, material_type = null;
		String cmdSearch = "SELECT * FROM material WHERE material_name = \"" + name + "\" AND material_type = \"" + type + "\"";
		boolean add = true;
		try {
			connect = DBConnect.connectDB();
			stmt = connect.prepareStatement(cmdSearch);			
			//Create the code
			//Execute the code
			stmt.executeQuery(cmdSearch);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmdSearch);
			//While there's code to be executes, do something
			while(rs.next()) {//Working
				material_name = rs.getString(2);
				material_type = rs.getString(3);
				if(name.equals(material_name) && type.equals(material_type)) {
					Invoice.writeMatOutput("Error", "The material is already in the DataBase");
					add = false;
					break;
				}
			}
			if(add) {
				String material = name + ", " + type + ", $" + cost;

				Invoice.writeMatOutput("Added", material + "");
				String cmd = "INSERT INTO material(material_name, material_cost, material_type) VALUES(?, ?, ?)";
				//In case the user uses , instead of . the program will replace it
				String newCost = cost.replace(",", ".");		

				double dCost = Double.parseDouble(newCost);

				String changedName = Strin.FirstCapital(name);

				//				System.out.println(name);
				//				System.out.println(changedName);
				try{
					PreparedStatement pstmt = connect.prepareStatement(cmd);			
					pstmt.setString(1, changedName);
					pstmt.setDouble(2, dCost);
					pstmt.setString(3, type);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Create Material");
					System.out.println(e.getMessage());
					return false;
				}
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}


		return true;

	}

	public static void LoadMaterials(){
		Invoice.homeMaterialTbl.setRowCount(0);
		Invoice.materialTable.setRowCount(0);
		Invoice.txtSearchMaterial.setText("");;
		String cmd = "SELECT * FROM material ORDER BY material_name ASC";
		int id;
		String name, type;
		double cost;


		try {
			//Create the code
			connect = DBConnect.connectDB();
			stmt = connect.prepareStatement(cmd);			
			//Create the code
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

				//				Builds the price with .00 in the end
				StringBuilder sbuf = new StringBuilder();
				Formatter fmt = new Formatter(sbuf);
				fmt.format("$%.2f%n", cost);

				Invoice.materialTable.insertRow(Invoice.materialTable.getRowCount(), new Object[] {Integer.toString(id), 
						name, type, fmt});
				Invoice.homeMaterialTbl.insertRow(Invoice.homeMaterialTbl.getRowCount(), new Object[] {name, type, fmt});
			}

			//If there's some error, return it
		} catch (SQLException e) {
			System.out.println("Load Material");
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

	public static void SearchMaterial(String materialSearch) {
		Invoice.materialTable.setRowCount(0);
		//		char typed = enter.getKeyChar();
		//		//		String letter = typed.substring(55, 56);
		//		if(typed == 'a' || typed == 'b' || typed == 'c' || typed == 'd' || typed == 'e'||  typed == 'f' || typed == 'g' || typed == 'h' || typed == 'i' || typed == 'j' || typed == 'k' || typed == 'l' || typed == 'm' || typed == 'n' || typed == 'o' || typed == 'p' || typed == 'q' || typed == 'r' || typed == 's' || typed == 't' || typed == 'u' || typed == 'v' || typed == 'w' || typed == 'x' || typed == 'y' || typed == 'z' ||  
		//				typed == 'A' || typed == 'B' || typed == 'C' || typed == 'D' || typed == 'E'||  typed == 'F' || typed == 'G' || typed == 'H' || typed == 'I' || typed == 'J' || typed == 'K' || typed == 'L' || typed == 'M' || typed == 'N' || typed == 'O' || typed == 'P' || typed == 'Q' || typed == 'R' || typed == 'S' || typed == 'T' || typed == 'U' || typed == 'V' || typed == 'W' || typed == 'X' || typed == 'Y' || typed == 'Z' ||
		//				typed == '1' || typed == '2' || typed == '3' || typed == '4' || typed == '5' || typed == '6' || typed == '7' || typed == '8' || typed == '9' || typed == '0') {
		//			if(materialSearch == null) {
		//				Invoice.materialSearch = Character.toString(typed);
		//			}else {
		//				Invoice.materialSearch = Invoice.materialSearch + Character.toString(typed);
		//			}
		//			System.out.println(Invoice.materialSearch);
		//
		//		}			
		//
		//
		//		if(enter.getKeyCode() == KeyEvent.VK_BACK_SPACE && Invoice.materialSearch.length() > 0) {
		//			Invoice.materialSearch = Invoice.materialSearch.substring(0, Invoice.materialSearch.length()-1);
		//		}
		//
		//		if(enter.getKeyCode() == KeyEvent.VK_TAB) {
		//
		//		}

		String cmd = "SELECT * FROM material WHERE material_name LIKE \"%" + materialSearch + "%\" ORDER BY material_name ASC";
		//		String cmd = "SELECT * FROM material WHERE material_name = " + "\"" + materialSearch + "\"";
		System.out.println(cmd);
		int id;
		String name, type;


		double cost;		
		try {
			//Create the code
			connect = DBConnect.connectDB();
			stmt = connect.prepareStatement(cmd);
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
				//hi
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





	public static void EditInvoice(String code) {


	}

	public static void LoadClients() {
		//		Invoice.testTable.setRowCount(0);
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
				name = rs.getString("studio_name");    
				owner = rs.getString("studio_owner");
				phone = rs.getString("studio_phone");

				bill = rs.getDouble("studio_bill");

				//				System.out.println(id + " . " + name + " . " + costumes + " . " + bill + " . " + owner + " . " + address
				//						+ " . " + phone + " . " + email);
				Object[] row = new Object[] {Integer.toString(id), name, Integer.toString(costumes), 
						Double.toString(bill), owner, address, phone, email};
				Invoice.rows.addRow(row);				
			}

			//If there's some error, return it
		} catch (SQLException e) {
			System.out.print(e);
		}	

	}

	public static void getPrices() {
		// TODO Auto-generated method stub
		String cmd = null;

		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();

			for(int i = 0; i < 10; i++) {
				if(Invoice.selectedMaterials[0][i] != null) {

					String name = Invoice.selectedMaterials[0][i];

					int index = name.indexOf(".");
					String type = name.substring(index+1); 
					name = name.substring(0, index);
					//					Invoice.selectedMaterials[0][i] = name;
					cmd =  "SELECT * FROM material where material_name = " + "\"" + name + "\" and material_type = " + "\"" + type + "\"";
					//				
					//				//Execute the code
					stmt.executeQuery(cmd);
					//				//For every possible execution, create a rs
					ResultSet rs = stmt.executeQuery(cmd);
					//				//While there's code to be executes, do something
					//				
					//				
					while(rs.next()) {					
						double price = rs.getDouble("material_cost");
						Invoice.selectedMaterials[2][i] = price + "";
					}
				}else {
					break;
				}

			}
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

	public static String GetValues() {

		// TODO Auto-generated method stub
		String cmd = null;

		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();


			cmd =  "SELECT * FROM settings";

			//						
			//						//Execute the code
			stmt.executeQuery(cmd);
			//						//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmd);
			//						//While there's code to be executes, do something
			//						
			//						
			//							while(rs.next()) {					
			//								double price = rs.getDouble("material_cost");
			//								Invoice.selectedMaterials[2][i] = price + "";
			//							}


			while (rs.next()) {
				four.Math.setTax(rs.getDouble("tax"));
				four.Math.setHourly(rs.getDouble("hours"));
				four.Math.setThread(rs.getDouble("thread"));
			}

			//							four.Math.setTax(taxi);




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
		return "";

	}

	public static void LoadYear(int studioId) {
		System.out.println(studioId);		
		Invoice.cmbYear.removeAllItems();
		String cmd = "SELECT * FROM invoice WHERE studio_id = " + studioId + " ORDER BY year ASC";
		int previous = -10, year = -1;
		//
		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();
			stmt.executeQuery(cmd);
			ResultSet rs = stmt.executeQuery(cmd);
			while(rs.next()) {	
				year = rs.getInt("year");
				String sYear = year + "";
				if(year != previous) {
					if(year<10) {
						sYear = "0" + sYear;
					}
					Invoice.cmbYear.addItem(sYear+"");
				}
				previous = year;
			}
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

	public static void GetCreatedInvoices(int studio_id, String year) {
		Invoice.cmbInvoiceId.removeAllItems();
		String cmd = "SELECT * FROM invoice WHERE studio_id = " + studio_id + " AND year = " + year + " ORDER BY invoice_name ASC";
		String name;
		try {
			//Create the code
			connect = DBConnect.connectDB();
			//Create the code
			stmt = connect.createStatement();
			stmt.executeQuery(cmd);
			ResultSet rs = stmt.executeQuery(cmd);
			while(rs.next()) {					
				name = rs.getString("invoice_name");
				Invoice.cmbInvoiceId.addItem(name);

			}
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
