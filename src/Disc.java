/*
 * Assignment9
 * Class for Disc
 * Author:      Johannes Pertl
 * Last Change: 28.11.2018
 */
public class Disc {
    private Player player;

    private static int numDiscs = 0;
     
    // Constructor for a new Disc
    public Disc(Player player) {
        this.player = player;
        numDiscs++;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }

	public static int getNumDiscs() {
		return numDiscs;
	}

}
