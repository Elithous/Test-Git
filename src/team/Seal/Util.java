package team.Seal;

import java.util.Scanner;

public class Util {
	private static Scanner scan = new Scanner(System.in);

	public static void sleep() {
		scan.nextLine();
	}
	
	public static void sleep(int mili) {
		try {
		Thread.sleep((long)mili);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
