package com.z41n.blackjack.hand;

import java.util.LinkedList;

import com.z41n.blackjack.items.Deck.Card;

public class PlayerHand implements Hand{
	
	private int numCards;
	private int total;
	private LinkedList<Card> cards;
	public String playerName;
	
	public PlayerHand(String playerName) {
		this.playerName = playerName;
	}
	
	//add card to linked list.
	public void addCard(Card newCard) {
		cards.add(newCard);
		numCards++;
	}
	
	//remove all cards from hand.
	public void removeHand() {
		while(numCards != 0) {
			cards.remove();
			numCards--;
		}
		
		total = 0;
	}
	
	//get total 
	public int getTotal() {
		
		if(cards == null || cards.size() < 0) {
			return -1;
		}
		
		for(int i = 0; i < cards.size(); i++) {
			Card currentCard = cards.get(i);
			int val = 0;
			if(currentCard.value.equals("A")) {
				val = 1;
			} else if(currentCard.value.equals("J")) {
				val = 11;
			} else if(currentCard.value.equals("Q")) {
				val = 12;
			} else if(currentCard.value.equals("K")) {
				val = 13;
			} else {
				val = Integer.parseInt(currentCard.value);
			}
			
			total+=val;
		}
		
		return total;
	}

}
