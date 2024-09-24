package com.br.dto;

public class SelectEventDto {
	private String img;
	private String topLetter;
	private String title;
	private String period;
	
	public SelectEventDto() {}
	
	public SelectEventDto(String img, String topLetter, String title, String period) {
		super();
		this.img = img;
		this.topLetter = topLetter;
		this.title = title;
		this.period = period;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
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
