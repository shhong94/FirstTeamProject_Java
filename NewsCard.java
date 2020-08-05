package com.sist.client;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import com.sist.server.NewsVO;

// jpanel => html => <div>
public class NewsCard extends JPanel {
	JLabel poster = new JLabel();
	JLabel title = new JLabel();
	JTextPane tp = new JTextPane();
	JLabel author = new JLabel();
	// 라벨은 한줄짜리만

	public NewsCard() {
		setLayout(null);
		poster.setBounds(10, 5, 300, 200);
		add(poster);
		title.setBounds(315, 5, 900, 35);
		add(title);
		JScrollPane js=new JScrollPane(tp);
		add(js);
		js.setBounds(315, 45, 900, 120);
		author.setBounds(315, 170, 900, 35);
		add(author);

	}

	// 값을 채운다
	public void newsPrint(NewsVO vo) {
		try {
			URL url = new URL(vo.getPoster());
			Image img = ClientMainFrame.getImage(new ImageIcon(url), 300, 150);
			poster.setIcon(new ImageIcon(img));
			title.setText(vo.getTitle());
			tp.setText(vo.getContent());
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
}