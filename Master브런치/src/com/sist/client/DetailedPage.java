package com.sist.client;

import javax.swing.*;

public class DetailedPage extends JPanel{
	
	JLabel poster;
	JTextArea inform;
	JButton review, reserve;
	
	public DetailedPage() {
		poster = new JLabel();
		inform = new JTextArea();
		review = new JButton("평점 후기");
		reserve = new JButton("예매하기");
		
		
		add(poster);
		add(inform);
		add(review);
		add(reserve);
	}
}
