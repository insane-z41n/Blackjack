package com.z41n.blackjack.items;

import java.util.LinkedList;
import java.util.Random;

public class Deck {

	private Card top;
	private int size;
	private String [] cardValues;
	private String [] cardTypes;

	public Deck() {
		size = 0;
		cardValues = new String[13];
		cardTypes = new String[4];
		
		
		for(int i = 0; i < cardValues.length; i++) {
			if(i == 0) {
				cardValues[i] = "A";
			}
			else if(i == 10) {
				cardValues[i] = "J";
			}
			else if (i == 11) {
				cardValues[i] = "Q";
			}
			else if(i == 12) {
				cardValues[i] = "K";
			}
			else {
				cardValues[i] = String.valueOf(i + 1);
			}
		}
		
		cardTypes[0] = "Spades";
		cardTypes[1] = "Hearts";
		cardTypes[2] = "Clubs";
		cardTypes[3] = "Diamonds";
	}
	
	
	//Shuffle the order of the deck.
	public void shuffle() {
		LinkedList<Card> deck = new LinkedList<Card>();
		for(int i = 0; i < cardTypes.length; i++) { 
			for(int j = 0; j < cardValues.length; j++) {
				deck.add(new Card(cardValues[j], cardTypes[i]));
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
		public String type;
		private Card next;
		
		public Card(String value, String type) {
			this.value = value;
			this.type = type;
		}
	}
	
	
}
