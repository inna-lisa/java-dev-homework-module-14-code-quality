package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoxGame {
	private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';
	private static final Scanner SCAN = new Scanner(System.in);

	private BoxGame() {
	}

	public static void run() {
		System.out.println("Enter box number to select. Enjoy!\n");

		while (true) {
			BoxGame.printBox();
			if (BoxGame.isWin()) {
				break;
			}
			BoxGame.playersMove();
		}
		BoxGame.SCAN.close();
	}

	private static void printBox() {
		System.out.println("\n\n " + BOX[0] + " | " + BOX[1] + " | " + BOX[2] + " ");
		System.out.println("-----------");
		System.out.println(" " + BOX[3] + " | " + BOX[4] + " | " + BOX[5] + " ");
		System.out.println("-----------");
		System.out.println(" " + BOX[6] + " | " + BOX[7] + " | " + BOX[8] + " \n");
	}

	private static boolean isWin() {
		if (ifIsWin(PLAYER_X)) {
			System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
			return true;
		}

		if (ifIsWin(PLAYER_O)) {
			System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
			return true;
		}

		if (!isBoxAvailable()) {
			System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
			return true;
		}
		return false;
	}

	private static boolean ifIsWin(char player){
		return (BOX[0] == player && BOX[1] == player && BOX[2] == player)
				|| (BOX[3] == player && BOX[4] == player && BOX[5] == player)
				|| (BOX[6] == player && BOX[7] == player && BOX[8] == player)
				|| (BOX[0] == player && BOX[3] == player && BOX[6] == player)
				|| (BOX[1] == player && BOX[4] == player && BOX[7] == player)
				|| (BOX[2] == player && BOX[5] == player && BOX[8] == player)
				|| (BOX[0] == player && BOX[4] == player && BOX[8] == player)
				|| (BOX[2] == player && BOX[4] == player && BOX[6] == player);
	}

	private static void playersMove() {
		int input = 0;
		while (true) {
			try {
				input = SCAN.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Invalid input. Enter from 1 to 9");
				SCAN.next();
			}
			if (input > 0 && input < 10) {
				if (BOX[input - 1] == PLAYER_X || BOX[input - 1] == PLAYER_O)
					System.out.println("That one is already in use. Enter another.");
				else {
					BOX[input - 1] = PLAYER_X;
					break;
				}
			} else
				System.out.println("Invalid input. Enter again.");
		}
		if (isBoxAvailable()) {
			while (true) {
				byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
				if (BOX[rand - 1] != PLAYER_X && BOX[rand - 1] != PLAYER_O) {
					BOX[rand - 1] = PLAYER_O;
					break;
				}
			}
		}
	}
	
	private static boolean isBoxAvailable() {
		for (int i = 0; i < 9; i++) {
			if (BOX[i] != PLAYER_X && BOX[i] != PLAYER_O) {
				return true;
			}
		}
		return false;
	}
}


