package com.br.dto;

public class KakaoPayOrderFormDto {
	private String name;
	private int totalPrice;
	
	public KakaoPayOrderFormDto() {
	}
	public KakaoPayOrderFormDto(String name, int totalPrice) {
		super();
		this.name = name;
		this.totalPrice = totalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
