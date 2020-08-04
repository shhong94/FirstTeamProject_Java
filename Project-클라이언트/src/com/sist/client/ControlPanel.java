package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class ControlPanel extends JPanel{
	 CardLayout card=new CardLayout();
	  LightListForm lf=new LightListForm();
	  public ControlPanel(ClientMainFrame c)
	   {
		  setLayout(card);
		   add("LF",lf);
		   
	   }
}
