package com.sist.data;
/*
 *   ���α׷� �ۼ�
 *   =����
 *    = 1. ��ü ������ �о �и� => �޸𸮿� ���� =======> AI
 *                            ===== ArrayList
 *        FileReader
 *        StringTokenizer, split
 *    = 2. �޸𸮿��� ����
 *   =����Ŭ : �и��� �Ǿ��ִ� ����
 *    = �ʿ�ø��� ����Ŭ�� ���� => �޼ҵ� �ȿ��� ó��
 */

//������ ����
import java.util.*;
import java.io.*;

public class MusicManager {
	   // ������ ����
	   private static ArrayList<MusicVO> List = new ArrayList<MusicVO>();
	   // ���α׷� ���� => ������ ���� => ArrayList�� ���� �� ����
	   static {
	      try {
	    	  /*
	    	   * 	���� �б� 
	    	   * 	1. �ѱ��ھ� �д� ��� => read()
	    	   * 		FileInputStream
	    	   * 		FileReader
	    	   * 	2. ���پ� �д� ��� => readLine()
	    	   * 		��ü �����͸� �ӽ���������� ������ ���
	    	   * 		BufferedReader
	    	   */
	    	 // ����� ���� �б�
	         FileInputStream fr = new FileInputStream("c:\\javaDev\\genie_music.txt");
	         // �޸𸮿� ��ü �����͸� ��Ƽ� ����
	         BufferedReader in = new BufferedReader(new InputStreamReader(fr));
	         while (true) {
	            String music = in.readLine(); // readline() => \n
	            if (music == null)
	               break; // ����=> ������ �� ���� ���
	
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
	         //pagecnt => �����ؾ��� ��ġ
	         if(i<50 && j>=pagecnt)
	         {
	            musics.add(vo);
	            i++; //10���� �����ִ� ����
	         }
	         j++; //for�� ���ư��� Ƚ��
	      }
	      return musics;
	   }
	   public int musicTotalPage()
	   {
	      return(int)(Math.ceil(List.size()/10.0));
	      //ceil�� �ø� �޼ҵ�
	   }
	   
	   // �󼼺���
	   public MusicVO musicDetailData(int mno) {
		   return List.get(mno-1);						
	   }
	   
	   
	   
	   // ��ȭ ã��
	   public ArrayList<MusicVO> musicAllData(int cno){
		   ArrayList<MusicVO> musics=new ArrayList<MusicVO>();
		   for(MusicVO vo:List) {
			   if(vo.getRank()==cno) {
				   musics.add(vo);
			   }
		   }
		   return musics;
	   }
	   
	   
	   // �˻�
	   public ArrayList<MusicVO> musicFindData(String ss){
		   ArrayList<MusicVO> musics=new ArrayList<MusicVO>();// �����迭
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
	      System.out.print("������ : ");
	      int page=scan.nextInt();
	      
	      MusicManager m=new MusicManager();
	      System.out.println(page+"page / "+m.musicTotalPage()+"pages");
	      
	      //������ �б�
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