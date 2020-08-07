package com.sist.data;
import java.util.*;
import java.io.*;

public class LightManager {

	   
private static ArrayList<LightVO> list=
new ArrayList<LightVO>();

static {
    try {
    	
       FileInputStream fr=new FileInputStream("c:\\javaDev\\Light.txt");
    
       BufferedReader in=new BufferedReader(new InputStreamReader(fr));
       while(true)
       {
          String light=in.readLine(); 
          if(light==null) break; 
          
           StringTokenizer st=new StringTokenizer(light,"|");
            while(st.hasMoreTokens())
            {
               LightVO vo=new LightVO();
               vo.setMno(Integer.parseInt(st.nextToken()));
               vo.setCno(Integer.parseInt(st.nextToken()));
               vo.setName(st.nextToken());
               vo.setPoster("http:"+st.nextToken());
               vo.setQuantity(st.nextToken());
               vo.setSell(st.nextToken());
               vo.setMile(st.nextToken());
               list.add(vo);
            }
         }
         
      }catch(Exception ex) 
      {
         System.out.println(ex.getMessage());
      }
   }
   
   public static ArrayList<LightVO> lightListData(int page)
   {
      ArrayList<LightVO> lights=new ArrayList<LightVO>();
      int i=0;
      int j=0;
      int pagecnt=(page*10)-10;
      /*
       *    1page  => 0~9
       *    2page  => 10~19
       *    3page  => 20~29
       */
      for(LightVO vo:list)
      {
         // pagecnt => 저장 위치 
         if(i<10 && j>=pagecnt)
         {
            lights.add(vo);
            i++;// 10개씩 나눠주는 변수 
         }
         j++;// for돌아가는 횟수
      }
      return lights;
   }
   
   public int lightTotalPage()
   {
      return (int)(Math.ceil(list.size()/10.0)); //ceil 올림메소드
   }
   
   //상세보기
   public LightVO lightDetailData(int mno) {
	   
	   return list.get(mno-1);
   }
   //영화 전체 읽기
   public ArrayList<LightVO> LightAllData(int cno)
   {
	   ArrayList<LightVO> lights=new ArrayList<LightVO>();
	   for(LightVO vo:list)
	   {
		   if(vo.getCno()==cno) {
			   lights.add(vo);
		   }
	   }
	  return lights;

   }
   //검색
   public ArrayList<LightVO> lightFindData(String ss)
   {  
	   ArrayList<LightVO> lights=new ArrayList<LightVO>(); //가변배열
      //list
	  for(LightVO vo:list)
	  {
		  if(vo.getName().contains(ss))
		  {
			  lights.add(vo);
		  }
	  }
	  return lights;
  }

   
   public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      System.out.print("페이지:");
      int page=scan.nextInt();
      LightManager m= new LightManager();
      System.out.println(page+"page/ "+m.lightTotalPage()+"pages");
      
      //데이터읽기
      ArrayList<LightVO> list=lightListData(page);
      
      
      for(LightVO vo:list)
      {
           System.out.println(vo.getName());
      }
  }
}