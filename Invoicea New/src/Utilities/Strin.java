package Utilities;

public class Strin {
	
	public static String FirstCapital(String a) {
		String frstL = a.substring(0,1);
		int letter;
		try {
			letter = Integer.parseInt(frstL);
			return a;
		}catch(Exception e){
			frstL.toUpperCase();
			return frstL + a.substring(1) + "";
		}
		
		
		
		
	}
	
}
