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
         // pagecnt => ���� ��ġ 
         if(i<10 && j>=pagecnt)
         {
            lights.add(vo);
            i++;// 10���� �����ִ� ���� 
         }
         j++;// for���ư��� Ƚ��
      }
      return lights;
   }
   
   public int lightTotalPage()
   {
      return (int)(Math.ceil(list.size()/10.0)); //ceil �ø��޼ҵ�
   }
   
   //�󼼺���
   public LightVO lightDetailData(int mno) {
	   
	   return list.get(mno-1);
   }
   //��ȭ ��ü �б�
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
   //�˻�
   public ArrayList<LightVO> lightFindData(String ss)
   {  
	   ArrayList<LightVO> lights=new ArrayList<LightVO>(); //�����迭
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
      System.out.print("������:");
      int page=scan.nextInt();
      LightManager m= new LightManager();
      System.out.println(page+"page/ "+m.lightTotalPage()+"pages");
      
      //�������б�
      ArrayList<LightVO> list=lightListData(page);
      
      
      for(LightVO vo:list)
      {
           System.out.println(vo.getName());
      }
  }
}