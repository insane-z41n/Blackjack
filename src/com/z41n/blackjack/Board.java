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

import com.z41n.blackjack.controller.BoardController;
import com.z41n.blackjack.items.Deck.Card;

public class Board extends JFrame{
	
	private int width, height;
	private int dealerIndex = 0, playerIndex = 0;
	
	private JPanel dealerCardsPanel, playerCardsPanel;
	
	public JButton dealButton, hitButton, standButton;
	
	private LinkedList<JLabel> dealerCards = new LinkedList<JLabel>();
	private LinkedList<JLabel> playerCards = new LinkedList<JLabel>();
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void initBoard() {
		
		setSize(width, height);
		setPreferredSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//contains all the components on the board.
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(2,0));
		add(tablePanel, BorderLayout.CENTER);

		//Contains all the dealer card.
		JPanel dealerPanel = new JPanel();
		dealerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tablePanel.add(dealerPanel);
		
		dealerCardsPanel = new JPanel();
		dealerCardsPanel.setLayout(new BoxLayout(dealerCardsPanel, BoxLayout.PAGE_AXIS));
		dealerPanel.add(dealerCardsPanel);
		
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
		buttonPanel.add(hitButton);
		
		standButton = new JButton("Stand");
		standButton.setFocusPainted(false);
		buttonPanel.add(standButton);
		
//		newButton = new JButton("New Game");
//		newButton.setFocusPainted(false);
//		newButton.setVisible(false);
		
		new BoardController(this);
		
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void addToPlayerHand(Card newCard) {
		JLabel card = createCardLabel(newCard);
		playerCards.add(card);
		
		playerCardsPanel.add(playerCards.get(playerIndex));
		
		playerIndex++;
		
		playerCardsPanel.revalidate();
		playerCardsPanel.repaint();
		
	}
	
	//Display cards from deallers hand.
	public void addToDealerHand(Card newCard) {
		JLabel card = createCardLabel(newCard);
		dealerCards.add(card);
		
		if(dealerCards.size() == 1) {
			JLabel blankLabel = new JLabel("FLIPPED");
			createCardLabel(blankLabel);
			dealerCardsPanel.add(blankLabel);
		} else {
			dealerCardsPanel.add(dealerCards.get(dealerIndex));
		}
	
		dealerIndex++;
		
		dealerCardsPanel.revalidate();
		dealerCardsPanel.repaint();
	}
	
	//Create Card Label with Card as paramater.
	private JLabel createCardLabel(Card newCard) {
		//System.out.println(newCard.value + " of " + newCard.type);
		JLabel card = new JLabel(newCard.value + " of " + newCard.type);
		createCardLabel(card);
		return card;
	}
	
	//Create Card Label 
	private void createCardLabel(JLabel lbl) {
		lbl.setForeground(Color.RED);
	}
	
	

}
