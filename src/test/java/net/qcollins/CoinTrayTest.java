package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.qcollins.coinsystem.CoinTray;
import net.qcollins.currency.Quarter;

public class CoinTrayTest {
	private CoinTray coinTray;

	@Before
	public void setup() {
		coinTray = new CoinTray();
	}

	@Test
	public void canAddCoinsToCoinTray() {
		coinTray.addCoinToCoinTray(new Quarter());
		Assert.assertEquals(1, coinTray.getCoinTray().size());
	}
}
