package com.br.dto;

import java.util.ArrayList;

// 메뉴(음료) 페이지(페이지네이션)
public class DrinkPaginationDto {
	
	private int totalPageNum;	// 전체 페이지 수
	private ArrayList<DrinkDto> drinkList;	// 음료 리스트
	
	public DrinkPaginationDto() {
		
	}

	public DrinkPaginationDto(int totalPageNum, ArrayList<DrinkDto> drinkList) {
		super();
		this.totalPageNum = totalPageNum;
		this.drinkList = drinkList;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public ArrayList<DrinkDto> getDrinkList() {
		return drinkList;
	}

	public void setDrinkList(ArrayList<DrinkDto> drinkList) {
		this.drinkList = drinkList;
	}
	
}
