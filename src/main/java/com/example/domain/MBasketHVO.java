package com.example.domain;

public class MBasketHVO {
	private String mhid; // �����ϴ� ��� mlogin-mid  ����
	private String mhrecent; // �ֱ� �� ����
	private int mhres; //���� ����
	private int mhreview; //���� ����(�������̺� ���̵� ����)
	
	
	public String getMhid() {
		return mhid;
	}
	public void setMhid(String mhid) {
		this.mhid = mhid;
	}
	public String getMhrecent() {
		return mhrecent;
	}
	public void setMhrecent(String mhrecent) {
		this.mhrecent = mhrecent;
	}
	
	public int getMhres() {
		return mhres;
	}
	public void setMhres(int mhres) {
		this.mhres = mhres;
	}
	public int getMhreview() {
		return mhreview;
	}
	public void setMhreview(int mhreview) {
		this.mhreview = mhreview;
	}
	
	
	@Override
	public String toString() {
		return "MBasketHVO [mhid=" + mhid + ", mhrecent=" + mhrecent + ", mhres=" + mhres + ", mhreview=" + mhreview
				+ "]";
	}
	
	
}
