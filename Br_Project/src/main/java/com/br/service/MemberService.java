package com.br.service;

import java.util.HashMap;

public interface MemberService {
	// 토큰 받아오기
	String getAccessToken(String authorize_code);
	
	// 카카오 사용자 정보 받아오기
	HashMap<String, Object> getUserInfo(String access_Token);
	
	// 회원 있는지 확인
	boolean IdDuplicationCheck(String email);
	
	// 회원가입
	void signUp(String email, String nickname);
	
	// 관리자 여부 체크
	boolean adminCheck(String id);
}
