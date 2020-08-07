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
	 *  ��� => �޼ҵ� ==> ������ ,�Ű�����
	 */
     public LightListForm() {
    	 setLayout(null);// null��(��������ǹ�ġ) ����������� �˻�â�� ��ư�� �ٷ� �پ���� => FlowLayout
    	 b1=new JButton("���׸�������");
    	 b2=new JButton("���ĵ�");
    	 b3=new JButton("��������");
    	 b4=new JButton("��ǰ");
    	 b5=new JButton("�Žǵ�");
    	 b6=new JButton("�˻�");
    	 tf=new JTextField(20);
    	 JPanel p=new JPanel(); // �г��� 1�ڹ�ġ,�߾ӹ�ġ
    	 p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(tf);p.add(b6); // add = b�� �������
    	 p.setBounds(10, 25, 900, 35);
    	 add(p);
    	 
    	 String[] col= {"��ȣ","�̸�","�Һ��ڰ�","�ǸŰ�","������"};
    	 Object[][] row=new Object[0][5];
    	 
    	 //DefaultTableModel => �������̵��� �޼ҵ尡 �ִ� (�͸��� Ŭ���� => ����Ŭ����)
    	 /*
    	  *   ���� Ŭ����  => ������, ��Ʈ��ũ
    	  *   ========
    	  *    class A
    	  *    {
    	  *    	 O P C V B //������
    	  *        class B{ ====> ���Ŭ����
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
    	 
    	 //���̺� �ѹ� �����
    	 // ���������� �����
    	 for(int i=model.getRowCount()-1;i>=0;i--) {
    		 model.removeRow(i);
    	 }
    	 //���������
    	 /*
    	  *  java.io,java.net ===> CheckExeption => �ݵ�� ����ó��
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
    // ������ ��������
    LightManager m = new LightManager();
    ArrayList<LightVO> list = m.lightFindData(ss);
    // ������ �ѹ� �����
    for (int i = model.getRowCount() - 1; i >= 0; i--) {
       model.removeRow(i);
    }
    // ������ ���
    /*
     * java.io,java net= checEXception �ݵ�� ����ó��
     */
    for (LightVO vo : list) {
       {
          try {
       //   URL url = new URL(vo.getPoster()); // http: ������ url�� �̿��ؾ��� , c:\\
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
