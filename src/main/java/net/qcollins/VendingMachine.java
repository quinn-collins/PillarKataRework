package net.qcollins;

import net.qcollins.coinsystem.CoinSlot;

public class VendingMachine {
	private CoinSlot coinSlot;
	private Display display;
	
	public VendingMachine() {
		coinSlot = new CoinSlot();
		display = new Display();
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public CoinSlot getCoinSlot() {
		return coinSlot;
	}
}
