package team.Seal;

import java.util.Random;

public class Cup {
	private Die[] dice = new Die[13];

	Cup() {
		this.fillCup(6, 4, 3);
	}

	public void fillCup(int green, int yellow, int red) {
		for (int i = 0; i < dice.length; i++) {
			if (i < green) {
				dice[i] = new Die("green");
			} else if (i < 10) {
				dice[i] = new Die("yellow");
			} else if (i < 13) {
				dice[i] = new Die("red");
			}
		}
	}
	
	public void refillCup() {
		for(int i = 0;  i < dice.length; i++) {
			if(dice[i].toString() != null && dice[i].toString().equals("Brain")) {
				dice[i] = new Die(dice[i].getColor());
			}
		}
		System.out.println("The dice that came up as brains are back in the cup!");
	}

	public Die getDice() {
		boolean diceRemaining = false;
		for (int i = 0; i < dice.length; i++) {
			if (dice[i].toString() == null) {
				diceRemaining = true;
				break;
			}
		}
		if (!diceRemaining)
			refillCup();
		Random rand = new Random();
		Die die;
		int random;
		do {
			random = rand.nextInt(dice.length);
			die = dice[random];
		} while (die.toString() != null);
		return die;
	}
}
