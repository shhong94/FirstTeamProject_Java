package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieMainForm extends JFrame implements ActionListener{
	MenuForm mf = new MenuForm();				// ��� �޴���
	ControllPanel cp = new ControllPanel();		// ȭ�����â (����Ǵ� ������)
	ChatForm cf = new ChatForm();				// ä��â
	
	public MovieMainForm() {
		// ȭ�� ���̾ƿ� : null
		setLayout(null);
		// ��� �޴�(MenuForm Ŭ����)
		mf.setBounds(270, 85, 800, 50);
		add(mf);
		// (�����ư)
		JPanel p=new JPanel();
		p.setBounds(1300, 85, 200, 50);
		p.setLayout(new GridLayout());
		p.add(mf.reserve);
		add(p);				
				
		// ��� â(ControllPanel Ŭ����)
		cp.setBounds(40, 170, 1240, 690);
		add(cp);
		// ä�� â
		cf.setBounds(1300, 170, 255, 690);
		add(cf);		
		
		// ������ â
		setSize(1600, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �޴���ư Ŭ���� �̺�Ʈ
		mf.home.addActionListener(this);
		mf.pageOnShow.addActionListener(this);
		mf.pageScheduled.addActionListener(this);
		mf.pageRank.addActionListener(this);		
		
		// �����ư Ŭ���� �̺�Ʈ
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
    }//	��ũ�⿡ ���� �̹����� ũ�� ����
	
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
