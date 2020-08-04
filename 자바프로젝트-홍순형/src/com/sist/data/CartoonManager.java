package com.sist.data;

import java.util.ArrayList;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CartoonManager {

	public void Cartoon() {
		ArrayList<CartoonVO> list1 = new ArrayList<CartoonVO>();
		
		String day = "sun";
		int num = 121;
		
		for(int i = 1; i <= 20; i++) {
			try {
				Document doc = Jsoup.connect("https://comic.naver.com/webtoon/weekdayList.nhn?week=sun").get();
					
				
				Element title = doc.select(".img_list dl dt a").get(i);			// 제목
				System.out.println(title.text());
				Element author = doc.select(".img_list .desc").get(i);			// 작가
				System.out.println(author.text());
				Element star = doc.select(".img_list .rating_type strong").get(i);	// 평점
				System.out.println(star.text());
				Element photo = doc.select("ul.img_list .thumb img").get(i);		// 사진
				System.out.println(photo.attr("src"));
//				System.out.println("=====================================================================");
				
				
				String data = day + "|" + num + "|" + photo.attr("src") + "|" +
								title.text() +"|"+
								author.text() +"|"+
								star.text() + "\r\n";
				FileWriter fw = new FileWriter("c:\\javaDev\\Cartoon.txt", true);
				fw.write(data);
				fw.close();
				
				num++;
				
								
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	
	public void CartoonDetail() {
		ArrayList<CartoonVO> list2 = new ArrayList<CartoonVO>();
		
		String day = "mon";
		int num = 1;
		//https://store.steampowered.com/search/?sort_by=Released_DESC&os=win
			try {
				Document doc = Jsoup.connect("https://comic.naver.com/webtoon/weekdayList.nhn?week=mon").get();
				Elements link = doc.select("ul.img_list .thumb a");
				
			
				for(int i = 1; i <= 20; i++) {
					String url = "https://comic.naver.com" + link.get(i).attr("href");
					Document doc2 = Jsoup.connect(url).get();
//					System.out.println(url);
					
//					Element photo = doc2.selectFirst(".comicinfo .thumb img");		// 사진 ok
//					System.out.println(photo.attr("src"));
					Element title = (doc2.selectFirst(".comicinfo .detail h2"));	// 제목
					System.out.println(title.text());
//					Elements author = doc.select("");			// 작가
//					System.out.println(author.text());
//					Element description = doc2.select(".comicinfo .detail p").get(0);					// 만화설명 ok
//					System.out.println(description.text());
//					Elements genre = doc2.select(".detail_info .genre");				// 장르 ok
//					System.out.println(genre.text());
					
					System.out.println("=====================================================================");
	//				
	//				
	//				String data = day + "|" + cno + "|" + 
//									photo.attr("src") + "|" +
	//								title.text() +"|"+
	//								author.text() +"|"+
	//								description.text() +"|"+
//									genre + "\r\n";
	//				FileWriter fw = new FileWriter("c:\\javaDev\\Steam.txt", true);
	//				fw.write(data);
	//				fw.close();
					
					num++;
					}
			}
			catch(Exception e) {
				
			}
				
								
			
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		CartoonManager c = new CartoonManager();
//		c.Cartoon();
		c.CartoonDetail();

	}

}
