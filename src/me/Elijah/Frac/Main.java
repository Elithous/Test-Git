package me.Elijah.Frac;

import lib.ConsoleIO;

public class Main {
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		boolean loop = true;
		int input;
		int[] fraction;
		do {
			input = ConsoleIO.promptForMenuSelection(new String[] { "reduce fraction", "perform faction math" }, true);
			switch (input) {
			case 0:
				loop = false;
				break;
			case 1:
				fraction = reduceFraction();
				printFraction(fraction, true);
				break;
			case 2:
				loop = fractionMath();
				break;
			}
		} while (loop);
	}

	private static boolean fractionMath() {
		boolean loop = true;
		int input;

		do {
			input = ConsoleIO.promptForMenuSelection(
					new String[] { "add", "subtract", "multiply", "divide", "go to main menu" }, true);
			switch (input) {
			case 0:
				return false;
			case 1:
				add();
				break;
			case 2:
				subtract();
				break;
			case 3:
				multiply();
				break;
			case 4:
				divide();
				break;
			case 5:
				loop = false;
				break;
			}
		} while (loop);

		return true;
	}

	private static void divide() {
		int[] frac1 = getFraction("Enter the first fraction");
		int[] frac2 = getFraction("Enter the second fraction");

		//int value = frac1[0] * frac2[0];
		int num1 = frac1[1] + ((frac1[0]) * frac1[2]);
		int num2 = frac2[1] + ((frac2[0]) * frac2[2]);
		int num = (num1) * (frac2[2]);
		int denom = frac1[2] * num2;

		int[] frac = reduceFraction(new int[] { 0, num, denom });
		printFraction(frac1, false);
		System.out.print("/ ");
		printFraction(frac2, false);
		System.out.print("= ");
		printFraction(frac, true);
	}

	private static void multiply() {
		int[] frac1 = getFraction("Enter the first fraction");
		int[] frac2 = getFraction("Enter the second fraction");

		//int value = frac1[0] * frac2[0];
		int num1 = frac1[1] + ((frac1[0]) * frac1[2]);
		int num2 = frac2[1] + ((frac2[0]) * frac2[2]);
		int num = (num1) * (num2);
		int denom = frac1[2] * frac2[2];

		int[] frac = reduceFraction(new int[] { 0, num, denom });
		printFraction(frac1, false);
		System.out.print("* ");
		printFraction(frac2, false);
		System.out.print("= ");
		printFraction(frac, true);
	}

	private static void subtract() {
		int[] frac1 = getFraction("Enter the first fraction");
		int[] frac2 = getFraction("Enter the second fraction");

		int num1 = frac1[1] + ((frac1[0]) * frac1[2]);
		int num2 = frac2[1] + ((frac2[0]) * frac2[2]);
		int num = (num1 * frac2[2]) - (num2 * frac1[2]);
		int denom = frac1[2] * frac2[2];
		int[] frac = reduceFraction(new int[] { 0, num, denom });
		printFraction(frac1, false);
		System.out.print("- ");
		printFraction(frac2, false);
		System.out.print("= ");
		printFraction(frac, true);
	}

	private static void add() {
		int[] frac1 = getFraction("Enter the first fraction");
		int[] frac2 = getFraction("Enter the second fraction");

		int num1 = frac1[1] + ((frac1[0]) * frac1[2]);
		int num2 = frac2[1] + ((frac2[0]) * frac2[2]);
		int num = (num1 * frac2[2]) + (num2 * frac1[2]);
		int denom = frac1[2] * frac2[2];

		int[] frac = reduceFraction(new int[] { 0, num, denom });
		printFraction(frac1, false);
		System.out.print("+ ");
		printFraction(frac2, false);
		System.out.print("= ");
		printFraction(frac, true);
	}

	private static int[] getFraction(String prompt) {
		boolean loop = true;

		String input = ConsoleIO.promptForInput(prompt, false);
		String[] temp;

		int value = 0;
		int num = 0;
		int denom = 1;
		do {
			value = 0;
			num = 0;
			denom = 1;
			try {
				temp = input.split("(/| )");
				if (temp.length == 3) {
					value = Integer.parseInt(temp[0]);
					num = Integer.parseInt(temp[1]);
					denom = Integer.parseInt(temp[2]);
				} else if (temp.length == 2) {
					num = Integer.parseInt(temp[0]);
					denom = Integer.parseInt(temp[1]);
				} else if (temp.length == 1) {
					value = Integer.parseInt(temp[0]);
				} else
					throw new Exception();
				if (denom == 0) {
					System.err.println("YOU CANNOT DIVIDE BY 0!");
					throw new Exception();
				}
				loop = false;
			} catch (Exception e) {
				input = ConsoleIO.promptForInput("Please enter a VALID fraction (example: 1 1/2)", false);
			}
		} while (loop);
		return new int[] { value, num, denom };
	}

	private static int[] reduceFraction() {
		int[] temp = getFraction("Please enter a fraction");
		return reduceFraction(temp);
	}

	private static int[] reduceFraction(int[] fraction) {
		int[] temp = fraction;

		int value = temp[0];
		int num = temp[1];
		int denom = temp[2];

		value += num / denom;
		num = num % denom;

		for (int div = num; div >= 2; div--) {
			if (num % div == 0 && denom % div == 0) {
				num = num / div;
				denom = denom / div;
				//div++;
			}
		}
		return new int[] { value, num, denom };
	}

	private static void printFraction(int[] fraction, boolean decimal) {
		int value = fraction[0];
		int num = fraction[1];
		int denom = fraction[2];

		// System.out.print("The reduced value is ");
		if (value != 0)
			System.out.print(value + " ");
		if (num != 0)
			System.out.print(num + "/" + denom + " ");
		if (value == 0 && num == 0)
			System.out.print("0 ");
		// System.out.println(". Or in decimal it is " + ((double) value + ((double) num
		// / (double) denom)));
		if (decimal) {
			System.out.println("or " + ((double) value + ((double) num / (double) denom)));
		}
	}

}
