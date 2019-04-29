package com.z41n.blackjack.hand;

import com.z41n.blackjack.items.Deck.Card;

public interface Hand {
	
	public void addCard(Card newCard);	
	public void removeHand();
	public int getTotal();
	
}
