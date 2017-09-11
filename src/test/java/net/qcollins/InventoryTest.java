package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class InventoryTest {
	Inventory inventory;
	
	@Before
	public void setup() {
		inventory = new Inventory();
		inventory.replenishItemStock(20, 20, 20);
	}
	
	@Test
	public void canReplenishInventory() {
		inventory.replenishItemStock(1, 1, 1);
		Assert.assertEquals(21, inventory.getItemStock().get(inventory.getCola()).intValue());
	}
	
	@Test
	public void canRemoveAnItemFromStock() {
		inventory.decreaseItemStock(inventory.getChips());
		Assert.assertEquals(19, inventory.getItemStock().get(inventory.getChips()).intValue());
	}
}
