/*
 * Assignment9
 * Class for Player
 * Author:      Johannes Pertl
 * Last Change: 26.11.2018
 */
public class Player {

	private String name;
	private char symbol;

	private static int numPlayers = 0;

	// Constructor for new Player with name and symbol as attributes
	public Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
		numPlayers++;
	}

	// Constructor for new empty player
	public Player() {
		numPlayers++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public static int getNumPlayers() {
		return numPlayers;
	}

}
