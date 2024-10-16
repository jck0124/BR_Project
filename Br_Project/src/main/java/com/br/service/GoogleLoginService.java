package com.br.service;

import org.springframework.http.ResponseEntity;

import com.br.dto.GoogleOAuthDto;
import com.br.dto.GoogleOAuthTokenDto;
import com.br.dto.GoogleUserInfoDto;

public interface GoogleLoginService {
	
	// 구글 로그인창 URL
	String getOauthRedirectUrl();
	
	// 구글 로그인 서비스
	// String googleLoginService();
	
	// AccessToken 요청
	ResponseEntity<String> requestAccessToken(String code);
	
	// AccessToken 가져오기
	GoogleOAuthTokenDto getAccessToken(ResponseEntity<String> response);
	
	// 유저정보 요청
	ResponseEntity<String> requestUserInfo(GoogleOAuthTokenDto oAuthToken);	
	
	// 유저정보 가져오기
	GoogleUserInfoDto getUserInfo(ResponseEntity<String> response);
	
}
