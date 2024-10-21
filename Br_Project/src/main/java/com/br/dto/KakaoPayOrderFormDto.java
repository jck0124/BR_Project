package com.br.dto;

// 카카오페이 내역
public class KakaoPayOrderFormDto {
	
	private String name;	// 상품명
	private int totalPrice;	// 최종 가격
	
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