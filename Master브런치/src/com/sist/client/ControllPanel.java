package com.sist.client;
import java.awt.*;
import javax.swing.*;

public class ControllPanel extends JPanel{
	CardLayout card = new CardLayout();			// ���̾ƿ� : ī��
	HomePrint1 home=new HomePrint1();						// Ȩ ������
	PageOnShow2 pos = new PageOnShow2();			// ����󿵿�ȭ ������
	PageScheduled3 ps = new PageScheduled3();		// ����������ȭ ������
	PageRank4 pr = new PageRank4();				// ������ ������
	DetailedPage dp = new DetailedPage();		// ��������
	Reserve rs = new Reserve();					// �����ϱ� ������
	Review rv = new Review();					// ���� �ı� ������
	
	public ControllPanel() {
		setBackground(Color.yellow);
		setOpaque(true);
		setLayout(card);
		add("HOME",home);
		add("POS",pos);
		add("PS",ps);
		add("PR",pr);
		
	}
}
