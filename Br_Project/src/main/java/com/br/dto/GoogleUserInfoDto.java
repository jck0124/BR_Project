package com.br.dto;

public class GoogleUserInfoDto {
	
	private String id;
	private String pw;
	private String email;
	private Boolean verified_email;
	private String name;
	private String given_name;
	private String picture;
	private String locale;
	
	public GoogleUserInfoDto() {
		
	}

	public GoogleUserInfoDto(String id, String pw, String email, Boolean verified_email, String name, String given_name,
			String picture, String locale) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.verified_email = verified_email;
		this.name = name;
		this.given_name = given_name;
		this.picture = picture;
		this.locale = locale;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getVerified_email() {
		return verified_email;
	}

	public void setVerified_email(Boolean verified_email) {
		this.verified_email = verified_email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
