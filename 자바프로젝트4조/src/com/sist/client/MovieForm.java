package com.sist.client;
import java.awt.*;
import javax.swing.*;
import com.sist.data.*;
import java.util.*;//ArrayList

// 메인화면
public class MovieForm extends JPanel{
   JButton b1,b2;	// 페이지 넘기는 버튼
   JPanel p=new JPanel();
   MovieCard[] mc=new MovieCard[10];
   ClientMainFrame c;
   public MovieForm(ClientMainFrame c)
   {
	   this.c=c;
	   setLayout(new BorderLayout());
	   b1=new JButton("<=");
	   b2=new JButton("=>");
	   
	   
	   p.setLayout(new GridLayout(2,5,5,5));
	   
	   moviePrint(1);
	   add("West",b1);add("Center",p);add("East",b2);
   }
   public void moviePrint(int page)
   {
	   MovieManager m=new MovieManager();
	   ArrayList<CartoonVO> list=m.movieListData(page);
	   int i=0;
	   for(CartoonVO vo:list)
	   {
		   mc[i]=new MovieCard(vo.getTitle(),vo.getPhoto());
		   p.add(mc[i]);
		   mc[i].addMouseListener(c);
		   i++;
	   }
   }
}

