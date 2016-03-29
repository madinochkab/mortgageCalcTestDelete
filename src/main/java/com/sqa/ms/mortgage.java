/**
 *   File Name: mortgage.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 28, 2016
 *
 */

package com.sqa.ms;

import java.util.*;

/**
 * mortgage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Siebenthal, Madina
 * @version 1.0.0
 * @since 1.0
 *
 */
public class mortgage {
	static double interest;
	static double monthlyPayment;
	static double principal;
	static String propertyID;
	static Scanner scanner = new Scanner(System.in);
	static double termInMonths;

	static String userName;
	// private static Object monthlyPayment;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		welcomeUserToApp();

		while (requestToContinue()) {
			RequestValues();
			calculatePayments();
			displayPayments();

		}
		farewellUser();
	}

	/**
	 *
	 */
	private static void calculatePayments() {
		System.out.println("calculate payment :\n----------------------");
		// monthlyPayment = (principal * interest) / (1 - Math.pow(1 + interest,
		// -termInMonths));
		monthlyPayment = Math.round((principal * interest) / (1 - Math.pow(1 + interest, -termInMonths)) * 100) / 100;

	}

	/**
	 *
	 */
	private static void displayPayments() {
		System.out.println("display payment:\n----------------------");
		System.out.println("your monthly payment is " + monthlyPayment + "per month for "
				+ Math.floor(termInMonths / 12) + " years and " + termInMonths % 12 + "months");

	}

	/**
	 *
	 */
	private static void farewellUser() {
		System.out.println("farewell user :\n----------------------");
		System.out.println(userName + " , thank you for using the mortgage calc application");
		scanner.close();

	}

	/**
	 * @return
	 */
	private static boolean requestToContinue() {
		System.out.println("Request to continue:\n----------------------");
		while (true) {
			System.out.print("would you like to calculate the mortgage?");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
				return true;

			} else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {

				return false;
			} else {
				System.out.println("invalid option (" + input + "), please use Yes/Y or No/N ");
			}
		}

	}

	/**
	 *
	 */
	private static void RequestValues() {
		System.out.println("Get Value from user:\n----------------------");
		System.out.print("whats your property id");
		String input = scanner.nextLine();
		propertyID = input;

		System.out.print("whats your property principal");
		input = scanner.nextLine();
		principal = Double.parseDouble(input);

		System.out.print("whats your property interest");
		input = scanner.nextLine();
		interest = Double.parseDouble(input);

		System.out.print("whats your property term in month");
		input = scanner.nextLine();
		termInMonths = Double.parseDouble(input);

	}

	/**
	 *
	 */
	private static void welcomeUserToApp() {
		System.out.println("Welcome user to app:\n----------------------");
		System.out.println("welcome to mortgage calc app");
		System.out.println("what's your name");
		userName = scanner.nextLine();

	}

}
