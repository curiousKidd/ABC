<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<script type="text/javascript">
  var naver_id_login = new naver_id_login("rqO0TDIARI6udRXDMExh", "http://192.168.0.134:8088/abc/Member/naverlogin");
  // 접근 토큰 값 출력
   var token = naver_id_login.oauthParams.access_token;
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    //alert(naver_id_login.getProfileData('email'));
    var email = naver_id_login.getProfileData('email');
//     alert(naver_id_login.getProfileData('nick_name'));
//     alert(naver_id_login.getProfileData('gender'));
//     alert(token)
	
    location.href="naverHomelogin?mid="+email;
  }
</script>
</body>
</html>