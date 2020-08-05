package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MenuForm extends JPanel{ //고정됨
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	//초기화 (버튼) > 배치 (생성자)
	public MenuForm () {
//		setBackground(Color.orange); //백그라운드는 사이즈 조정할떄 볼라규
		b1=new JButton("홈");
		b2=new JButton("영화찾기");
		b3=new JButton("영화예매");
		b4=new JButton("영화추천");
		b5=new JButton("뉴스");
		b6=new JButton("영화뮤직");
		b7=new JButton("영화맛집");
		b8=new JButton("종료");
		
		setLayout(new GridLayout(8, 1,5,5)); //위에 한줄 null
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
	}
}
