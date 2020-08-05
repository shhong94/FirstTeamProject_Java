package com.sist.client;
// 윈도우 > JFrame
// 윈도우와 관련된 클래스를 읽어온다
import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.sist.common.Function;

import java.awt.*; // Color, Layout 배치관련
import java.awt.event.*; // interface
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class ClientMainFrame extends JFrame implements ActionListener,MouseListener,Runnable{  //버튼눌렀을때 처리하는거 인터페이스 implements> 오버라이딩하기
	//메인클래스에서 이벤트처리
	//윈도우 크기 결정 > 생성자에서 사용 > 291page
	JLabel title=new JLabel("영화 예매 & 추천 프로그램",JLabel.CENTER);
	MenuForm mf=new MenuForm();
	ChatForm cf=new ChatForm();
	DetailForm df=new DetailForm();
	Login login=new Login();
	ControllPanel cp;
	int curpage=1;
	int totalpage=16;
	// 네트워크 관련 프로그램 
		Socket s; // 연결 기계 
		OutputStream out; // 서버로 요청값 전송 => 로그인,채팅 문자열 , 종료 ....
		BufferedReader in; // 서버로부터 값을 받아오는 클래스  ==> 쓰레드 
	public ClientMainFrame() {
		cp=new ControllPanel(this);
		title.setFont(new Font("굴림체",Font.BOLD,55));
//		title.setOpaque(true); //불투명모드
//		title.setBackground(Color.magenta);
		setLayout(null); //레이아웃 없이 쓰겠다 // JFrame (BorderLayout) 사용자 정의로 배치 > null 직접배치
		title.setBounds(10, 15, 1570, 100);
		// 추가 > add()
		add(title);
		// 메뉴배치
		mf.setBounds(10, 120, 100, 300);
		add(mf);
		// 채팅폼
		cf.setBounds(115, 760, 1465, 200);
		add(cf);
		// 출력화면
		cp.setBounds(115, 120, 1465, 635);
		add(cp);
		setSize(1600, 1000);
//		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		mf.b1.addActionListener(this); // b1버튼누를떄 가운데form바뀜
		mf.b2.addActionListener(this);
		mf.b5.addActionListener(this); // 뉴스
		mf.b7.addActionListener(this); // 맛집
		
		cp.ff.b1.addActionListener(this); //이전버튼
		cp.ff.b2.addActionListener(this); //다음버튼
		
		df.b2.addActionListener(this); //목록버튼
		
		cp.lf.b1.addActionListener(this);
		cp.lf.b2.addActionListener(this);
		cp.lf.b3.addActionListener(this);
		cp.lf.b4.addActionListener(this);
		cp.lf.b5.addActionListener(this);
		cp.lf.b6.addActionListener(this);
		cp.lf.tf.addActionListener(this);
		
		cp.fof.b1.addActionListener(this);
		cp.fof.b2.addActionListener(this);
		cp.fof.b3.addActionListener(this);
		cp.fof.b4.addActionListener(this);
		cp.fof.b5.addActionListener(this);
		cp.fof.b6.addActionListener(this);
		cp.fof.tf.addActionListener(this);
		
		// 로그인 처리 
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		// 종료 
		mf.b7.addActionListener(this);
		
		// 채팅 
		cf.tf.addActionListener(this);
//		for(int i=0;i<10;i++) {
//			cp.ff.mc[i].addMouseListener(this);
//		}
	}
	public static void main(String[] args) throws Exception {
		// 생성자는 호출시에 반든시 > new 생성자()
		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		new ClientMainFrame();
	}
	public static Image getImage(ImageIcon ii,int w,int h) //라벨크기에맞춰 이미지
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mf.b1) { //b1을 눌렀을떄 df lf는 controllpanel에 등록된 것들이있음
			cp.card.show(cp, "FF");
		}
		else if(e.getSource()==mf.b2) { //b2을 눌렀을떄
			cp.card.show(cp, "LF");
		}
		else if(e.getSource()==mf.b5) { 
			cp.card.show(cp, "NF");
		}
		else if(e.getSource()==mf.b7) { 
			cp.card.show(cp, "FOF");
		}
		else if(e.getSource()==cp.df.b2) { 
			cp.card.show(cp, "FF");
		}
		else if(e.getSource()==cp.ff.b1) { //이전버튼
			 if(curpage>1) {
				 curpage--;
				 cp.ff.p.removeAll(); // JPanel의 모든 기능을 삭제
				 cp.ff.moviePrint(curpage);
				 cp.ff.repaint(); // paint를 다시 호출
				 cp.ff.p.validate(); // JPanel의 원래 기능으 재배치
			 }
		}
		else if(e.getSource()==cp.ff.b2) { //다음버튼
			if(curpage<totalpage) {
				curpage++;
				cp.ff.p.removeAll();
				cp.ff.moviePrint(curpage);
				cp.ff.repaint();
				cp.ff.p.validate();
			}
		}
		else if(e.getSource()==cp.lf.b1) {
			cp.lf.movieAllData(1);
		}
		else if(e.getSource()==cp.lf.b2) {
			cp.lf.movieAllData(2);
		}
		else if(e.getSource()==cp.lf.b3) {
			cp.lf.movieAllData(3);
		}
		else if(e.getSource()==cp.lf.b4) {
			cp.lf.movieAllData(4);
		}
		else if(e.getSource()==cp.lf.b5) {
			cp.lf.movieAllData(5);
		}
		else if(e.getSource()==cp.lf.b6 || e.getSource()==cp.lf.tf) {
			//엔터쳐도되고 검색버튼 눌러도됨
			//1. 입력된 값읽기
			String ss=cp.lf.tf.getText();
			if(ss.length()<1) { //값이 입력이 안됐다면
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				 cp.lf.tf.requestFocus(); //커서 깜빡이게
				 return; // 메서드 종료 > 다시 입력하게
			}
			cp.lf.movieFindData(ss); //찾아서 출력
		}
		else if(e.getSource()==cp.fof.b1) {
			cp.fof.foodAllData(1);
		}
		else if(e.getSource()==cp.fof.b2) {
			cp.fof.foodAllData(2);
		}
		else if(e.getSource()==cp.fof.b3) {
			cp.fof.foodAllData(3);
		}
		else if(e.getSource()==cp.fof.b4) {
			cp.fof.foodAllData(4);
		}
		else if(e.getSource()==cp.fof.b5) {
			cp.fof.foodAllData(5);
		}
		else if(e.getSource()==cp.fof.b6 || e.getSource()==cp.fof.tf) {
			//엔터쳐도되고 검색버튼 눌러도됨
			//1. 입력된 값읽기
			String ss=cp.fof.tf.getText();
			if(ss.length()<1) { //값이 입력이 안됐다면
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				 cp.fof.tf.requestFocus(); //커서 깜빡이게
				 return; // 메서드 종료 > 다시 입력하게
			}
			cp.fof.foodFindData(ss); //찾아서 출력
		}
		else if(e.getSource()==login.b1)
		{
			String id=login.tf1.getText();
			if(id.length()<1)// ID가 입력하지 않을 경우
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				login.tf1.requestFocus();
				return;
			}
			
			String name=login.tf2.getText();
			if(name.length()<1)
			{
				JOptionPane.showMessageDialog(this, "대화명을 입력하세요");
				login.tf2.requestFocus();
				return;
			}
			
			String sex="";
			if(login.rb1.isSelected())
				sex="남자";
			else
				sex="여자";
			
			// 서버로 입력받은 데이터 전송 
			try
			{
				// 연결  => 서버에 대한 정보를 가지고 있다 
				s=new Socket("localhost",3355);
				// 송수신 위치 확인
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				out=s.getOutputStream();
				
				// 로그인 요청 (서버로 전송되는 부분)
				out.write((Function.LOGIN+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
			}catch(Exception ex){}
			    
			    //서버에서 전송하는 데이터를 읽어서 출력 
			    new Thread(this).start();
			    // run()의 위치 확인 ==> 자신의 클래스안에 존재 => (this)
		}
		else if(e.getSource()==login.b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==cf.tf)// 채팅 
		{
			String color=cf.box.getSelectedItem().toString();
			String msg=cf.tf.getText();
			if(msg.length()<1)
				return;
			// 데이터를 서버로 전송 
			try
			{
				out.write((Function.CHAT+"|"+msg+"|"+color+"\n").getBytes());
			}catch(Exception ex){}
			
			    cf.tf.setText("");
		}
		else if(e.getSource()==mf.b7)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==cp.ff.mc[i]) { //cp안에 ff안에 mc
				if(e.getClickCount()==2) {
					int a=(i+1)+((curpage*10)-10);
//					JOptionPane.showMessageDialog(this, "mno="+a);
//					System.out.println(a);
					cp.df.detailPrint(a);
//					cp.card.show(cp, "DF"); // 상세페이지로 들어감
					df.setVisible(true);
					break;
				}
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
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 서버에서 들어오는 데이터를 받아서 처리 
		try
		{
			while(true)
			{
				String msg=in.readLine();
				System.out.println("server=>"+msg);
				StringTokenizer st=
						  new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				   case Function.MYLOG:
				   {
					   setTitle(st.nextToken());
					   login.setVisible(false);// 로그인창
					   setVisible(true);// 영화창 (Main) 
				   }
				   break;
				   case Function.LOGIN:
				   {
					   // 테이블에 출력 
					   String[] data= {
						  st.nextToken(), // id
						  st.nextToken(), // name
						  st.nextToken() // sex
					   };
					   cf.model.addRow(data);
				   }
				   break;
				   case Function.CHAT:
				   {
					     initStyle();
					     append(st.nextToken(),st.nextToken());
				   }
				   break;
				   case Function.EXIT:
				   {
					   String id=st.nextToken();
					   for(int i=0;i<cf.model.getRowCount();i++)
					   {
						   String mid=cf.model.getValueAt(i,0).toString();
						   if(id.equals(mid))
						   {
							   cf.model.removeRow(i);
							   break;
						   }
					   }
				   }
				   break;
				   case Function.MYEXIT:
				   {
					   dispose();// 윈도우 메모리 해제 
					   System.exit(0);// 프로그램 종료 
				   }
				   break;
				}
			}
		}catch(Exception ex) {}
	}
    public void initStyle()
    {
    	Style def=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    	Style red=cf.ta.addStyle("red", def);
    	StyleConstants.setForeground(red, Color.red);
    	
    	Style blue=cf.ta.addStyle("blue", def);
    	StyleConstants.setForeground(blue, Color.blue);
    	
    	Style green=cf.ta.addStyle("green", def);
    	StyleConstants.setForeground(green, Color.green);
    	
    	Style yellow=cf.ta.addStyle("yellow", def);
    	StyleConstants.setForeground(yellow, Color.yellow);
    	
    	Style gray=cf.ta.addStyle("gray", def);
    	StyleConstants.setForeground(gray, Color.gray);
    	
    	Style cyan=cf.ta.addStyle("cyan", def);
    	StyleConstants.setForeground(cyan, Color.cyan);
    }
    public void append(String msg,String color)
    {
    	try
    	{
    		Document doc=cf.ta.getDocument();
    		doc.insertString(doc.getLength(), msg+"\n", cf.ta.getStyle(color));
    	}catch(Exception ex) {}
    }
}











