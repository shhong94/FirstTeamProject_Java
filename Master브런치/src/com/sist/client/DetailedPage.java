package com.sist.client;

import javax.swing.*;

// ��������
public class DetailedPage extends JPanel{
	
	JLabel poster;				// ������
	JTextArea inform;			// ������ ������ ��ȭ����
	JButton review, reserve;	// ��ȭ���� �Ʒ� ��ư 2��(�����ı�, �����ϱ�)
	
	public DetailedPage() {
		// �ν��Ͻ� ����
		poster = new JLabel();
		inform = new JTextArea();
		review = new JButton("���� �ı�");
		reserve = new JButton("�����ϱ�");
		
		// JPanel�� �߰�
		add(poster);
		add(inform);
		add(review);
		add(reserve);
	}
}
