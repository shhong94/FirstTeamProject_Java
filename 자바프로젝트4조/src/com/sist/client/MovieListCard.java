package com.sist.client;
import java.awt.*;
import javax.swing.*;

import com.sist.data.*;
import java.net.*;
public class MovieListCard extends JPanel{
     JLabel posterLa=new JLabel();
     JLabel la1,la2,la3;
     JTextPane ta;
     // 매개변수 ==> 3개이상이면 => 배열,클래스
     public MovieListCard(CartoonVO vo)
     {
    	 //posterLa.setOpaque(true);
    	 //posterLa.setBackground(Color.black);
    	 try
    	 {
    		 URL url=new URL(vo.getPhoto());
    		 Image img=ClientMainFrame.getImage(new ImageIcon(url), 200, 200);
    		 posterLa.setIcon(new ImageIcon(img));
    	 }catch(Exception ex) {}
    	 la1=new JLabel(vo.getTitle());
    	 la2=new JLabel(String.valueOf(vo.getStar()));
    	 la2.setForeground(Color.orange);
    	 la3=new JLabel(vo.getTitle());
    	 ta=new JTextPane();
    	 ta.setText(vo.getDescription());
    	 
    	 setLayout(null);
    	 posterLa.setBounds(10, 15, 200, 200);
    	 la1.setBounds(215, 15, 350, 30);
    	 la2.setBounds(570, 15, 60, 30);
    	 la3.setBounds(215, 50, 415, 30);
    	 ta.setBounds(215, 85, 415, 130);
    	 
    	 add(posterLa);
    	 add(la1);add(la2);
    	 add(la3);add(ta);
    	 
     }
	
}

