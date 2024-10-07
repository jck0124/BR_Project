package com.br.dao;

public interface MemberDao {
	
	// 회원 있는지 확인 
	String IdDuplicationCheck(String email);
	
	// 회원가입 
	void SignUp(String email, String nickname);
	
	// 로그인 체크
	boolean loginCheck(String id, String pw);
	
}
