package com.br.dto;

// 게시판(레시피) - 이미지
public class RecipeImgDto {
	
	private int recipeIdx;	// 레시피 idx
	private String imgUrl;	// 이미지 URL
	
	public RecipeImgDto() {
		
	}
	
	public RecipeImgDto(int recipeIdx, String imgUrl) {
		super();
		this.recipeIdx = recipeIdx;
		this.imgUrl = imgUrl;
	}
	
	public int getRecipeIdx() {
		return recipeIdx;
	}
	
	public void setRecipeIdx(int recipeIdx) {
		this.recipeIdx = recipeIdx;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
