package com.example.persistence;

import java.util.List;

import com.example.domain.MemberVO;

public interface MemberDAO {
	//ȸ�������ϴ� �żҵ�
	public void signIn(MemberVO vo)throws Exception;
	
	//ȸ�������� �ҷ����� ����Ʈ
	public List<MemberVO> list() throws Exception;
	
	//�α����� �ϱ����� ��й�ȣ�� �������� �żҵ�
	public MemberVO login(String mid)throws Exception;
	
	//ȸ���� ���� ������ ������Ʈ�ϱ�
	public void update(String mid,int mstatus) throws Exception;
}
