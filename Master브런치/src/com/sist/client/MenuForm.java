package com.sist.client;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuForm extends JPanel{
	JButton home, pageOnShow, pageScheduled, pageRank, reserve;
	
	public MenuForm() {
		setBackground(Color.pink);
		home = new JButton("Ȩ");
		pageOnShow = new JButton("����� ��ȭ");
		pageScheduled = new JButton("�������� ��ȭ");
		pageRank = new JButton("���� ��");
		reserve = new JButton("�����ϱ�");
		
		setLayout(new GridLayout(1, 7, 30, 5));
		add(home);
		add(pageOnShow);
		add(pageScheduled);
		add(pageRank);
		add(reserve);
	}
	
}
