package net.qcollins;

import net.qcollins.coinsystem.CoinSlot;
import net.qcollins.product.VendingMachineItem;

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

	public void pressButton(String string) {
		if (string == "COLA") {
			productPurchase(inventory.getCola());
		} else if (string == "CHIPS") {
			productPurchase(inventory.getChips());
		} else if (string == "CANDY") {
			productPurchase(inventory.getCandy());
		} else if (string == "RETURN CHANGE") {
			coinSlot.returnCoins();
		} else {
			display.setMessage(DisplayMessage.ERROR.getMessage());
		}
	}

	public void productPurchase(VendingMachineItem item) {
		if (coinSlot.getCurrentBalance().isLessThan(item.getItemPrice())) {
			display.setMessage("PRICE " + item.getItemPrice());
		} else if (inventory.getItemStock().get(item) < 1) {
			display.setMessage(DisplayMessage.SOLD_OUT.getMessage());
		} else {
			if (machineNeedsExactChange(item, coinSlot.getCurrentBalance())) {
				display.setMessage(DisplayMessage.EXACT_CHANGE_ONLY.getMessage());
			} else {
				display.setMessage(DisplayMessage.THANK_YOU.getMessage());
				inventory.decreaseItemStock(item);
				coinSlot.setCurrentBalance(coinSlot.getCurrentBalance().minus(item.getItemPrice()));
				coinSlot.returnCoins();
			}
		}
	}

	private boolean machineNeedsExactChange(VendingMachineItem item, DollarAmount currentBalance) {
		DollarAmount expectedChange = currentBalance.minus(item.getItemPrice());
		for (int i = 0; i < coinSlot.getCoinBank().getNumberOfQuarters(); i++) {
			if (expectedChange.isGreaterThanOrEqualTo(DollarAmount.TWENTY_FIVE_CENTS)) {
				expectedChange = expectedChange.minus(DollarAmount.TWENTY_FIVE_CENTS);
			}
		}
		for (int i = 0; i < coinSlot.getCoinBank().getNumberOfDimes(); i++) {
			if (expectedChange.isGreaterThanOrEqualTo(DollarAmount.TEN_CENTS)) {
				expectedChange = expectedChange.minus(DollarAmount.TEN_CENTS);
			}
		}
		for (int i = 0; i < coinSlot.getCoinBank().getNumberOfNickels(); i++) {
			if (expectedChange.isGreaterThanOrEqualTo(DollarAmount.FIVE_CENTS)) {
				expectedChange = expectedChange.minus(DollarAmount.FIVE_CENTS);
			}
		}
		if (expectedChange.compareTo(DollarAmount.ZERO_DOLLARS) == 0) {
			return false;
		} else {
			return true;
		}
		//
	}
}
