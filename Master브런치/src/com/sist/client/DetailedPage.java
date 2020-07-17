package com.sist.client;

import javax.swing.*;

// 상세페이지
public class DetailedPage extends JPanel{
	
	JLabel poster;				// 포스터
	JTextArea inform;			// 포스터 오른쪽 영화정보
	JButton review, reserve;	// 영화정보 아래 버튼 2개(평점후기, 예매하기)
	
	public DetailedPage() {
		// 인스턴스 생성
		poster = new JLabel();
		inform = new JTextArea();
		review = new JButton("평점 후기");
		reserve = new JButton("예매하기");
		
		// JPanel에 추가
		add(poster);
		add(inform);
		add(review);
		add(reserve);
	}
}
