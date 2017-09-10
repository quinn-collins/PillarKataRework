package net.qcollins.currency;

import net.qcollins.DollarAmount;

public class Quarter extends Currency {
	private DollarAmount value;
	private String name;
	
	public Quarter() {
		this.value = DollarAmount.TWENTY_FIVE_CENTS;
		this.name = "quarter";
	}
	
	public DollarAmount getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
