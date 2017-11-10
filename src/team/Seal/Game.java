package team.Seal;

public class Game {
	private static Cup cup;

	private static void init() {
		int numOfPlayers = 0;
		numOfPlayers = lib.ConsoleIO.promptForInt("Enter the number of players", 2, 4);
		Player.setNumOfPlayers(numOfPlayers);
		String name;
		for (int i = 0; i < numOfPlayers; i++) {
			name = lib.ConsoleIO.promptForInput("Player " + (i + 1) + " enter your name", true);
			if (name.equals(""))
				name = "Player" + (i+1);
			new Player(name);
		}
		cup = new Cup();
	}

	private static void newDice(Die[] dice) {
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == null)
				dice[i] = cup.getDice();
		}
	}

	private static void rollDice(Die[] dice, Player player) {
		System.out.print("The results are");
		for (int i = 0; i < 3; i++) {
			Util.sleep(700);
			System.out.print(".");
		}
		System.out.println();
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == null)
				continue;
			switch (dice[i].roll()) {
			case "Brain":
				player.addBrains(1);
				System.out.println("The " + dice[i].getColor() + " die was a brain. Nice!");
				Util.sleep(700);
				dice[i] = null;
				break;
			case "Shot":
				player.addShots(1);
				System.out.println("The " + dice[i].getColor() + " die was a shot. Shoot!");
				Util.sleep(700);
				dice[i] = null;
				break;
			case "Run":
				System.out.println("The " + dice[i].getColor() + " die was a runner. Lame!");
				Util.sleep(700);
				break;
			}
		}
	}

	private static boolean turn(Player player) {
		boolean rollAgain = true;
		Die[] dice = new Die[3];
		int amountOfDice;
		cup.fillCup(6,4,3);
		System.out.println();
		System.out.print(player.getName() + " it is your turn! (Press enter to continue)");
		Util.sleep();
		System.out.println(
				"Brains: " + player.getBrains() + " Shots: " + player.getShots() + " Score: " + player.getPoints());
		while (rollAgain) {
			newDice(dice);
			amountOfDice = 0;
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] != null) {
					amountOfDice++;
				}
			}
			if (amountOfDice == 3)
				System.out.println("Your three dice are " + dice[0].getColor() + ", " + dice[1].getColor() + ", and "
						+ dice[2].getColor());
			Util.sleep(700);
			System.out.println("Time to roll them!");
			rollDice(dice, player);
			if (player.hasLost()) {
				System.out.println(
						"Those survivors are tough and armed! Now you are the runner. All survivors you cornered escaped. (You rolled too many shots)");
				break;
			}
			System.out.println(
					"Brains: " + player.getBrains() + " Shots: " + player.getShots() + " Score: " + player.getPoints());
			rollAgain = lib.ConsoleIO.promptForBool("Would you like to roll again?", "yes", "no");
		}
		if (!rollAgain) {
			player.addPoints(player.getBrains());
		}
		player.setBrains(0);
		player.setShots(0);
		if (player.hasWon()) {
			return true;
		}
		return false;
	}

	public static void run() {
		init();
		Player[] players = Player.getPlayersList();
		int numOfPlayers = Player.getNumOfPlayers();
		int playerWon = 0;
		//Player[] ties = new Player[numOfPlayers];
		//int amountInTies = 0;
		boolean won = false;
		while (!won) {
			for (int i = 0; i < numOfPlayers; i++) {
				won = turn(players[i]);
				if (won) {
					playerWon = i;
					System.out.println(players[i].getName() + " ended their turn with " + players[i].getPoints()
							+ "! Last chance to beat them!");
				}
			}
		}

		for (int i = playerWon + 1; i != playerWon; i++) {
			if (i >= numOfPlayers)
				i = 0;
			turn(players[i]);
		}
		for (int i = 0; i < numOfPlayers; i++) {
			if (players[playerWon].getPoints() < players[i].getPoints()) {
				playerWon = i;
			} //else if (players[playerWon].getPoints() == players[i].getPoints()) {
			//	ties[i] = players[i];
			//}
		}
		/*
		do {
			amountInTies = 0;
			for (int i = 0; i < ties.length; i++)
				amountInTies++;
			System.out.print("Looks like there is a tie! ");
			for (int i = 0; i < ties.length; i++)
				if(ties[i] != null)
					System.out.print(ties[i].getName() + ", ");
			System.out.println(". You all get another turn.");
			for (int i = 0; i < ties.length; i++)
				if(ties[i] != null)
					turn(ties[i]);
			for (int i = 0; i < numOfPlayers; i++) {
				if (players[playerWon].getPoints() < players[i].getPoints()) {
					playerWon = i;
				} else if (players[playerWon].getPoints() == players[i].getPoints()) {
					ties[i] = players[i];
				}
			}
		} while (amountInTies != 1);
		*/
		System.out.println("Congrats " + players[playerWon].getName() + "! You won!");
	}
}
