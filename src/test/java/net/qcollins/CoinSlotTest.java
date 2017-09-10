package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.qcollins.coinsystem.CoinSlot;

public class CoinSlotTest {
	private CoinSlot coinSlot;
	
	@Before
	public void setup() {
		coinSlot = new CoinSlot();
		coinSlot.insertCoin(5.670, 24.26, 1.75);
	}
	
	@Test
	public void canInsertQuarterIntoCoinSlot() {
		Assert.assertEquals(1, coinSlot.getCoinBank().getNumberOfQuarters());
	}
	
	@Test
	public void canGetCurrentBalance() {
		Assert.assertEquals(25, coinSlot.getCurrentBalance().getCents());
	}
	
	@Test
	public void canReturnCoins() {
		coinSlot.insertCoin(5, 21.21, 1.95);
		coinSlot.insertCoin(2.268, 17.91, 1.35);
		coinSlot.insertCoin(5.670, 24.26, 1.75);
		coinSlot.returnCoins();
		Assert.assertEquals(0, coinSlot.getCoinBank().getNumberOfQuarters());
	}
}
