package com.br.dto;

public class ShowIceCreamCakeDto {
	private int cakeIdx;
	private String name;
	private String img;
	private String tag;
	private String backgroundColor;
	
	public ShowIceCreamCakeDto() {}

	public ShowIceCreamCakeDto(int cakeIdx, String name, String img, String tag, String backgroundColor) {
		super();
		this.cakeIdx = cakeIdx;
		this.name = name;
		this.img = img;
		this.tag = tag;
		this.backgroundColor = backgroundColor;
	}

	public int getCakeIdx() {
		return cakeIdx;
	}

	public void setCakeIdx(int cakeIdx) {
		this.cakeIdx = cakeIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
}
