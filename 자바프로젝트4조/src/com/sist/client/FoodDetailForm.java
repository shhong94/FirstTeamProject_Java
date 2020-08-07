package com.sist.client;
import java.awt.*;
import java.net.URL;

import javax.swing.*;

import com.sist.data.FoodManager;
import com.sist.data.FoodVO;

import java.util.*;
public class FoodDetailForm extends JPanel{
	JLabel poster=new JLabel();
	JLabel la1=new JLabel();
	JLabel[] la=new JLabel[7];
//	JTextPane ta=new JTextPane(); //Area���� ����
	public FoodDetailForm() {
		setLayout(null);
		poster.setBounds(10, 15, 300, 350);
		add(poster);
		la1.setBounds(325, 15, 500, 45);
		la1.setFont(new Font("����ü",Font.BOLD,25));
		add(la1);
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(7,1,5,5));
		String[] str={"����","����","��ũ��","�ּ�","��ȭ��ȣ","��������","���ݴ�"};
		for(int i=0;i<7;i++) {
			la[i]=new JLabel(str[i]);
			la[i].setFont(new Font("����ü",Font.BOLD,17));
			p.add(la[i]);
		}
		p.setBounds(325, 80, 500, 300);
		add(p);
		
//		ta.setEditable(false); //��Ȱ��ȭ  
//		JScrollPane js=new JScrollPane(ta);
//		js.setBounds(10, 420, 700, 130);
//		add(js);
	}
	public void detailPrint(int mno) { //���
		FoodManager m=new FoodManager();
		FoodVO fo=m.foodDetailData(mno);
		la1.setText(fo.getTitle());
		try {
			URL url=new URL(fo.getPoster());
			Image img=ClientMainFrame.getImage(new ImageIcon(url), poster.getWidth(), poster.getHeight());
			//��ũ�⿡ �����缭 �̹����� �߶󳻶�
			poster.setIcon(new ImageIcon(img));
		}catch(Exception ex) {}
		la[0].setText("����: "+fo.getScore());
		la[1].setText("����: "+fo.getShowUser());
		la[2].setText("��ũ��: "+fo.getLike());
		la[3].setText("�ּ�: "+fo.getAddrss());
		la[4].setText("��ȭ��ȣ: "+fo.getTel());
		la[5].setText("��������: "+fo.getType());
		la[6].setText("���ݴ�: "+fo.getPrice());
//		ta.setText(fo.getReview());
	}
}
