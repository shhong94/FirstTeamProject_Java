package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class ControllPanel extends JPanel{
   CardLayout card=new CardLayout();
   ListForm lf=new ListForm();
   LightListForm llf=new LightListForm();	// ����
   FoodForm fff = new FoodForm();			// ����
   MusicListForm mlf = new MusicListForm();	// ����
   BookListForm blf = new BookListForm();	// å
   
   //DetailForm df=new DetailForm();
   MovieForm ff;
   ClientMainFrame c;
   NewsForm nf=new NewsForm();
   public ControllPanel(ClientMainFrame c)
   {
	   this.c=c;
	   ff=new MovieForm(c);
	   setLayout(card);
	   add("FF",ff);
	   //add("DF",df);
       add("NF",nf);
	   add("LF",lf);
	   add("LLF", llf);	// ����
	   add("FFF", fff);	// ����
	   add("MLF", mlf); // ����
	   add("BLF", blf); // å
	   
   }
}