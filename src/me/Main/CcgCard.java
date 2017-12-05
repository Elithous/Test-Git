package me.Main;

import me.Main.Main.Rarity;

public class CcgCard {
	private String name;
	private double value;
	private int quantity;
	private Rarity rarity;
	
	public CcgCard(String name, double value, int quatity, Rarity rarity) {
		this.name = name;
		this.value = value;
		this.quantity = quatity;
		this.rarity = rarity;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nRarity: " + rarity +"\nQuantity: " + quantity + "\nValue: " + value + "\nTotal value: " + (value*quantity);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
}
