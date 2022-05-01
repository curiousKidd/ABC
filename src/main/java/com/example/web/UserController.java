package com.example.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.MemberVO;
import com.example.domain.MessageVO;
import com.example.persistence.MemberDAO;
import com.example.persistence.MessageDAO;

@Controller
public class UserController {
	@Inject
	MemberDAO dao;
	@Inject
	MessageDAO msdao;
	
	
	@RequestMapping("page")
	public String page(String email, HttpSession session) {
		if (email != null) {
			session.setAttribute("mid", email);
		}
		return "page";
	}
	
	
	
	//Ȩ
	@RequestMapping("home")
	public String home(String email, HttpSession session) {
		if (email != null) {
			session.setAttribute("mid", email);
		}
		return "home";
	}

	//�α��� �̵�
	@RequestMapping("login")
	public String login() {
		return "/Member/login";
	}

	// �α��� �۾����� �����ϴ� post
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	public String loginPost(MemberVO vo, HttpSession session) throws Exception {

		String mid = vo.getMid();

		
		
		//�α��� �� ���̵� db�� �ִ� id�� �´��� ���غ�
		if(mid.equals(dao.login(mid).getMid())){
			
			String pass = dao.login(mid).getMpassword();
			
			
			//�α��� �� ���̵��� ����� DB�� �ִ� ����� �´��� ���غ�
			if (vo.getMpassword().equals(pass)&&dao.login(mid).getMstatus()!=5) {
				System.out.println("�α��� ���� ");
				session.setAttribute("mid", mid);
				return "redirect:page";
				
			//������ �������� �˻�	
			} else if (vo.getMpassword().equals(pass)&&dao.login(mid).getMstatus()==5) {

				session.setAttribute("admin", "������");
				session.setAttribute("mid", "admin");
				
				return "redirect:AdminMain";

			//��й�ȣ�� Ʋ������
			} else {
				System.out.println("�α��� ����, ���̵� : " + mid);
				System.out.println("��й�ȣ : " + pass);
				
				return "redirect:login?error='login failed! check your password'";
			}
			
		//���̵� Ʋ������
		}else {
			System.out.println("�α��� ����, ���̵� : " + mid);
			System.out.println("��й�ȣ : ");
			
			return "redirect:login?error='login failed! check your id'";
		}
		

		
	}

	//�α׾ƿ�
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("mid");
		return "redirect:homepage";
	}

	

	// ȸ������
	@RequestMapping("signIn")
	public String signIn() {
		return "/Member/signIn";
	}

	//ȸ������post
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public void signInPost(MemberVO vo, HttpSession session) throws Exception {
		dao.signIn(vo); 
		session.setAttribute("signlogin", vo.getMid());
		MessageVO msvo = new MessageVO();
		msvo.setMscontent("������ ȯ���մϴ�");
		msvo.setMssender("admin");
		msvo.setMstitle("������ ȯ���մϴ�!");
		msvo.setMsreceiver(vo.getMid());
		msdao.insert(msvo);
	}

	
}
