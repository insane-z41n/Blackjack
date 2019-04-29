package com.z41n.blackjack.hand;

public class PlayerHand extends Hand{

	private String playerName;
	
	//Player name or user name.
	public PlayerHand(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


}
