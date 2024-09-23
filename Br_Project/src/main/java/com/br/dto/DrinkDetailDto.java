package com.br.dto;

import java.util.ArrayList;

public class DrinkDetailDto {
	
	private DrinkDto dto;
	private ArrayList<DrinkDetailMenuDto> detailMenuList;
	
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