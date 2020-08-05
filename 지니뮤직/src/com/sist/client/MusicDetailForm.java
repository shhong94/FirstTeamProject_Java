package com.sist.client;
import java.awt.*;
import java.net.URL;

import javax.swing.*;

import com.sist.data.MusicManager;
import com.sist.data.MusicVO;

import java.util.*;
public class MusicDetailForm extends JPanel{
	   JLabel poster=new JLabel();
	   JLabel la1=new JLabel();
	   JLabel[] la=new JLabel[3];
	   JButton b1,b2;
	   public MusicDetailForm()
	   {
		   setLayout(null);
		   poster.setBounds(10, 15, 350, 400);
		   add(poster);
		   la1.setBounds(365, 15, 500, 45);
		   la1.setFont(new Font("굴림체",Font.BOLD,35));
		   add(la1);
		   JPanel p=new JPanel();
		   p.setLayout(new GridLayout(3,1,5,5));
		   String[] str={"순위","아티스트","앨범"};
		   for(int i=0;i<3;i++)
		   {
			   la[i]=new JLabel(str[i]);
			   la[i].setFont(new Font("굴림체",Font.BOLD,20));
			   p.add(la[i]);
		   }
		   p.setBounds(365, 80, 500, 300);
		   add(p);
		   
		   
		   b1=new JButton("예매");
		   b2=new JButton("목록");
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
		   MusicManager m=new MusicManager();
		   MusicVO vo=m.musicDetailData(mno);
		   la1.setText(vo.getTitle());
		   try
		   {
			   URL url=new URL(vo.getPoster());
			   Image img=ClientMainFrame.getImage(new ImageIcon(url), 
					   poster.getWidth(), poster.getHeight());
			   poster.setIcon(new ImageIcon(img));
		   }catch(Exception ex) {}
		   
		   la[0].setText("순위:"+vo.getRank());
		   la[1].setText("아티스트:"+vo.getArtist());
		   la[2].setText("앨범:"+vo.getAlbum());
		   
	   }
}