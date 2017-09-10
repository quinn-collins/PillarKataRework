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
		coinIdentifier = new CoinIdentifier();;
		coinBank = new CoinBank();
		coinTray = new CoinTray();
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
	
	public void returnCoins() {
		while(currentBalance.isGreaterThanOrEqualTo(DollarAmount.FIVE_CENTS)) {
			if(currentBalance.isGreaterThanOrEqualTo(DollarAmount.TWENTY_FIVE_CENTS) && coinBank.getNumberOfQuarters() > 0) {
				currentBalance = currentBalance.minus(DollarAmount.TWENTY_FIVE_CENTS);
				for(Currency coin : coinBank.getCoinStock()) {
					if(coin.getValue().getCents() == 25) {
						coinBank.getCoinStock().remove(coin);
						break;
					}
				}
				coinTray.addCoinToCoinTray(new Quarter());
				
			}
			else if(currentBalance.isGreaterThanOrEqualTo(DollarAmount.TEN_CENTS) && coinBank.getNumberOfDimes() > 0) {
				currentBalance = currentBalance.minus(DollarAmount.TEN_CENTS);
				for(Currency coin : coinBank.getCoinStock()) {
					if(coin.getValue().getCents() == 10) {
						coinBank.getCoinStock().remove(coin);
						break;
					}
				}
				coinTray.addCoinToCoinTray(new Dime());
			}
			else if(currentBalance.isGreaterThanOrEqualTo(DollarAmount.FIVE_CENTS) && coinBank.getNumberOfNickels() > 0) {
				currentBalance = currentBalance.minus(DollarAmount.FIVE_CENTS);
				for(Currency coin : coinBank.getCoinStock()) {
					if(coin.getValue().getCents() == 5) {
						coinBank.getCoinStock().remove(coin);
						break;
					}
				}
				coinTray.addCoinToCoinTray(new Nickel());
			}
		}
	}
}
