package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieMainForm extends JFrame{
	MenuForm mf = new MenuForm();
	ControllPanel cp = new ControllPanel();
	
	public MovieMainForm() {
		// ȭ�� ���̾ƿ� : null
		setLayout(null);
		// ��� �޴�(MenuForm Ŭ����)
		mf.setBounds(400, 30, 800, 50);
		add(mf);
		// ��� â(ControllPanel Ŭ����)
		cp.setBounds(50, 100, 1500, 700);
		add(cp);
		
		
		// ������ â
		setSize(1600, 900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MovieMainForm();

	}

}
