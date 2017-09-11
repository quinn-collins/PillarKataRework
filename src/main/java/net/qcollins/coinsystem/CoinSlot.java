package net.qcollins.coinsystem;

import net.qcollins.DollarAmount;
import net.qcollins.currency.Currency;
import net.qcollins.currency.Dime;
import net.qcollins.currency.Nickel;
import net.qcollins.currency.Quarter;

public class CoinSlot {
	private CoinIdentifier coinIdentifier;
	private CoinBank coinBank;
	private CoinTray coinTray;
	private DollarAmount currentBalance = DollarAmount.ZERO_DOLLARS;

	public CoinSlot() {
		coinIdentifier = new CoinIdentifier();
		coinBank = new CoinBank();
		coinTray = new CoinTray();
	}

	public CoinBank getCoinBank() {
		return coinBank;
	}

	public CoinTray getCoinTray() {
		return coinTray;
	}

	public DollarAmount getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(DollarAmount amount) {
		currentBalance = amount;
	}

	public void insertCoin(double mass, double diameter, double thickness) {
		Currency coin = coinIdentifier.identify(mass, diameter, thickness);
		if (coin.getName().equals("rejected")) {
			coinTray.addCoinToCoinTray(coin);
		} else {
			coinBank.addCoin(coin);
		}
		currentBalance = currentBalance.plus(coin.getValue());
	}

	public void returnCoins() {
		while (currentBalance.isGreaterThanOrEqualTo(DollarAmount.FIVE_CENTS)) {
			if (currentBalance.isGreaterThanOrEqualTo(DollarAmount.TWENTY_FIVE_CENTS)
					&& coinBank.getNumberOfQuarters() > 0) {
				currentBalance = currentBalance.minus(DollarAmount.TWENTY_FIVE_CENTS);
				removeCoinFromCoinBank(DollarAmount.TWENTY_FIVE_CENTS);
				coinTray.addCoinToCoinTray(new Quarter());
			} else if (currentBalance.isGreaterThanOrEqualTo(DollarAmount.TEN_CENTS)
					&& coinBank.getNumberOfDimes() > 0) {
				currentBalance = currentBalance.minus(DollarAmount.TEN_CENTS);
				removeCoinFromCoinBank(DollarAmount.TEN_CENTS);
				coinTray.addCoinToCoinTray(new Dime());
			} else if (currentBalance.isGreaterThanOrEqualTo(DollarAmount.FIVE_CENTS)
					&& coinBank.getNumberOfNickels() > 0) {
				currentBalance = currentBalance.minus(DollarAmount.FIVE_CENTS);
				removeCoinFromCoinBank(DollarAmount.FIVE_CENTS);
				coinTray.addCoinToCoinTray(new Nickel());
			}
		}
	}

	public void removeCoinFromCoinBank(DollarAmount amount) {
		for (Currency coin : coinBank.getCoinStock()) {
			if (coin.getValue().getCents() == amount.getCents()) {
				coinBank.getCoinStock().remove(coin);
				break;
			}
		}
	}
}
