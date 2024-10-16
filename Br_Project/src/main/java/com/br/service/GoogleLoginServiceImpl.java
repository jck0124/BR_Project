package com.br.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.dto.GoogleOAuthDto;
import com.br.dto.GoogleOAuthTokenDto;
import com.br.dto.GoogleUserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GoogleLoginServiceImpl implements GoogleLoginService {
	
	@Autowired
	private GoogleOAuthDto gDto;
	
	
	// 구글 로그인창 URL
	@Override
	public String getOauthRedirectUrl() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(gDto.getGoogleLoginUrl());
		sb.append("?client_id=");
		sb.append(gDto.getGoogleClientId());
		sb.append("&redirect_uri=");
		sb.append(gDto.getGoogleRedirectUrl());
		sb.append("&response_type=code");
		sb.append("&scope=email");
		
		return sb.toString();
	}
	
	// AccessToken 요청
	@Override
	public ResponseEntity<String> requestAccessToken(String code) {
		
		// 요청 url
		String tokenUrl = gDto.getGoogleTokenRequestUrl();

		// 헤더
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		
		// 요청 파라미터 설정
		Map<String, String> params = new HashMap<>();
		params.put("code", code);
		params.put("client_id", gDto.getGoogleClientId());
		params.put("client_secret", gDto.getGoogleClientSecret());
		params.put("redirect_uri", gDto.getGoogleRedirectUrl());
		params.put("grant_type", "authorization_code");
		
		// 바디
		StringBuilder sb = new StringBuilder();
		for( Map.Entry<String, String> entry : params.entrySet() ) {
			if(sb.length() != 0) {
				sb.append("&");
			}
			sb.append(entry.getKey()).append("=").append(entry.getValue());
		}
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(sb.toString(), headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, requestEntity, String.class);
		
		if(response.getStatusCode() == HttpStatus.OK) {
			return response;
		}
		return null;
	}
	
	// AccessToken 가져오기
	@Override
	public GoogleOAuthTokenDto getAccessToken(ResponseEntity<String> response) {
		
		ObjectMapper oMapper = new ObjectMapper();
		GoogleOAuthTokenDto tokenDto = null;
		
		try {
			tokenDto = oMapper.readValue(response.getBody(), GoogleOAuthTokenDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tokenDto;
	}
	
	// 유저정보 요청
	@Override
	public ResponseEntity<String> requestUserInfo(GoogleOAuthTokenDto oAuthToken) {
		
		String userInfoUrl = gDto.getGoogleUserinfoRequestUrl();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add( "Authorization", "Bearer" + oAuthToken.getAccess_token() );
		
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(userInfoUrl, HttpMethod.GET, requestEntity, String.class);
		
		return response;
	}
	
	// 유저정보 가져오기
	@Override
	public GoogleUserInfoDto getUserInfo(ResponseEntity<String> response) {
		
		ObjectMapper oMapper = new ObjectMapper();
		GoogleUserInfoDto userInfoDto = null;
		try {
			userInfoDto = oMapper.readValue(response.getBody(), GoogleUserInfoDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoDto;
	}
	
	
	
	
}
