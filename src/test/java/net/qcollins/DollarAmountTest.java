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
	
	@Test
	public void fiftyCentsIsEqualToFiftyCents() {
		Assert.assertTrue(dollarAmountFiftyCents.isGreaterThanOrEqualTo(new DollarAmount(50)));
	}
	
	@Test
	public void oneDollarIsGreaterThanOrEqualToFiftyCents() {
		Assert.assertTrue(dollarAmountOneDollar.isGreaterThanOrEqualTo(dollarAmountFiftyCents));
	}
	
	@Test
	public void fiftyCentsIsNotGreaterThanOrEqualToOneDollar() {
		Assert.assertFalse(dollarAmountFiftyCents.isGreaterThanOrEqualTo(dollarAmountOneDollar));
	}
	
	@Test
	public void oneDollarIsNotLessThanFiftyCents() {
		Assert.assertFalse(dollarAmountOneDollar.isLessThan(dollarAmountFiftyCents));
	}
	
	@Test
	public void fiftyCentsIsLessThanOneDollar() {
		Assert.assertTrue(dollarAmountFiftyCents.isLessThan(dollarAmountOneDollar));
	}
	
	
	@Test
	public void oneDollarIsEqualToOneDollar() {
		Assert.assertTrue(dollarAmountOneDollar.isLessThanOrEqualTo(new DollarAmount(100)));
	}
	
	@Test
	public void fiftyCentsIsLessThanOrEqualToOneDollar() {
		Assert.assertTrue(dollarAmountFiftyCents.isLessThanOrEqualTo(dollarAmountOneDollar));
	}
	
	@Test
	public void oneDollarIsNotLessThanOrEqualToFiftyCents() {
		Assert.assertFalse(dollarAmountOneDollar.isLessThanOrEqualTo(dollarAmountFiftyCents));
	}
	
}
