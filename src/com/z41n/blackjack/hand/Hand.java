package com.z41n.blackjack.hand;

import java.util.LinkedList;

import com.z41n.blackjack.items.Deck.Card;

public class Hand {

	private int maxedAces = 0;
	private LinkedList<Card> cards = new LinkedList<Card>();
	
	//Add card to hand (Specifically the cards LinkedList).
	public void addToHand(Card newCard) {
		if(newCard.value.equals("A")) {
			maxedAces++;
		}
		cards.add(newCard);
	}
	
	//Remove all cards from linked list.
	public void removeHand() {
		while(cards.size() != 0) {
			
			cards.remove();
		}
	}
	
	//Get total value of cards in hand.
	public int getTotal() {
		
		if(cards == null || cards.size() < 0) {
			return -1;
		}
		
		int total = 0;
		
		for(int i = 0; i < cards.size(); i++) {
			
			int val = 0;
			
			if(cards.get(i).value.equals("A")) {

				val = 11;

			} else if(cards.get(i).value.equals("J") || cards.get(i).value.equals("Q") || cards.get(i).value.equals("K")) {

				val = 10;

			} else {
				val = Integer.parseInt(cards.get(i).value);
			}
			total+=val;
		}
		
		//While there are aces at the value of 11.
		while(maxedAces > 0) {
			if(total > 21) {
				total -=10;		//change value of ace to 1 by subtracting 10 from total.
				maxedAces--;
			}
		}
		
		return total;
	}
	
	//Returns the number of cards in hand.
	public int getNumCards() {
		
		return cards.size();
	}
	
	//Returns the list of cards.
	public LinkedList<Card> getCurrentHand() {
		
		return cards;
	}
	
	//Check if current hand is empty or not.
	public boolean isHandEmpty() {
		
		return cards.isEmpty();
	}
	
	//Remove current hands cards.
	public void removeCurrentHand(){
		
		while(cards.size() != 0) {
			cards.removeFirst();
		}
	}
	
}
