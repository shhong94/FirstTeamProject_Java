package com.sist.client;
import java.awt.*;
import javax.swing.*;

public class ControllPanel extends JPanel{
	CardLayout card = new CardLayout();			// 레이아웃 : 카드
	HomePrint1 home=new HomePrint1();						// 홈 페이지
	PageOnShow2 pos = new PageOnShow2();			// 현재상영영화 페이지
	PageScheduled3 ps = new PageScheduled3();		// 개봉예졍영화 페이지
	PageRank4 pr = new PageRank4();				// 평점순 페이지
	DetailedPage dp = new DetailedPage();		// 상세페이지
	Reserve rs = new Reserve();					// 예약하기 페이지
	Review rv = new Review();					// 평점 후기 페이지
	
	public ControllPanel() {
		setBackground(Color.yellow);
		setOpaque(true);
		setLayout(card);
		add("HOME",home);
		add("POS",pos);
		add("PS",ps);
		add("PR",pr);
		
	}
}
