package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DollarAmountTest {
	
	private DollarAmount dollarAmountFiftyCents;
	private DollarAmount dollarAmountOneDollar;
	private DollarAmount dollarAmountNegative;
	private DollarAmount dollarAmountTemp;
	
	
	@Before
	public void setup() {
		dollarAmountFiftyCents = new DollarAmount(50);
		dollarAmountOneDollar = new DollarAmount(1, 0);
		dollarAmountNegative = new DollarAmount(-25);
		dollarAmountTemp = new DollarAmount(0);
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
	
	@Test
	public void negativeTwentyFiveCentsReturnsTrueOnIsNegativeMethodCall() {
		Assert.assertTrue(dollarAmountNegative.isNegative());
	}
	
	@Test
	public void positiveDollarAmountReturnsFalseOnIsNegativeMethodCall() {
		Assert.assertFalse(dollarAmountFiftyCents.isNegative());
	}
	
	@Test
	public void canSubtractFiftyCentsFromOneDollarWithMinusMethodCall() {
		dollarAmountTemp = dollarAmountOneDollar.minus(dollarAmountFiftyCents);
		Assert.assertEquals(50, dollarAmountTemp.getCents());
	}
	
	@Test
	public void canAddFiftyCentsToOneDollarWithPlusMethodCall() {
		dollarAmountTemp = dollarAmountOneDollar.plus(dollarAmountFiftyCents);
		Assert.assertEquals(150, dollarAmountTemp.getCents());
	}
	
	@Test
	public void whenICompareFiftyCentsToOneDollarCompareToReturnsNegativeOne() {
		Assert.assertEquals(-1, dollarAmountFiftyCents.compareTo(dollarAmountOneDollar));
	}
	
	@Test
	public void whenICompareOneDollarToFiftyCentsCompareToReturnsOne() {
		Assert.assertEquals(1, dollarAmountOneDollar.compareTo(dollarAmountFiftyCents));
	}
	
	@Test
	public void whenICompareZeroCentsToZeroCentsCompareToReturnsZero() {
		Assert.assertEquals(0, dollarAmountTemp.compareTo(DollarAmount.ZERO_DOLLARS));
	}
	
	@Test
	public void dollarAmountFiftyCentsDoesNotHaveSameReferenceAsDollarAmountOneDollar() {
		Assert.assertFalse(dollarAmountFiftyCents.equals(dollarAmountOneDollar));
	}
	
	@Test
	public void dollarAmountFiftyCentsHasSameReferenceAsDollarAmountFiftyCentsAgain() {
		DollarAmount dollarAmountFiftyCentsAgain = dollarAmountFiftyCents;
		Assert.assertTrue(dollarAmountFiftyCents.equals(dollarAmountFiftyCentsAgain));
	}
	
	@Test
	public void checkingReferenceOfDollarAmountAgainstNullDollarAmountObjectReturnsFalse() {
		DollarAmount dollarAmountNull = null;
		Assert.assertFalse(dollarAmountFiftyCents.equals(dollarAmountNull));
	}
	
}
