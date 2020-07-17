package com.sist.client;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuForm extends JPanel{
	JButton home, pageOnShow, pageScheduled, pageRank, reserve;
	
	public MenuForm() {
		setBackground(Color.pink);
		home = new JButton("홈");
		pageOnShow = new JButton("현재상영 영화");
		pageScheduled = new JButton("개봉예정 영화");
		pageRank = new JButton("평점 순");
		reserve = new JButton("예매하기");
		
		setLayout(new GridLayout(1, 7, 30, 5));
		add(home);
		add(pageOnShow);
		add(pageScheduled);
		add(pageRank);
		add(reserve);
	}
	
}
