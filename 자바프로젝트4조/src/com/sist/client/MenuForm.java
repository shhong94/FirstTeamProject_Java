package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MenuForm extends JPanel {
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    // �ʱ�ȭ (��ư) ==> ��ġ (������)
    public MenuForm()
    {
    	//setBackground(Color.orange);
    	b1=new JButton("Ȩ");
    	b2=new JButton("���Ϻ� ����");
    	b3=new JButton("��ȭ������");
    	b4=new JButton("����");
    	b5=new JButton("����");
    	b6=new JButton("��ȭ����");
    	b7=new JButton("���� ��õ");
    	b8=new JButton("����");
    	
    	setLayout(new GridLayout(8, 1,5,5));
    	add(b1);
    	add(b2);
    	add(b3);
    	add(b4);
    	add(b5);
    	add(b6);
    	add(b7);
    	add(b8);
    }
}


