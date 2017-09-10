package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DollarAmountTest {
	
	private DollarAmount dollarAmount;
	
	@Before
	public void setup() {
		dollarAmount = new DollarAmount(50);
	}
	
	@Test
	public void canGetCents() {
		Assert.assertEquals(50, dollarAmount.getCents());
	}
}
