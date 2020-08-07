package com.sist.client;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import java.util.ArrayList;
import com.sist.data.*;
import javax.swing.table.*;
import javax.swing.*;
import java.net.*;
public class LightListForm extends JPanel implements MouseListener{
	JButton b1,b2,b3,b4,b5,b6;
	JTextField tf;
	JTable table;
	DefaultTableModel model;
	LightDetailForm ldf=new LightDetailForm();
	/*
	 *  기능 => 메소드 ==> 리턴형 ,매개변수
	 */
     public LightListForm() {
    	 setLayout(null);// null값(사용자정의배치) 주지않을경우 검색창과 버튼이 바로 붙어버림 => FlowLayout
    	 b1=new JButton("인테리어조명");
    	 b2=new JButton("스탠드");
    	 b3=new JButton("레일조명");
    	 b4=new JButton("소품");
    	 b5=new JButton("거실등");
    	 b6=new JButton("검색");
    	 tf=new JTextField(20);
    	 JPanel p=new JPanel(); // 패널은 1자배치,중앙배치
    	 p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(tf);p.add(b6); // add = b값 순서대로
    	 p.setBounds(10, 25, 900, 35);
    	 add(p);
    	 
    	 String[] col= {"번호","이름","소비자가","판매가","적립금"};
    	 Object[][] row=new Object[0][5];
    	 
    	 //DefaultTableModel => 오버라이딩할 메소드가 있다 (익명의 클래스 => 내부클래스)
    	 /*
    	  *   내부 클래스  => 쓰레드, 네트워크
    	  *   ========
    	  *    class A
    	  *    {
    	  *    	 O P C V B //데이터
    	  *        class B{ ====> 멤버클래스
    	  *        
    	  *        }
    	  *     }
    	  */
    	 
    	 model=new DefaultTableModel(row,col){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;}

			
//			  @Override 
//			  public Class<?> getColumnClass(int columnIndex) {
//			     return getValueAt(0, columnIndex).getClass(); 
//			    }
//			 
    	 
    	 };
    	 
    	 table=new JTable(model);
    	 table.setRowHeight(60);
    	 JScrollPane js=new JScrollPane(table);
    	 
    	
    	 js.setBounds(10, 70, 700, 550);
    	 add(js); 
    	 
    	 ldf.setBounds(715, 70, 800, 650);
    	 add(ldf);
    	 LightAllData(1);
    	 ldf.detailPrint(1);
    	 
    	 table.addMouseListener(this);
     }
     public void LightAllData(int cno) {
    	 LightManager m=new LightManager();
    	 ArrayList<LightVO> list=m.LightAllData(cno);
    	 
    	 //테이블 한번 지우기
    	 // 마지막부터 지운다
    	 for(int i=model.getRowCount()-1;i>=0;i--) {
    		 model.removeRow(i);
    	 }
    	 //데이터출력
    	 /*
    	  *  java.io,java.net ===> CheckExeption => 반드시 예외처리
    	  */
    	 for(LightVO vo:list)
    	 {
    		 try {
//    			 URL url=new URL(vo.getPoster());
//    	          Image img=ClientMainFrame.getImage(new ImageIcon(url),70,60);

    		 Object[] data= {
    				 vo.getMno(),
    				// new ImageIcon(img),
    				 vo.getName(),
    				 vo.getQuantity(),
    				 vo.getSell(),
    				 vo.getMile()
    		 };
    		 model.addRow(data);
    		 }catch(Exception ex) {}
    		 
    	 }
     }
    
     

public void movieFindData(String ss) {
    // 데이터 가져오기
    LightManager m = new LightManager();
    ArrayList<LightVO> list = m.lightFindData(ss);
    // 데이터 한번 지우기
    for (int i = model.getRowCount() - 1; i >= 0; i--) {
       model.removeRow(i);
    }
    // 데이터 출력
    /*
     * java.io,java net= checEXception 반드시 예외처리
     */
    for (LightVO vo : list) {
       {
          try {
       //   URL url = new URL(vo.getPoster()); // http: 파일은 url을 이용해야함 , c:\\
         //    Image img = ClientMainFrame.getImage(new ImageIcon(url), 70, 70);

             Object[] data = { vo.getMno(),  vo.getName(), vo.getQuantity(), vo.getSell(),
                   vo.getMile()//,new ImageIcon(img)

             };
             model.addRow(data);
          } catch (Exception ex) {
             // TODO: handle exception
          }
       }
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
			ldf.detailPrint(Integer.parseInt(mno));
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
