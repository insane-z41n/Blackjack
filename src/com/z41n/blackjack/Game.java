package com.z41n.blackjack;

import com.z41n.blackjack.hand.PlayerHand;
import com.z41n.blackjack.items.Deck;
import com.z41n.blackjack.items.Deck.Card;

public class Game {
	
	public static void main(String [] args) {
		
		//Testing
//		Deck deck = new Deck();
//		deck.shuffle();
//		
//		Card card = deck.pickUp();
//		System.out.println(card.value + " of " + card.suit);
//		
//		PlayerHand player1 = new PlayerHand("Player 1");
//		player1.addToHand(card);
//		System.out.println(player1.getTotal());
//		System.out.println(player1.getPlayerName());
		
		//Initialize display board
		Board newBoard = new Board(500, 500);
		newBoard.initBoard();
		
	}

}
