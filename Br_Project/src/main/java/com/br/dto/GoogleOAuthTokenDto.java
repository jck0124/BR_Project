package com.br.dto;

// 로그인(구글) 토큰 발급
public class GoogleOAuthTokenDto {

	private String access_token;	// 요청 승인 위한 토큰
	private Integer expires_in;	// 만료일
	private String scope;	// 범위
	private String token_type;	// 반환 토큰 유형
	private String id_token;	// 아이디 토큰
	
	public GoogleOAuthTokenDto() {
		
	}

	public GoogleOAuthTokenDto(String access_token, Integer expires_in, String scope, String token_type,
			String id_token) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in; 	
		this.scope = scope;
		this.token_type = token_type;
		this.id_token = id_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getexpires_in() {
		return expires_in;
	}

	public void setexpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getId_token() {
		return id_token;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}
	
}
