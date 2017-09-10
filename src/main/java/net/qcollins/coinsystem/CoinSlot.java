package net.qcollins.coinsystem;

import net.qcollins.DollarAmount;
import net.qcollins.currency.Currency;

public class CoinSlot {
	private CoinIdentifier coinIdentifier;
	private CoinBank coinBank;
	private DollarAmount currentBalance = DollarAmount.ZERO_DOLLARS;

	public CoinSlot() {
		coinIdentifier = new CoinIdentifier();;
		coinBank = new CoinBank();
	}
	
	public CoinBank getCoinBank() {
		return coinBank;
	}
	
	public DollarAmount getCurrentBalance() {
		return currentBalance;
	}

	public void insertCoin(double mass, double diameter, double thickness) {
		Currency coin = coinIdentifier.identify(mass, diameter, thickness);
		coinBank.addCoin(coin);
		currentBalance = currentBalance.plus(coin.getValue());
	}
}
