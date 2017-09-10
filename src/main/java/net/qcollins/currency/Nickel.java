package net.qcollins.currency;

import net.qcollins.DollarAmount;

public class Nickel extends Currency {
	private DollarAmount value;
	private String name;
	
	public Nickel() {
		this.value = DollarAmount.FIVE_CENTS;
		this.name = "nickel";
	}
	
	public DollarAmount getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}