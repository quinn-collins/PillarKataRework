package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DisplayTest {
	private VendingMachine vendingMachine;
	
	@Before
	public void setup() {
		vendingMachine = new VendingMachine();
		
	}
	
	@Test
	public void canSetTheDisplayMessage() {
		vendingMachine.getDisplay().setMessage(DisplayMessage.THANK_YOU.getMessage());
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay().getMessage());
	}
	
	@Test
	public void whenNoCoinsHaveBeenInsertedVendingMachineDisplaysInsertCoins() {
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplay().getMessage());
	}
	
	@Test
	public void insertingQuarterShowsCorrectlyOnDisplay() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals("$0.25", vendingMachine.getDisplay().getMessage());
	}
}
