package com.example.persistence;

import java.util.List;

import com.example.domain.HVO;
import com.example.domain.MBasketHVO;
import com.example.domain.ReviewVO;
import com.example.domain.SearchCriteria;

public interface HDAO {
	
	
	public void insert(HVO vo) throws Exception;
	//���� ���� �� ����
	public void tinsert(HVO vo) throws Exception;	
	public List<HVO> list() throws Exception; //ũ�Ѹ� ������ hsearch�� ������ ��� ���
	public List<HVO> slist(SearchCriteria cri) throws Exception;//ũ�Ѹ� ������ hsearch�� ������ ��� ��� keyword �˻� ����
	public HVO read(String h_code) throws Exception;//�ڵ�,�̸�,���� �ð� read

	public void update(HVO vo)throws Exception; //������� �Է��ϱ�
	/*    ���� ����    */
	public void reviewinsert(ReviewVO vo) throws Exception;
		

}
