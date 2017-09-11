package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.qcollins.currency.Dime;
import net.qcollins.currency.Nickel;
import net.qcollins.currency.Quarter;

public class VendingMachineTest {

	private VendingMachine vendingMachine;

	@Before
	public void setup() {
		vendingMachine = new VendingMachine();
		vendingMachine.getInventory().replenishItemStock(1, 1, 1);
	}

	@Test
	public void insertingQuarterAddsToCurrentBalance() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		Assert.assertEquals(25, vendingMachine.getCoinSlot().getCurrentBalance().getCents());
	}

	@Test
	public void insertingDimeAddsToCurrentBalance() {
		vendingMachine.getCoinSlot().insertCoin(2.268, 17.91, 1.35);
		Assert.assertEquals(10, vendingMachine.getCoinSlot().getCurrentBalance().getCents());
	}

	@Test
	public void insertingNickelAddsToCurrentBalance() {
		vendingMachine.getCoinSlot().insertCoin(5, 21.21, 1.95);
		Assert.assertEquals(5, vendingMachine.getCoinSlot().getCurrentBalance().getCents());
	}

	@Test
	public void vendingMachineRejectsCoinsOfIncorrectDimensionsAndPutsItInCoinTray() {
		vendingMachine.getCoinSlot().insertCoin(2.5, 19, 1.52);
		Assert.assertEquals(1, vendingMachine.getCoinSlot().getCoinTray().getCoinTray().size());
	}

	@Test
	public void insertingNickelShowsCorrectlyOnDisplay() {
		vendingMachine.getCoinSlot().insertCoin(5, 21.21, 1.95);
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals("$0.05", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenNoCoinsAreInsertedMachineDisplaysInsertCoins() {
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenColaButtonPressedAndMachineHasBeenFedEnoughMoneyDisplayShowsThankYou() {
		insertADollar();
		vendingMachine.pressButton("COLA");
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void afterColaButtonPressedAndItemHasBeenDispensedMachineDisplaysInsertCoins() {
		insertADollar();
		vendingMachine.pressButton("COLA");
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughForTheItemMachineDisplaysPrice() {
		vendingMachine.pressButton("COLA");
		Assert.assertEquals("PRICE $1.00", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughForColaMachineDisplaysCurrentBalance() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals(vendingMachine.getCoinSlot().getCurrentBalance().toString(),
				vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughForChipsMachineDisplaysCurrentBalance() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals(vendingMachine.getCoinSlot().getCurrentBalance().toString(),
				vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughCandyItemMachineDisplaysCurrentBalance() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CANDY");
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals(vendingMachine.getCoinSlot().getCurrentBalance().toString(),
				vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenChipButtonPressedAndMachineHasBeenFedEnoughMoneyDisplayShowsThankYou() {
		insertADollar();
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void afterChipButtonPressedAndItemHasBeenDispensedMachineDisplaysInsertCoins() {
		insertADollar();
		vendingMachine.pressButton("CHIPS");
		vendingMachine.getDisplay().updateMessage(vendingMachine.getCoinSlot().getCurrentBalance());
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenCandyButtonPressedAndMachineHasBeenFedEnoughMoneyDisplayShowsThankYou() {
		fillCoinBank();
		insertADollar();
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void afterPurchaseHasBeenMadeCurrentBalanceIsSetToZero() {
		insertADollar();
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals(DollarAmount.ZERO_DOLLARS, vendingMachine.getCoinSlot().getCurrentBalance());
	}

	@Test
	public void whenPurchaseIsMadeWithExtraMoneyInMachineTheExtraIsPutInTheCoinTray() {
		insertADollar();
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals(2, vendingMachine.getCoinSlot().getCoinTray().getCoinTray().size());
	}

	@Test
	public void whenCustomerPressesReturnChangeButtonCoinsAreAddedToCoinTray() {
		insertADollar();
		vendingMachine.pressButton("RETURN CHANGE");
		Assert.assertEquals(4, vendingMachine.getCoinSlot().getCoinTray().getCoinTray().size());
	}

	@Test
	public void canSetInventory() {
		vendingMachine.getInventory().replenishItemStock(30, 30, 30);
		Assert.assertEquals(31,
				vendingMachine.getInventory().getItemStock().get(vendingMachine.getInventory().getCola()).intValue());
	}

	@Test
	public void whenChipsAreOutOfStockTheMachineDisplaysSoldOut() {
		insertADollar();
		vendingMachine.pressButton("CHIPS");
		insertADollar();
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals("SOLD OUT", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenColaIsOutOfStockTheMachineDisplaysSoldOut() {
		insertADollar();
		vendingMachine.pressButton("COLA");
		insertADollar();
		vendingMachine.pressButton("COLA");
		Assert.assertEquals("SOLD OUT", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenCandyIsOutOfStockTheMachineDisplaysSoldOut() {
		fillCoinBank();
		insertADollar();
		vendingMachine.pressButton("CANDY");
		insertADollar();
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals("SOLD OUT", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void ifButtonMalfunctionsErrorIsDisplayed() {
		vendingMachine.pressButton("error");
		Assert.assertEquals("ERROR", vendingMachine.getDisplay().getMessage());
	}

	@Test
	public void whenCustomerInsertsQuartersTheyAreAddedToCoinBank() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		Assert.assertEquals(1, vendingMachine.getCoinSlot().getCoinBank().getNumberOfQuarters());
	}

	@Test
	public void whenCustomerInsertsDimesTheyAreAddedToCoinBank() {
		vendingMachine.getCoinSlot().insertCoin(2.268, 17.91, 1.35);
		Assert.assertEquals(1, vendingMachine.getCoinSlot().getCoinBank().getNumberOfDimes());
	}

	@Test
	public void whenCustomerInsertsNickelsTheyAreAddedToCoinBank() {
		vendingMachine.getCoinSlot().insertCoin(5, 21.21, 1.95);
		Assert.assertEquals(1, vendingMachine.getCoinSlot().getCoinBank().getNumberOfNickels());
	}

	@Test
	public void whenCustomerHasChangeReturnedCoinsAreRemovedFromCoinBank() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		Assert.assertEquals(1, vendingMachine.getCoinSlot().getCoinBank().getCoinStock().size());
		vendingMachine.getCoinSlot().returnCoins();
		Assert.assertEquals(0, vendingMachine.getCoinSlot().getCoinBank().getCoinStock().size());
	}

	@Test
	public void whenMachineDoesNotHaveChangeForAnItemItWillDisplayExactChangeOnly() {
		insertADollar();
		vendingMachine.getCoinSlot().insertCoin(5, 21.21, 1.95);
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals("EXACT CHANGE ONLY", vendingMachine.getDisplay().getMessage());
	}

	private void insertADollar() {
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
		vendingMachine.getCoinSlot().insertCoin(5.670, 24.26, 1.75);
	}

	private void fillCoinBank() {
		for (int i = 0; i <= 5; i++) {
			vendingMachine.getCoinSlot().getCoinBank().addCoin(new Quarter());
			vendingMachine.getCoinSlot().getCoinBank().addCoin(new Dime());
			vendingMachine.getCoinSlot().getCoinBank().addCoin(new Nickel());
		}
	}
}
