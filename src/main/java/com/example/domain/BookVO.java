package com.example.domain;

public class BookVO {
	//�����ϴ� ���
	private String mbmyid;
	
	//�ּҷϿ� ����Ǵ� ����
	private String mbid;
	private String mbname;
	public String getMbmyid() {
		return mbmyid;
	}
	public void setMbmyid(String mbmyid) {
		this.mbmyid = mbmyid;
	}
	public String getMbid() {
		return mbid;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	public String getMbname() {
		return mbname;
	}
	public void setMbname(String mbname) {
		this.mbname = mbname;
	}
	@Override
	public String toString() {
		return "BookVO [mbmyid=" + mbmyid + ", mbid=" + mbid + ", mbname=" + mbname + "]";
	}
	
	
}
