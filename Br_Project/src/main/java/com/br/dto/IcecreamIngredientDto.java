package com.br.dto;

public class IcecreamIngredientDto {
	private int icecreamIdx;
	private int ingredientIdx;
	private String name;
	private String imgUrl;
	
	public IcecreamIngredientDto() {
		
	}
	public IcecreamIngredientDto(int icecreamIdx, int ingredientIdx, String name, String imgUrl) {
		super();
		this.icecreamIdx = icecreamIdx;
		this.ingredientIdx = ingredientIdx;
		this.name = name;
		this.imgUrl = imgUrl;
	}
	
	public int getIcecreamIdx() {
		return icecreamIdx;
	}
	public void setIcecreamIdx(int icecreamIdx) {
		this.icecreamIdx = icecreamIdx;
	}
	public int getIngredientIdx() {
		return ingredientIdx;
	}
	public void setIngredientIdx(int ingredientIdx) {
		this.ingredientIdx = ingredientIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
