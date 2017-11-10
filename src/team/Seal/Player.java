package team.Seal;

public class Player {
	private static Player[] playerList;
	private static int playerNum = 0;

    private String Name;
    private int points;
    private int brains;
    private int shots;

    public Player(String name){
    	Player.playerList[playerNum++] = this;
        this.Name = name;
        this.points = 0;
    }

    public String getName() {
        return Name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void addPoints(int points) {
    	this.points += points;
    }

    public int getBrains() {
		return brains;
	}

	public void setBrains(int brains) {
		this.brains = brains;
	}
	
	public void addBrains(int brains) {
		this.brains += brains;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}
	
	public void addShots(int shots) {
		this.shots += shots;
	}
	
	public static Player[] getPlayersList() {
		return playerList;
	}

	public static Player getPlayer(int playerNumber) {
    	if(playerNumber >= playerNum) return null;
    	return playerList[playerNumber];
    }
    
    public static int getNumOfPlayers() {
    	return playerNum;
    }
    
    public static void setNumOfPlayers(int num) {
    	playerList = new Player[num];
    }
    
    public boolean hasWon() {
    	return (this.points + this.brains >= 13);
    }

	public boolean hasLost() {
		return (this.shots >= 3);
	}
}
