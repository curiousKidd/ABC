package com.example.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MemberVO;
import com.example.persistence.MemberDAO;

@RequestMapping("/Member")
@Controller
public class NaverController {
	@Inject
	MemberDAO dao;
	
	// �׾Ʒ�
	@RequestMapping("naverlogin")
	public String naverlogin() {
		return "/Member/naverlogin";
	}
	
	

	// ���̹� ���̵�� �α��� �۾�
	@RequestMapping("naverHomelogin")
	public String naverlogin(String mid) throws Exception {
		System.out.println(mid);
		System.out.println(dao.login(mid));
		
		if (dao.login(mid)==null) {
			return "redirect:../signIn?mid=" + mid;
		}else{
			MemberVO loginInfo = dao.login(mid);

			String logid = loginInfo.getMid();
			String logpass = loginInfo.getMpassword();
			return "redirect:naverLoginImm?mid=" + logid + "&mpassword=" + logpass;
		}
	}

	@RequestMapping("naverLoginImm")
	public String naverlogingimm(MemberVO vo, HttpSession session) throws Exception {

		String mid = vo.getMid();

		String pass = dao.login(mid).getMpassword();

		if (vo.getMpassword().equals(pass)) {
			System.out.println("�α��� ���� ");
			session.setAttribute("mid", mid);
		} else {
			System.out.println("�α��� ����, ���̵� : " + mid);
			System.out.println("��й�ȣ : " + pass);
		}

		return "redirect:../homepage";
	}

	
	//�Ⱦ�
	@RequestMapping("naverLoginnotuse")
	public static String naverLogin(String myToken) {
		String token = myToken;// ���̹� �α��� ���� ��ū;
		String header = "Bearer " + token; // Bearer ������ ���� �߰�
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ���� ȣ��
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // ���� �߻�
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());

		} catch (Exception e) {
			System.out.println(e);
		}
		return "/Member/signIn?mid=";
	}
}
