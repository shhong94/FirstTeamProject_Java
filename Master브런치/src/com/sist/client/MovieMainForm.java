package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieMainForm extends JFrame{
	MenuForm mf = new MenuForm();
	ControllPanel cp = new ControllPanel();
	
	public MovieMainForm() {
		setLayout(null);
		// 상단 메뉴
		mf.setBounds(400, 30, 800, 50);
		add(mf);
		// 출력 창
		cp.setBounds(50, 100, 1500, 700);
		add(cp);
		
		
		// 윈도우 창
		setSize(1600, 900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MovieMainForm();

	}

}
