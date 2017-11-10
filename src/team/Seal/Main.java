package team.Seal;

public class Main {

	public static void main(String[] args) {
		boolean playAgain;
		do {
		Game.run();
		playAgain = lib.ConsoleIO.promptForBool("Do you want to play again?", "yes" ,"no");
		} while (playAgain);
	}

}
