package com.sist.client;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

// 상단 메뉴바
public class MenuForm extends JPanel{
	JButton home, pageOnShow, pageScheduled, pageRank, reserve;
	
	public MenuForm() {
		setBackground(Color.gray);
		home = new JButton("홈");
		home.setFont(new Font("굴림체",Font.BOLD,30));
		
		pageOnShow = new JButton("현재상영");
		pageOnShow.setFont(new Font("굴림체",Font.BOLD,30));
		
		pageScheduled = new JButton("개봉예정");
		pageScheduled.setFont(new Font("굴림체",Font.BOLD,30));
		
		pageRank = new JButton("평점순");
		pageRank.setFont(new Font("굴림체",Font.BOLD,30));
		
		
		reserve = new JButton("예매하기");
		reserve.setFont(new Font("굴림체",Font.BOLD,30));
						
		
		// 레이아웃 : 그리드
		setLayout(new GridLayout(1, 4, 1, 10));
		// JPanel에 추가
		// 메뉴버튼
		add(home);
		add(pageOnShow);
		add(pageScheduled);
		add(pageRank);
		
		
	}
	
}
