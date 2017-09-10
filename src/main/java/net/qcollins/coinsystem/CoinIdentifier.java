package net.qcollins.coinsystem;

import net.qcollins.currency.Currency;
import net.qcollins.currency.Dime;
import net.qcollins.currency.Nickel;
import net.qcollins.currency.Quarter;
import net.qcollins.currency.Rejected;

public class CoinIdentifier {
	/**
	 * This method is used to identify coins based on some parameters.
	 * @param mass is identified in grams.
	 * @param diameter is identified in millimeters.
	 * @param thickness is identified in millimeters.
	 * @return a coin object.
	 */
	public Currency identify(double mass, double diameter, double thickness) {
		if(inRange(5.670, 0.1, mass)) {
			return new Quarter();
		}
		else if(inRange(2.268, 0.1, mass)) {
			return new Dime();
		}
		else if(inRange(5, 0.1, mass)) {
			return new Nickel();
		}
		else {
			return new Rejected();
		}
	}
	
	private boolean inRange(double target, double range, double value) {
		return target - range <= value && target + range >= value;
	}
}
