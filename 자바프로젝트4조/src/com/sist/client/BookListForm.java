package com.sist.client;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import com.sist.data.*;
import javax.swing.*;
import javax.swing.table.*;
import java.net.*;
public class BookListForm extends JPanel implements MouseListener{
   JButton b1,b2;
   JTextField tf;
   JTable table;
   DefaultTableModel model;
   BookDetailForm bdf=new BookDetailForm();
   /*
    *    ��� => �޼ҵ� ==> ������ , �Ű����� 
    */
  
   public BookListForm()
   {
	   setLayout(null);// FlowLayout => null ����� ���� ��ġ
	   b1=new JButton("���� �ְ� ����Ʈ");
	   b2=new JButton("�˻�");
	   tf=new JTextField(20);
	   JPanel p=new JPanel();
	   p.add(b1);p.add(tf);p.add(b2);
	   p.setBounds(10, 25, 900, 35);
	   add(p);
	   String[] col={"��ȣ","","����","����","���ǻ�","�о�"};
	   Object[][] row=new Object[0][5];
	   
	   // DefaultTableModel=> �������̵��� �޼ҵ尡 �ִ� (�͸��� Ŭ���� => ����Ŭ����)
	   /*
	    *     ���� Ŭ���� => ������ , ��Ʈ��ũ 
	    *     =========
	    *      class A
	    *      {
	    *          O P C V B
	    *          class B{  ===> ���Ŭ���� 
	    *          }
	    *      }
	    */
  
   
	   model=new DefaultTableModel(row,col) {
        // ������ �Ұ��� 
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
	        // �̹��� ÷�� 
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
		   
	   };
	   
	   table=new JTable(model);
	   table.setRowHeight(50);
	   JScrollPane js=new JScrollPane(table);
	   
	   js.setBounds(10, 70, 700, 550);
	   add(js);
	   
	   bdf.setBounds(715,70 , 800, 650);
	   add(bdf);
	   movieAllData(1);
	   bdf.detailPrint(1);
	   
	   table.addMouseListener(this);
   }
  
	   
   public void movieAllData(int cno)
   {
	   // ������ ������ ���� 
	   BookManager m=new BookManager();
	   ArrayList<BookVO> list=m.movieAllData(cno);
	   
	   // ���̺� �ѹ� ����� 
	   // ���������� ����� 
	   for(int i=model.getRowCount()-1;i>=0;i--)
	   {
		   model.removeRow(i);
	   }
	   
	   // ������ ��� 
	   /*
	    *    java.io,java.net ==> CheckException => �ݵ�� ����ó��
	    */
	   for(BookVO vo:list)
	   {
		  try
		  {
			   URL url=new URL(vo.getPoster());//http:,c:\\image
			   Image img=ClientMainFrame.getImage(new ImageIcon(url),
					   35, 50);
			   Object[] data={
					 vo.getMno(),
					 new ImageIcon(img),
					 vo.getTitle(),
					 vo.getDirector(),
					 vo.getActor(),
					 vo.getGenre()
			   };
			   model.addRow(data);
		  }catch(Exception ex){ex.printStackTrace();}
	   }
   }
   
   public void movieFindData(String ss)
   {
	   // ������ ������ ���� 
	   BookManager m=new BookManager();
	   ArrayList<BookVO> list=m.movieFindData(ss);
	   
	   // ���̺� �ѹ� ����� 
	   // ���������� ����� 
	   for(int i=model.getRowCount()-1;i>=0;i--)
	   {
		   model.removeRow(i);
	   }
	   
	   // ������ ��� 
	   /*
	    *    java.io,java.net ==> CheckException => �ݵ�� ����ó��
	    */
	   for(BookVO vo:list)
	   {
		  try
		  {
			   URL url=new URL(vo.getPoster());//http:,c:\\image
			   Image img=ClientMainFrame.getImage(new ImageIcon(url),
					   35, 50);
			   Object[] data={
					 vo.getMno(),
					 new ImageIcon(img),
					 vo.getTitle(),
					 vo.getDirector(),
					 vo.getActor(),
					 vo.getGenre()
			   };
			   model.addRow(data);
		  }catch(Exception ex){ex.printStackTrace();}
	   }
   }
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==table)
	{
		if(e.getClickCount()==2)
		{
			int row=table.getSelectedRow();
			String mno=model.getValueAt(row, 0).toString();
			bdf.detailPrint(Integer.parseInt(mno));
		}
	}
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}