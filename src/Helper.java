
/*
 * Assignment9
 * Helper class containing useful functions
 * Author:      Johannes Pertl
 * Last Change: 28.11.2018
 */
import java.util.Scanner;

public class Helper {

	// Prints a separator line
	public static void printSeparatorLine(int i) {
		System.out.println("-".repeat(i));
	}

	// Prints a header line
	public static void printHeaderLine(int i) {
		System.out.println("=".repeat(i));
	}

	// Returns input as a String
	public static String inputString(Scanner scanner) {
		while (true) {
			String i = scanner.nextLine();
			if (!i.equals("")) {
				return i;
			}
		}
	}

	// Prints a string and returns input as a string
	public static String inputStringFor(String text, Scanner scanner) {
		while (true) {
			System.out.print(text);
			String i = scanner.nextLine();
			if (!i.matches("\\s*")) {
				return i;
			}
		}
	}

	// Returns input as a String
	public static char inputCharFor(String text, Scanner scanner) {
		while (true) {
			System.out.print(text);
			String i = scanner.nextLine().trim();
			if (i.length() == 1) {
				return i.charAt(0);
			}
		}
	}

	// Get int as input
	public static int getIntInput(Scanner scanner) {
		int i = 0;
		if (scanner.hasNextInt()) {
			i = scanner.nextInt();
			scanner.nextLine();
		} else {
			scanner.nextLine();
		}
		return i;
	}

	// Get positive integer as input
	public static int parseIntPos(Scanner scanner) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				return -1;
			}
		}
	}

	public static int getInt(Scanner scanner) {
		return Integer.parseInt(scanner.nextLine());
	}

	// Prints a String passed to the function and returns input as an integer
	public static int getIntInputFor(String x, Scanner scanner) {
		while (true) {
			System.out.print(x);
			if (scanner.hasNextInt()) {
				scanner.nextInt();
			} else {
				scanner.nextLine();
			}
		}
	}

	// Prints a String passed to the function and returns a positive integer
	public static int getPosIntInputFor(String x, Scanner scanner) {
		int i = -1;
		while (i < 1) {
			System.out.print(x);
			if (scanner.hasNextInt()) {
				i = scanner.nextInt();
				scanner.nextLine();
			} else {
				scanner.nextLine();
			}
		}
		return i;
	}

	// Print a 2D Array
	public static void printMatrix(char[][] matrix) {
		for (char[] row : matrix) {
			for (char element : row) {
				System.out.printf("%s ", element);
			}
			System.out.println();
		}
	}

}
