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
	private static double GroupRate;
	private static double SoloRate;
	
	private static int kids;
	
	private static double [] Amount = new double[10];
	private static double [] Cost   = new double[10];
	
	private static boolean GroupOrKids;
	
	

	public Math() {
		getInformation();
		Material = Material();
		Labour = Labour();
		Done();
	}
	
	private void getInformation() {
		for (int i = 0; i < 10; i++) {
			if(Invoice.selectedMaterials[1][i] != null) {
				Amount[i] = Double.parseDouble(Invoice.selectedMaterials[1][i]);
				Cost[i] = Double.parseDouble(Invoice.selectedMaterials[2][i]);
			}else {
				break;
			}
		}
		
		kids = (int)Invoice.spnK.getValue();
		
		Database.GetValues();
		
		try {
			Hours = (double) Invoice.getSpnHHValue();
		} catch (Exception e) {
//			e.printStackTrace();
			Invoice.writeOutput("ERROR", "ERROR IS UNDEFINED");
		}
		
		if(Invoice.getRdbGroupBool()) {
			GroupOrKids = true;
		}else {
			GroupOrKids = false;
		}
		
	}
	
	private static double Material() {
		
		double total = 0;
		
		for(int i = 0; i < Amount.length; i++) {
			total = total + (Amount[i] * Cost[i]);
		}
		
		total = total * 2 + Thread;
		
		return total;
	}
	
	private static double Rhinestones() {
		return 0;
	}
	
	private static double Labour() {
		
		double total = 0;
		
		if(Hours == 0 && GroupOrKids == true) {
			Hours = kids * GroupRate;
			Invoice.spnHH.setValue(Hours);
		}else if(Hours == 0 && GroupOrKids == false) {
			Hours = kids * SoloRate;
			Invoice.spnHH.setValue(Hours);
		}
		
		if(GroupOrKids) {
			total = Hours * Hourly * GroupRate;
		}else {
			total = Hours * Hourly * SoloRate;
		}
		
		return total;
	}
	
	private static void Done() {
		Invoice.writeOutput("", "" + Labour);
		
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
	
	public static double getGroupRate() {
		return GroupRate;
	}

	public static void setGroupRate(double groupRate) {
		GroupRate = groupRate;
	}

	public static double getSoloRate() {
		return SoloRate;
	}

	public static void setSoloRate(double soloRate) {
		SoloRate = soloRate;
	}

}
