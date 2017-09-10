package net.qcollins;

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
}
