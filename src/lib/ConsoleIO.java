package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {

	// PRO TIP: Make sure to create a new BufferedReader in each method
	// where a BufferedReader is required. Do NOT close the reader as that will
	// cause
	// other issues. Also, catch ALL IOExceptions and NumberFormatExceptions.
	// Do not simply mark the method with a "throws" statement

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options
	 *            - Strings representing the menu options
	 * @param withQuit
	 *            - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int value = -1;
		boolean valid = false;
		System.out.print("Enter ");
		for (int i = 0; i < options.length; i++) {
			System.out.print((i + 1) + " to " + options[i]);
			if (withQuit) {
				if (i == options.length - 1)
					System.out.print(", or 0 to quit.");
				else if (i < options.length - 1)
					System.out.print(", ");
				else
					System.out.print("");
			}
			if (!withQuit) {
				if (i == options.length - 2)
					System.out.print(", or ");
				else if (i < options.length - 2)
					System.out.print(", ");
				else
					System.out.print(".");
			}
		}
		System.out.println();
		while (!valid) {
			try {
				value = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				System.err.print("Please enter a valid integer: ");
			}
			valid = value <= options.length && ((value >= 0 && withQuit) || (value > 0 && !withQuit));
		}
		return value;
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses that
	 * will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters "no",
	 * the method returns false. All other inputs are considered invalid, the user
	 * will be informed, and the prompt will repeat.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param trueString
	 *            - the case insensitive value that will evaluate to true
	 * @param falseString
	 *            - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	public static boolean promptForBool(String prompt, String trueString, String falseString) {
		String input = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(prompt + " (" + trueString + " or " + falseString + ")");
		do {
			try {
				if (input != null) {
					System.err.print("Please enter either " + trueString + " or " + falseString + ": ");
				}
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!input.equalsIgnoreCase(trueString) && !input.equalsIgnoreCase(falseString));
		return input.equalsIgnoreCase(trueString);
	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the byte value
	 */
	public static byte promptForByte(String prompt, byte min, byte max) {
		byte value;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = Byte.parseByte(reader.readLine());
			} catch (Exception e) {
				value = (byte) (min - 1);
			}
		} while (!(value <= max && value >= min));
		return value;

	}

	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the short value
	 */
	public static short promptForShort(String prompt, short min, short max) {
		short value;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = Short.parseShort(reader.readLine());
			} catch (Exception e) {
				value = (short) (min - 1);
			}
		} while (!(value <= max && value >= min));
		return value;

	}

	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the int value
	 */
	public static int promptForInt(String prompt, int min, int max) {
		int value;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = Integer.parseInt(reader.readLine());
			} catch (Exception e) {
				value = (int) (min - 1);
			}
		} while (!(value <= max && value >= min));
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the long value
	 */
	public static long promptForLong(String prompt, long min, long max) {
		long value;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = Long.parseLong(reader.readLine());
			} catch (Exception e) {
				value = (long) (min - 1);
			}
		} while (!(value <= max && value >= min));
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the float value
	 */
	public static float promptForFloat(String prompt, float min, float max) {
		float value;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = Float.parseFloat(reader.readLine());
			} catch (Exception e) {
				value = (float) (min - 1);
			}
		} while (!(value <= max && value >= min));
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the double value
	 */
	public static double promptForDouble(String prompt, double min, double max) {
		double value;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = Double.parseDouble(reader.readLine());
			} catch (Exception e) {
				value = (double) (min - 1);
			}
		} while (!(value <= max && value >= min));
		return value;
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns the
	 * String. When allowEmpty is true, empty responses are valid. When false,
	 * responses must contain at least one character (including whitespace).
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user.
	 * @param allowEmpty
	 *            - when true, makes empty responses valid
	 * @return the input from the user as a String
	 */
	public static String promptForInput(String prompt, boolean allowEmpty) {
		String input = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean valid;
		System.out.println(prompt);
		do {
			valid = true;
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(!allowEmpty && input.equalsIgnoreCase("")) {
				valid = false;
				System.out.println("You cannot enter an empty string");
			}
		} while(!valid);
		return input;
	}
	/**
	 * Generates a prompt that expects a single character input representing a char
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the char value
	 */
	public static char promptForChar(String prompt, char min, char max) {
		String value = "";
		boolean valid = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println(prompt + " (between " + min + " and " + max + ")");
			try {
				value = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();;
			}
			valid = !(value.length() == 1 && !(value.charAt(0) >= min && value.charAt(0) <= max));
		} while (!valid);
		return value.charAt(0);
	}

}
