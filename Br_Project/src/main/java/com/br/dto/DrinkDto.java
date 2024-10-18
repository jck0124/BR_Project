package com.br.dto;

// 메뉴(음료)
public class DrinkDto {
	
	private int drinksIdx;	// 음료 idx
	private String name;	// 메뉴명
	private String img;	// 이미지 URL
	private String tag;	// 태그
	private String backgroundColor;	// 배경색
	private String fontColor;	// 글자색
	private String nameEng;	// 영어명
	private String description;	// 설명
	
	
	public DrinkDto() {
		
	}

	public DrinkDto(int drinksIdx, String name, String img, String tag, String backgroundColor, String fontColor,
			String nameEng, String description) {
		super();
		this.drinksIdx = drinksIdx;
		this.name = name;
		this.img = img;
		this.tag = tag;
		this.backgroundColor = backgroundColor;
		this.fontColor = fontColor;
		this.nameEng = nameEng;
		this.description = description;
	}

	public int getDrinksIdx() {
		return drinksIdx;
	}

	public void setDrinksIdx(int drinksIdx) {
		this.drinksIdx = drinksIdx;
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

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
 