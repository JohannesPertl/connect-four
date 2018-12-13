/*
 * Assignment9
 * Class for a Tile
 * Author:      Johannes Pertl
 * Last Change: 28.11.2018
 */
public class Tile {
	private Disc disc;

	private static int numTiles = 0;

	// Constructor for a new Tile
	public Tile(Disc disc) {
		this.disc = disc;
		numTiles++;
	}

	// Constructor for a new empty Tile
	public Tile() {
		numTiles++;
	}

	public Disc getDisc() {
		return disc;
	}

	public void setDisc(Disc disc) {
		this.disc = disc;
	}

	public static int getNumTiles() {
		return numTiles;
	}

	// Checks if a tile is empty
	public boolean isEmpty() {
		return getDisc() == null;
	}

	// Checks if a tile belongs to a player
	public boolean isPlayerTile(Player player) {
		return getDisc() != null ? getDisc().getPlayer() == player : false;
	}

}