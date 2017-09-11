package net.qcollins;

import java.util.LinkedHashMap;
import java.util.Map;

import net.qcollins.product.Candy;
import net.qcollins.product.Chips;
import net.qcollins.product.Cola;
import net.qcollins.product.VendingMachineItem;

public class Inventory {

	private Map<VendingMachineItem, Integer> itemStock;
	private Cola cola;
	private Chips chips;
	private Candy candy;

	public Inventory() {
		itemStock = new LinkedHashMap<VendingMachineItem, Integer>();
		cola = new Cola("Cola", new DollarAmount(100));
		chips = new Chips("Chips", new DollarAmount(50));
		candy = new Candy("Candy", new DollarAmount(65));
		itemStock.put(cola, 0);
		itemStock.put(chips, 0);
		itemStock.put(candy, 0);
	}

	public Map<VendingMachineItem, Integer> getItemStock() {
		return itemStock;
	}

	public void decreaseItemStock(VendingMachineItem item) {
		itemStock.put(item, itemStock.get(item).intValue() - 1);

	}

	public void replenishItemStock(int numberOfColas, int numberOfChips, int numberOfCandy) {
		itemStock.put(cola, itemStock.get(cola).intValue() + numberOfColas);
		itemStock.put(chips, itemStock.get(chips).intValue() + numberOfChips);
		itemStock.put(candy, itemStock.get(candy).intValue() + numberOfCandy);
	}

	public Cola getCola() {
		return cola;
	}

	public Chips getChips() {
		return chips;
	}

	public Candy getCandy() {
		return candy;
	}
}
