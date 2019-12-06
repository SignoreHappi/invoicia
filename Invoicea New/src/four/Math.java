package four;

import database.Database;

public class Math {
	
	private static double Material;
	private static double Rhinestone;
	private static double Labour;
	private static double Deposit;
	
	private static double TAX;
	private static double Thread;
	private static double Hours;
	private static double Hourly;
	private static double [] Amount = new double[10];
	private static double [] Cost   = new double[10];
	
	

	public Math() {
		Invoice.writeOutput("☼", "Getting Information...");
		getInformation();
		Invoice.writeOutput("☼", "Building Material...");
		Material = Material();
		Done();
	}
	
	private void getInformation() {
		for (int i = 0; i < Invoice.selectedMaterials.length; i++) {
			if(Invoice.selectedMaterials[1][i] != null) {
				Amount[i] = Double.parseDouble(Invoice.selectedMaterials[1][i]);
				Cost[i] = Double.parseDouble(Invoice.selectedMaterials[2][i]);
			}
		}
		
		Database.GetValues();
		
		System.out.println(this.Thread);
		
	}
	
	private static double Material() {
		
		double total = 0;
		
		for(int i = 0; i < Amount.length; i++) {
			total = total + (Amount[i] * Cost[i]);
		}
		
		total = total * 2 + Thread;
		
		return total;
	}
	
	private static void Done() {
		Invoice.writeOutput("", "" + Material);
		
		Invoice.setLblsMaterialText("" + Material);
	}
	
	//--------------------------------------------------------// Getters and Setters //-------------------------------

	public static double getTax() {
		return TAX;
	}
	
	public static void setTax(double a) {
		TAX = a;
	}

	public static double getThread() {
		return Thread;
	}

	public static void setThread(double thread) {
		Thread = thread;
	}
	public static double getHours() {
		return Hours;
	}

	public static void setHours(double hours) {
		Hours = hours;
	}

	public static double getHourly() {
		return Hourly;
	}

	public static void setHourly(double hourly) {
		Hourly = hourly;
	}
}
