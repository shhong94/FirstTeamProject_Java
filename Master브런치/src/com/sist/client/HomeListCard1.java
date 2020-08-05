package com.sist.client;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.*;

public class HomeListCard1 extends JPanel{
	JLabel posterLa=new JLabel();
	JLabel la1,la2,la3;
	JTextPane ta;
	public HomeListCard1(DetailVO vo) {
		
		try {
			URL url=new URL(vo.getPoster());
			Image img=MovieMainForm.getImage(new ImageIcon(url), 200, 200);
			posterLa.setIcon(new ImageIcon(img));
		}catch (Exception e) {
			
		}
		
		la1=new JLabel();
		la2=new JLabel();
		la2.setForeground(Color.orange);	// 점수 색깔 주황
		la3=new JLabel();
		ta=new JTextPane();
		//ta.setText();
		
		setLayout(null);
		posterLa.setBounds(10, 15, 200, 200);
		la1.setBounds(215, 15, 350, 30);
		la2.setBounds(570, 15, 60, 30);
		la3.setBounds(215, 50, 415, 30);
		ta.setBounds(215, 85, 415, 130);
		
		add(posterLa);
		add(la1);
		add(la2);
		add(la3);
		add(ta);
		
		
	}
	
}
