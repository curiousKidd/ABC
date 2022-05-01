package com.example.persistence;

import java.util.List;

import com.example.domain.BookVO;
import com.example.domain.MessageVO;
import com.example.domain.SearchCriteria;

public interface MessageDAO {
	//�޼��� ����Ʈ �ҷ���
	public List<MessageVO> list(String mid,SearchCriteria cri);
	
	//����¡�� ��ü �޼��� ������ ��
	public int total(String mid);
	
	//�޼��������� ���̺� �μ�Ʈ
	public void insert(MessageVO vo);
	
	//�޼��� ����(���������� ����)
	public void updateDel(MessageVO vo);
	
	//�޼��� ���� ����
	public void delete(MessageVO vo);
	
	//�޼��� �б�
	public MessageVO read(String msid);
	
	//�ּҷ� �б�
	public List<BookVO> booklist(String mbmyid,SearchCriteria cri);
	
	//����¡�� ��ü�ּҷ� ������ ��
		public int btotal(String mbmyid);
}
