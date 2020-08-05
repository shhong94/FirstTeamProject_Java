package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieMainForm extends JFrame implements ActionListener{
	MenuForm mf = new MenuForm();				// 상단 메뉴바
	ControllPanel cp = new ControllPanel();		// 화면출력창 (변경되는 페이지)
	ChatForm cf = new ChatForm();				// 채팅창
	
	public MovieMainForm() {
		// 화면 레이아웃 : null
		setLayout(null);
		// 상단 메뉴(MenuForm 클래스)
		mf.setBounds(270, 85, 800, 50);
		add(mf);
		// (예약버튼)
		JPanel p=new JPanel();
		p.setBounds(1300, 85, 200, 50);
		p.setLayout(new GridLayout());
		p.add(mf.reserve);
		add(p);				
				
		// 출력 창(ControllPanel 클래스)
		cp.setBounds(40, 170, 1240, 690);
		add(cp);
		// 채팅 창
		cf.setBounds(1300, 170, 255, 690);
		add(cf);		
		
		// 윈도우 창
		setSize(1600, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 메뉴버튼 클릭시 이벤트
		mf.home.addActionListener(this);
		mf.pageOnShow.addActionListener(this);
		mf.pageScheduled.addActionListener(this);
		mf.pageRank.addActionListener(this);		
		
		// 예약버튼 클릭시 이벤트
		mf.reserve.addActionListener(this);
	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		new MovieMainForm();

	}
	
	public static Image getImage(ImageIcon ii,int w,int h)
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    }//	라벨크기에 맞춰 이미지의 크기 조절
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mf.home) {
			cp.card.show(cp, "HOME");
		}else if(e.getSource()==mf.pageOnShow) {
			cp.card.show(cp, "POS");
		}else if(e.getSource()==mf.pageScheduled) {
			cp.card.show(cp, "PS");
		}else if(e.getSource()==mf.pageRank) {
			cp.card.show(cp, "PR");
		}
	}

}
