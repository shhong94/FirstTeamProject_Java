package com.sist.client;
import java.awt.*;
import java.net.URL;

import javax.swing.*;

import com.sist.data.LightManager;
import com.sist.data.LightVO;

import java.util.*;

public class LightDetailForm extends JPanel{
	JLabel poster=new JLabel();
	JLabel la1=new JLabel("");
	JLabel[] la=new JLabel[4];
	JTextPane ta=new JTextPane();
	JButton b1,b2;
	public LightDetailForm()
	{
		 setLayout(null);
    	 poster.setBounds(10, 15, 350, 500);
    	 add(poster);
    	 la1.setBounds(365, 15, 500, 45);
    	 la1.setFont(new Font("굴림체",Font.BOLD,30));
    	 add(la1);
    	JPanel p=new JPanel();
    	p.setLayout(new GridLayout(4, 1, 5, 5));
    	String[] str= {"제품명: ","소비자가 :","판매가 :","적립금 :"};

    	for(int i=0;i<4;i++)
    	{
    		la[i]=new JLabel(str[i]);
    		 la[i].setFont(new Font("굴림체",Font.BOLD,25));
    		p.add(la[i]);
    	}
    	p.setBounds(365, 80, 500, 350);
    	add(p);
    	
    	
    	b1=new JButton("구매하기");
    	b2=new JButton("목록");
    	b1.setBackground(Color.pink);
    	b2.setBackground(Color.cyan);
    	
    	JPanel p2=new JPanel();
    	p2.add(b1);
    	p2.add(b2);
    	p2.setBounds(300, 480, 300, 60);
    	add(p2);
    	
    	detailPrint(1);
    	
	}
	public void detailPrint(int mno)
    {
       LightManager m=new LightManager();
       LightVO vo=m.lightDetailData(mno);
       la1.setText(vo.getName());
       try {
          URL url=new URL(vo.getPoster());
          //Image img=ClientMainFrame.getImage(ii, w, h)
          Image img=ClientMainFrame.getImage(new ImageIcon(url),
       		   poster.getWidth(),poster.getHeight());
       		   poster.setIcon(new ImageIcon(img));
          //ClientMainFrame cf=new ClientMainFrame();
          //Image img=cf.getImage(ii, w, h)
       }catch (Exception ex) {
     
   }
       la[0].setText("제품명:"+vo.getName());
       la[1].setText("소비자가:"+vo.getQuantity());
       la[2].setText("판매가:"+vo.getSell());
       la[3].setText("적립금:"+vo.getMile());
      
    }

}