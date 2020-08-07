package com.sist.client;
// 윈도우 => JFrame
// 윈도우와 관련된 클래스를 읽어온다 
import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.sist.common.Function;

import java.awt.*; // Color,Layout
import java.awt.event.*;// interface
/*
 *    재사용 
 *      = 상속 (is-a) : 기존의 클래스를 변경해서 사용
 *      public class ClientMainFrame extends JFrame
 *                   ===============
 *                    JFrame의 기능을 전체 가지고 온다 
 *      class A
 *      {
 *         O X W
 *      }
 *      class B extends A
 *      {
 *          O X W
 *      }
 *      = 포함 (has-a) : 기존의 클래스를 변경없이 사용
 *      public class ClientMainFrame
 *      {
 *          JFrame f=new JFrame();
 *      }
 *      
 */
import java.io.*;
import java.net.*;
import java.util.*;
/*
 *    1. 사용자가 서버에 요청 
 *    2. 서버에서 들어오는 응답을 받아서 출력 (쓰레드) => 자동화 
 */
public class ClientMainFrame extends JFrame implements ActionListener,
MouseListener,Runnable{
    // 윈도우 크기 결정  => 생성자에서 사용  ==> 291 page
	JLabel title=new JLabel("☆★웹툰맛집조명뉴스뮤직☆★",JLabel.CENTER);
	MenuForm mf=new MenuForm();
	ChatForm cf=new ChatForm();
	DetailForm df=new DetailForm();
	Login login=new Login();
	ControllPanel cp;
	int curpage=1;
	int totalpage=16;
	
	// 조명
	LightListForm llf=new LightListForm();
	LightDetailForm ldf=new LightDetailForm();
	
	// 네트워크 관련 프로그램 
	Socket s; // 연결 기계 
	OutputStream out; // 서버로 요청값 전송 => 로그인,채팅 문자열 , 종료 ....
	BufferedReader in; // 서버로부터 값을 받아오는 클래스  ==> 쓰레드 
	
	public ClientMainFrame()
	{
		cp=new ControllPanel(this);
		// 새로운 창 => 현재 실행중인 윈도우창을 전송 
		/*
		 *   클래스에서 생성자 사용 => 선언이 아니라 => 구현할때 
		 *   예)
		 *       데이터베이스 : 오라클연결 
		 *       네트워크 : 셋팅 => IP,PORT => 핸드폰 (개통)
		 *       웹 : 쿠키에서 값읽기 => 지동로그인 
		 */
		title.setFont(new Font("굴림체",Font.BOLD,55));
		//title.setOpaque(true);
		//title.setBackground(Color.magenta);
		setLayout(null);// JFrame (BorderLayout) 사용자 정의로 배치 => null
		title.setBounds(10, 15, 1570, 100);
		// 추가 => add()
		add(title);
		// 메뉴 배치
		mf.setBounds(10, 120, 100, 300 );
		add(mf);
		// 채팅폼 
		cf.setBounds(115, 760, 1465, 200);
		add(cf);
		// 출력화면 
		cp.setBounds(115, 120, 1465, 635);
		add(cp);
		setSize(1600, 1000);
		//setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// X버튼 클릭시 종료
		
		mf.b1.addActionListener(this);
		mf.b2.addActionListener(this);
		mf.b3.addActionListener(this);	// 영화관 맛집
		mf.b4.addActionListener(this);	// 조명
		mf.b5.addActionListener(this);
		mf.b6.addActionListener(this);	// 뮤직
		mf.b7.addActionListener(this);
		mf.b8.addActionListener(this);
		
		cp.ff.b1.addActionListener(this);// 이전
		cp.ff.b2.addActionListener(this);// 다음
		
		df.b2.addActionListener(this);// 목록
		
		cp.lf.b1.addActionListener(this);
		cp.lf.b2.addActionListener(this);
		cp.lf.b3.addActionListener(this);
		cp.lf.b4.addActionListener(this);
		cp.lf.b5.addActionListener(this);
		cp.lf.b6.addActionListener(this);
		cp.lf.tf.addActionListener(this);
		
		// 조명
		cp.llf.b1.addActionListener(this);
		cp.llf.b2.addActionListener(this);
		cp.llf.b3.addActionListener(this);
		cp.llf.b4.addActionListener(this);
		cp.llf.b5.addActionListener(this);
		cp.llf.b6.addActionListener(this);
		cp.llf.tf.addActionListener(this);
		
		// 영화관 맛집
		cp.fff.b1.addActionListener(this);
		cp.fff.b2.addActionListener(this);
		cp.fff.b3.addActionListener(this);
		cp.fff.b4.addActionListener(this);
		cp.fff.b5.addActionListener(this);
		cp.fff.b6.addActionListener(this);
		cp.fff.tf.addActionListener(this);
		
		// 뮤직
		cp.mlf.b1.addActionListener(this);
		cp.mlf.b2.addActionListener(this);
		cp.mlf.b3.addActionListener(this);
		cp.mlf.b4.addActionListener(this);
		cp.mlf.b6.addActionListener(this);
		cp.mlf.tf.addActionListener(this);
		
		
		// 로그인 처리 
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		// 종료 
		mf.b7.addActionListener(this);
		
		// 채팅 
		cf.tf.addActionListener(this);
		
		/*
		 * for(int i=0;i<10;i++) { cp.ff.mc[i].addMouseListener(this); }
		 */
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        // 생성자는 호출시에 반드시  => new 생성자()
		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		new ClientMainFrame();
	}
	public static Image getImage(ImageIcon ii,int w,int h)
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) { //======================================================================================
		// TODO Auto-generated method stub
		if(e.getSource()==mf.b1)
		{
			cp.card.show(cp, "FF");
		}
		else if(e.getSource()==mf.b2)
		{
			cp.card.show(cp, "LF");
		}
		else if(e.getSource()==mf.b5)
		{
			cp.card.show(cp, "NF");
		}
		else if(e.getSource()==df.b2)
		{
			cp.card.show(cp, "FF");
		}
		else if(e.getSource()==cp.ff.b1)// 이전버튼
		{
			if(curpage>1)
			{
				curpage--;
				cp.ff.p.removeAll();// JPanel의 모든 기능을 삭제
				cp.ff.moviePrint(curpage);
				cp.ff.repaint();
				cp.ff.p.validate();//JPanel의 원래 기능을 재배치
			}
			
		}
		else if(e.getSource()==cp.ff.b2)// 다음버튼
		{
			if(curpage<totalpage)
			{
				curpage++;
				cp.ff.p.removeAll();
				cp.ff.moviePrint(curpage);
				cp.ff.repaint();
				cp.ff.p.validate();
			}
		}
		else if(e.getSource()==cp.lf.b1)
		{
			cp.lf.movieDayData("mon");
		}
		else if(e.getSource()==cp.lf.b2)
		{
			cp.lf.movieDayData("tue");
		}
		else if(e.getSource()==cp.lf.b3)
		{
			cp.lf.movieDayData("wed");
		}
		else if(e.getSource()==cp.lf.b4)
		{
			cp.lf.movieDayData("thu");
		}
		else if(e.getSource()==cp.lf.b5)
		{
			cp.lf.movieDayData("fri");
		}
		else if(e.getSource()==cp.lf.b6 || e.getSource()==cp.lf.tf)
		{
			// 1. 입력된 값 읽기
			String ss=cp.lf.tf.getText();
			if(ss.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				cp.lf.tf.requestFocus();
				return; // 메소드 종료 
			}
			cp.lf.movieFindData(ss);
		}
		
		
		// 조명
		else if(e.getSource()==mf.b4)
		{
			cp.card.show(cp, "LLF");
		}
		else if(e.getSource()==cp.llf.b1)
		{
			cp.llf.LightAllData(1);
		}
		else if(e.getSource()==cp.llf.b2)
		{
			cp.llf.LightAllData(2);
		}
		else if(e.getSource()==cp.llf.b3)
		{
			cp.llf.LightAllData(3);
		}
		else if(e.getSource()==cp.llf.b4)
		{
			cp.llf.LightAllData(4);
		}
		else if(e.getSource()==cp.llf.b5)
		{
			cp.llf.LightAllData(5);
		}
		
		
		// 영화관 맛집
		else if(e.getSource()==mf.b3)
		{
			cp.card.show(cp, "FFF");
		}
		else if(e.getSource()==cp.fff.b1) {
			cp.fff.foodAllData(1);
		}
		else if(e.getSource()==cp.fff.b2) {
			cp.fff.foodAllData(2);
		}
		else if(e.getSource()==cp.fff.b3) {
			cp.fff.foodAllData(3);
		}
		else if(e.getSource()==cp.fff.b4) {
			cp.fff.foodAllData(4);
		}
		else if(e.getSource()==cp.fff.b5) {
			cp.fff.foodAllData(5);
		}
		
		
		// 뮤직
		else if(e.getSource()==mf.b6)
		{
			cp.card.show(cp, "MLF");
		}
		else if(e.getSource()==cp.mlf.b1) {
			cp.mlf.musicAllData(1);
		}
		else if(e.getSource()==cp.mlf.b2) {
			cp.mlf.musicAllData(2);
		}
		else if(e.getSource()==cp.mlf.b3) {
			cp.mlf.musicAllData(3);
		}
		else if(e.getSource()==cp.mlf.b4) {
			cp.mlf.musicAllData(4);
		}
		
		
		// 도서
		else if(e.getSource()==mf.b7)
		{
			cp.card.show(cp, "BLF");
		}
		else if(e.getSource()==cp.blf.b1) {
			cp.blf.movieAllData(1);
		}
		else if(e.getSource()==cp.blf.b2) {
			cp.blf.movieAllData(2);
		}
		
		
		
		// 로그인
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
		else if(e.getSource()==mf.b8)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {}
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==cp.ff.mc[i])
			{
				if(e.getClickCount()==2)
				{
					int a=(i+1)+((curpage*10)-10);
					//JOptionPane.showMessageDialog(this, "mno="+a);
					//System.out.println(a);
					df.detailPrint(a);
					//cp.card.show(cp,"DF");
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

