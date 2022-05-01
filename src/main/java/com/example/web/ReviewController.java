package com.example.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.HVO;
import com.example.domain.PageMaker;
import com.example.domain.ReviewVO;
import com.example.domain.SearchCriteria;
import com.example.persistence.MBHDAO;
import com.example.persistence.ReviewDAO;
import com.example.service.ReviewService;

@Controller
public class ReviewController {
	
	@Inject
	ReviewDAO Revdao;
	
	@Inject
	MBHDAO mbhdao;
	
	@Inject
	ReviewService Revservice;
	
	//���� �Է�
	@ResponseBody
	@RequestMapping("Hos-reviewinsert")
	public void review(ReviewVO vo)throws Exception{
		Revdao.insert(vo);
	}
	
	//�������
	@ResponseBody
	@RequestMapping("revlist")
	public List<ReviewVO> list(String hcode) throws Exception{
		return Revdao.rlist(hcode);
	}
	
	//������������ ���丮��Ʈ ���
	@ResponseBody
	@RequestMapping("Hos-reviewlist")
	public HashMap<String, Object> revlist(String hrevmyid,SearchCriteria cri) throws Exception{
		HashMap<String, Object> hash = new HashMap<String, Object>();
		cri.setPerPageNum(10); //�� �������� ������ ������ ����
		PageMaker pm = new PageMaker(); //�������� ���� ������
		pm.setCri(cri);
		pm.setTotalCount(Revdao.total(hrevmyid));
	
		List<ReviewVO> rlist = Revdao.list(hrevmyid, cri);
		int size = rlist.size();
		//System.out.println(size);
		
		//����� ������ ���� �ҷ�����
		ArrayList<HVO> array = new ArrayList<HVO>();
		for(int i=0; i<size;i++){
			HVO vo = new HVO();
			vo = mbhdao.hread(rlist.get(i).getH_hcode().toString());
			array.add(vo);
		}
		//�ϳ��� ������ �����
		HashMap<String, Object> haslist = new HashMap<String, Object>();
		haslist.put("list", Revdao.list(hrevmyid, cri));
		haslist.put("rev", array);
		
		//System.out.println(array.toString());
		//hash.put("rev", array);
		hash.put("list", Revdao.list(hrevmyid, cri));
		hash.put("pm", pm);
		return hash;
	}
}
