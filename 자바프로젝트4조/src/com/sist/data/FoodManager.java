package com.sist.data;
// ������ ����
import java.util.*;
import java.io.*;
public class FoodManager {
	//������ ����
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
			//����� ���� �б�
			FileInputStream fr=new FileInputStream("c:\\javaDev\\daum_food.txt");
			//�޸𸮿� ��ü �����͸� ��Ƽ� ����
			BufferedReader in=
					new BufferedReader(new InputStreamReader(fr));
			while(true) {
				String food=in.readLine(); //���� ��ü�� �о��
				if(food==null) break; //������ ������ ��� ����
				
				StringTokenizer st=new StringTokenizer(food,"|");//�����͸� |�� �ڸ���
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
			i++; //10���� �����ִ� ����
		}
		j++;//for ���ư��� Ƚ��
	}
	return foods;
}
public int foodTotalPage() {
	return (int)(Math.ceil(list.size()/10.0));
	// ceil�� �ø� �޼ҵ�
}
// �󼼺���
public FoodVO foodDetailData(int mno) {
	return list.get(mno-1);
}
// ���� ��ü�б�
public ArrayList<FoodVO> foodAllData(int cno) {
	ArrayList<FoodVO> foods=new ArrayList<FoodVO>();
	for(FoodVO fo:list) {
		if(fo.getCno()==cno)
		foods.add(fo);
	}
	return foods;
 }

// �˻�
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
	System.out.println("������:");
	int page=scan.nextInt();
	
	FoodManager f=new FoodManager();
	System.out.println(page+" page / "+f.foodTotalPage()+" pages");
	
	//������ �б�
	ArrayList<FoodVO> list=f.foodListData(page); // �ش�Ǵ� �������� �Ѱ���
	for(FoodVO fo:list) {
		System.out.println(fo.getTitle());
	}
	}
}

