package com.sist.client;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import com.sist.data.*;
import javax.swing.*;
import javax.swing.table.*;
import java.net.*;
public class FoodForm extends JPanel implements MouseListener{
	JButton b1,b2,b3,b4,b5,b6;
	JTextField tf;
	JTable table;
	DefaultTableModel model;
	FoodDetailForm fdf=new FoodDetailForm();
	
	/*
	 * 기능 > 메소드 > 리턴형(ArrayList), 매개변수(검색어) //메소드만들때 리턴형이랑 매개변수 찾는 연습많이하기
	 */
	public FoodForm() {
		setLayout(null); // FlowLayout > null 사용자 정의 배치
		b1=new JButton("물회맛집");
		b2=new JButton("제주맛집");
		b3=new JButton("서촌카페베스트");
		b4=new JButton("장어맛집");
		b5=new JButton("제주카페베스트");
		b6=new JButton("검색");
		tf=new JTextField(20);
		JPanel p=new JPanel();// 일자로 배열
		p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(tf);p.add(b6);
		p.setBounds(10, 25, 900, 35);
		add(p);
		String[] col= {"번호","","이름","주소","음식종류","가격대"};
		Object[][] row=new Object[0][6];
	
		model=new DefaultTableModel(row,col) {
			//마우스오른쪽 오버라이딩해서 iscell
			// 편집이 불가능하게
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
		
		fdf.setBounds(715, 70, 800, 650);
		add(fdf);
		foodAllData(1);
		fdf.detailPrint(1);
		
		table.addMouseListener(this);
	}
	public void foodAllData(int cno) {
		// 데이터 가지고 오기
		FoodManager m=new FoodManager();
		ArrayList<FoodVO> list=m.foodAllData(cno);
		
		// 테이블 한번 지우기
		// 마지막부터 지운다 //단점
		for(int i=model.getRowCount()-1;i>=0;i--) { //출력된 전체 갯수
			model.removeRow(i);
		}
		// 데이터 출력
		/*
		 *  java.io,java.net > CheckException > 반드시 예외처리
		 */
		for(FoodVO fo:list) {
			try {
				URL url=new URL(fo.getPoster());
				Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);
			Object[] data= {
				fo.getNo(),
				//그림은 URL로 긁어옴
				new ImageIcon(img),
				fo.getTitle(),
				fo.getAddrss(),
				fo.getType(),
				fo.getPrice()
			};
			model.addRow(data);
			}catch(Exception ex) {}
		}
	}
	
	//위에꺼 복사
	public void foodFindData(String ss) {
		// 데이터 가지고 오기
		FoodManager m=new FoodManager();
		ArrayList<FoodVO> list=m.foodFindData(ss);
		
		// 테이블 한번 지우기
		// 마지막부터 지운다 //단점
		for(int i=model.getRowCount()-1;i>=0;i--) { //출력된 전체 갯수
			model.removeRow(i);
		}
		// 데이터 출력
		/*
		 *  java.io,java.net > CheckException > 반드시 예외처리
		 */
		for(FoodVO fo:list) {
			try {
				URL url=new URL(fo.getPoster());
				Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);
			Object[] data= {
				fo.getNo(),
				//그림은 URL로 긁어옴
				new ImageIcon(img),
				fo.getTitle(),
				fo.getAddrss(),
				fo.getType(),
				fo.getPrice()
			};
			model.addRow(data);
			}catch(Exception ex) {}
		}
	}
@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==table) {
		if(e.getClickCount()==2) {
			int row=table.getSelectedRow();
			String mno=model.getValueAt(row, 0).toString();
			fdf.detailPrint(Integer.parseInt(mno));
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




