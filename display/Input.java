package display;

import java.util.Scanner;

public class Input {

	private static Scanner input = new Scanner(System.in);
	
	public static int getIntOption(int min, int max) {
		int opt = -999;
		
		while (opt < min || opt > max) {
			System.out.print(">>>");
			opt = input.nextInt();
		}
	
		return opt;
	}
	
	
	private static boolean searchStringOptions(String[] options, String in) {
		for (String s: options) {
			if (in.equalsIgnoreCase(s)){
				return true;
			}
		}
		return false;
	}
	
	
	public static String getStringInput(String prompt) {
		System.out.println(prompt + "\n>>>");
		return input.next();
	}
	
	
	public static String getStringOption(String...strings) {
		String opt = "adsdsadsa";
		
		while (!searchStringOptions(strings, opt) ) {
			System.out.print(">>>");
			opt = input.nextLine();
		}
	
		return opt;
		
	}
}
