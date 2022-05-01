package com.example.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.MemberVO;
import com.example.persistence.MemberDAO;

@Controller
public class AdminController {
	@Inject
	MemberDAO Memdao;
	
	//���� �亯 ���
	@RequestMapping("adminQuestionList")
	public String adminQuestionList(){
		return "/Admin/adminQuestionList";
	}
	
	//���� �亯 ����
	@RequestMapping("adminQuestionAnswer")
	public String adminQuestionAnswer(){
		return "/Admin/adminQuestionAnswer";
	}
	//�Ű� �� �� ���
	@RequestMapping("adminReport")
	public String adminReport(){
		return "/Admin/adminReport";
	}
	//�Ű�� ȸ�� ���
	@RequestMapping("NewFile")
	public String NewFile(){
		return "/Admin/NewFile";
	}
	//������Ʈ
	@RequestMapping("NewFile2")
	public String NewFile2(){
		return "/Admin/NewFile2";
	}
	//Ż��
	@RequestMapping("NewFile3")
	public String NewFile3(){
		return "/Admin/NewFile3";
	}
	//Q&A
	@RequestMapping("qna")
	public String qna(){
		return "/Admin/qna";
	}

	
	//���� ���������� �̵�
	@RequestMapping("AdminMain")
	public String main(){
		return "/Admin/AdminMain";
	}
	
	//ȸ������Ʈ Ȯ��
	@ResponseBody
	@RequestMapping("MemList")
	public List<MemberVO> Memlist() throws Exception{
		List<MemberVO> list = Memdao.list();
		return list;
	}
	
	
}
