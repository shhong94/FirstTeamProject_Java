package com.sist.data;

public class MusicVO {
	
	private int rank;		// ����
	//private String state;	// ����(���,�ϰ�)
	//private int id;			// ���º��� ����
	private String title;	// ����
	private String poster;	// ������
	private String artist;	// ��Ƽ��Ʈ
	private String album;	// �ٹ�
	
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	/*
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	
	
	
}
