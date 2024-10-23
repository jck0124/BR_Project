package com.br.service;

// NaverLoginApi는 특정 API의 설정을 제공하는 API 클래스
import com.github.scribejava.core.builder.api.DefaultApi20; 

public class NaverLoginApi extends DefaultApi20{     
	
	protected NaverLoginApi(){    
		
	// Singleton 패턴을 위한 내부 클래스
	}     
	private static class InstanceHolder{        
		private static final NaverLoginApi INSTANCE = new NaverLoginApi();    
	}      
	// NaverLoginApi 인스턴스를 반환하는 정적 메소드
	public static NaverLoginApi instance(){        
		return InstanceHolder.INSTANCE;    
	}     
	// 액세스 토큰을 요청할 엔드포인트 URL을 반환
	@Override    
	public String getAccessTokenEndpoint() {        
		return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";    
	}                        
	// 사용자 인증을 위한 기본 URL을 반환
	@Override    
	protected String getAuthorizationBaseUrl() {        
		return "https://nid.naver.com/oauth2.0/authorize";    
	}   
}
