package net.qcollins.currency;

import net.qcollins.DollarAmount;

public class Dime extends Currency {
	private DollarAmount value;
	private String name;

	public Dime() {
		this.value = DollarAmount.TEN_CENTS;
		this.name = "dime";
	}

	public DollarAmount getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}