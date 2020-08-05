package com.sist.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Music데이터수집 {

	public void musicData() {	
			
			try {
				ArrayList<MusicVO> List = new ArrayList<MusicVO>();
				/*
				 * 실시간 차트 주소
				 * https://www.genie.co.kr/chart/top200?ditc=D&ymd=19000101&hh=16&rtm=Y&pg=4
				 * 
				 */				
				for(int i=1;i<=4;i++) {
					Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=19000101&hh=16&rtm=Y&pg="+i).get();
										
					Elements rank=doc.select("td.number");
					Elements title=doc.select("td.info a.title");
					Elements artist=doc.select("td.info a.artist");
					Elements album=doc.select("td.info a.albumtitle");
					Elements poster=doc.select("a.cover img");
					
					for(int j=0;j<title.size();j++) {
						System.out.println(rank.get(j).text());
						System.out.println(title.get(j).text());
						System.out.println(artist.get(j).text());
						System.out.println(album.get(j).text());
						System.out.println(poster.get(j).attr("src"));
						
						
						FileWriter fw=new FileWriter("c:\\javaDev\\genie_music.txt",true);
						String data=rank.get(j).text()+"|"
								+title.get(j).text()+"|"
								+artist.get(j).text()+"|"
								+album.get(j).text()+"|"
								+poster.get(j).attr("src")+"|"+"\r\n";
						fw.write(data);
						fw.close();
						
					}
					
				}
				
				
				
			}catch (Exception e) {
			}
			
		
	}
	
	public static void main(String[] args) {
		Music데이터수집 m=new Music데이터수집();
		m.musicData();
		
	}

}


