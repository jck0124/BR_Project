package com.br.dto;

import org.springframework.web.multipart.MultipartFile;

public class InsertEventDto {
	private MultipartFile img;
	private String topLetter;
	private String title;
	private String period;
	
	public InsertEventDto() {}

	public InsertEventDto(MultipartFile img, String topLetter, String title, String period) {
		super();
		this.img = img;
		this.topLetter = topLetter;
		this.title = title;
		this.period = period;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public String getTopLetter() {
		return topLetter;
	}

	public void setTopLetter(String topLetter) {
		this.topLetter = topLetter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
}
