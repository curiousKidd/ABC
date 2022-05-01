package com.example.web;




import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//���� �˻� ���α׷� ����� ��� ũ�Ѹ� 
@Controller
public class SearchController {
	//���̹� �Ҿư�
		@ResponseBody
		@RequestMapping("q.json")
		public ArrayList q() throws Exception{
			
			ArrayList array=new ArrayList();
			
			Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%86%8C%EC%95%84%EA%B3%BC").get();
			
			
			
			Elements es=doc.select(".list_area .list_place_col1");
			
			
			for(Element e:es.select("li")){
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("title", e.select(".name").text());
				map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
				map.put("time",e.select(".time").text());
				array.add(map);
				
			}
			//System.out.println(array);
			return array;
			
			
		}	
		//���̹� �����ܰ�
		@ResponseBody
		@RequestMapping("one.json")
		public ArrayList one() throws Exception{
			
			ArrayList array=new ArrayList();
			
			Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%84%B1%ED%98%95%EC%99%B8%EA%B3%BC").get();
			
			
			
			Elements es=doc.select(".list_area .list_place_col1");
			
			
			for(Element e:es.select("li")){
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("title", e.select(".name").text());
				map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
				map.put("time",e.select(".time").text());
				array.add(map);
				
			}
			//System.out.println(array);
			return array;
			
			
		}	
		//���̹� �����ܰ�
		@ResponseBody
		@RequestMapping("one2.json")
		public ArrayList one2() throws Exception{
			
			ArrayList array=new ArrayList();
			
			Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%A0%95%ED%98%95%EC%99%B8%EA%B3%BC").get();
			
			
			
			Elements es=doc.select(".list_area .list_place_col1");
			
			
			for(Element e:es.select("li")){
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("title", e.select(".name").text());
				map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
				map.put("time",e.select(".time").text());
				array.add(map);
				
			}
			//System.out.println(array);
			return array;
			
			
		}
		//���̹� �̺����İ�
		@ResponseBody
		@RequestMapping("one3.json")
		public ArrayList one3() throws Exception{
			
			ArrayList array=new ArrayList();
			
			Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%9D%B4%EB%B9%88%EC%9D%B4%ED%9B%84%EA%B3%BC").get();
			
			
			
			Elements es=doc.select(".list_area .list_place_col1");
			
			
			for(Element e:es.select("li")){
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("title", e.select(".name").text());
				map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
				map.put("time",e.select(".time").text());
				array.add(map);
				
			}
			//System.out.println(array);
			return array;
			
			
		}
		//���̹� ����ΰ�
		@ResponseBody
		@RequestMapping("one4.json")
		public ArrayList one4() throws Exception{
			
			ArrayList array=new ArrayList();
			
			Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%82%B0%EB%B6%80%EC%9D%B8%EA%B3%BC").get();
			
			
			
			Elements es=doc.select(".list_area .list_place_col1");
			
			
			for(Element e:es.select("li")){
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("title", e.select(".name").text());
				map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
				map.put("time",e.select(".time").text());
				array.add(map);
				
			}
			//System.out.println(array);
			return array;
			
			
		}
		
		
	//���̹� ����
	@ResponseBody
	@RequestMapping("q1.json")
	public ArrayList q1() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EB%82%B4%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}	
	//���̹� �Ǻΰ� 
	@ResponseBody
	@RequestMapping("q2.json")
	public ArrayList q2() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%ED%94%BC%EB%B6%80%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}	
	//�Ȱ�
	@ResponseBody
	@RequestMapping("q3.json")
	public ArrayList q3() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%95%88%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	//ġ��
	@ResponseBody
	@RequestMapping("q4.json")
	public ArrayList q4() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%B9%98%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	//���ǿ�
	@ResponseBody
	@RequestMapping("q5.json")
	public ArrayList q5() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%ED%95%9C%EC%9D%98%EC%9B%90").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	//�񴢱��
	@ResponseBody
	@RequestMapping("q6.json")
	public ArrayList q6() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EB%B9%84%EB%87%A8%EA%B8%B0%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	
	
	
	
	//�������а�
	@ResponseBody
	@RequestMapping("q8.json")
	public ArrayList q8() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%EA%B0%80%EC%A0%95%EC%9D%98%ED%95%99%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	//�ܰ�
	@ResponseBody
	@RequestMapping("q9.json")
	public ArrayList q9() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%99%B8%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	//�Ű�ܰ�
	@ResponseBody
	@RequestMapping("q10.json")
	public ArrayList q10() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%8B%A0%EA%B2%BD%EC%99%B8%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}

	//�Ű��
	@ResponseBody
	@RequestMapping("q12.json")
	public ArrayList q12() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%8B%A0%EA%B2%BD%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".list_area .list_place_col1");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".name").text());
			map.put("id", e.select(".list_item_inner").attr("data-nmb_hpl-doc-id"));
			map.put("time",e.select(".time").text());
			array.add(map);
			
		}
		//System.out.println(array);
		return array;
		
		
	}
	////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	//�������� ���� �о�(�������а�,����������)
	
	//���������� id ������������
	@ResponseBody
	@RequestMapping("daum2.json")
	public ArrayList daum2() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q=%EC%A0%95%EC%8B%A0%EC%9D%98%ED%95%99%EA%B3%BC").get();
		
		
		
		Elements es=doc.select(".wrap_place .list_place");
		
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".fn_tit").text());
			//map.put("id", e.select("#list_item"));
			array.add(map);
			
		}
		System.out.println(array);
		return array;
		
		
	}//�������а� id ������������
	@ResponseBody
	@RequestMapping("q7.json")
	public ArrayList q7() throws Exception{
		
		ArrayList array=new ArrayList();
		
		Document doc=Jsoup.connect("https://store.naver.com/hospitals/list?department=%EC%A0%95%EC%8B%A0%EA%B1%B4%EA%B0%95%EC%9D%98%ED%95%99%EA%B3%BC&query=%EC%9D%B8%EC%B2%9C%EA%B4%91%EC%97%AD%EC%8B%9C%20%EB%AF%B8%EC%B6%94%ED%99%80%EA%B5%AC%20%ED%95%99%EC%9D%B5%EB%8F%99%20%EC%A0%95%EC%8B%A0%EA%B1%B4%EA%B0%95%EC%9D%98%ED%95%99%EA%B3%BC&queryType=hospital&sessionid=PHxnrSggtMNQ15%2FjMthRFndJ&sortingOrder=precision").get();
		
		Elements es=doc.select(".list_wrapper_inner .list_area .list_place_col1");
		
		for(Element e:es.select("li")){
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("title", e.select(".category").text());
			//map.put("id",e.select(".list_item").text());
			array.add(map);
			
		}
		System.out.println(array);
		return array;
		
		
	}
}




