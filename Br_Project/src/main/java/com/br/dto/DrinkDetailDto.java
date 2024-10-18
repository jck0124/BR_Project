package com.br.dto;

import java.util.ArrayList;

// 음료 상세 페이지
public class DrinkDetailDto {
	private DrinkDto dto;	// 음료	
	private ArrayList<DrinkDetailMenuDto> detailMenuList;	// 음료의 옵션
	
	public DrinkDetailDto() {
		
	}

	public DrinkDetailDto(DrinkDto dto, ArrayList<DrinkDetailMenuDto> detailMenuList) {
		super();
		this.dto = dto;
		this.detailMenuList = detailMenuList;
	}

	public DrinkDto getDto() {
		return dto;
	}

	public void setDto(DrinkDto dto) {
		this.dto = dto;
	}

	public ArrayList<DrinkDetailMenuDto> getDetailMenuList() {
		return detailMenuList;
	}

	public void setDetailMenuList(ArrayList<DrinkDetailMenuDto> detailMenuList) {
		this.detailMenuList = detailMenuList;
	}
	
}
