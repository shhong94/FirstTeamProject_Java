package com.sist.data;

public class FoodVO { 
	private int no;
	private int cno; //그림 1~10번 --가게홈페이지들어감
	private String poster;// 1번클릭하면 1번상세페이지로 들어감 //splite이용 
	private String title; // 가게이름
	private String score; // 평점 ******
	private String addrss;
	private String tel; 
	private String type;
	private String price;
	private String showUser;
	private String like;
	//마우스 오른쪽 getta,setta --오타낼경우 게터세터 삭제후 다시만들기
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public String getAddrss() {
		return addrss;
	}
	public void setAddrss(String addrss) {
		this.addrss = addrss;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getShowUser() {
		return showUser;
	}
	public void setShowUser(String showUser) {
		this.showUser = showUser;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	
}

