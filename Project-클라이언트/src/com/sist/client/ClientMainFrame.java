package com.sist.client;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClientMainFrame extends JFrame implements ActionListener{
	JLabel title=new JLabel("프로젝트",JLabel.CENTER);
	MenuForm mf=new MenuForm();
	LightDetailForm ldf=new LightDetailForm();
	LightListForm lf=new LightListForm();
	ControlPanel cp;
	public ClientMainFrame()
	{
		
		cp=new ControlPanel(this);
		title.setFont(new Font("굴림체",Font.BOLD,55));
		
		setLayout(null);
		
		title.setBounds(10, 15, 1570, 100);
		add(title);
		mf.setBounds(10, 120, 100, 300 );
		add(mf);
	
		mf.b4.addActionListener(this);
		cp.setBounds(115, 120, 1465, 635);
		add(cp);
		setSize(1600, 1000);
		setVisible(true);
		
		cp.lf.b1.addActionListener(this);
		cp.lf.b2.addActionListener(this);
		cp.lf.b3.addActionListener(this);
		cp.lf.b4.addActionListener(this);
		cp.lf.b5.addActionListener(this);
		cp.lf.b6.addActionListener(this);
		cp.lf.tf.addActionListener(this);
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        // 생성자는 호출시에 반드시  => new 생성자()
		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		new ClientMainFrame();
		
	}
	public static Image getImage(ImageIcon ii,int w,int h)
    {
       Image dimg = ii.getImage().getScaledInstance(w, h,
               Image.SCALE_SMOOTH);
       return dimg;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mf.b4)
		{
			cp.card.show(cp, "LF");
		}
		else if(e.getSource()==cp.lf.b1)
		{
			cp.lf.LightAllData(1);
		}
		else if(e.getSource()==cp.lf.b2)
		{
			cp.lf.LightAllData(2);
		}
		else if(e.getSource()==cp.lf.b3)
		{
			cp.lf.LightAllData(3);
		}
		else if(e.getSource()==cp.lf.b4)
		{
			cp.lf.LightAllData(4);
		}
		else if(e.getSource()==cp.lf.b5)
		{
			cp.lf.LightAllData(5);
		}
		else if(e.getSource()==cp.lf.b6 || e.getSource()==cp.lf.tf)
		{
			// 1. 입력된 값 읽기
			String ss=cp.lf.tf.getText();
			if(ss.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				cp.lf.tf.requestFocus();
				return; // 메소드 종료 
			}
			cp.lf.movieFindData(ss);
		}
	}
	
}
