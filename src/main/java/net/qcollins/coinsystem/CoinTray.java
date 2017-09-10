package net.qcollins.coinsystem;

import java.util.ArrayList;
import java.util.List;

import net.qcollins.currency.Currency;

public class CoinTray {
	private List<Currency> coinTray;
	
	public CoinTray() {
		coinTray = new ArrayList<Currency>();
	}
	
	public void addCoinToCoinTray(Currency coin) {
		coinTray.add(coin);
	}
	
	public List<Currency> getCoinTray() {
		return coinTray;
	}
}
