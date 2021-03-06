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
    *    기능 => 메소드 ==> 리턴형 , 매개변수 
    */
  
   public BookListForm()
   {
	   setLayout(null);// FlowLayout => null 사용자 정의 배치
	   b1=new JButton("종합 주간 베스트");
	   b2=new JButton("검색");
	   tf=new JTextField(20);
	   JPanel p=new JPanel();
	   p.add(b1);p.add(tf);p.add(b2);
	   p.setBounds(10, 25, 900, 35);
	   add(p);
	   String[] col={"번호","","제목","저자","출판사","분야"};
	   Object[][] row=new Object[0][5];
	   
	   // DefaultTableModel=> 오버라이딩할 메소드가 있다 (익명의 클래스 => 내부클래스)
	   /*
	    *     내부 클래스 => 쓰레드 , 네트워크 
	    *     =========
	    *      class A
	    *      {
	    *          O P C V B
	    *          class B{  ===> 멤버클래스 
	    *          }
	    *      }
	    */
  
   
	   model=new DefaultTableModel(row,col) {
        // 편집이 불가능 
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
	        // 이미지 첨부 
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
	   // 데이터 가지고 오기 
	   BookManager m=new BookManager();
	   ArrayList<BookVO> list=m.movieAllData(cno);
	   
	   // 테이블 한번 지우기 
	   // 마지막부터 지운다 
	   for(int i=model.getRowCount()-1;i>=0;i--)
	   {
		   model.removeRow(i);
	   }
	   
	   // 데이터 출력 
	   /*
	    *    java.io,java.net ==> CheckException => 반드시 예외처리
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
	   // 데이터 가지고 오기 
	   BookManager m=new BookManager();
	   ArrayList<BookVO> list=m.movieFindData(ss);
	   
	   // 테이블 한번 지우기 
	   // 마지막부터 지운다 
	   for(int i=model.getRowCount()-1;i>=0;i--)
	   {
		   model.removeRow(i);
	   }
	   
	   // 데이터 출력 
	   /*
	    *    java.io,java.net ==> CheckException => 반드시 예외처리
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