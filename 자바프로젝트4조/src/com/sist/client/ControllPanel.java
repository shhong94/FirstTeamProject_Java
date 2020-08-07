package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class ControllPanel extends JPanel{
   CardLayout card=new CardLayout();
   ListForm lf=new ListForm();
   LightListForm llf=new LightListForm();	// Á¶¸í
   FoodForm fff = new FoodForm();			// ¸ÀÁý
   MusicListForm mlf = new MusicListForm();	// ¹ÂÁ÷
   BookListForm blf = new BookListForm();	// Ã¥
   
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
	   add("LLF", llf);	// Á¶¸í
	   add("FFF", fff);	// ¸ÀÁý
	   add("MLF", mlf); // ¹ÂÁ÷
	   add("BLF", blf); // Ã¥
	   
   }
}