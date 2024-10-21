package com.br.dto;

// 메뉴(아이스크림) 재료
public class IcecreamIngredientDto {
	
	private int icecreamIdx;	// 아이스크림 idx
	private int ingredientIdx;	// 재료 idx
	private String name;	// 재료명
	private String imgUrl;	// 재료 이미지 URL
	
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
