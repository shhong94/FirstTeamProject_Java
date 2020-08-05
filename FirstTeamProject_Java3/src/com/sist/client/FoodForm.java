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
	 * ��� > �޼ҵ� > ������(ArrayList), �Ű�����(�˻���) //�޼ҵ常�鶧 �������̶� �Ű����� ã�� ���������ϱ�
	 */
	public FoodForm() {
		setLayout(null); // FlowLayout > null ����� ���� ��ġ
		b1=new JButton("��ȸ����");
		b2=new JButton("���ָ���");
		b3=new JButton("����ī�亣��Ʈ");
		b4=new JButton("������");
		b5=new JButton("����ī�亣��Ʈ");
		b6=new JButton("�˻�");
		tf=new JTextField(20);
		JPanel p=new JPanel();// ���ڷ� �迭
		p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(tf);p.add(b6);
		p.setBounds(10, 25, 900, 35);
		add(p);
		String[] col= {"��ȣ","","�̸�","�ּ�","��������","���ݴ�"};
		Object[][] row=new Object[0][6];
	
		model=new DefaultTableModel(row,col) {
			//���콺������ �������̵��ؼ� iscell
			// ������ �Ұ����ϰ�
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
		
		fdf.setBounds(715, 70, 800, 650);
		add(fdf);
		foodAllData(1);
		fdf.detailPrint(1);
		
		table.addMouseListener(this);
	}
	public void foodAllData(int cno) {
		// ������ ������ ����
		FoodManager m=new FoodManager();
		ArrayList<FoodVO> list=m.foodAllData(cno);
		
		// ���̺� �ѹ� �����
		// ���������� ����� //����
		for(int i=model.getRowCount()-1;i>=0;i--) { //��µ� ��ü ����
			model.removeRow(i);
		}
		// ������ ���
		/*
		 *  java.io,java.net > CheckException > �ݵ�� ����ó��
		 */
		for(FoodVO fo:list) {
			try {
				URL url=new URL(fo.getPoster());
				Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);
			Object[] data= {
				fo.getNo(),
				//�׸��� URL�� �ܾ��
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
	
	//������ ����
	public void foodFindData(String ss) {
		// ������ ������ ����
		FoodManager m=new FoodManager();
		ArrayList<FoodVO> list=m.foodFindData(ss);
		
		// ���̺� �ѹ� �����
		// ���������� ����� //����
		for(int i=model.getRowCount()-1;i>=0;i--) { //��µ� ��ü ����
			model.removeRow(i);
		}
		// ������ ���
		/*
		 *  java.io,java.net > CheckException > �ݵ�� ����ó��
		 */
		for(FoodVO fo:list) {
			try {
				URL url=new URL(fo.getPoster());
				Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);
			Object[] data= {
				fo.getNo(),
				//�׸��� URL�� �ܾ��
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




