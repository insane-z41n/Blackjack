package com.z41n.blackjack.hand;

import java.util.LinkedList;

import com.z41n.blackjack.items.Deck.Card;

public class Hand {
	
	private int numCards = 0;
	private int total = 0;
	private LinkedList<Card> cards = new LinkedList<Card>();
	
	
	//Add card to hand (Specifically the cards LinkedList).
	public void addToHand(Card newCard) {
		cards.add(newCard);
		numCards++;
	}
	
	//Remove all cards from linked list.
	public void removeHand() {
		while(numCards != 0) {
			cards.remove();
			numCards--;
		}
	}
	
	//Get total value of cards in hand.
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
	
	public int getNumCards() {
		return numCards;
	}
	
}
