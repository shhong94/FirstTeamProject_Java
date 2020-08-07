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
			img=Toolkit.getDefaultToolkit().getImage(new URL(poster)); //Toolkit.getDefaultToolkit() //Toolkit �� ��ӹ޴� subClass�� return �Ѵ�
		}catch(Exception ex) {}
		setToolTipText(title); // �̹����� ���콺�� ���ٴ����� ������ ��
	}
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		

	}
}