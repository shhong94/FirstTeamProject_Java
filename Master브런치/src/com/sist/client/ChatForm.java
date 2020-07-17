package com.sist.client;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.*;

public class ChatForm extends JPanel{
	JTextArea ta;
	JTextField tf;
	JButton reserve;
	
	public ChatForm() {
		setLayout(null);
		
		
		ta = new JTextArea();
		
		tf = new JTextField();
		tf.setBounds(0, 0, 300, 650);
		add(tf);
		
		JScrollPane js = new JScrollPane(ta);
		js.setBounds(0, 655, 245, 45);
		add(js);
		
		reserve = new JButton("¿¹¸Å");
		reserve.setBounds(250, 655, 50, 45);
		add(reserve);
	
		
		
		
	}
	
}
