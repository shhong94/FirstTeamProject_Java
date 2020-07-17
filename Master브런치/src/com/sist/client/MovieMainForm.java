package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieMainForm extends JFrame{
	MenuForm mf = new MenuForm();				// 상단 메뉴바
	ControllPanel cp = new ControllPanel();		// 화면출력창 (변경되는 페이지)
	ChatForm cf = new ChatForm();				// 채팅창
	
	public MovieMainForm() {
		// 화면 레이아웃 : null
		setLayout(null);
		// 상단 메뉴(MenuForm 클래스)
		mf.setBounds(400, 30, 800, 50);
		add(mf);
		// 출력 창(ControllPanel 클래스)
		cp.setBounds(50, 100, 1200, 700);
		add(cp);
		// 채팅 창
		cf.setBounds(1260, 100, 300, 700);
		add(cf);
		
		
		// 윈도우 창
		setSize(1600, 900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MovieMainForm();

	}

}
