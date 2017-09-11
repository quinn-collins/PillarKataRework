package net.qcollins.coinsystem;

import java.util.ArrayList;

import net.qcollins.currency.Currency;

public class CoinBank {
	private ArrayList<Currency> coinStock;

	public CoinBank() {
		coinStock = new ArrayList<Currency>();
	}

	public ArrayList<Currency> getCoinStock() {
		return coinStock;
	}

	public void addCoin(Currency coin) {
		coinStock.add(coin);
	}

	public int getNumberOfQuarters() {
		return getNumberOfCoins("quarter");
	}

	public int getNumberOfDimes() {
		return getNumberOfCoins("dime");
	}

	public int getNumberOfNickels() {
		return getNumberOfCoins("nickel");
	}

	public int getNumberOfCoins(String coinName) {
		int numberOfCoins = 0;
		for (Currency coin : coinStock) {
			if (coin.getName().equals(coinName)) {
				numberOfCoins++;
			}
		}
		return numberOfCoins;
	}
}
