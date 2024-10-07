package com.br.dto;

public class RecipeImgDto {
	private int recipeIdx;
	private String imgUrl;
	
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
