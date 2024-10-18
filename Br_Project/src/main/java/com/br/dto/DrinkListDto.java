package com.br.dto;

// 메뉴(음료) 리스트
public class DrinkListDto {
	private int drinksIdx;	// 음료 idx
	private String name;	// 메뉴명
	private int price;	// 가격
	private String img;	// 이미지 URL
	
	public DrinkListDto() {
		
	}

	public DrinkListDto(int drinksIdx, String name, int price, String img) {
		super();
		this.drinksIdx = drinksIdx;
		this.name = name;
		this.price = price;
		this.img = img;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
