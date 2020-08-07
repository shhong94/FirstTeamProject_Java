package com.sist.data;
/*
 *   프로그램 작성
 *   =파일
 *    = 1. 전체 파일을 읽어서 분리 => 메모리에 저장 =======> AI
 *                            ===== ArrayList
 *        FileReader
 *        StringTokenizer, split
 *    = 2. 메모리에서 제어
 *   =오라클 : 분리가 되어있는 상태
 *    = 필요시마다 오라클에 연결 => 메소드 안에서 처리
 */

//데이터 관리
import java.util.*;
import java.io.*;

public class MusicManager {
	   // 데이터 저장
	   private static ArrayList<MusicVO> List = new ArrayList<MusicVO>();
	   // 프로그램 시작 => 데이터 수집 => ArrayList에 저장 후 시작
	   static {
	      try {
	    	  /*
	    	   * 	파일 읽기 
	    	   * 	1. 한글자씩 읽는 방법 => read()
	    	   * 		FileInputStream
	    	   * 		FileReader
	    	   * 	2. 한줄씩 읽는 방법 => readLine()
	    	   * 		전체 데이터를 임시저장공간에 저장후 사용
	    	   * 		BufferedReader
	    	   */
	    	 // 저장된 파일 읽기
	         FileInputStream fr = new FileInputStream("c:\\javaDev\\genie_music.txt");
	         // 메모리에 전체 데이터를 모아서 관리
	         BufferedReader in = new BufferedReader(new InputStreamReader(fr));
	         while (true) {
	            String music = in.readLine(); // readline() => \n
	            if (music == null)
	               break; // 종료=> 파일을 다 읽은 경우
	
	            StringTokenizer st = new StringTokenizer(music, "|");
	            while (st.hasMoreTokens()) {
	               MusicVO vo = new MusicVO();	              
	               String rank = st.nextToken();
	               rank=rank.substring(0,rank.lastIndexOf(" "));
	               vo.setRank(Integer.parseInt(rank));
	               vo.setTitle(st.nextToken());
	               vo.setArtist(st.nextToken());
	               vo.setAlbum(st.nextToken());	               
	               vo.setPoster("https:" + st.nextToken());
	              
	               List.add(vo);
	            }
	
	         }
	      } catch (Exception ex) {
	         System.out.println(ex.getMessage());
	      }
	   }
	
	   public ArrayList<MusicVO> musicListData(int page) {
	      ArrayList<MusicVO> musics = new ArrayList<MusicVO>();
	      int i=0;
	      int j=0;
	      int pagecnt=(page*50)-50;
	      /*
	       *  1page=>0~9
	       *  2page=>10~19
	       *  3page=>20~29
	       */
	      for(MusicVO vo:List)
	      {
	         //pagecnt => 저장해야할 위치
	         if(i<50 && j>=pagecnt)
	         {
	            musics.add(vo);
	            i++; //10개씩 나눠주는 변수
	         }
	         j++; //for문 돌아가는 횟수
	      }
	      return musics;
	   }
	   public int musicTotalPage()
	   {
	      return(int)(Math.ceil(List.size()/10.0));
	      //ceil는 올림 메소드
	   }
	   
	   // 상세보기
	   public MusicVO musicDetailData(int mno) {
		   return List.get(mno-1);						
	   }
	   
	   
	   
	   // 영화 찾기
	   public ArrayList<MusicVO> musicAllData(int cno){
		   ArrayList<MusicVO> musics=new ArrayList<MusicVO>();
		   for(MusicVO vo:List) {
			   if(vo.getRank()==cno) {
				   musics.add(vo);
			   }
		   }
		   return musics;
	   }
	   
	   
	   // 검색
	   public ArrayList<MusicVO> musicFindData(String ss){
		   ArrayList<MusicVO> musics=new ArrayList<MusicVO>();// 가변배열
		   // list
		   for(MusicVO vo:List) {
			   if(vo.getTitle().contains(ss)) {
				   musics.add(vo);
			   }				   
		   }
		   return musics;
	   }
	
	   public static void main(String[] args) {
	      Scanner scan=new Scanner(System.in);
	      System.out.print("페이지 : ");
	      int page=scan.nextInt();
	      
	      MusicManager m=new MusicManager();
	      System.out.println(page+"page / "+m.musicTotalPage()+"pages");
	      
	      //데이터 읽기
	      ArrayList<MusicVO> list=m.musicListData(page);
	      
	      for(MusicVO vo:list)
	      {
	         System.out.println(vo.getTitle());
	      }
	      /*String ss=scan.next();
	      for (MusicVO vo : List) {
	         if(vo.getTitle().contains(ss))
	         {
	            System.out.println(vo.getTitle());
	         }*/
      }
   }