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

	//	public static void ExportDB() throws InterruptedException, IOException {
	//		String cmd = "mysqldump -h remotemysql.com -P 3306 -u ZYebHXfmH9 -p AIRtr96APu –database ZYebHXfmH9 > backup.sql";		
	//		Process runtimeProcess =Runtime.getRuntime().exec(cmd);
	//		int processComplete = runtimeProcess.waitFor();
	//		if(processComplete == 0){
	//
	//			System.out.println("Backup taken successfully");
	//
	//		} else {
	//
	//			System.out.println("Could not take mysql backup");
	//
	//		}
	//	}

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
		String cmd = "INSERT INTO invoice(code, invoice_name, studio_id, invoice_id, year, "
				+ "material_1, amount_1, material_2, amount_2, material_3, amount_3, material_4, amount_4,material_5, amount_5,material_6, amount_6,"
				+ "material_7, amount_7, material_8, amount_8, material_9, amount_9, material_10, amount_10) "
				+ "VALUES(?, ?, ?, ?, ?, "
				+ "?,?, ?,?, ?,?, ?,?, ?,?, ?,?, "
				+ "?,?, ?,?, ?,?, ?,?)";		
		String code = null;


		if(invcName.equals("101") || invcName.equals("Fill") || invcName.equals("Clear all")) {
			SaveInvoices(studio_id, invcName);
		}else {
			code = CreateCode(studio_id, iYear, 0);
			try{
				connect = DBConnect.connectDB();
				PreparedStatement pstmt = connect.prepareStatement(cmd);
				pstmt.setString(1, code);
				pstmt.setString(2, invcName);
				pstmt.setInt(3, studio_id);
				pstmt.setInt(4, 1);
				pstmt.setInt(5, iYear);
				int count = 1;
				for(int i = 0; i<10; i++) {
					if(Invoice.selectedMaterials[0][i] == null) {
						pstmt.setString(5 + count, null);
						count++;
						pstmt.setString(5 + count, null);
						count++;
					}else {
						String name = Invoice.selectedMaterials[0][i];
						if(selectedMaterials[0][i].contains("\"")) {						
							name = selectedMaterials[0][i].replace("\"", "#");
						}
						name = SeparateName(name);
						pstmt.setString(5 + count, name);
						count++;
						pstmt.setString(5 + count, Invoice.selectedMaterials[1][i]);
						count++;
					}
				}
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


	public static String SeparateName(String nameType) {
		//		int index = nameType.indexOf(".");

		//		String name = nameType.substring(0, index);
		//		String type = nameType.substring(index+1);
		//		name = name + " " + type;
		//		System.out.println(name);
		return nameType.replace(".", " ");

	}

	//If the studio has an invoice, create a new one with invoice_id+1
	public static int CreateInvoice(int studio_id, int invoice_id, int iYear, String invcName) {
		Invoice.result = 0;
		String cmd = "INSERT INTO invoice(code, invoice_name, studio_id, invoice_id, year, "
				+ "material_1, amount_1, material_2, amount_2, material_3, amount_3, material_4, amount_4,material_5, amount_5,material_6, amount_6,"
				+ "material_7, amount_7, material_8, amount_8, material_9, amount_9, material_10, amount_10) "


				+ "VALUES(?, ?, ?, ?, ?, "
				+ "?,?, ?,?, ?,?, ?,?, ?,?, ?,?, "
				+ "?,?, ?,?, ?,?, ?,?)";
		int inv = invoice_id+1;
		String code = null;
		//\\//FOR TESTING ONLY	 //\\//		//\\//		//\\//		//\\//		//\\//		//\\//


		if(invcName.equals("101")) {
			invcName = "Test" + inv + "";
			iYear = (int) (Math.random() * 20 );
			System.out.println("random year: " + iYear);
			if(iYear < 10) {
				String year = "0" + iYear;
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
			int count = 1;
			for(int i = 0; i<10; i++) {
				if(Invoice.selectedMaterials[0][i] == null) {
					pstmt.setString(5 + count, null);
					count++;
					pstmt.setString(5 + count, null);
					count++;
				}else {
					String name = Invoice.selectedMaterials[0][i];
					if(selectedMaterials[0][i].contains("\"")) {						
						name = selectedMaterials[0][i].replace("\"", "#");
					}
					name = SeparateName(name);


					pstmt.setString(5 + count, name);
					count++;
					pstmt.setString(5 + count, Invoice.selectedMaterials[1][i]);
					count++;
				}
			}


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

	public static void LoadMaterials(boolean typers){
		Invoice.homeMaterialTbl.setRowCount(0);
		Invoice.materialTable.setRowCount(0);
		Invoice.txtSearchMaterial.setText("");;
		String cmd;

		if(typers == false) {
			cmd = "SELECT * FROM material ORDER BY material_name ASC";
		}else {
			cmd = "SELECT * FROM material ORDER BY material_type ASC";
		}
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

				if(name.contains("#")) {
					int index = name.indexOf("#");
					String subName = name;
					name = subName.substring(0, index);
					name = name + "\" " + subName .substring(index+1);
				}

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
				Invoice.cmbStudio.addItem(name);
				Invoice.cmbStudioName.addItem(name);

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
				four.Mathe.setTax(rs.getDouble("tax"));
				four.Mathe.setHourly(rs.getDouble("hours"));
				four.Mathe.setThread(rs.getDouble("thread"));
				four.Mathe.setGroupRate(rs.getDouble("groupRate"));
				four.Mathe.setSoloRate(rs.getDouble("soloRate"));

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

	public static String StartInvoice() {

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


			while (rs.next()) {
				four.Invoice.spnSolo.setValue(rs.getDouble("soloRate"));
				four.Invoice.spnGroup.setValue(rs.getDouble("groupRate"));

				four.Mathe.setHourly(rs.getDouble("hours"));
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




	//Insert a new material into the table
	public static boolean CreateClient(String name, String owner, String address, String phoneNumber, String email){
		String studio_name = null, studio_owner = null, studio_email = null;
		String cmdSearch = "SELECT * FROM studio";
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
				studio_name = rs.getString("studio_name");
				studio_owner = rs.getString("studio_owner");
				studio_email = rs.getString("studio_email");
				if(name.equals(studio_name) || owner.equals(studio_owner) || email.equals(studio_email)) {
					Invoice.writeMatOutput("Error", "The client is already in the DataBase");
					add = false;
					break;
				}
			}
			if(add) {
				String studio = name + ", " + owner;

				Invoice.writeMatOutput("Added", studio + "");
				System.out.println("helo");
				String cmd = "INSERT INTO studio(studio_name, studio_owner, studio_email, studio_phone, studio_address) VALUES(?, ?, ?, ?, ?)";

				String changedName = Strin.FirstCapital(name);
				String changedOwner = Strin.FirstCapital(owner);

				//				System.out.println(name);
				//				System.out.println(changedName);
				try{
					PreparedStatement pstmt = connect.prepareStatement(cmd);			
					pstmt.setString(1, changedName);
					pstmt.setString(2, changedOwner);
					pstmt.setString(3, email);
					pstmt.setString(4, phoneNumber);
					pstmt.setString(5, address);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Create Client");
					System.out.println(e);
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


	public static void LoadYear(int studioId) {
		//		System.out.println(studioId);		
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
				}//aaa
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


	public static boolean CreateDate(String date){
		String cmdSearch = "SELECT * FROM settings";
		boolean add = true;
		try {
			connect = DBConnect.connectDB();
			stmt = connect.prepareStatement(cmdSearch);			
			//Create the code
			//Execute the code
			stmt.executeQuery(cmdSearch);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmdSearch);
			while(rs.next()) {//Working
				//				material_name = rs.getString(2);

			}
			String cmd = "UPDATE `settings` SET `lastDate`= ? WHERE 1";

			try{
				PreparedStatement pstmt = connect.prepareStatement(cmd);			
				pstmt.setString(1, date);
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Create Date ERROR");
				System.out.println(e.getMessage());
				return false;
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

	public static void RetrieveInvoice(String studio, String year, String invoice) {
		String cmd = "SELECT * FROM invoice WHERE studio_id = " + studio + " AND invoice_name = \"" + invoice + "\" AND year = " + year;

		try {
			connect = DBConnect.connectDB();
			stmt = connect.prepareStatement(cmd);			
			//Create the code
			//Execute the code
			stmt.executeQuery(cmd);
			//For every possible execution, create a rs
			ResultSet rs = stmt.executeQuery(cmd);
			while(rs.next()) {//Working
				
				//Get the Invoice name
				Invoice.txtCostumeName.setText(rs.getString(3));
				
				
				//Get all the materials/amounts 
				int count = 1;
				for(int i = 0; i<10; i++) {
					if(rs.getString(5 + count) != null) {
						String name = rs.getString(5+count);
						name = name.replace("#", "\"");


						switch(i) {
						case 0:
							Invoice.lblMaterialName0.setText("1.    " + name);
							count++;
							Invoice.lblMaterialAmount0.setText(rs.getString(5+count));
							count++;
							Invoice.lblX0.setText(" X");
							break;
						case 1:
							Invoice.lblMaterialName1.setText("2.    " + name);
							count++;
							Invoice.lblMaterialAmount1.setText(rs.getString(5+count));
							count++;
							Invoice.lblX1.setText(" X");
							break;
						case 2:
							Invoice.lblMaterialName2.setText("3.    " + name);
							count++;
							Invoice.lblMaterialAmount2.setText(rs.getString(5+count));
							count++;
							Invoice.lblX2.setText(" X");
							break;
						case 3:
							Invoice.lblMaterialName3.setText("4.    " + name);
							count++;
							Invoice.lblMaterialAmount3.setText(rs.getString(5+count));
							count++;
							Invoice.lblX3.setText(" X");
							break;
						case 4:
							Invoice.lblMaterialName4.setText("5.    " + name);
							count++;
							Invoice.lblMaterialAmount4.setText(rs.getString(5+count));
							count++;
							Invoice.lblX4.setText(" X");
							break;
						case 6:
							Invoice.lblMaterialName6.setText("7.    " + name);
							count++;
							Invoice.lblMaterialAmount6.setText(rs.getString(5+count));
							count++;
							Invoice.lblX6.setText(" X");
							break;
						case 7:
							Invoice.lblMaterialName7.setText("8.    " + name);
							count++;
							Invoice.lblMaterialAmount7.setText(rs.getString(5+count));
							count++;
							Invoice.lblX7.setText(" X");
							break;
						case 8:
							Invoice.lblMaterialName8.setText("9.    " + name);
							count++;
							Invoice.lblMaterialAmount8.setText(rs.getString(5+count));
							count++;
							Invoice.lblX0.setText(" X");
							break;
						case 9:
							Invoice.lblMaterialName9.setText("10.    " + name);
							count++;
							Invoice.lblMaterialAmount9.setText(rs.getString(5+count));
							count++;
							Invoice.lblX9.setText(" X");
							break;
						}
					}else {
						break;
					}
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


	}

}
