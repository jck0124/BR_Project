package com.br.dao;

import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sqlSession;

	// 로그인
	@Override
	public String login(String email) {
		HashMap<String, String> hmap = new HashMap<>();
		hmap.put("loginId", email);
		
		String loginId = sqlSession.selectOne("MemberMapper.loginCheck", hmap);
		
		return loginId;
	}
	
	// 회원가입
	@Override
	public void SignUp(String email, String nickname) {
		HashMap<String, String> hmap = new HashMap<>();
		hmap.put("email", email);
		hmap.put("nickname", nickname);
		sqlSession.insert("MemberMapper.insertMember", hmap);
	}

}
