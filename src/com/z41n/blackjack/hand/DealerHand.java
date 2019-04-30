package com.z41n.blackjack.hand;

public class DealerHand extends Hand {
	
	private int maxAmount;
	
	//The dealers max amount they do not hit on unless the are losing.
	public DealerHand(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	public int getMaxAmount() {
		return maxAmount;
	}
	
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

}
