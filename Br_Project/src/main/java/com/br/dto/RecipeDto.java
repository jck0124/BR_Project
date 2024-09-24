package com.br.dto;

public class RecipeDto {
	private int recipeIdx;
	private int categoryIdx;
	private String categoryName;
	private String imgUrl;
	private String titleKor;
	private String titleEng;
	
	public RecipeDto() {
		
	}
	
	public RecipeDto(int recipeIdx, int categoryIdx, String categoryName, String imgUrl, String titleKor,
			String titleEng) {
		super();
		this.recipeIdx = recipeIdx;
		this.categoryIdx = categoryIdx;
		this.categoryName = categoryName;
		this.imgUrl = imgUrl;
		this.titleKor = titleKor;
		this.titleEng = titleEng;
	}
	
	public int getRecipeIdx() {
		return recipeIdx;
	}
	public void setRecipeIdx(int recipeIdx) {
		this.recipeIdx = recipeIdx;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTitleKor() {
		return titleKor;
	}
	public void setTitleKor(String titleKor) {
		this.titleKor = titleKor;
	}
	public String getTitleEng() {
		return titleEng;
	}
	public void setTitleEng(String titleEng) {
		this.titleEng = titleEng;
	}
}
