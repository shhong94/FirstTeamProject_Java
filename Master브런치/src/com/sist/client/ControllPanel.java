package com.sist.client;
import java.awt.*;
import javax.swing.*;

public class ControllPanel extends JPanel{
	CardLayout card = new CardLayout();
	PageOnShow pos = new PageOnShow();
	PageScheduled ps = new PageScheduled();
	PageRank pr = new PageRank();
	DetailedPage dp = new DetailedPage();
	Reserve rs = new Reserve();
	Review rv = new Review();
	
	public ControllPanel() {
		setBackground(Color.yellow);
		setOpaque(true);
		setLayout(card);
		
		
	}
}
