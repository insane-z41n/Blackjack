package com.z41n.blackjack.items;

import java.util.LinkedList;
import java.util.Random;

/*
 * Deck Class
 * 
 * Stack of card nodes
 * Card data
 */
public class Deck {

	private Card top;
	private int size;
	private String [] values;
	private String [] suits;

	public Deck() {
		size = 0;
		values = new String[13];
		suits = new String[4];
		
		
		for(int i = 0; i < values.length; i++) {
			if(i == 0) {
				values[i] = "A";
			}
			else if(i == 10) {
				values[i] = "J";
			}
			else if (i == 11) {
				values[i] = "Q";
			}
			else if(i == 12) {
				values[i] = "K";
			}
			else {
				values[i] = String.valueOf(i + 1);
			}
		}
		
		suits[0] = "Spades";
		suits[1] = "Hearts";
		suits[2] = "Clubs";
		suits[3] = "Diamonds";
	}
	
	
	//Shuffle the order of the deck.
	public void shuffle() {
		LinkedList<Card> deck = new LinkedList<Card>();
		for(int i = 0; i < suits.length; i++) { 
			for(int j = 0; j < values.length; j++) {
				deck.add(new Card(values[j], suits[i]));
			}
		}
		
		int tempSize = 52;
		while(!deck.isEmpty()) {
			Random rand = new Random();
			int i = rand.nextInt(tempSize);
			Card card = deck.remove(i);
			add(card);
			tempSize--;
		}
	}
	
	//Pick up card from top of the deck.
	public Card pickUp() {
		if(this.isEmpty()) {
			return null;
		}
		Card card = top;
		top = top.next;
		size--;
		return card;
	}
	
	//Add a card to top of deck.
	public void add(Card card) {
		card.next = top;
		top = card;
		size++;
	}
	
	//Checks to see if deck is empty.
	public boolean isEmpty() {
		return top == null;
	}
	
	//Return the top Card.
	public Card peek() {
		return top;
	}
	
	//Returns the size of the deck.
	public int size() {
		return size;
	}
	
	public static class Card {
		
		public String value;
		public String suit;
		private Card next;
		
		public Card(String value, String suit) {
			this.value = value;
			this.suit = suit;
		}
	}
	
	
}
