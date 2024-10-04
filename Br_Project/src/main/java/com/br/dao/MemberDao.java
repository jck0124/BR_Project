package com.br.dao;

public interface MemberDao {
	
	// 회원 있는지 확인 
	String login(String email);
	
	// 회원가입 
	void SignUp(String email, String nickname);

}
