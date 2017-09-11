package net.qcollins;

import net.qcollins.coinsystem.CoinSlot;

public class VendingMachine {
	private CoinSlot coinSlot;
	private Display display;
	private Inventory inventory;
	
	public VendingMachine() {
		coinSlot = new CoinSlot();
		display = new Display();
		inventory = new Inventory();
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public CoinSlot getCoinSlot() {
		return coinSlot;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}
