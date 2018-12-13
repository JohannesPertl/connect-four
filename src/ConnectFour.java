/*
 * Assignment9
 * ConnectFour for two players
 * Author:      Johannes Pertl
 * Last Change: 28.11.2018
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ConnectFour {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		printHeader(scanner, 80);

		Player player1 = new Player(
				Helper.inputStringFor("Name of player 1: ", scanner),
				Helper.inputCharFor("Symbol for Player 1: ", scanner));
		Player player2 = new Player(
				Helper.inputStringFor("Name of player 2: ", scanner),
				Helper.inputCharFor("Symbol for Player 2: ", scanner));

		// Create the game board
		Box board = new Box();

		int turn = 0;
		// Randomize who starts first
		int choosePlayer = ThreadLocalRandom.current().nextInt(1, Player.getNumPlayers() + 1);

		// Main Game Loop
		while (true) {
			
			choosePlayer = choosePlayer > Player.getNumPlayers() ? 1 : choosePlayer;
			Player currentPlayer = choosePlayer == 1 ? player1 : player2;
			
			// New turn
			boolean hasPlayed = false;
			while (!hasPlayed) {
				board.printBox();
				System.out.printf("%s (Turn %d): ", currentPlayer.getName(), ++turn);
				hasPlayed = board.putDisc(Helper.parseIntPos(scanner), currentPlayer);
				if (!hasPlayed) {
					System.out.println("\n\n\nWrong turn!");
					turn--;
				}
			}

			choosePlayer++;
			System.out.println("\n\n");
			
			
			// Check for win or draw
			if (board.checkWinner(currentPlayer) != null) {
				board.printBox();
				System.out.printf("Winner after %d turns: %s", turn, currentPlayer.getName());
				break;
			} else if (board.isFull()) {
				board.printBox();
				System.out.print("Game over! Draw!");
				break;
			}

		}

	}

	// Prints the game header
	public static void printHeader(Scanner scanner, int i) {
		Helper.printHeaderLine(i);
		System.out.println("Connect Four");
		Helper.printSeparatorLine(i);
	}

}
