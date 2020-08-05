package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class ControllPanel extends JPanel{ //변경되는 패널공간 상세페이지, 평점같은거 // 가운데 공간 바꿔줌
	CardLayout card=new CardLayout();
	ListForm lf=new ListForm();
	DetailForm df=new DetailForm();
	MovieForm ff;
	ClientMainFrame c;
	NewsForm nf=new NewsForm();
	FoodForm fof=new FoodForm();
	public ControllPanel(ClientMainFrame c) {
		this.c=c;
		ff=new MovieForm(c);
		setLayout(card);
		add("FF",ff);
//		add("DF",df);
		add("NF",nf);
		add("LF",lf); 
		add("FOF",fof);
	}
}
