package com.sist.client;

import javax.swing.*;

public class DetailedPage extends JPanel{
	
	JLabel poster;
	JTextArea inform;
	JButton review, reserve;
	
	public DetailedPage() {
		poster = new JLabel();
		inform = new JTextArea();
		review = new JButton("���� �ı�");
		reserve = new JButton("�����ϱ�");
		
		
		add(poster);
		add(inform);
		add(review);
		add(reserve);
	}
}
