package com.example.web;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.MessageVO;
import com.example.domain.PageMaker;
import com.example.domain.SearchCriteria;
import com.example.persistence.MessageDAO;

@Controller
public class MessageController {
	@Inject
	MessageDAO msdao;
	
	//�޼��� �����͸� ������
	@ResponseBody
	@RequestMapping("messagelist")
	public HashMap<String, Object> messagelist(SearchCriteria cri, String mid)throws Exception{
		HashMap<String, Object> hash = new HashMap<String, Object>();
		cri.setPerPageNum(10); //�� �������� ������ ������ ����
		
		PageMaker pm = new PageMaker(); //�������� ���� ������
		pm.setCri(cri);
		
		pm.setTotalCount(msdao.total(mid)); //��ü�� �����͸� ���Ƿ� ���� ��������.
		
		hash.put("list", msdao.list(mid, cri));
		hash.put("pm", pm);
		return hash;
	}
	
	//�޼��� ������ DB�� �����ϴ� ����
	@ResponseBody
	@RequestMapping(value="message",method=RequestMethod.POST)
	public void messagepost(MessageVO vo)throws Exception{
		msdao.insert(vo);
	}
	
	
	//�޼��� �о����
	@ResponseBody
	@RequestMapping("msgread")
	public MessageVO msgread(String msid){
		MessageVO vo = msdao.read(msid);
		//System.out.println(vo.toString());

		return vo;
	}
	
	//�ּҷ� �о����
	@RequestMapping("MessageBook")
	public String messageBook(String mbmyid, Model model,SearchCriteria cri){
		cri.setPerPageNum(10); //�� �������� ������ ������ ����
		
		PageMaker pm = new PageMaker(); //�������� ���� ������
		pm.setCri(cri);
		
		pm.setTotalCount(msdao.btotal(mbmyid)); //��ü�� �����͸� ���Ƿ� ���� ��������.
		
		model.addAttribute("book",msdao.booklist(mbmyid, cri));
		model.addAttribute("pm",pm);
		return "/Member/Message/MessageBook";
	}
}
