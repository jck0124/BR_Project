package com.br.dto;

public class IcecreamDto {
	private int icecreamIdx;
    private String nameKor;
    private String nameEng;
    private String imgUrl;
    private String detailImg;
    private String info;
    private String hashtag;
    private String backgroundColor;
    private String textColor;
    private int orderNum;
    private int servingSize;
    private int calories;
    private int sugars;
    private int protein;
    private int saturatedFat;
    private int sodium;
    private String allergens;
    
	public IcecreamDto(){
		
	}
    
	public IcecreamDto(int icecreamIdx, String nameKor, String nameEng, String imgUrl, String detailImg, String info,
			String hashtag, String backgroundColor, String textColor, int orderNum, int servingSize, int calories,
			int sugars, int protein, int saturatedFat, int sodium, String allergens) {
		super();
		this.icecreamIdx = icecreamIdx;
		this.nameKor = nameKor;
		this.nameEng = nameEng;
		this.imgUrl = imgUrl;
		this.detailImg = detailImg;
		this.info = info;
		this.hashtag = hashtag;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.orderNum = orderNum;
		this.servingSize = servingSize;
		this.calories = calories;
		this.sugars = sugars;
		this.protein = protein;
		this.saturatedFat = saturatedFat;
		this.sodium = sodium;
		this.allergens = allergens;
	}
	public int getIcecreamIdx() {
		return icecreamIdx;
	}
	public void setIcecreamIdx(int icecreamIdx) {
		this.icecreamIdx = icecreamIdx;
	}
	public String getNameKor() {
		return nameKor;
	}
	public void setNameKor(String nameKor) {
		this.nameKor = nameKor;
	}
	public String getNameEng() {
		return nameEng;
	}
	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDetailImg() {
		return detailImg;
	}
	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getServingSize() {
		return servingSize;
	}
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getSugars() {
		return sugars;
	}
	public void setSugars(int sugars) {
		this.sugars = sugars;
	}
	public int getProtein() {
		return protein;
	}
	public void setProtein(int protein) {
		this.protein = protein;
	}
	public int getSaturatedFat() {
		return saturatedFat;
	}
	public void setSaturatedFat(int saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	public int getSodium() {
		return sodium;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public String getAllergens() {
		return allergens;
	}
	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}
    
}
