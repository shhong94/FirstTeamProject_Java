package com.sist.client;
import java.awt.*;
import javax.swing.*;

public class ControllPanel extends JPanel{
	CardLayout card = new CardLayout();			// 레이아웃 : 카드
	PageOnShow pos = new PageOnShow();			// 현재상영영화 페이지
	PageScheduled ps = new PageScheduled();		// 개봉예졍영화 페이지
	PageRank pr = new PageRank();				// 평점순 페이지
	DetailedPage dp = new DetailedPage();		// 상세페이지
	Reserve rs = new Reserve();					// 예약하기 페이지
	Review rv = new Review();					// 평점 후기 페이지
	
	public ControllPanel() {
		setBackground(Color.yellow);
		setOpaque(true);
		setLayout(card);
		
		
	}
}
