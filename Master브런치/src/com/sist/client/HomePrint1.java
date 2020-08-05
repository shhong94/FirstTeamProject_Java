package com.sist.client;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class HomePrint1 extends JPanel{
	public HomePrint1() {
		setBackground(Color.green);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(5,2));
		add("Center",p);
		
		setSize(1300, 1000);
		setVisible(true);
	}
}
