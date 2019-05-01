package com.z41n.blackjack.controller;

import com.z41n.blackjack.Board;
import com.z41n.blackjack.hand.DealerHand;
import com.z41n.blackjack.hand.PlayerHand;
import com.z41n.blackjack.items.Deck;
import com.z41n.blackjack.items.Deck.Card;

/*
 * BoardController Class
 * 
 * Controller class for Board GUI
 * handles all interactions in Board Class.
 * 
 */
public class BoardController {
	
	private Board board;
	private Deck deck;
	
	private DealerHand dealer;
	private PlayerHand player;
	

	//Constructor Initializes Objects.
	public BoardController(Board board) {
		this.board = board;
		deck = new Deck();
		dealer = new DealerHand(17);
		player = new PlayerHand("Player 1");
		
		deck.shuffle();
		initController();
	}
	
	//Holds all components with listeners.
	private void initController() {
		board.dealButton.addActionListener(a -> dealCards());
		board.hitButton.addActionListener(a -> hitPlayerHand());
		//board.standButton.addActionListener(a -> stand());
	}
	
	private void hitPlayerHand() {
		
	}
	
	//Deals cards to the players and the dealer.
	private void dealCards() {
		
		boolean cardsDealt = false;
		
		do {
			//Total cards that need to be dealt this pass
			Card card1 = deck.pickUp();
			Card card2 = deck.pickUp();
			
			//Deal the card to Dealer
			//System.out.println(dealer.getNumCards());
			if(dealer.getNumCards() != 2) {
				dealer.addToHand(card1);
				board.addToDealerHand(card1);
				
				cardsDealt = false;
			} else {
				cardsDealt = true;
			}
			
			//Deal the card to Player
			//System.out.println(player.getNumCards());
			if(player.getNumCards() != 2) {
				player.addToHand(card2);
				board.addToPlayerHand(card2);
				
				cardsDealt = false;
			} else {
				cardsDealt = true;
			}
			
			//System.out.println("Hello");
			
		} while(!cardsDealt);
		
	}
	
	


}
