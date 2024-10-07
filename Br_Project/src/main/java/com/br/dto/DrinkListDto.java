package com.br.dto;

public class DrinkListDto {
	private String name;
	private int price;
	private String img;
	
	public DrinkListDto() {}
	
	public DrinkListDto(String name, int price, String img) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
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
