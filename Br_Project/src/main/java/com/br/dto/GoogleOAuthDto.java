package com.br.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleOAuthDto {
	
	// private final String googleLoginUrl = "https://accounts.google.com";
	private final String googleLoginUrl = "https://accounts.google.com/o/oauth2/v2/auth";
	private final String googleTokenRequestUrl = "https://oauth2.googleapis.com/token";
	private final String googleUserinfoRequestUrl = "https://www.googleapis.com/oauth2/v1/userinfo";
	
	@Value("${app.google.clientId}")
	private String googleClientId;
	
	@Value("${app.google.redirect}")
	private String googleRedirectUrl;
	
	@Value("${app.google.secret}")
	private String googleClientSecret;

	
	
	
	public String getGoogleLoginUrl() {
		return googleLoginUrl;
	}

	public String getGoogleTokenRequestUrl() {
		return googleTokenRequestUrl;
	}

	public String getGoogleUserinfoRequestUrl() {
		return googleUserinfoRequestUrl;
	}

	public String getGoogleClientId() {
		return googleClientId;
	}

	public String getGoogleRedirectUrl() {
		return googleRedirectUrl;
	}

	public String getGoogleClientSecret() {
		return googleClientSecret;
	}
	
}
