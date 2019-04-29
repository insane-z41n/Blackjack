package com.z41n.blackjack;

import com.z41n.blackjack.items.Deck;
import com.z41n.blackjack.items.Deck.Card;

public class Game {
	
	public static void main(String [] args) {
		Deck deck = new Deck();
		deck.shuffle();
		
		Card card = deck.pickUp();
		System.out.println(card.value + " of " + card.type);
		
		Board newBoard = new Board(500, 500);
		newBoard.initBoard();
		
	}

}
