package net.qcollins;

public class DollarAmount {
	public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0);
    private int totalAmountInCents;
	
	public DollarAmount(int totalAmountInCents) {
        this.totalAmountInCents = totalAmountInCents;
    }
    public DollarAmount(int dollars, int cents) {
    	this.totalAmountInCents = dollars * 100 + cents;
    }
    
    public int getCents() {
        return (int)(totalAmountInCents % 100);
    }
    
    public int getDollars() {
        return totalAmountInCents / 100;
    }
    
    public boolean isGreaterThan(DollarAmount amountToCompare) {
        return this.totalAmountInCents > amountToCompare.totalAmountInCents;
    }
}
