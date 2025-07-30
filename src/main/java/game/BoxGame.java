package game;

import java.util.Scanner;

public class BoxGame {
	private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static final char playerX = 'X';
	private static final char playerO = 'O';
	Scanner scan = new Scanner(System.in);

	public static void run() {
		System.out.println("Enter box number to select. Enjoy!\n");
		BoxGame boxGame = new BoxGame();

		while (true) {
			boxGame.printBox();
			if (boxGame.isWin()) {
				break;
			}
			boxGame.playersMove();
		}
		boxGame.scan.close();
	}

	private void printBox() {
		System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
		System.out.println("-----------");
		System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
		System.out.println("-----------");
		System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
	}

	private boolean isWin() {
		if ((box[0] == playerX && box[1] == playerX && box[2] == playerX)
				|| (box[3] == playerX && box[4] == playerX && box[5] == playerX)
				|| (box[6] == playerX && box[7] == playerX && box[8] == playerX)
				|| (box[0] == playerX && box[3] == playerX && box[6] == playerX)
				|| (box[1] == playerX && box[4] == playerX && box[7] == playerX)
				|| (box[2] == playerX && box[5] == playerX && box[8] == playerX)
				|| (box[0] == playerX && box[4] == playerX && box[8] == playerX)
				|| (box[2] == playerX && box[4] == playerX && box[6] == playerX)) {
			System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
			return true;
		}

		if ((box[0] == playerO && box[1] == playerO && box[2] == playerO)
				|| (box[3] == playerO && box[4] == playerO && box[5] == playerO)
				|| (box[6] == playerO && box[7] == playerO && box[8] == playerO)
				|| (box[0] == playerO && box[3] == playerO && box[6] == playerO)
				|| (box[1] == playerO && box[4] == playerO && box[7] == playerO)
				|| (box[2] == playerO && box[5] == playerO && box[8] == playerO)
				|| (box[0] == playerO && box[4] == playerO && box[8] == playerO)
				|| (box[2] == playerO && box[4] == playerO && box[6] == playerO)) {
			System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
			return true;
		}

		if (!isBoxAvailable()) {
			System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
			return true;
		}
		return false;
	}

	private void playersMove() {
  byte input;
		while (true) {
			input = scan.nextByte();
			if (input > 0 && input < 10) {
				if (box[input - 1] == playerX || box[input - 1] == playerO)
					System.out.println("That one is already in use. Enter another.");
				else {
					box[input - 1] = playerX;
					break;
				}
			} else
				System.out.println("Invalid input. Enter again.");
		}
		if (isBoxAvailable()) {
			byte rand;
			while (true) {
				rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
				if (box[rand - 1] != playerX && box[rand - 1] != playerO) {
					box[rand - 1] = playerO;
					break;
				}
			}
		}
	}

	private boolean isBoxAvailable() {
		byte i;
		boolean boxAvailable = false;
		for (i = 0; i < 9; i++) {
			if (box[i] != playerX && box[i] != playerO) {
				boxAvailable = true;
				break;
			}
		}
		return boxAvailable;
	}
}


