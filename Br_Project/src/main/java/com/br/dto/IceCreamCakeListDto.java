package com.br.dto;

public class IceCreamCakeListDto {
	private String name;
	private int price;
	private String img;
	private int cakeIdx;
	
	public IceCreamCakeListDto() {}

	public IceCreamCakeListDto(String name, int price, String img, int cakeIdx) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
		this.cakeIdx = cakeIdx;
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

	public int getCakeIdx() {
		return cakeIdx;
	}

	public void setCakeIdx(int cakeIdx) {
		this.cakeIdx = cakeIdx;
	}

}
