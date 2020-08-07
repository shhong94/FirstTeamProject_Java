package com.sist.data;
// 데이터 관리
import java.util.*;
import java.io.*;
public class FoodManager {
	//데이터 저장
	private static ArrayList<FoodVO> list=
			new ArrayList<FoodVO>();
	static {
		/*
		 * 	String msg=mno+"|"+cno+"|"+poster.attr("src")+"|"+poster2.attr("src")+"|"
						+title.text()+"|"+showUser.text()+"|"+like.text()+"|"
						+score.text()+"|"+address.text()
						+"|"+tel.text()+"|"+type.text()+"|"
						+price.text()+"\r\n";
		 */
		try {
			//저장된 파일 읽기
			FileInputStream fr=new FileInputStream("c:\\javaDev\\daum_food.txt");
			//메모리에 전체 데이터를 모아서 관리
			BufferedReader in=
					new BufferedReader(new InputStreamReader(fr));
			while(true) {
				String food=in.readLine(); //한줄 자체를 읽어옴
				if(food==null) break; //파일을 다읽은 경우 종료
				
				StringTokenizer st=new StringTokenizer(food,"|");//데이터를 |로 자르기
				while(st.hasMoreTokens()) {
					FoodVO fo=new FoodVO();
					fo.setNo(Integer.parseInt(st.nextToken()));
					fo.setCno(Integer.parseInt(st.nextToken()));
					fo.setPoster(st.nextToken());
					fo.setTitle(st.nextToken());
					fo.setShowUser(st.nextToken());
					fo.setLike(st.nextToken());
					fo.setScore(st.nextToken());
					fo.setAddrss(st.nextToken());
					fo.setTel(st.nextToken());
					fo.setType(st.nextToken());
					fo.setPrice(st.nextToken());
                    list.add(fo);
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public ArrayList<FoodVO> foodListData(int page) {
		ArrayList<FoodVO> foods=new ArrayList<FoodVO>();
		int i=0;
		int j=0;
		int pagecnt=(page*10)-10;
		for(FoodVO fo:list) {
			if(i<10 && j>=pagecnt) {
			foods.add(fo);
			i++; //10개씩 나눠주는 변수
		}
		j++;//for 돌아가는 횟수
	}
	return foods;
}
public int foodTotalPage() {
	return (int)(Math.ceil(list.size()/10.0));
	// ceil는 올림 메소드
}
// 상세보기
public FoodVO foodDetailData(int mno) {
	return list.get(mno-1);
}
// 음식 전체읽기
public ArrayList<FoodVO> foodAllData(int cno) {
	ArrayList<FoodVO> foods=new ArrayList<FoodVO>();
	for(FoodVO fo:list) {
		if(fo.getCno()==cno)
		foods.add(fo);
	}
	return foods;
 }

// 검색
public ArrayList<FoodVO> foodFindData(String ss) {
	ArrayList<FoodVO> foods=new ArrayList<FoodVO>();
	for(FoodVO fo:list) {
		if(fo.getTitle().contains(ss)) {
		foods.add(fo);
	}
 }
	return foods;
}
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("페이지:");
	int page=scan.nextInt();
	
	FoodManager f=new FoodManager();
	System.out.println(page+" page / "+f.foodTotalPage()+" pages");
	
	//데이터 읽기
	ArrayList<FoodVO> list=f.foodListData(page); // 해당되는 페이지만 넘겨줌
	for(FoodVO fo:list) {
		System.out.println(fo.getTitle());
	}
	}
}

