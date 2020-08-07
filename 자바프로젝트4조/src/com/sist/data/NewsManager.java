package com.sist.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 데이터 읽은 순서 확인용
 * String data=	 title.get(j).text()+"|"
				+content.get(j).text().replace("|", " ")+"|"
				+author.get(j).text()+"|"
				+link.get(j).attr("href")+"|"
				+"https:"+img+"\r\n";
 */

public class NewsManager {
	private static ArrayList<NewsVO> list = new ArrayList<NewsVO>();

	// 프로그램 => 시작 => 데이터 읽어서 => ArrayList에 저장
	/*
	 * 파일 데이터베이스 ========= 한 번만 수행
	 */
	static {
		try {
			// 파일에서 데이터 읽기
			FileInputStream fis = new FileInputStream("c:\\javaDev\\daum_news.txt");
			// 2바이트씩으로 변경
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			while (true) {
				String data = in.readLine();
				if (data == null)
					break;

				StringTokenizer st = new StringTokenizer(data, "|");
				NewsVO vo = new NewsVO();
				vo.setTitle(st.nextToken()); // 오라클에선 컬럼
				vo.setContent(st.nextToken());
				vo.setAuthor(st.nextToken());
				vo.setLink(st.nextToken());
				vo.setPoster(st.nextToken());
				list.add(vo);
			}
			fis.close();
		} catch (Exception e) {
		}
	}

	// 페이지별 나누기 기능
	public ArrayList<NewsVO> newsListData(int page) {
		ArrayList<NewsVO> news = new ArrayList<NewsVO>();
		int i = 0; /// i6개씩 나눠주는 변수
		int j = 0; // j= for 이 수행되는 횟수
		int pagecnt = (page * 5) - 5; // 출력할 시작 위치
		for (NewsVO vo : list) {
			if (i < 5 && j >= pagecnt) {
				news.add(vo);
				i++;
			}
			j++;
		}
		return news;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsManager m = new NewsManager();
		ArrayList<NewsVO> list = m.newsListData(1);
		int i = 1;
		for (NewsVO vo : list) {
			System.out.println(i + "." + vo.getTitle());
			i++;
		}
	}

	
}

