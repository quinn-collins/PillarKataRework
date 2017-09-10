package net.qcollins;

public class Display {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void updateMessage(DollarAmount currentBalance) {
		if(currentBalance.getCents() == 0) {
			this.message = DisplayMessage.INSERT_COINS.getMessage();
		}
		else {
			this.message = currentBalance.toString();
		}
	}
}
