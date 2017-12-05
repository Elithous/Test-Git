package me.Main;

import lib.ConsoleIO;

public class Main {

	public enum Rarity {
		UNLIMITED(0, "Unlimited"), ULTRACOMMON(1, "Ultra Common"), COMMON(2, "Common"), UNCOMMON(3,
				"Uncommon"), ULTRAUNCOMMON(4, "Ultra Uncommon"), RARE(5, "Rare"), ULTRARARE(6,
						"Ultra Rare"), FOILRARE(7, "Foil Rare"), ULTRAFOILRARE(8, "Ultra Foil Rare");

		private int ordinalValue;
		private String rarity;

		Rarity(int value, String rarity) {
			this.ordinalValue = value;
			this.rarity = rarity;
		}

		public int getOrdinalValue() {
			return ordinalValue;
		}

		@Override
		public String toString() {
			return rarity;
		}
	}

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		CcgCard card;
		Rarity rarity = null;
		String name = ConsoleIO.promptForInput("What is the card name?", false);
		double value = ConsoleIO.promptForDouble("Enter the value of the card.");
		int quantity = ConsoleIO.promptForInt("How many do you have?");
		int rare = ConsoleIO.promptForMenuSelection(new String[] { "Unlimited", "Ultra Common", "Common", "Uncommon",
				"Ultra Uncommon", "Rare", "Ultra Rare", "Foil Rare", "Ultra Foil Rare" }, false);
		switch(rare) {
		case 1: rarity = Rarity.UNLIMITED; break;
		case 2: rarity = Rarity.ULTRACOMMON; break;
		case 3: rarity = Rarity.COMMON; break;
		case 4: rarity = Rarity.UNCOMMON; break;
		case 5: rarity = Rarity.ULTRAUNCOMMON; break;
		case 6: rarity = Rarity.RARE; break;
		case 7: rarity = Rarity.ULTRARARE; break;
		case 8: rarity = Rarity.FOILRARE; break;
		case 9: rarity = Rarity.ULTRAFOILRARE; break;
		}
		card = new CcgCard(name, value, quantity, rarity);
		System.out.println(card);
	}
}
