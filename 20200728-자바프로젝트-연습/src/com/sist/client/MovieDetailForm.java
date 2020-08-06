package com.sist.client;
import java.awt.*;
import java.net.URL;

import javax.swing.*;

import com.sist.data.MovieManager;
import com.sist.data.MovieVO;

import java.util.*;
public class MovieDetailForm extends JPanel{
	   JLabel poster=new JLabel();
	   JLabel la1=new JLabel();
	   JLabel[] la=new JLabel[7];
	   JTextPane ta=new JTextPane();
	   JButton b1,b2;
	   public MovieDetailForm()
	   {
		   setLayout(null);
		   poster.setBounds(10, 15, 350, 400);
		   add(poster);
		   la1.setBounds(365, 15, 500, 45);
		   la1.setFont(new Font("맑은 고딕",Font.BOLD,30));
		   add(la1);
		   JPanel p=new JPanel();
		   p.setLayout(new GridLayout(7,1,5,5));
		   String[] str={"","저자","출판사","분야","순위","출간일","가격",""};
		   for(int i=0;i<7;i++)
		   {
			   la[i]=new JLabel(str[i]);
			   la[i].setFont(new Font("맑은 고딕",Font.BOLD,18));
			   p.add(la[i]);
		   }
		   p.setBounds(365, 80, 500, 300);
		   add(p);
		   
		   ta.setEditable(false);
		   JScrollPane js=new JScrollPane(ta);
		   js.setBounds(10, 420,700, 130);
		   add(js);
		   
		   b1=new JButton("구매");
		   b2=new JButton("찜 ♥");
		   b1.setBackground(Color.red);
		   b2.setBackground(Color.green);
		   JPanel p2=new JPanel();
		   p2.add(b1);
		   p2.add(b2);
		   p2.setBounds(365, 385, 200, 35);
		   add(p2);
	   }
	   public void detailPrint(int mno)
	   {
		   MovieManager m=new MovieManager();
		   MovieVO vo=m.movieDetailData(mno);
		   la1.setText(vo.getTitle());
		   try
		   {
			   URL url=new URL(vo.getPoster());
			   Image img=ClientMainFrame.getImage(new ImageIcon(url), 
					   poster.getWidth(), poster.getHeight());
			   poster.setIcon(new ImageIcon(img));
		   }catch(Exception ex) {}
		   
		   la[0].setText(vo.getScore());
		   la[1].setText("저자 : "+vo.getDirector());
		   la[2].setText("출판사 : "+vo.getActor());
		   la[3].setText("분야 : "+vo.getGenre());
		   la[4].setText("순위 : "+vo.getGrade());
		   la[5].setText("출간일 : "+vo.getRegdate());
		   la[6].setText("가격 : "+vo.getShowUser());
		   ta.setText(vo.getStory());
	   }
}




