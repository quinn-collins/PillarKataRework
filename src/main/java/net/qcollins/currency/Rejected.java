package net.qcollins.currency;

import net.qcollins.DollarAmount;

public class Rejected extends Currency {
	private DollarAmount value;
	private String name;

	public Rejected() {
		this.value = DollarAmount.ZERO_DOLLARS;
		this.name = "rejected";
	}

	public DollarAmount getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}