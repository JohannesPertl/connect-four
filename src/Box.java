/*
 * Assignment9
 * Class for the game board
 * Author:      Johannes Pertl
 * Last Change: 04.12.2018
 */

public class Box {
	private static final int WIN_COUNT = 4;
	private static final int ROWS = 6;
	private static final int COLUMNS = 7;
	private Tile[][] board;

	// Constructor for the gaming board
	public Box() {
		this.board = new Tile[ROWS][COLUMNS];
		for (int x = 0; x < ROWS; x++)
			for (int y = 0; y < COLUMNS; y++)
				board[x][y] = new Tile();
	}

	public Tile[][] getBoard() {
		return board;
	}
	
	public void printNumColumns() {
		for (int i = 1; i <= COLUMNS; i++)
			System.out.printf(" %d", i);

		System.out.println();
	}

	
	// Print the game board
	public void printBox() {
		System.out.println();
		printNumColumns();
		for (Tile[] row : board) {
			for (Tile tile : row) {
				System.out.printf("|%s", tile.isEmpty() ? " " : tile.getDisc().getPlayer().getSymbol());
			}
			System.out.println("|");
		}
		Helper.printSeparatorLine(COLUMNS * 2 + 1);
		printNumColumns();
		System.out.println();

	}
	
	// Throw a new Disc into the game board, return true if it worked
	public boolean putDisc(int position, Player player) {
		boolean success = false;
		// iterate backwards through column
		if (1 <= position && position <= COLUMNS)
			for (int j = ROWS - 1; j >= 0; j--)
				if (board[j][position - 1].isEmpty()) {
					board[j][position - 1].setDisc(new Disc(player));
					success = true;
					break;
				}

		return success;
	}
	
	// Check if the game board is full of discs
	public boolean isFull() {
		return Disc.getNumDiscs() >= ROWS*COLUMNS;
		
	}
	
	// Check if an array elemnt is in bounds (to prevent unchecked ArrayIndexOutOfBoundsException)
	public boolean inBounds(int i, int j) {
		return (i >= 0 && i < ROWS) && (j >= 0 && j < COLUMNS) ? true : false;
	}

	// Returns the player, if he won, else returns null
	public Player checkWinner(Player player) {
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < COLUMNS; j++)
				if (board[i][j].isPlayerTile(player)) {
					for (int winMode = 0; winMode < 4; winMode++) {
						int x = i;
						int y = j;
						
						for (int w = 1; w <= WIN_COUNT; w++) {

							if (w == WIN_COUNT)
								return player;

							switch (winMode) {
							case (0): // Horizontal
								y = j + w;
								break;
							case (1): // Vertical
								x = i + w;
								break;
							case (2): // Diagonal right
								x = i + w;
								y = j + w;
								break;
							case (3): // Diagonal left
								x = i + w;
								y = j - w;
								break;
							}
							if (inBounds(x, y) && board[x][y].isPlayerTile(player))
								continue;
							else
								break;
						}
					}
				}
		return null;
	}

}