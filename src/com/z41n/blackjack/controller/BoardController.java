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
		board.newGameButton.addActionListener(a -> startNewGame());
		board.dealButton.addActionListener(a -> dealCards());
		board.hitButton.addActionListener(a -> hitPlayerHand());
		//board.standButton.addActionListener(a -> stand());
	}
	
	//Add card to player hand and check if they have not exceeded 21.
	private void hitPlayerHand() {
		
		boolean bust = false;
		
		Card newCard = deck.pickUp();
		player.addToHand(newCard);
		board.displayPlayerHand(newCard);
		
		int total = player.getTotal();
		bust = getHandResult(total);
		
		if(!bust) {
			
			if(total == 21) {
				System.out.println("You have 21! You win!");
				
			} else if(player.getNumCards() > 4) {
				System.out.println("You win by the rule of Charlie");
				
			} else {
				System.out.println("Your total = " + total + ".");
			}
			
		} else {
			System.out.println("You Lose");
		}

	}
	
	//Returns result of current hand.
	private boolean getHandResult(int total) {
		if(total > 21) {
			return true;
		} else if (total == 21) {
			return false;
		} else {
			return false;
		}
	}
	
	//Deals cards to the players and the dealer.
	private void dealCards() {
		
		boolean cardsDealt = false;
		
		do {
			//Total cards that need to be dealt this pass
			Card card1 = null;
			Card card2 = null;
			
			while(card1 == null) {
				card1 = deck.pickUp();
			}
			while(card2 == null) {
				card2 = deck.pickUp();
			}
			
			//Deal the card to Dealer
			if(dealer.getNumCards() != 2) {
				
				dealer.addToHand(card1);
				board.displayDealerHand(card1);
				
				cardsDealt = false;
			} else {
				
				cardsDealt = true;
			}
			
			//Deal the card to Player
			if(player.getNumCards() != 2) {
				
				player.addToHand(card2);
				board.displayPlayerHand(card2);
				
				cardsDealt = false;
				
			} else {
				
				cardsDealt = true;
			}
			
		} while(!cardsDealt);
		
		int total = player.getTotal();
		
		if(total == 21) {
			System.out.println("You have 21! You win!");
			
		} else if(player.getNumCards() > 4) {
			System.out.println("You win by the rule of Charlie");
			
		} else {
			System.out.println("Your total = " + total + ".");
		}
		
	}
	
	
	private void startNewGame() {
		
		if(!dealer.isHandEmpty() && !player.isHandEmpty()) {
			//Remove dealer cards from board.
			dealer.removeCurrentHand();
			board.removeDealerCardsLabel();
			board.dealerCardsPanel.removeAll();
			board.dealerCardsPanel.revalidate();
			board.dealerCardsPanel.repaint();
			board.dealerIndex = 0;
			
			//Remove player cards from board.
			player.removeCurrentHand();
			board.removePlayerCardsLabel();
			board.playerCardsPanel.removeAll();
			board.playerCardsPanel.revalidate();
			board.playerCardsPanel.repaint();
			board.playerIndex = 0;
		
			//Shuffle deck.
			deck.shuffle();
		}
	}
	


}
