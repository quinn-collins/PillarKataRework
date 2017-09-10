package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DollarAmountTest {
	
	private DollarAmount dollarAmountFiftyCents;
	private DollarAmount dollarAmountOneDollar;
	
	@Before
	public void setup() {
		dollarAmountFiftyCents = new DollarAmount(50);
		dollarAmountOneDollar = new DollarAmount(100);
	}
	
	@Test
	public void canGetCents() {
		Assert.assertEquals(50, dollarAmountFiftyCents.getCents());
	}
	
	@Test
	public void canGetDollars() {
		Assert.assertEquals(1, dollarAmountOneDollar.getDollars());
	}
	
	@Test
	public void oneDollarIsGreaterThanFiftyCents() {
		Assert.assertTrue(dollarAmountOneDollar.isGreaterThan(dollarAmountFiftyCents));
	}
	
	@Test
	public void fiftyCentsIsNotGreaterThanOneDollar() {
		Assert.assertFalse(dollarAmountFiftyCents.isGreaterThan(dollarAmountOneDollar));
	}
}
