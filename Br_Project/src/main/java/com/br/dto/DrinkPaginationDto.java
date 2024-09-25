package com.br.dto;

import java.util.ArrayList;

public class DrinkPaginationDto {
	
	private int totalPageNum;
	private ArrayList<DrinkDto> drinkList;
	
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
