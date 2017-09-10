package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.qcollins.currency.Dime;
import net.qcollins.currency.Nickel;
import net.qcollins.currency.Quarter;


public class CoinBankTest {
	private CoinBank coinBank;
	
	@Before
	public void setup() {
		coinBank = new CoinBank();
		coinBank.addCoin(new Quarter());
		coinBank.addCoin(new Dime());
		coinBank.addCoin(new Nickel());
	}
	
	@Test
	public void canGetCoinStock() {
		Assert.assertEquals(3, coinBank.getCoinStock().size());
	}
	
	@Test
	public void canGetNumberOfQuartersInCoinStock() {
		Assert.assertEquals(1, coinBank.getNumberOfQuarters());
	}
	
	@Test
	public void canGetNumberOfDimesInCoinStock() {
		Assert.assertEquals(1, coinBank.getNumberOfDimes());
	}
	
	@Test
	public void canGetNumberOfNickelInCoinStock() {
		Assert.assertEquals(1, coinBank.getNumberOfNickels());
	}
}
