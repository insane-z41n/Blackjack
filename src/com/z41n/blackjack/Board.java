package com.z41n.blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.z41n.blackjack.controller.BoardController;
import com.z41n.blackjack.items.Deck.Card;

public class Board extends JFrame{
	
	private int width, height;
	public int dealerIndex = 0, playerIndex = 0;
	
	public JPanel dealerCardsPanel, playerCardsPanel;
	
	public JLabel gameInfoLabel, flippedLabel;
	
	public JButton newGameButton, dealButton, hitButton, standButton;
	
	public LinkedList<JLabel> dealerCards = new LinkedList<JLabel>();
	public LinkedList<JLabel> playerCards = new LinkedList<JLabel>();
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void initBoard() {
		
		setSize(width, height);
		setPreferredSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(topPanel, BorderLayout.NORTH);
		
		newGameButton = new JButton("New Game");
		newGameButton.setFocusPainted(false);
		newGameButton.setEnabled(false);
		topPanel.add(newGameButton);
		
		//contains all the components on the board.
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(3,0));
		add(tablePanel, BorderLayout.CENTER);

		//Contains all the dealer card.
		JPanel dealerPanel = new JPanel();
		dealerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tablePanel.add(dealerPanel);
		
		//Panel containing the 
		dealerCardsPanel = new JPanel();
		dealerCardsPanel.setLayout(new BoxLayout(dealerCardsPanel, BoxLayout.PAGE_AXIS));
		dealerPanel.add(dealerCardsPanel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tablePanel.add(centerPanel);
		
		gameInfoLabel = new JLabel("Welcome to BlackJack!");
		gameInfoLabel.setForeground(Color.RED);
		gameInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(gameInfoLabel);
		
		
		//Contains all the player cards.
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tablePanel.add(playerPanel);
		
		playerCardsPanel = new JPanel();
		playerCardsPanel.setLayout(new BoxLayout(playerCardsPanel, BoxLayout.PAGE_AXIS));
		playerPanel.add(playerCardsPanel);
		
		
		//Contains all the user buttons.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(buttonPanel, BorderLayout.SOUTH);
		
		dealButton = new JButton("Deal");
		dealButton.setFocusPainted(false);
		buttonPanel.add(dealButton);
		
		hitButton = new JButton("Hit");
		hitButton.setFocusPainted(false);
		hitButton.setEnabled(false);
		buttonPanel.add(hitButton);
		
		standButton = new JButton("Stand");
		standButton.setFocusPainted(false);
		standButton.setEnabled(false);
		buttonPanel.add(standButton);

		new BoardController(this);
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	//Display cards from player hand after adding new card to player cards label list.
	public void displayPlayerHand(Card newCard) {
		JLabel card = createCardLabel(newCard);
		playerCards.add(card);
		
		playerCardsPanel.add(playerCards.get(playerIndex));
		
		playerIndex++;
		
		playerCardsPanel.revalidate();
		playerCardsPanel.repaint();
		
	}
	
	//Display cards from dealers hand after adding new card to player cards label list.
	public void displayDealerHand(Card newCard) {
		JLabel card = createCardLabel(newCard);
		dealerCards.add(card);
		
		if(dealerCards.size() == 1) {
			flippedLabel = new JLabel("FLIPPED");
			designCard(flippedLabel);
			dealerCardsPanel.add(flippedLabel);
		} else {
			dealerCardsPanel.add(dealerCards.get(dealerIndex));
		}
	
		dealerIndex++;
		
		dealerCardsPanel.revalidate();
		dealerCardsPanel.repaint();
	}
	
	
	//Create Card Label with Card as parameter.
	private JLabel createCardLabel(Card newCard) {
		//System.out.println(newCard.value + " of " + newCard.type);
		JLabel card = new JLabel(newCard.value + " of " + newCard.suit);
		designCard(card);
		return card;
	}
	
	//Design Card Label 
	private void designCard(JLabel lbl) {
		lbl.setForeground(Color.RED);
	}
	
	//Remove Dealer Cards Label
	public void removeDealerCardsLabel() {
		while(!dealerCards.isEmpty()) {
			dealerCards.removeFirst();
		}
	}
	
	//Remove Player Cards Label
	public void removePlayerCardsLabel() {
		while(!playerCards.isEmpty()) {
			playerCards.removeFirst();
		}
	}
	
	

}
