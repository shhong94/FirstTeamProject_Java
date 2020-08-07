package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.net.*;
public class FoodCard extends JPanel{
	String title,poster;
	Image img;
	public FoodCard(String title, String poster) {
		this.title=title;
		this.poster=poster;
		try {
			img=Toolkit.getDefaultToolkit().getImage(new URL(poster)); //Toolkit.getDefaultToolkit() //Toolkit 을 상속받는 subClass를 return 한다
		}catch(Exception ex) {}
		setToolTipText(title); // 이미지에 마우스를 갔다댔을때 제목이 뜸
	}
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		

	}
}